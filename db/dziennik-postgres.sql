<<<<<<< HEAD
/* Baza Dziennik */

--USE master;
--DROP DATABASE Dziennik;
--GO

--CREATE DATABASE Dziennik;
--GO

--USE Dziennik;
--GO

--SET LANGUAGE polski;
--GO

SET datestyle = dmy;

----------------- DROP ------------------------

DROP TABLE IF EXISTS Komunikaty;
DROP TABLE IF EXISTS Konto_użytkownika;
DROP TABLE IF EXISTS Prowadzacy_grupa;
DROP TABLE IF EXISTS Student_grupa;
DROP TABLE IF EXISTS Oceny;
DROP TABLE IF EXISTS Grupy;
DROP TABLE IF EXISTS Prowadzacy;
DROP TABLE IF EXISTS Studenci;
DROP TABLE IF EXISTS Przedmioty;

----------------- CREATE -----------------------

CREATE TABLE Studenci
(
    nr_albumu INT CONSTRAINT pk_student PRIMARY KEY,
    imie VARCHAR(30) NOT NULL,
    nazwisko VARCHAR(30) NOT NULL,
    pesel VARCHAR(11) CONSTRAINT ck_student_pesel CHECK (pesel SIMILAR TO '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	adres VARCHAR(50),
	data_ur DATE CONSTRAINT ck_student_data_ur CHECK (data_ur between '1900-01-01' AND '2021-01-01'),
	nr_tel INT CONSTRAINT ck_student_nr_tel CHECK (nr_tel between 100000000 AND 999999999),
	mail VARCHAR(50)
);


CREATE TABLE Prowadzacy
(
    id_prowadzacego INT CONSTRAINT pk_prowadzacy PRIMARY KEY,
    imie VARCHAR(30) NOT NULL,
    nazwisko VARCHAR(30) NOT NULL,
    pesel VARCHAR(11) CONSTRAINT ck_prowadzacy_pesel CHECK (pesel SIMILAR TO '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	adres VARCHAR(50),
	data_ur DATE CONSTRAINT ck_prowadzacy_data_ur CHECK (data_ur between '1900-01-01' AND '2021-01-01'),
	nr_tel INT CONSTRAINT ck_prowadzacy_nr_tel CHECK (nr_tel between 100000000 AND 999999999),
	tytul VARCHAR(50),
	dyzur VARCHAR(150),
	mail VARCHAR(50)
);

CREATE TABLE Przedmioty (
                            id_przedmiotu INT PRIMARY KEY,
                            nazwa VARCHAR(50),
                            opis VARCHAR(250),
                            ects INT
);

CREATE TABLE Oceny (
                       nr_albumu_studenta INT REFERENCES Studenci(nr_albumu),
                       id_przedmiotu INT REFERENCES Przedmioty(id_przedmiotu),
                       id_prowadzacego INT REFERENCES Prowadzacy(id_prowadzacego),
                       wartosc FLOAT CONSTRAINT ck_wartosc CHECK (wartosc IN (2, 3, 3.5, 4, 4.5, 5))
);

CREATE TABLE Grupy (
                       id_grupy INT PRIMARY KEY,
                       id_prowadzacego INT REFERENCES Prowadzacy(id_prowadzacego),
                       id_przedmiotu INT REFERENCES Przedmioty(id_przedmiotu),
                       dzien_zajec VARCHAR(30),
                       godzina_zajec TIME
);


CREATE TABLE Student_grupa
(
    nr_albumu_studenta INT REFERENCES Studenci(nr_albumu),
    id_grupy INT REFERENCES Grupy(id_grupy),
    CONSTRAINT pk_student_grupa PRIMARY KEY(nr_albumu_studenta, id_grupy)
);

CREATE TABLE Prowadzacy_grupa
(
    id_prowadzacego INT REFERENCES Prowadzacy(id_prowadzacego),
    id_grupy INT REFERENCES Grupy(id_grupy),
    CONSTRAINT pk_prowadzacy_grupa PRIMARY KEY(id_prowadzacego, id_grupy)
);

CREATE TABLE Komunikaty
(
    id_prowadzacego INT REFERENCES Prowadzacy(id_prowadzacego),
    tytul VARCHAR(50),
    tresc VARCHAR(250)
);

CREATE TABLE Konto_użytkownika
(
    student_email VARCHAR(50),
    haslo VARCHAR(30),
    typ_uprawnien VARCHAR(10) CONSTRAINT ck_typ_uprawnien CHECK (typ_uprawnien IN ('student', 'lecturer', 'moderator'))
);


--SELECT * FROM Studenci
--SELECT * FROM Prowadzacy
--SELECT * FROM Przedmioty
--SELECT * FROM Oceny
--SELECT * FROM Grupy
--SELECT * FROM Student_grupa
--SELECT * FROM Prowadzacy_grupa
--SELECT * FROM Komunikaty
--SELECT * FROM Konto_użytkownika
=======
/* Baza Dziennik */

--USE master;
--DROP DATABASE Dziennik;
--GO

--CREATE DATABASE Dziennik;
--GO

--USE Dziennik;
--GO

--SET LANGUAGE polski;
--GO

SET datestyle = dmy;

----------------- DROP ------------------------

DROP TABLE IF EXISTS Komunikaty;
DROP TABLE IF EXISTS Konto_użytkownika;
DROP TABLE IF EXISTS Prowadzacy_grupa;
DROP TABLE IF EXISTS Student_grupa;
DROP TABLE IF EXISTS Oceny;
DROP TABLE IF EXISTS Grupy;
DROP TABLE IF EXISTS Prowadzacy;
DROP TABLE IF EXISTS Studenci;
DROP TABLE IF EXISTS Przedmioty;

----------------- CREATE -----------------------

CREATE TABLE Studenci
(
	nr_albumu INT CONSTRAINT pk_student PRIMARY KEY,
	imie VARCHAR(30) NOT NULL,
	nazwisko VARCHAR(30) NOT NULL,
	pesel VARCHAR(11) CONSTRAINT ck_student_pesel CHECK (pesel SIMILAR TO '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	adres VARCHAR(50),
	data_ur DATE CONSTRAINT ck_student_data_ur CHECK (data_ur between '1900-01-01' AND '2021-01-01'),
	nr_tel INT CONSTRAINT ck_student_nr_tel CHECK (nr_tel between 100000000 AND 999999999),
	mail VARCHAR(50)
);


CREATE TABLE Prowadzacy
(
	id_prowadzacego INT CONSTRAINT pk_prowadzacy PRIMARY KEY,
	imie VARCHAR(30) NOT NULL,
	nazwisko VARCHAR(30) NOT NULL,
	pesel VARCHAR(11) CONSTRAINT ck_prowadzacy_pesel CHECK (pesel SIMILAR TO '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	adres VARCHAR(50),
	data_ur DATE CONSTRAINT ck_prowadzacy_data_ur CHECK (data_ur between '1900-01-01' AND '2021-01-01'),
	nr_tel INT CONSTRAINT ck_prowadzacy_nr_tel CHECK (nr_tel between 100000000 AND 999999999),
	tytul VARCHAR(50),
	dyzur VARCHAR(150),
	mail VARCHAR(50)
);

CREATE TABLE Przedmioty (
	id_przedmiotu INT PRIMARY KEY,
	nazwa VARCHAR(50),
	opis VARCHAR(250),
	ects INT
);

CREATE TABLE Oceny (
	nr_albumu_studenta INT REFERENCES Studenci(nr_albumu),
	id_przedmiotu INT REFERENCES Przedmioty(id_przedmiotu),
	id_prowadzacego INT REFERENCES Prowadzacy(id_prowadzacego),
	wartosc FLOAT CONSTRAINT ck_wartosc CHECK (wartosc IN (2, 3, 3.5, 4, 4.5, 5))
);

CREATE TABLE Grupy (
	id_grupy INT PRIMARY KEY,
	id_prowadzacego INT REFERENCES Prowadzacy(id_prowadzacego),
	id_przedmiotu INT REFERENCES Przedmioty(id_przedmiotu),
	dzien_zajec VARCHAR(30),
	godzina_zajec TIME
);


CREATE TABLE Student_grupa
(
	nr_albumu_studenta INT REFERENCES Studenci(nr_albumu),
	id_grupy INT REFERENCES Grupy(id_grupy),
	CONSTRAINT pk_student_grupa PRIMARY KEY(nr_albumu_studenta, id_grupy)
);

CREATE TABLE Prowadzacy_grupa
(
	id_prowadzacego INT REFERENCES Prowadzacy(id_prowadzacego),
	id_grupy INT REFERENCES Grupy(id_grupy),
	CONSTRAINT pk_prowadzacy_grupa PRIMARY KEY(id_prowadzacego, id_grupy)
);

CREATE TABLE Komunikaty
(
    id_prowadzacego INT REFERENCES Prowadzacy(id_prowadzacego),
    tresc VARCHAR(250)
);

CREATE TABLE Konto_użytkownika
(
    student_email VARCHAR(50),
    haslo VARCHAR(30),
    typ_uprawnien VARCHAR(10) CONSTRAINT ck_typ_uprawnien CHECK (typ_uprawnien IN ('student', 'lecturer', 'moderator'))
);


--SELECT * FROM Studenci
--SELECT * FROM Prowadzacy
--SELECT * FROM Przedmioty
--SELECT * FROM Oceny
--SELECT * FROM Grupy
--SELECT * FROM Student_grupa
--SELECT * FROM Prowadzacy_grupa
--SELECT * FROM Komunikaty
--SELECT * FROM Konto_użytkownika
>>>>>>> e81a3090c7bf1164ca908c3a7f625781d6d42e5c
