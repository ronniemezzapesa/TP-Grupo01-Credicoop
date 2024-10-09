# dds-deploy

En esta carpeta se encuentran los archivos de configuracion necesarios para la APPx-API

docker-compose.yml: 
-> Diferente al usado en infraestructura
-> appx-api:
            Build: Construye una imagen Docker usando el Dockerfile en el directorio actual.
            Puertos: Expone el puerto 8080 para acceder a la aplicación.
            Variables de entorno: Carga variables desde un archivo .env y define la conexión a la base de datos PostgreSQL a través del servicio dbservice.
            Red: Conecta el servicio a la red personalizada app-network.

-> dbservice (PostgreSQL):
            Imagen: Usa la imagen oficial de PostgreSQL.
            Variables de entorno: Carga variables desde el archivo env_variables.env, 
            como el nombre de la base de datos, usuario y contraseña.
            Puertos: Expone el puerto 5432 para conectarse a la base de datos.
            Red: Conecta el servicio a la red personalizada app-network.
            La red app-network asegura que ambos servicios puedan comunicarse entre sí dentro del mismo entorno.

pom.xml: Archivo .xml que contiene informacion sobre el .net Libros 

Jenkinsfile: 
Contiene un pipeline con los stages y steps correspondientes al despliegue
Realiza inicialmente una configuracion de entorno
Luego los siguientes stages: 
-> Checkout: Clona el repositorio desde GitHub en el directorio de trabajo del build
-> Build: Compila la aplicación usando Maven.
-> Sonarqube Analisis: Ejecuta el análisis de calidad de código con SonarQube.
-> Build Docker Images: Crea una imagen Docker para la aplicación.
-> Push Docker Images: Publica la imagen Docker en Docker Hub.
-> Restart Deployment: Reinicia el despliegue de la aplicación en Minikube.
