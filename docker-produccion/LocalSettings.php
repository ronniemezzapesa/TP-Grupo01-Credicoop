<?php
$wgSitename = "MiWiki";  // Nombre de tu wiki
$wgMetaNamespace = "Miwiki";  // Espacio de nombres

$wgServer = "http://192.168.232.132:7000";  // URL base para acceder a tu wiki
$wgDBtype = "mysql";  // Tipo de base de datos (puede ser 'mysql' o 'postgres')
$wgDBserver = "db";  // Nombre del contenedor de la base de datos (que será tu servicio en docker-compose)
$wgDBname = "wikidb";  // Nombre de la base de datos que deseas usar
$wgDBuser = "wikiuser";  // Usuario de la base de datos
$wgDBpassword = "wikisecret";  // Contraseña de la base de datos

// Configuraciones adicionales (opcional)
$wgEnableUserEmail = true;  // Permitir que los usuarios envíen correos electrónicos
$wgEnableNotifications = true;  // Habilitar notificaciones
$wgDefaultSkin = "vector";  // Skin predeterminado (puedes cambiar a otro skin)

$wgResourceModules['ext.visualEditor'] = [
    'scripts' => [
        'ext.visualEditor.js',
    ],
    'styles' => [
        'ext.visualEditor.css',
    ],
];
