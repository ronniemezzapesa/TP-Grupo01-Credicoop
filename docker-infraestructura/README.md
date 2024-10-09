Este archivo docker-compose.yaml configura dos servicios: SonarQube y Jenkins. 
SonarQube usa la imagen sonarqube:community,
que se encuentra en un container sonarqube, 
expone el puerto 9000 y define volúmenes para persistir extensiones, logs y datos temporales. 
Jenkins utiliza una imagen personalizada, expone los puertos 8080 y 50000, depende de SonarQube para iniciar. 
Ambos servicios usan volúmenes para persistir datos y se reinician automáticamente según sea necesario.

