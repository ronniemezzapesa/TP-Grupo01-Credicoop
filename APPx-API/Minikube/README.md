minikube start --driver=docker
kubectl apply -f .
kubectl get pods
kubectl logs 
kubectl delete pods --all
kubectl rollout restart deployment appx-api-deployments

# DESCRIPCION BREVE DE CADA .YAML

appx-api-deployment.yaml:
    Define una réplica del contenedor que ejecuta la imagen ronniemezzapesa/tp-credicoop:latest, exponiendo el puerto 8080. 
    Además, utiliza un ConfigMap para inyectar las variables de entorno necesarias para la conexión a una base de datos PostgreSQL (como el nombre de la base de datos, usuario y URL) y un Secret para manejar de manera segura la contraseña de la base de datos. 
    También emplea imagePullSecrets para autenticar la descarga de la imagen desde un registro privado.

appx-api-service.yaml:
    Configura un Service de Kubernetes para la aplicación. Utiliza un selector que coincide con los Pods etiquetados como app: appx-api y expone el puerto 80 para que los usuarios externos accedan a la aplicación. 
    El tráfico que llega al puerto 80 se redirige al puerto 8080 del contenedor. 
    El tipo de servicio es LoadBalancer, lo que significa que distribuye el tráfico entrante a través de las réplicas del Pod y proporciona una IP externa para el acceso.

db-deployment.yaml:
    Crea un Deployment de Kubernetes para el servicio de base de datos PostgreSQL llamado dbservice. Define una única réplica del contenedor que utiliza la imagen de Postgres y expone el puerto 5432 para las conexiones a la base de datos. Además, configura las variables de entorno necesarias para la base de datos: POSTGRES_DB establece el nombre de la base de datos en dbservice, POSTGRES_USER define el usuario como postgres, y POSTGRES_PASSWORD se extrae de un secreto almacenado en db-secret.

db-service.yaml:
    Configura un Service de Kubernetes para el servicio de base de datos dbservice. Expone el puerto 5432, que es el puerto estándar de PostgreSQL, y mapea el tráfico entrante al mismo puerto dentro del contenedor. El tipo de servicio es NodePort, lo que permite acceder a la base de datos desde fuera del clúster a través del puerto 30000 en cualquier nodo del clúster. El selector garantiza que este servicio enrute el tráfico a los Pods etiquetados como app: dbservice.
