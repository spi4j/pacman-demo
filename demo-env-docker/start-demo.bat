@echo off
setlocal EnableDelayedExpansion

cls

echo =====================================
echo DEMARRAGE DE L'ENVIRONNEMENT DEMO
echo =====================================

echo.
echo Lancement des conteneurs Docker...
docker compose up -d

echo.
echo Attente de fin demarrage des services...

REM attente intelligente Vault
set /a COUNT=0

:WAIT_VAULT
curl -s http://127.0.0.1:8200/v1/sys/health >nul 2>&1

if %errorlevel%==0 goto READY_VAULT

timeout /t 2 >nul
set /a COUNT+=1

if %COUNT% GTR 30 (
    echo Timeout Vault - arret du script
    goto END
)

echo Attente Vault...
goto WAIT_VAULT

:READY_VAULT
echo Vault accessible

echo.
echo =====================================
echo VERIFICATION VAULT INITIALISATION
echo =====================================

set INIT_FILE=vault\vault-init.txt

docker exec vault vault status | findstr "Initialized.*true" >nul 2>&1

if %errorlevel%==0 (
    echo Vault deja initialise
    goto UNSEAL
)

echo.
echo =====================================
echo INITIALISATION DE VAULT
echo =====================================

docker exec vault vault operator init > %INIT_FILE% 2>&1

if not exist %INIT_FILE% (
    echo ERREUR : fichier init non cree
    echo Vault probablement deja initialise ou inaccessible
    goto UNSEAL
)

findstr /i "Unseal Key" %INIT_FILE% >nul
if %errorlevel% neq 0 (
    echo ERREUR : init invalide
    type %INIT_FILE%
    goto END
)

echo Vault initialise correctement

goto UNSEAL

:UNSEAL

echo.
echo =====================================
echo DEVERROUILLAGE DE VAULT
echo =====================================

if not exist %INIT_FILE% (
    echo ERREUR : fichier %INIT_FILE% introuvable
    goto INFOS
)

echo Utilisation des cles...

for /f "delims=" %%k in ('type %INIT_FILE% ^| findstr /i "Unseal Key"') do (
    docker exec vault vault status | findstr "Sealed.*false" >nul
    if !errorlevel! == 0 (
	    echo =====================================
        echo Vault deja deverrouille
		echo =====================================
        goto INFOS
    )

    for /f "tokens=1,* delims=:" %%a in ("%%k") do (
        set KEY=%%b
        set KEY=!KEY: =!
        docker exec vault vault operator unseal !KEY!
    )
)

echo Vault deverrouille

goto INFOS

:INFOS

echo.
echo =====================================
echo INFORMATIONS KEYCLOAK
echo =====================================

echo URL : http://localhost:8085
echo Utilisateur : admin
echo Mot de passe : password

echo.
echo =====================================
echo INFORMATIONS MINIO
echo =====================================

echo API : http://localhost:9000
echo Console : http://localhost:9001
echo Utilisateur : admin
echo Mot de passe : password

echo.
echo =====================================
echo TOKEN ROOT VAULT
echo =====================================

if exist %INIT_FILE% (
    findstr /i "root token" %INIT_FILE%
) else (
    echo Root token non disponible
)

echo.
echo =====================================
echo ENVIRONNEMENT PRET POUR LA DEMO
echo =====================================
timeout /t 25 >nul
:END