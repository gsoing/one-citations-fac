# One Citations

Ce repo contient le squelette du projet à rendre. Les différents répertoires cotiennent les éléments suivants : 
* [keycloak](./keycloak): il va nous servir d'idp
* [profiles-api](./profiles-api): Exemple de projet java configuré pour fonctionner avec l'idp
* [swagger](./swagger): Runtime swagger-ui configuré pour se logguer sur l'idp et envoyer une requête à l'api profile

En plus la maquette contient une base mongo

**Pour rappel docker compose ne rebuild pas les images automatiquement, il faut donc les re-build explicitement si vous voulez que les modifications de codes soient prises en compte**

Pour démarrer la maquette il suffit d'éxécuter la commande docker compose suivante:
```
docker compose up -d
```

Puis on vérifie que tout est ok :
```
docker compose ps
```

Le résultat attendu est le suivant:
```
NAME                       IMAGE                    COMMAND                  SERVICE    CREATED          STATUS                      PORTS
one-citations-keycloak-1   one-citations-keycloak   "/opt/keycloak/bin/k…"   keycloak   17 minutes ago   Up 17 minutes (unhealthy)   8443/tcp, 0.0.0.0:8080->8080/tcp, :::8080->8080/tcp, 9000/tcp
one-citations-mongo-1      mongo                    "docker-entrypoint.s…"   mongo      17 minutes ago   Up 17 minutes               0.0.0.0:27017->27017/tcp, :::27017->27017/tcp
one-citations-profile-1    one-citations-profile    "java -jar /home/app…"   profile    11 minutes ago   Up 11 minutes               0.0.0.0:9080->8080/tcp, [::]:9080->8080/tcp
one-citations-swagger-1    swaggerapi/swagger-ui    "/docker-entrypoint.…"   swagger    17 minutes ago   Up 17 minutes               80/tcp, 0.0.0.0:8888->8080/tcp, [::]:8888->8080/tcp
```

Les ports sont les suivants:
* swagger: 8888
* keycloak: 8080
* profile-api: 9080

## Keycloak
C'est un idp opensource.
Lors du build de l'image, on importe un `realm` one-citations qui contient un client `swagger` qui est utilisé par notre application swagger[./swagger].
Attention toutes modification du fichier d'[import](./keycloak/one-citations-realm.json) implique de re-builder l'image

** Dans le cadre du TP il est nécessaire d'ajouter un alias sur localhost dans le fichier `hosts` de votre machine comme ci-dessous :
```
##
# Host Database
#
# localhost is used to configure the loopback interface
# when the system is booting.  Do not change this entry.
##
127.0.0.1	localhost keycloak
255.255.255.255	broadcasthost
::1             localhost
```

La console d'administration est accessible [ici](http://keycloak:8080) 

## Swagger
Affiche un swagger-ui (plus de détails [ici](https://github.com/swagger-api/swagger-ui)), ce dernier est déjà tout configuré pour interagir avec keycloak et l'api profile. On y accède via ce [lien](http://localhost:8888)

Dans le cadre du TP il faut documenter l'intégralité de l'API dans ce  [fichier](./swagger/citations.yaml)

Il permet d'accéder à 2 serveurs:
* 9090 : api profile si elle est démarrée en locale dans inteillij avec le profile `local`
* 9080 : api profile qui tourne dans le réseau docker avec les profile `security,docker`

## Profile API
Exemple de projet java qui attend un token généré par keycloak et retourne son contenu sur le endpoint `/api/v1/profile/current`
