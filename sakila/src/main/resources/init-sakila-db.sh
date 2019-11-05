#!/bin/bash

if [ $# -ne 1 ]
then
	echo "Required arguments start | stop"
	exit 1
fi

DB_HOST_IP=172.22.0.10
DB_ROOT_PASSWORD=s3cret
DB_NETMASK=172.22.0.0/16
DB_PORT=3306
DB_HOSTNAME=sakila
DB_NETWORK_NAME=dbms-network
DOCKER_CONTAINER_NAME=mysql_container

if [ $1 == "start" ]
then
	echo "Starting Docker Container"

	docker network create -d bridge --subnet $DB_NETMASK $DB_NETWORK_NAME

	docker run --detach --network $DB_NETWORK_NAME --ip $DB_HOST_IP -e MYSQL_ROOT_PASSWORD=$DB_ROOT_PASSWORD --name $DOCKER_CONTAINER_NAME mysql 

	until [ "docker inspect $DOCKER_CONTAINER_NAME -f {{.State.Status}}" != "running" ]
	do
		sleep 0.1
	done

	#Poor solution for wait until server started in container
	#Should be fixied with proper while loop (bash)
	while true; do
		#statements
		#echo "Connection Refused"
		#echo "nc -z -v $DB_HOST_IP $DB_PORT"
		#If the netcat connects sucessfully then it return 0 then breaks the loop
		#otherwise it 
		nc -z $DB_HOST_IP $DB_PORT
		if [ $? -eq 0 ]
		then
			break
		fi
		sleep 0.5
	done
	

	docker exec -i $DOCKER_CONTAINER_NAME mysql -uroot -p$DB_ROOT_PASSWORD < ./sakila-schema.sql
	docker exec -i $DOCKER_CONTAINER_NAME mysql -uroot -p$DB_ROOT_PASSWORD < ./sakila-data.sql
fi

if [ $1 == "stop" ]
then
	echo "Stop Docker Container"
	docker stop $DOCKER_CONTAINER_NAME
	docker container rm $DOCKER_CONTAINER_NAME
fi
