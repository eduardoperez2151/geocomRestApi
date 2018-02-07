# Geocom Rest API

El objetivo del presente proyecto es demostrar algunas capacidades técnicas y de desarrollo, mediante el uso del lenguaje de programación Java y Spring Framework.
## Frameworks y tecnologías utilizadas en el proyecto

* Java 8
* Spring Boot 2 RC1
* Spring Data JPA
* Gradle 4.2
* Swagger/ SwaggerUI 2.7


#### Pasos para correr el proyecto 

1. Descargarse o clonar el proyecto
[Guia para clonar un proyecto](https://help.github.com/articles/cloning-a-repository/)

3. Navegar hasta la carpeta geocomRestApi, este directorio posee la siguiente estructura.

		geocomRestApi
		└── backend
			├── config
			│   └── dev
			│       ├── keystore
			│       └── scripts
			└── geocomRestApi
					├── gradle
					│   └── wrapper
					└── src
						├── main
						│   └── java
						│       └── com
						│           └── geocom
						│               ├── configurations
						│               ├── controllers
						│               ├── converters
						│               ├── dtos
						│               ├── exceptions
						│               ├── models
						│               │   └── abstracts
						│               ├── repositories
						│               └── services
						│                   └── implementation
						└── test
							├── java
							│   └── com
							│       └── geocom
							│           ├── controllers
							│           └── repositories
							└── resources
										
## Configuración

Antes de correr el proyecto primero debemos editar algunos archivos de configuración.
Para ello vamos a centrarnos en la carpeta  geocomRestApi/backend/config/dev ( para motivos de prueba solo se configuraron las propiedades para un ambiente de desarrollo),dentro de este directorio encontraremos los siguientes archivos:

	config
	└── dev
	    ├── application.properties
	    ├── banner.txt
	    ├── cors.properties
	    ├── database.properties
	    ├── keystore
	    │   └── ssl-server.jks
	    ├── scripts
	    │   ├── data.sql
	    │   └── schema.sql
	    ├── ssl.properties
	    └── swagger.properties

#### application.properties

Posee configuración general del proyecto como ser el puerto donde va a correr el servidor,el nombre de la aplicación y la versión de la misma.
Dentro de este archivo tenemos que editar la siguiente propiedad **banner.location**, esta propiedad nos desplega en la consola al inicio de la aplicación un banner personalizado para la aplicación, ** !importante esta propiedad debe tener como valor  la ruta absoluta del archivo que vamos a utilizar como banner** , en nuestro caso debemos configurar la ruta absoluta al archivo banner.txt. 

#### banner.txt

Posee el Banner para le Rest Api de Geocom

#### cors.properties

En este Archivo se encuentra la configuración del Control de acceso HTTP 
o Cross Origin Resource Sharing, configuraciones tales como los verbos HTTP y origenes aceptados.

#### database.properties
Configuración de la base de datos.

#### ssl.properties
Este archivo nos permite el uso de un certificado con nuestra API, aqui configuraremos todo lo referente al keystore, como por ejemplo el puerto donde va a correr el servidor, alias, y el password . **!importante** dentro de este archivo se encuentra la propiedad **server.ssl.key-store**   esta propiedad debe configurarse con la ruta absoluta a nuestro keystore. dentro de la carpeta config/dev/keystore encontraremos  un keystore creado para motivos prácticos.
El archivo de configuración posee todas las propiedades para el uso del mismo.
[Guia como crear un keystore](https://docs.oracle.com/cd/E19636-01/819-1655/fapsf/index.html)

#### swagger.properties
Contiene la informacion a mostrarse en la documentación de la Rest API. (swaggerUI).

#### schema.sql y data.sql
Contienen tanto el esquema de la base de datos como los datos respectivamente.


#### ! Antes de continuar...
Debemos de impactar los scripts en la base de datos y asegurarnos que hemos configurado correctamente los archivos de configuración.

Una vez realizado estos pasos navegamos hacia la carpeta **geocomRestApi/backend/geocomRestApi**

	geocomRestApi/
	├── build.gradle
	├── gradle
	│   └── wrapper
	│       ├── gradle-wrapper.jar
	│       └── gradle-wrapper.properties
	├── gradlew
	├── gradlew.bat

en la raíz de esa carpeta tenemos nuestro archivo de configuracion build.gradle (configuración del build para el proyecto)  y otros dos gradlew y gradlew.bat, estos ultimos son scripts para ejecutar gradle wrapper ( una herramienta muy util si no disponemos de gradle en nuestro sistema)

## Creando el jar 
para crear el jar en la raiz del directorio escribimos el siguiente comando.
** ./gardlew build (Linux)  ** 
** gradlew.bat build (windows) **

## Corriendo la Rest API
Spring boot nos crea por defecto un jar con un servidor de aplicaciones tomcat embebido, para iniciarlo debemos utilizar nuestra configuracion externa al proyecto (mencionada previemante en este documento)
para ellos vamos a utilizar las properties ** spring.config.name** y  **spring.config.location**, propiedades las cuales deben ser configuradas con los archivos de configuracion a utilizar y la ubicacion de los mismos ( debemos utilizar la ruta absoluta), por lo tanto debemos escribir el sieguiente comando.

**Java -jar -Dspring.config.name=application,database,security,ssl,cors,swagger -Dspring.config.location=`<ruta-absoluta`>/config/dev/   `<ruta-jar`>/geocomRestApi-0.0.1-SNAPSHOT.jar**

## Capturas

![1](https://github.com/eduardoperez2151/geocomRestApi/blob/master/images/RestApi-1.png)
![2](https://github.com/eduardoperez2151/geocomRestApi/blob/master/images/RestApi-2.png)
![3](https://github.com/eduardoperez2151/geocomRestApi/blob/master/images/Swagger-Ingredients-get.png)
![4](https://github.com/eduardoperez2151/geocomRestApi/blob/master/images/SwaggerUI-1.png)
![5](https://github.com/eduardoperez2151/geocomRestApi/blob/master/images/swaggerui-2.png)
![6](https://github.com/eduardoperez2151/geocomRestApi/blob/master/images/swaggerui-3.png)

---

# Geocom Frontend

#### Pasos para correr el proyecto 
Para poder correr el frontend necesitamos tener instalados Node, npm y angular-cli 

[Guia para la instalacion de Node y npm](https://docs.npmjs.com/getting-started/installing-node)
[Guit-hub de angular-cli](https://github.com/angular/angular-cli)

Luego de ser clonado o descargado el proyecto debemos navegar hacia la carpeta **geocomRestApi/frontend/** la misma posee la siguiente estructura 
	
	frontend
	├── e2e
	└── src
	    ├── app
	    │   ├── components
	    │   │   ├── ingredient-form
	    │   │   ├── ingredient-list
	    │   │   ├── navigation-bar
	    │   │   ├── recipe-detail
	    │   │   ├── recipe-form
	    │   │   ├── recipe-form-edit
	    │   │   ├── recipe-item
	    │   │   └── recipe-list
	    │   ├── models
	    │   ├── routes
	    │   └── services
	    ├── assets
	    │   └── img
	    └── environments

Luego debemos ejecutar el comando **npm install** esto nos instalara todas las dependencias del proyecto y se generarar una carpeta llamada node_modules.

## Configuración
En este proyecto el unico archivo que hay que modificar es ServiceUrls.ts que se encuentra en la carpeta **geocomRestApi/frontend/src/app/services**.
Debemos editar la url en donde esta corriendo nuestra Rest Api.

una vez editado este archivo ejecutamos el comando **npm start**
, por defecto levantara un servidor en el puerto 4200.

## Capturas

![1](https://github.com/eduardoperez2151/geocomRestApi/blob/master/images/frontend-1.png)
![2](https://github.com/eduardoperez2151/geocomRestApi/blob/master/images/frontend-2.png)
![3](https://github.com/eduardoperez2151/geocomRestApi/blob/master/images/frontend-3.png)
![4](https://github.com/eduardoperez2151/geocomRestApi/blob/master/images/frontend-4.png)
![5](https://github.com/eduardoperez2151/geocomRestApi/blob/master/images/frontend-5.png)
![6](https://github.com/eduardoperez2151/geocomRestApi/blob/master/images/frontend-6.png)
![7](https://github.com/eduardoperez2151/geocomRestApi/blob/master/images/frontend-7.png)
![8](https://github.com/eduardoperez2151/geocomRestApi/blob/master/images/frontend-8.png)
![9](https://github.com/eduardoperez2151/geocomRestApi/blob/master/images/frontend-9.png)
![10](https://github.com/eduardoperez2151/geocomRestApi/blob/master/images/frontend-10.png)




