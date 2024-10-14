<?php
# This file was automatically generated by the MediaWiki installer.

$wgDBtype = getenv('MEDIAWIKI_DB_TYPE');
$wgDBserver = getenv('MEDIAWIKI_DB_HOST');
$wgDBname = getenv('MEDIAWIKI_DB_NAME');
$wgDBuser = getenv('MEDIAWIKI_DB_USER');
$wgDBpassword = getenv('MEDIAWIKI_DB_PASSWORD');

$wgSitename = getenv('MEDIAWIKI_SITE_NAME');
$wgLanguageCode = getenv('MEDIAWIKI_LANGUAGE_CODE');
$wgDefaultSkin = getenv('MEDIAWIKI_DEFAULT_SKIN');

# Habilitar la carga de archivos (opcional)
$wgEnableUploads = true;
$wgUploadPath = "images";
$wgUploadDirectory = "$IP/images";

# Configuraciones adicionales
$wgGroupPermissions['*']['createaccount'] = true;
$wgGroupPermissions['*']['edit'] = true;

# Fin de la configuración
