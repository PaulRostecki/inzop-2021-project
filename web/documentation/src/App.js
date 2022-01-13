// Import Ui components
import Header from "./components/Header";
import AboutSection from "./components/AboutSection";
import TechnologySection from "./components/TechnologySection";
import CreatorsList from "./components/CreatorsList";
import HeaderSection from "./components/HeaderSection";

// Import logos

import MapUniversity from "./icons/map_university.svg";

function App() {
  return (
    <body>
      <div className="container">
        <Header
          headerTitle="eDzienniczek"
          headerLink="https://www.google.com"
          headerLinkText="Strona projektu"
        />
        <main className="front-page" id="front-page">
          <HeaderSection title="Dokumentacja" />
          <AboutSection
            Id="about"
            sectionTitle="O projekcie"
            sectionText="Naszym głównym założeniem w projekcie było utworzenie wygodnej i intuicyjnej aplikacji, przypominającą znane nam już dotychczas dzienniki elektroniczne, stosowane w szkołach (np. MobiDziennik) oraz uniwerstytetach (np. USOS)."
          />
          <AboutSection
          Id="model"
            sectionTitle="Zastosowany model projektu"
            sectionText={[
              "Zastosowany przez nas model projektowy - ",
              <strong>RUP (Rational Unified Process)</strong>,
              "jest metodyką zakładającą iteracyjny proces tworzenia oprogramowania. Metodyka ta wprowadza reguły oraz dobre praktyki dla wszystkich faz wytwarzania oprogramowania.",
              <br />,
              "W każdej iteracji wytwarzany jest fragment systemu, który jest udostępniany klientowi. Pozwala to na uzyskanie szybkiej informacji zwrotnej i upewnieniu się, że zespół realizujący projekt dobrze zrozumiał wymagania i oczekiwania klienta. Szybkie wykrycie ewentualnych problemów lub nieporozumień, pozwala szybko wprowadzić odpowiednie modyfikacje.",
            ]}
          />
          <article className="sub-container">
            <h2> {["< ", "Zastosowane technologie", " / >"]}</h2>
            <h3>Aplikacja desktopowa</h3>
            <TechnologySection
            Id="Java"
              technologyTitle="Java"
              technologyText="To najpopularniejszy język programowania i najczęściej wybierana platforma programistyczna. Obniża koszty, skraca czas programowania, pobudza innowacyjność i usprawnia usługi aplikacj."
              technologyLink="https://docs.oracle.com/en/java/"
            />
            <TechnologySection
            Id="JavaFx"
              technologyTitle="JavaFx"
              technologyText="To platforma aplikacji klienckich nowe generacji typu open source dla komputerów stacjonarnych, moblinych i systemów wbudowanych, zbudowana w języku Java."
              technologyLink="https://openjfx.io/"
            />
            <TechnologySection
            Id="Maven"
              technologyTitle="Maven"
              technologyText="Następca już prawie wymarłego ANT a. Maven potrafi zrobić wszystko z naszym projektem podczas jego budowania. Jedyne co musimy zrobić to zastosować się do konwencji nazewnictwa
                katalogów w projekcie jaką wymaga Maven. Jeśli to zrobimy - sam
                Maven zatroszczy się o kompilowanie kodu, wykonywanie testów
                itd."
              technologyLink="https://maven.apache.org/guides/"
            />
            <TechnologySection
            Id="Hibernate"
              technologyTitle="Hibernate"
              technologyText="Framework stanowiący jedną z najpopularniejszych implementacji
                Java Persistence API (JPA). Umożliwia on dokonania mapowania
                obiektowo-relacyjnego (ORM) - czyli odzworowania obiektów klas
                na bazę danych. Najprościej mówiąc odpowiada za wygodną
                komunikację aplikacji z bazą danych"
              technologyLink="https://hibernate.org/orm/documentation/5.6/"
            />
            <TechnologySection
            Id="Spring"
              technologyTitle="Spring"
              technologyText="Narzędzie, które znacznie skraca proces tworzenia aplikacji.
                Stanowi szereg usprawnień, których implementacja w Javie
                zajęłaby wieki."
              technologyLink="https://docs.spring.io/spring-framework/docs/current/reference/html/"
            />
            <TechnologySection
            Id="JUnit"
              technologyTitle="JUnit"
              technologyText="Narzędzie służące do tworzenia powtarzalnych testów
                jednostkowych oprogramowania pisanego w języku Java."
              technologyLink="https://junit.org/junit5/docs/current/user-guide/"
            />
            <TechnologySection
            Id="Log4j2"
              technologyTitle="Log4j2"
              technologyText="Biblioteka języka programowania Java służąca do tworzenia logów
                podczas działania aplikacji."
              technologyLink="https://logging.apache.org/log4j/2.x/"
            />
            <h3>Strona internetowa</h3>

            <TechnologySection
            Id="HTML5"
              technologyTitle="HTML5"
              technologyText="Język znaczników stosowany do tworzenia dokumentów
                hipertekstowych."
              technologyLink="https://developer.mozilla.org/pl/docs/Web/HTML"
            />
            <TechnologySection
            Id="CSS3"
              technologyTitle="CSS3"
              technologyText="Kaskadowe arkusze stylów to język, który wnosi styl do stron
                internetowych poprzez interakcję z elementami HTML."
              technologyLink="https://developer.mozilla.org/pl/docs/Web/CSS"
            />
            <TechnologySection
            Id="JavaScript"
              technologyTitle="JavaScript"
              technologyText="Język programowania, który umożliwia wdrożenie na stronie
                internetowej skoplikowanych elementów, dzięki którym strona ta
                może nie tylko wyświetlać statyczne informacje, ale również
                obsługiwac zmianę treść odpowiednio do sytuacji, wyświetlać
                interaktywne mapy i animacje grafiki 2D/3D, wyświetlać wideo
                itd."
              technologyLink="https://developer.mozilla.org/pl/docs/Web/JavaScript"
            />
            <TechnologySection
            Id="React"
              technologyTitle="React"
              technologyText="JavaScriptowa biblioteka służąca do tworzenia interfejsów
                użytkownika."
              technologyLink="https://pl.reactjs.org/"
            />
            <h3>Bazy danych</h3>
            <TechnologySection
            Id="T-SQL"
              technologyTitle="T-SQL"
              technologyText="Rozszerzenie języka SQL. T-SQL jest językiem proceduralnym.
                Możemy za jego pomocą stosować typowe elementy programowania jak
                pętle, intrukcje warunkowe, możemy także tworzyć własne funkcje,
                procedury i operować na zmiennych."
              technologyLink="https://docs.microsoft.com/en-us/sql/t-sql/language-reference?view=sql-server-ver15"
            />
            <TechnologySection
            Id="MSSQL"
              technologyTitle="MSSQL"
              technologyText="System zarządzania bazą danych."
              technologyLink="https://docs.microsoft.com/en-us/sql/?view=sql-server-ver15"
            />
            <h3>Inne</h3>
            <TechnologySection
            Id="Git"
              technologyTitle="Git"
              technologyText="Jest rozproszonym systemem kontroli wersji ułatwiającym pracę
                nad tworzeniem aplikacji, stron internetowych i innych narzędzi
                w grupach. System śledzi wszystkie wykonywane zmiany w plikach,
                a także umożliwia przywrócenie ich dowolnej, wcześniejszej
                wersji."
              technologyLink="https://git-scm.com/doc"
            />
            <TechnologySection
            Id="GitHub"
              technologyTitle="GitHub"
              technologyText="To usługa hostingu umożliwiająca zarządzanie repozytoriami Git.
                Przy jego pomocy jesteśmy w stanie udostępnić swój kod w jednym
                miejscu dla wszystkich."
              technologyLink="https://docs.github.com/en"
            />
            <TechnologySection
            Id="Taiga"
              technologyTitle="Taiga"
              technologyText="To darmowy system zarządzania projektami typu open source dla startupów, programistów i projektantów."
              technologyLink="https://docs.taiga.io/"
            />
          </article>
          <article className="sub-container" id="creators">
            <h2>Twórcy projektu</h2>
            <CreatorsList />
          </article>
        </main>
        <footer>
          <div className="logo">
            <img src={MapUniversity} alt="" />
            <h1>eDzienniczek</h1>
          </div>
        </footer>
      </div>
    </body>
  );
}

export default App;
