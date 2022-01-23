# Wymagania:

 - Java 11
 - Maven 3.x
 - Docker 3.6+
 - Python 3.x
 - IDE do wykonania kodu Javy (preferowalnie IntelliJ IDEA)
 - połączenie z internetem podczas budowania/używania aplikacji oraz podczas pierwszego stawiania kontenera z bazą.

# Jak postawić program:

1. Upewnij się, że Docker jest uruchomiony oraz port 5432 jest wolny (jeśli ktoś z was ma lokalnie postawioną bazę na Postgresie to może wystąpić konflikt).
2. Z katalogu db, uruchom rundatabase.sh (jeżeli coś nie działa, spróbuj w skrypcie podmienić polecenie 'python' na 'python3' i/lub 'pip' na 'pip3') 
3. Otwórz folder 'app' jako projekt w IDE ( !!! w przypadku otwarcia projektu z folderu inzop-2021-project mogą wystąpić problemy z Mavenem !!! )
4. Zbuduj projekt Mavenem ( komenda: 'mvn clean install' ).
5. Uruchom program z src/main/java/init/AppInitializer#main.
6. Zaloguj się na jedno z istniejących w bazie kont i używaj programu.

# Testowanie programu

Po utworzeniu się kontenera z bazą zostanie uruchomiony skrypt z importem danych testowych.

Podczas pracy na programie zalecam logować się na poniższe konta:

 - STUDENT: email: jedryb@st.amu.edu.pl, hasło: ocft0f0

 - WYKŁADOWCA: email: galazka@amu.edu.pl, hasło: bcmhh1c

 - MODERATOR: email: projectmod@amu.edu.pl, hasło: xq0ukbo
