#!/usr/bin/python3

# pip install psycopg2
import pandas as pd
import configparser
from sqlalchemy.engine.url import URL
from sqlalchemy import create_engine


def create_tables(conn):
    cursor = conn.cursor()
    sql_file = open("dziennik-postgres.sql", "r", encoding="utf-8").read()

    cursor.execute(sql_file)
    conn.commit()


def parse_csvs():
    studenci = pd.read_csv("../proj/dane_demo/studenci.csv", dtype={'pesel': object})
    prowadzacy = pd.read_csv("../proj/dane_demo/prowadzacy.csv", dtype={'pesel': object})
    przedmioty = pd.read_csv("../proj/dane_demo/przedmioty.csv")
    oceny = pd.read_csv("../proj/dane_demo/oceny.csv")
    grupy = pd.read_csv("../proj/dane_demo/grupy.csv")
    student_grupa = pd.read_csv("../proj/dane_demo/student_grupa.csv")
    komunikaty = pd.read_csv("../proj/dane_demo/komunikaty.csv")
    konto_uzytkownika = pd.read_csv("../proj/dane_demo/konto_użytkownika.csv")

    # have to convert date formats from %d.%m.%Y to %m-%d-%Y
    studenci['data_ur'] = pd.to_datetime(studenci['data_ur'], format='%d.%m.%Y').dt.strftime('%m-%d-%Y')
    prowadzacy['data_ur'] = pd.to_datetime(prowadzacy['data_ur'], format='%d.%m.%Y').dt.strftime('%m-%d-%Y')

    return [studenci, prowadzacy, przedmioty, oceny, grupy, student_grupa, komunikaty, konto_uzytkownika]


def import_data(engine, dfs):
    dfs[0].to_sql('studenci', engine, if_exists='append', index=False)
    dfs[1].to_sql('prowadzacy', engine, if_exists='append', index=False)
    dfs[2].to_sql('przedmioty', engine, if_exists='append', index=False)
    dfs[3].to_sql('oceny', engine, if_exists='append', index=False)
    dfs[4].to_sql('grupy', engine, if_exists='append', index=False)
    dfs[5].to_sql('student_grupa', engine, if_exists='append', index=False)
    dfs[6].to_sql('komunikaty', engine, if_exists='append', index=False)
    dfs[7].to_sql('konto_użytkownika', engine, if_exists='append', index=False)


if __name__ == '__main__':
    config = configparser.ConfigParser()
    config.read('dbconfig.ini')
    connect_url = URL.create(
        drivername=config['PostgreSQL']['driver'],
        username=config['PostgreSQL']['user'],
        password=config['PostgreSQL']['pass'],
        host=config['PostgreSQL']['host'],
        port=config['PostgreSQL']['port'],
        database=config['PostgreSQL']['db'])

    engine = create_engine(connect_url)
    conn = engine.raw_connection()

    create_tables(conn)
    dfs = parse_csvs()
    import_data(engine, dfs)
