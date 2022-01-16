#!/usr/bin/python3

import psycopg2
import configparser

#to be changed possibly (maybe replaced by env vars when running Docker?)
config = configparser.ConfigParser()
config.read('dbconfig.ini')

conn = psycopg2.connect(
    user=config['PostgreSQL']['user'],
    password=config['PostgreSQL']['pass'],
    host=config['PostgreSQL']['host'],
    port=config['PostgreSQL']['port'],
    database=config['PostgreSQL']['db'])

cursor = conn.cursor()

cursor.execute("""SELECT table_name FROM information_schema.tables
       WHERE table_schema = 'public'""")
for table in cursor.fetchall():
    cursor.execute(f"DELETE FROM {table[0]}")
    conn.commit()
