#!/bin/bash
docker ps 
docker ps -aqf "springdemo"  |xargs docker rm -f  | echo "removed any old running containers(if any)"
docker ps 
