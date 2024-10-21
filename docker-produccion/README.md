Primero deben iniciar el contenedor sin el volumen de localsettings 
Luego cuando inicien el contenedor deben completar la instalacion dependiendo las variables de entorno que ustedes escogieron
Cuando completen la insalacion deben agregar el archivo local settings que se les haya  al lado del archivo docker-compose.yml y tambien deben agregar el volumen al docker-compose con esta linea:
./LocalSettings.php:/var/www/html/LocalSettings.php
Luego deben hacer un docker-compose down y volver a levantarlo con un docker-compose up -d
asi ya tienen su mediawiki funcionando
