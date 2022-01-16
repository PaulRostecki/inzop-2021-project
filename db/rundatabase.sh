#!/bin/bash

pip3 install -r requirements.txt > /dev/null
docker run -d \
  --name postgresql \
  -e POSTGRES_PASSWORD=$(awk -F "=" '/pass/ {print $2}' dbconfig.ini | sed 's/ //g') \
  -e POSTGRES_USER=$(awk -F "=" '/user/ {print $2}' dbconfig.ini | sed 's/ //g') \
  -e POSTGRES_DB=$(awk -F "=" '/db/ {print $2}' dbconfig.ini | sed 's/ //g') \
  -p $(awk -F "=" '/port/ {print $2}' dbconfig.ini | sed 's/ //g'):5432 \
  postgres:14.1
sleep 1 # database needs some time to set up
python3 import_demo.py
echo "The database is ready!"
