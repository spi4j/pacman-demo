@echo off
setlocal EnableDelayedExpansion

cls

echo =====================================
echo DEMARRAGE DE L'ENVIRONNEMENT DEMO
echo =====================================

echo.
echo Activation de Docker...
rem net start com.docker.service >nul 2>&1
docker info >nul 2>&1
if errorlevel 1 (
    echo Docker non demarre. Merci de le lancer....
    goto END
)
echo Docker est pret...

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
        goto CONFIG_VAULT
    )

    for /f "tokens=1,* delims=:" %%a in ("%%k") do (
        set KEY=%%b
        set KEY=!KEY: =!
        docker exec vault vault operator unseal !KEY!
    )
)

echo Vault deverrouille
goto CONFIG_VAULT

:CONFIG_VAULT

echo.
echo =====================================
echo CONFIGURATION VAULT
echo =====================================

if not exist %INIT_FILE% (
    echo Fichier init introuvable - skip config
    goto INFOS
)

rem Recuperation du root token
for /f "tokens=2 delims=:" %%a in ('findstr /i "Initial Root Token" %INIT_FILE%') do set ROOT_TOKEN=%%a
set ROOT_TOKEN=%ROOT_TOKEN:~1%

if "%ROOT_TOKEN%"=="" (
    echo Impossible de recuperer le root token
    goto INFOS
)
echo TOKEN VAULT = [%ROOT_TOKEN%]
echo Activation du moteur KV (si necessaire)...
docker exec -e VAULT_TOKEN=%ROOT_TOKEN% vault vault secrets list | findstr "secret/" >nul
if errorlevel 1 (
    echo Activation KV...
    docker exec -e VAULT_TOKEN=%ROOT_TOKEN% vault vault secrets enable -path=secret kv-v2
) else (
    echo KV deja actif
)

echo Injection des secrets S3 (MinIO)...
docker exec -e VAULT_TOKEN=%ROOT_TOKEN% vault vault kv put secret/demo-dsfr-rest ^
    s3.accessKey=admin ^
    s3.secretKey=password >nul 2>&1

echo Configuration Vault terminee
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
echo INFORMATIONS DEMO
echo =====================================
echo Back : http://localhost:8080/actuator
echo Back : http://localhost:8080/actuator/info
echo Back : http://localhost:8080/actuator/health
echo Back : http://localhost:8081/swagger-ui
echo Back : http://localhost:8081/api-docs
echo Front : http://localhost:5173
echo Front : (userdemo, password) (admindemon password)

echo.
echo Finalisation demarrage des interfaces serveurs...
timeout /t 20 /nobreak

echo.
echo =====================================
echo ENVIRONNEMENT PRET POUR LA DEMO
echo =====================================
:END