# Este Dockerfile configura una imagen de Jenkins basada en la versión LTS con JDK 17. 
# Se actualizan los paquetes del sistema e instala herramientas comunes como Git, curl y OpenSSH. 
# Finalmente, se asegura que los procesos de Jenkins se ejecuten con el usuario correcto.

docker build -t jenkins:latest .
docker tag jenkins:latest ronniemezzapesa/tp-credicoop:jenkins-latest
docker push ronniemezzapesa/tp-credicoop:jenkins-latest
docker rmi ronniemezzapesa/tp-credicoop:jenkins-latest

