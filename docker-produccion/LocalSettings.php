<?php
# Este archivo fue generado automáticamente por el instalador de MediaWiki.

# Configuración de la base de datos
$wgDBtype = getenv('MEDIAWIKI_DB_TYPE');  // Tipo de base de datos (mysql)
$wgDBserver = getenv('MEDIAWIKI_DB_HOST'); // Servidor de la base de datos
$wgDBname = getenv('MEDIAWIKI_DB_NAME');   // Nombre de la base de datos
$wgDBuser = getenv('MEDIAWIKI_DB_USER');   // Usuario de la base de datos
$wgDBpassword = getenv('MEDIAWIKI_DB_PASSWORD'); // Contraseña de la base de datos

# Configuración del sitio
$wgSitename = getenv('MEDIAWIKI_SITE_NAME');  // Nombre del sitio
$wgLanguageCode = getenv('MEDIAWIKI_LANGUAGE_CODE'); // Código de idioma
$wgDefaultSkin = getenv('MEDIAWIKI_DEFAULT_SKIN'); // Piel predeterminada

# Habilitar la carga de archivos 
$wgEnableUploads = true;  
$wgUploadPath = "images";  
$wgUploadDirectory = "$IP/images";  // Directorio de subida de archivos

# Configuraciones adicionales
$wgGroupPermissions['*']['createaccount'] = true; // Permitir creación de cuentas para todos
$wgGroupPermissions['*']['edit'] = true; // Permitir edición para todos

# Definir la ruta del servidor
$wgServer = "http://192.168.232.133:7000"; 

$wgShowExceptionDetails = true;


