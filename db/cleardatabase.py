#!/usr/bin/python3

import psycopg2

#to be changed possibly (maybe replaced by env vars when running Docker?)
conn = psycopg2.connect(
    host = '127.0.0.1',
    port = 5432,
    database = 'postgres',
    user = 'postgres',
    password = 'admin')

cursor = conn.cursor()

cursor.execute("""SELECT table_name FROM information_schema.tables
       WHERE table_schema = 'public'""")
for table in cursor.fetchall():
    cursor.execute(f"DELETE FROM {table[0]}")
    conn.commit()
