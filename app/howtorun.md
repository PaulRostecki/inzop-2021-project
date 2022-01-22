# Wymagania:

 - Java 11
 - Maven 3.x
 - Docker 3.6+
 - Python 3.x
 - IDE do wykonania kodu Javy (preferowalnie IntelliJ IDEA)
 - połączenie z internetem podczas budowania/używania aplikacji oraz podczas pierwszego stawiania kontenera z bazą.

# Jak postawić program:

1. Z katalogu db, uruchom rundatabase.sh (jeżeli coś nie działa, spróbuj w skrypcie podmienić polecenie 'python' na 'python3' i/lub 'pip' na 'pip3') 
2. Otwórz projekt w IDE.
3. Zbuduj projekt Mavenem ( komenda: 'mvn clean install' ).
4. Uruchom program z src/main/java/init/AppInitializer#main.
5. Zaloguj się na jedno z istniejących w bazie kont  i używaj programu.
