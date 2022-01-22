#!/bin/bash

pip install -r requirements.txt > /dev/null #if doesn't work, replace pip with pip3
docker run -d \
  --name postgresql \
  -e POSTGRES_PASSWORD=$(awk -F "=" '/pass/ {print $2}' dbconfig.ini | sed 's/ //g') \
  -e POSTGRES_USER=$(awk -F "=" '/user/ {print $2}' dbconfig.ini | sed 's/ //g') \
  -e POSTGRES_DB=$(awk -F "=" '/db/ {print $2}' dbconfig.ini | sed 's/ //g') \
  -p $(awk -F "=" '/port/ {print $2}' dbconfig.ini | sed 's/ //g'):5432 \
  postgres:14.1
sleep 10 # database needs some time to set up
python import_demo.py #if doesn't work, replace python with python3
echo "The database is ready!"
