<!DOCTYPE html>
<html lang="pl-PL">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>eDzienniczek</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="./styles/doc.css" />
    <script defer src="script/scripts.js"></script>
    <script defer src="script/jquery-1.12.4.min.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600;700;800;900&display=swap" rel="stylesheet">
</head>

<body>
    <nav>
        <button class="navbar-toggler" onclick="toggleSidebar(this)">
            <div class="navbar-toggler-icon"></div>
        </button>
        <ul class="menu">
            <li class="item">Dokumentacja</li>
            <ul class="sub-menu">
                <li class="sub-item"><a href="#">O projekcie</a></li>
                <li class="sub-item"><a href="#">Zastosowany model projektu</a></li>
                <li class="sub-item">Zastosowane technologie</li>
                <ul class="sub-menu">
                    <li class="sub-item">Aplikacja desktopowa</li>
                    <ul class="sub-menu">
                        <li class="sub-item"><a href="#">Java</a></li>
                        <li class="sub-item"><a href="#">JavaFX</a></li>
                        <li class="sub-item"><a href="#">Maven</a></li>
                        <li class="sub-item"><a href="#">Hibernate</a></li>
                        <li class="sub-item"><a href="#">Spring</a></li>
                        <li class="sub-item"><a href="#">JUnit</a></li>
                        <li class="sub-item"><a href="#">Log4j2</a></li>
                    </ul>
                    <li class="sub-item">Strona internetowa</li>
                    <ul class="sub-menu">
                        <li class="sub-item"><a href="#">HTMl</a></li>
                        <li class="sub-item"><a href="#">CSS</a></li>
                        <li class="sub-item"><a href="#">JavaScript</a></li>
                        <li class="sub-item"><a href="#">React</a></li>
                    </ul>
                    <li class="sub-item">Bazy danych</li>
                    <ul class="sub-menu">
                        <li class="sub-item"><a href="#">T-SQ</a></li>
                        <li class="sub-item"><a href="#">MSSQL</a></li>
                    </ul>
                    <li class="sub-item">Inne</li>
                    <ul class="sub-menu">
                        <li class="sub-item"><a href="#">Git</a></li>
                        <li class="sub-item"><a href="#">GitHub</a></li>
                        <li class="sub-item"><a href="#">Taiga</a></li>
                    </ul>
                </ul>
                <li class="sub-item"><a href="#">Twórcy projektu</a></li>
            </ul>
        </ul>
    </nav>
    <div class="container">
        <header>
            <h1>eDzienniczek</h1>
            <a href="./index.php" class="btn">Strona projektu</a>
        </header>
        <main>
            <section class="front-page" id="front-page">
                <h1>
                    < Dokumentacja />
                </h1>
                <article class="sub-container">
                    <h2>
                        < O projekcie />
                    </h2>
                    <p>Naszym głównym założeniem w projekcie było utworzenie wygodnej i
                        intuicyjnej aplikacji, przypominającą znane nam już dotychczas
                        dzienniki elektroniczne, stosowane w szkołach (np. MobiDziennik)
                        oraz uniwerstytetach (np. USOS).</p>
                </article>

                <article class="sub-container">
                    <h2>
                        < Zastosowany model projektu />
                    </h2>
                    <article></article>
                    <p>Zastosowany przez nas model projektowy - <b>RUP (Rational Unified Process)</b> jest metodyką
                        zakładającą iteracyjny proces tworzenia oprogramowania. Metodyka ta wprowadza reguły oraz
                        dobre praktyki dla wszystkich faz wytwarzania oprogramowania.<br>

                        W każdej iteracji wytwarzany jest fragment systemu, który jest udostępniany klientowi. Pozwala
                        to na uzyskanie szybkiej informacji zwrotnej i upewnieniu się, że zespół realizujący projekt dobrze
                        zrozumiał wymagania i oczekiwania klienta. Szybkie wykrycie ewentualnych problemów lub
                        nieporozumień, pozwala szybko wprowadzić odpowiednie modyfikacje.</p>
                </article>

                <article class="sub-container">
                    <h2>
                        < Zastosowane technologie />
                    </h2>

                    <h3>Aplikacja desktopowa</h3>

                    <h4>Java</h4>
                    <p>To najpopularniejszy język programowania i najczęściej wybierana platforma programistyczna.
                        Obniża koszty, skraca czas programowania, pobudza innowacyjność i usprawnia usługi aplikacj.</p>
                    <a class="zastosowanie" href="#">Wiecej</a>

                    <h4>JavaFX</h4>
                    <p>Następca już prawie wymarłego ANT a. Maven potrafi zrobić wszystko z naszym projektem
                        podczas jego budowania. Jedyne co musimy zrobić to zastosować się do konwencji
                        nazewnictwa katalogów w projekcie jaką wymaga Maven. Jeśli to zrobimy - sam Maven
                        zatroszczy się o kompilowanie kodu, wykonywanie testów itd.</p>
                    <a class="zastosowanie" href="#">Wiecej</a>

                    <h4>Hibernate</h4>
                    <p>Framework stanowiący jedną z najpopularniejszych implementacji Java Persistence API (JPA).
                        Umożliwia on dokonania mapowania obiektowo-relacyjnego (ORM) - czyli odzworowania
                        obiektów klas na bazę danych. Najprościej mówiąc odpowiada za wygodną komunikację
                        aplikacji z bazą danych</p>
                    <a class="zastosowanie" href="#">Wiecej</a>

                    <h4>Spring</h4>
                    <p>Narzędzie, które znacznie skraca proces tworzenia aplikacji. Stanowi szereg usprawnień, których
                        implementacja w Javie zajęłaby wieki.</p>
                    <a class="zastosowanie" href="#">Wiecej</a>

                    <h4>JUnit</h4>
                    <p>Narzędzie służące do tworzenia powtarzalnych testów jednostkowych oprogramowania
                        pisanego w języku Java.</p>
                    <a class="zastosowanie" href="#">Wiecej</a>

                    <h4>Log4j2</h4>
                    <p>Biblioteka języka programowania Java służąca do tworzenia logów podczas działania aplikacji.</p>
                    <a class="zastosowanie" href="#">Wiecej</a>


                    <h3>Strona internetowa</h3>

                    <h4>HTML</h4>
                    <p>Język znaczników stosowany do tworzenia dokumentów hipertekstowych.</p>
                    <a class="zastosowanie" href="#">Wiecej</a>

                    <h4>CSS</h4>
                    <p>Kaskadowe arkusze stylów to język, który wnosi styl do stron internetowych poprzez interakcję z
                        elementami HTML.</p>
                    <a class="zastosowanie" href="#">Wiecej</a>

                    <h4>JavaScript</h4>
                    <p>Język programowania, który umożliwia wdrożenie na stronie internetowej skoplikowanych
                        elementów, dzięki którym strona ta może nie tylko wyświetlać statyczne informacje, ale również
                        obsługiwac zmianę treść odpowiednio do sytuacji, wyświetlać interaktywne mapy i animacje
                        grafiki 2D/3D, wyświetlać wideo itd.</p>
                    <a class="zastosowanie" href="#">Wiecej</a>

                    <h4>React</h4>
                    <p>JavaScriptowa biblioteka służąca do tworzenia interfejsów użytkownika.</p>
                    <a class="zastosowanie" href="#">Wiecej</a>


                    <h3>Bazy danych</h3>

                    <h4>T-SQL</h4>
                    <p>Rozszerzenie języka SQL. T-SQL jest językiem proceduralnym. Możemy za jego pomocą stosować
                        typowe elementy programowania jak pętle, intrukcje warunkowe, możemy także tworzyć własne
                        funkcje, procedury i operować na zmiennych.</p>
                    <a class="zastosowanie" href="#">Wiecej</a>

                    <h4>MSSQL</h4>
                    <p>System zarządzania bazą danych.</p>
                    <a class="zastosowanie" href="#">Wiecej</a>


                    <h3>Inne</h3>

                    <h4>Git</h4>
                    <p>Jest rozproszonym systemem kontroli wersji ułatwiającym pracę nad tworzeniem aplikacji, stron
                        internetowych i innych narzędzi w grupach. System śledzi wszystkie wykonywane zmiany w
                        plikach, a także umożliwia przywrócenie ich dowolnej, wcześniejszej wersji.</p>
                    <a class="zastosowanie" href="#">Wiecej</a>

                    <h4>GitHub</h4>
                    <p>To usługa hostingu umożliwiająca zarządzanie repozytoriami Git. Przy jego pomocy jesteśmy w
                        stanie udostępnić swój kod w jednym miejscu dla wszystkich.</p>
                    <a class="zastosowanie" href="#">Wiecej</a>

                    <h4>Taiga</h4>
                    <p>To darmowy system zarządzania projektami typu open source dla startupów, programistów i
                        projektantów.</p>
                    <a class="zastosowanie" href="#">Wiecej</a>

                </article>

                <article class="sub-container">
                    <h2>
                        < Twórcy projektu />
                    </h2>
                    <ul>
                        <li class="item">Michał Musiałowicz - Project Manager, Implementator (java), Integrato<a href="http://" class="git"></a><a href="http://" class="linkedin"></a></li>
                        <li class="item">Michał Nowak - Process Engineer, Implementator (java)<a href="http://" class="git"></a><a href="http://" class="linkedin"></a></li>
                        <li class="item">Krzysztof Raczyński - Software Architect/Database Designer<a href="http://" class="git"></a><a href="http://" class="linkedin"></a></li>
                        <li class="item">Miłosz Konarski - Software Architect/Database Designer<a href="http://" class="git"></a><a href="http://" class="linkedin"></a></li>
                        <li class="item">Paweł Rostecki - System Administrator<a href="http://" class="git"></a><a href="http://" class="linkedin"></a></li>
                        <li class="item">Jędrzej Wesołowski - Implementator (web)<a href="http://" class="git"></a><a href="http://" class="linkedin"></a></li>
                        <li class="item">Szymon Mazurek - Implementator (web)<a href="http://" class="git"></a></li>
                        <li class="item">Mateusz Cwojdziński - Implementator (web)<a href="http://" class="git"></a><a href="http://" class="linkedin"></a></li>
                        <li class="item">Jędrzej Rybczyński - Implementator, System Administrator (support)<a href="http://" class="git"></a><a href="http://" class="linkedin"></a></li>
                        <li class="item">Dominika Leśniewska - System Analyst, UI Designer<a href="http://" class="git"></a><a href="http://" class="linkedin"></a></li>
                        <li class="item">Maciej Maciejewski - System Analyst<a href="http://" class="git"></a><a href="http://" class="linkedin"></a></li>
                        <li class="item">Maksymilian Łasecki - System Tester (manual testing), Course Developer<a href="http://" class="git"></a><a href="http://" class="linkedin"></a></li>
                        <li class="item">Mikołaj Mumot - Test Manager, System Tester (automatic testing)<a href="http://" class="git"></a><a href="http://" class="linkedin"></a></li>
                    </ul>
                </article>
            </section>
        </main>
        <footer>
            <h1>eDzienniczek</h1>
        </footer>
    </div>
</body>

</html>