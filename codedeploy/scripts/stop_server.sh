#!/bin/bash
docker ps 
docker kill $(docker ps -q)
docker ps 
