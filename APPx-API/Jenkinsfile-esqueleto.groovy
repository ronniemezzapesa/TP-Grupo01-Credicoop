pipeline {
    agent any

    environment {
        // Variables de entorno para el directorio de trabajo, la imagen de Docker, etc.
    }

    stages {
        stage('Checkout') {
            steps {
                // Clona el repositorio del proyecto desde GitHub
            }
        }

        stage('Build') {
            steps {
                // Compila la aplicación utilizando Maven
            }
        }

        stage("SonarQube Analysis") {
            steps {
                // Realiza el análisis de calidad del código con SonarQube
            }
        }

        stage('Build Docker Image') {
            steps {
                // Construye la imagen de Docker a partir del Dockerfile
            }
        }

        stage('Push Docker Image') {
            steps {
                // Inicia sesión en Docker Hub y empuja la imagen construida
            }
        }

        stage('Restart Deployment') {
            agent { label 'minikube' }
            steps {
                // Reinicia el despliegue en Minikube
            }
        }
    }
}
