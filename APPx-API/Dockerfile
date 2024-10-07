# Usa una imagen base de Maven para compilar la aplicación
FROM maven:3.8.6-openjdk-11 AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml y el código fuente
COPY pom.xml .
COPY src ./src

# Compila la aplicación
RUN mvn clean package -DskipTests

# Usa una imagen base de Java para ejecutar la aplicación
FROM openjdk:11-jre-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR de la etapa de compilación
COPY --from=build /app/target/*.jar appx-api.jar

# Expone el puerto en el que la aplicación se ejecuta
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "appx-api.jar"]
