# This is not a ShellScript
# This file explains some commands that were issued during the configuration of the example.


# Run MySQL server in a Docker Container
# ROOT Password is set to s3cret
# Container belongs to the dbms-network which was already defined.
# Network mask is 172.22.0.0/16
#
# Contaner is named as mysql
# If container name us already used then issue the following command.
# docker container rm mysql

# Container run detached

docker run --name mysql -e MYSQL_ROOT_PASSWORD=s3cret --network dbms-network --ip 172.22.0.2 -d mysql

# You can connect to the MySQL Server as root
mysql -u root -ps3cret --host 172.22.0.2
# You can initialize the user and the database.
# username: springuser
# password: s3cret
mysql -u root -ps3cret --host 172.22.0.2 < createDB.sql

# You can connect to the server as spring user
mysql -u springuser -ps3cret --host 172.22.0.2