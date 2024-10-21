Para crear el secrets.yml(VM infra):
ansible-vault create secrets.yml

Para no tener que poner la contraseña ecada vez que inicio el playbook creo el vault_pass.txt(VM infra):
nano vault_pass.txt

Para ejecutar el playbook principal:
ansible-playbook -i inventory.ini backup-BoxedApp.yml --vault-password-file vault_pass.txt 

Para ejecutar el playboock que escala o desescala a la APPx-API:
ansible-playbook -i inventory.ini deployment-APPx-API.yml --vault-password-file vault_pass.txt