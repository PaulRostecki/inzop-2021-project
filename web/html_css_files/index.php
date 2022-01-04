<!DOCTYPE html>
<html lang="pl-PL">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>eDzienniczek</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="./styles/style.css" />
    <script defer src="./script/scripts.js"></script>
    <script defer src="./script/jquery-1.12.4.min.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600;700;800;900&display=swap" rel="stylesheet">
</head>

<body>
    <div class="container">
        <header>
            <nav id="nav-grabber">
                <h1>eDzienniczek</h1>
                <button class="navbar-toggler" onclick="navbar(this)">
                    <div class="navbar-toggler-icon"></div>
                </button>
                <ul class="navbar-collapse">
                    <li class="item"><a href="#">Strona główna</a></li>
                    <li class="item"><a href="#project">O projekcie</a></li>
                    <li class="item"><a href="#functions">Funkcjonalności</a></li>
                    <li class="item"><a href="#creators">O twórcach</a></li>
                    <li class="item"><a href="#contact">Kontakt</a></li>
                </ul>
            </nav>
        </header>
        <main>
            <section class="front-page" id="front-page">
                <h2>Intuicyjny i<br>rozbudowany<br> dziennik elektroniczny</h2>
                <p>Inżynieria oprogramowania - projekt zaliczeniowy</p>
                <a href="doc.php" class="btn">Dokumentacja</a>
            </section>

            <section class="project" id="project">
                <div class="item1">
                    <img src="svg/main-website/SVG-pic-o-projekcie.svg" alt="">
                </div>
                <div class="item2">
                    <h2>O projekcie</h2>
                    <p>Naszym głównym założeniem w projekcie było
                        utworzenie wygodnej aplikacji, przypominającej
                        znane nam już dotychczas dzienniki
                        elektroniczne, stosowane w szkołach oraz
                        uniwersytetach.
                    </p>
                </div>
            </section>

            <section class="functions" id="functions">
                <h2>Główne funkcjonalności dziennika</h2>
                <ul>
                    <li>Dodawanie ocen przez prowadzącego</li>
                    <li>Edycja ocen przez prowadzącego</li>
                    <li>Wyświetlanie zawartości: planu lekcji, ocen, grup, informacji o użytkowniku</li>
                    <li>Przesylanie / Odbieranie komunikatów</li>
                    <li>Dodawanie nowego/nowej: studenta, prowadzącego, grupy, przedmiotu</li>
                    <li>Usuwanie: studenta, prowadzącego, grupy przedmiotu</li>
                </ul>
            </section>

            <section class="creators" id="creators">
                <div class="item1">
                    <img src="svg/main-website/SVG-o-tworcach.svg" alt="">
                </div>
                <div class="item2">
                    <h2>O twórcach</h2>
                    <p>Cały projekt powstał w oparciu o pracę trzynastu osób.
                        W skład zespołu wchodzili m.in.:
                    </p>
                    <ul>
                        <li>Project Manager</li>
                        <li>Test Manager</li>
                        <li>Process Engineer</li>
                        <li>System Testers</li>
                        <li>Software Architects</li>
                        <li>System Analysts</li>
                        <li>System Administrators</li>
                        <li>UI Designer</li>
                        <li>Implementations</li>
                    </ul>
                    <a href="#" class="btn">Więcej</a>
                </div>
            </section>

            <section class="contact" id="contact">
                <h2>Kontakt</h2>
                <form action="" method="get" class="form-style">
                    <label for="name"><span>Imię i nazwisko:</span>
                        <input type="text" name="name" id="name" required></label>
                    <label for="email"><span>Adres e-mail:</span>
                        <input type="email" name="email" id="email" required>
                    </label>
                    <label for="text">
                        <span>Treść wiadomości:</span>
                        <textarea></textarea>
                    </label>
                    <input type="submit" value="Wyślij" class="btn">
                </form>
            </section>
        </main>
        <footer>
            <h1>eDzienniczek</h1>
        </footer>
    </div>
</body>

</html>