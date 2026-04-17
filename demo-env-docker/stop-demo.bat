@echo off
setlocal

cls

echo =====================================
echo ARRET DE L'ENVIRONNEMENT DEMO
echo =====================================

echo.
echo Choisissez un mode :
echo 1 - Arret simple (conserver les donnees)
echo 2 - RESET COMPLET (SUPPRIME TOUT)
echo.

set /p MODE=Entrez votre choix (1 ou 2) : 

echo.

if "%MODE%"=="1" goto STOP
if "%MODE%"=="2" goto RESET

echo Choix invalide
goto END

:STOP
echo =====================================
echo ARRET SIMPLE
echo =====================================

echo Arret des conteneurs...
docker compose stop

echo.
echo Conteneurs arretes (donnees conservees)

goto END

:RESET
echo =====================================
echo RESET COMPLET
echo =====================================

echo Arret des conteneurs...
docker compose down -v --remove-orphans

echo.
echo =====================================
echo SUPPRESSION DES IMAGES DOCKER
echo =====================================

docker rmi quay.io/keycloak/keycloak:26.5 2>nul
docker rmi hashicorp/vault:1.21 2>nul
docker rmi minio/minio:latest 2>nul

echo.
echo =====================================
echo NETTOYAGE GENERAL
echo =====================================

docker system prune -f

echo.
echo Suppression des fichiers locaux...
if exist vault\vault-init.txt (
    echo Suppression du fichier vault/vault-init.txt
    del vault\vault-init.txt
)

if exist vault\data (
    echo Suppression du dossier vault/data
    rmdir /s /q vault\data
)

mkdir vault\data
echo Dossier vault/data recree

if exist keycloak\data (
    echo Suppression du dossier keycloak/data...
    rmdir /s /q keycloak\data
) 

mkdir keycloak\data
echo Dossier keycloak\data recree

echo.
echo Tout a ete supprime
echo Environnement vierge pret pour relance

goto END

:DOCKER

echo =====================================
echo ARRET DE DOCKER
echo =====================================

tasklist | find /I "Docker Desktop.exe" >nul 2>&1
set A=%errorlevel%

tasklist | find /I "com.docker.backend.exe" >nul 2>&1
set B=%errorlevel%

if %A%==0 goto RUNNING
if %B%==0 goto RUNNING

echo Docker n'est PAS en cours d'execution
goto END

:RUNNING
echo Docker est actif

echo Arret de Docker Desktop...
taskkill /IM "Docker Desktop.exe" /F >nul 2>&1
taskkill /IM "com.docker.backend.exe" /F >nul 2>&1

echo Docker Desktop arrete
goto END

:END

echo.
echo =====================================
echo FIN
echo =====================================
