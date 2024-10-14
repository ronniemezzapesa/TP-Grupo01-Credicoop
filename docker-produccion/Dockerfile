# Utiliza la imagen oficial de MediaWiki
FROM mediawiki:1.39

# Opcional: Instala dependencias adicionales
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    git \
    && rm -rf /var/lib/apt/lists/*

# Copia cualquier archivo adicional o configuración personalizada
COPY LocalSettings.php /var/www/html/LocalSettings.php

# Ajusta permisos para LocalSettings.php
RUN chown www-data:www-data /var/www/html/LocalSettings.php && \
    chmod 600 /var/www/html/LocalSettings.php

# Ejecuta el script de actualización de la base de datos antes de iniciar Apache
CMD ["/bin/bash", "-c", "php /var/www/html/maintenance/update.php && apache2-foreground"]

# Define el puerto que se expondrá
EXPOSE 80
