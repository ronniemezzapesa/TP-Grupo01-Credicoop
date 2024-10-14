# Utiliza la imagen oficial de MediaWiki
FROM mediawiki:1.39

# Opcional: Instala dependencias adicionales
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    git \
    && rm -rf /var/lib/apt/lists/*

# Copia cualquier archivo adicional o configuración personalizada
COPY LocalSettings.php /var/www/html/LocalSettings.php

# Define el puerto que se expondrá
EXPOSE 80
