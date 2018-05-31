#!/bin/bash

# Proposed directory structure is - 
# Base dir - /home/vikasa/microservices/<servicename>
# Jar dir - /home/vikasa/microservices/<servicename>/<mjaorversion>
# Startup Script dir - /home/vikasa/microservices/<servicename>/<mjaorversion>/<portno>/
# Common Logs dir - /home/vikasa/microservices/logs/

dirpath='<path-to-jar-file>'
port=<portno>
appname='<application-name>'
logpath='<path-to-common-log-directory>'

<path to jdk8>/java -Xmx2048m -Xms512m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$dirpath/$port -Dspring.profiles.active=prod -Dserver.port=$port -Dlog.path=$logpath -Dapp.name=$appname -jar $dirpath/<jar-file-name>.jar >> /dev/null 2>&1 &