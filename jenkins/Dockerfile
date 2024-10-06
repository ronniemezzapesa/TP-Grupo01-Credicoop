# Usa la imagen oficial de Jenkins con JDK 17 como base
FROM jenkins/jenkins:lts-jdk17

# Cambia al usuario root para poder instalar los paquetes necesarios
USER root

# Actualiza los paquetes e instala los requeridos
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    ca-certificates \
    curl \
    fontconfig \
    git \
    git-lfs \
    less \
    netbase \
    openssh-client && \
    rm -rf /var/lib/apt/lists/*

# Regresa al usuario Jenkins para que los procesos corran con el usuario correcto
USER jenkins
