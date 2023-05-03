#!/bin/bash
pwd 
id 
ls -lrt /tmp 
ls -lrt ~
echo $HOME
cd /tmp; docker build -t springdemo:latest .
docker run --name springdemo -p 8080:8080 -d springdemo:latest 
