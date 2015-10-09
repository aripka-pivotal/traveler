#!/bin/bash
COUNTER=0
TOP=$1
while [ $COUNTER -lt $TOP ]; do
	curl http://localhost:8080/refresh
	let COUNTER=COUNTER+1
	sleep .45
done
