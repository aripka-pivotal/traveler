#!/bin/bash
COUNTER=0
TOP=$1
while [ $COUNTER -lt $TOP ]; do
	curl http://agency-air.west-1.fe.gopivotal.com
	let COUNTER=COUNTER+1
	sleep .35
done
