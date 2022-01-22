import MapUniversity from "../icons/map_university.svg";
import { useState } from "react";
import { Link } from "react-scroll";

function Header(props) {
  const [show, setShow] = useState(false);
  const handleShow = () => {
    setShow((prevState) => !prevState);
  };

  return (
    <header>
      <div className="logo">
        <nav>
          <button
            className="navbar-toggler"
            style={{ cursor: "pointer" }}
            onClick={handleShow}
          >
            <div
              className={
                show
                  ? "navbar-toggler-icon aft bfr none"
                  : "navbar-toggler-icon"
              }
              style={{ zIndex: "99999" }}
            ></div>
          </button>
          <ul className={show ? "menu active" : "menu"}>
            <li className="item">Dokumentacja</li>
            <ul className="sub-menu">
              <li className="sub-item">
                <Link
                  to="about"
                  spy={true}
                  smooth={true}
                  style={{ cursor: "pointer" }}
                >
                  Strona główna
                </Link>
              </li>
              <li className="sub-item">
                <Link
                  to="model"
                  spy={true}
                  smooth={true}
                  style={{ cursor: "pointer" }}
                >
                  Zastosowany model projektu
                </Link>
              </li>
              <li className="sub-item">Zastosowane technologie</li>
              <ul className="sub-menu">
                <li className="sub-item">Aplikacja desktopowa</li>
                <ul className="sub-menu">
                  <li className="sub-item">
                    <Link
                      to="Java"
                      spy={true}
                      smooth={true}
                      style={{ cursor: "pointer" }}
                    >
                      Java
                    </Link>
                  </li>
                  <li className="sub-item">
                    <Link
                      to="JavaFx"
                      spy={true}
                      smooth={true}
                      style={{ cursor: "pointer" }}
                    >
                      JavaFx
                    </Link>
                  </li>
                  <li className="sub-item">
                    <Link
                      to="Maven"
                      spy={true}
                      smooth={true}
                      style={{ cursor: "pointer" }}
                    >
                      Maven
                    </Link>
                  </li>
                  <li className="sub-item">
                    <Link
                      to="Hibernate"
                      spy={true}
                      smooth={true}
                      style={{ cursor: "pointer" }}
                    >
                      Hibernate
                    </Link>
                  </li>
                  <li className="sub-item">
                    <Link
                      to="Spring"
                      spy={true}
                      smooth={true}
                      style={{ cursor: "pointer" }}
                    >
                      Spring
                    </Link>
                  </li>
                  <li className="sub-item">
                    <Link
                      to="JUnit"
                      spy={true}
                      smooth={true}
                      style={{ cursor: "pointer" }}
                    >
                      JUnit
                    </Link>
                  </li>
                  <li className="sub-item">
                    <Link
                      to="Log4j2"
                      spy={true}
                      smooth={true}
                      style={{ cursor: "pointer" }}
                    >
                      Log4j2
                    </Link>
                  </li>
                </ul>
                <li className="sub-item">Strona internetowa</li>
                <ul className="sub-menu">
                  <li className="sub-item">
                    <Link
                      to="HTML5"
                      spy={true}
                      smooth={true}
                      style={{ cursor: "pointer" }}
                    >
                      HTML5
                    </Link>
                  </li>
                  <li className="sub-item">
                    <Link
                      to="CSS3"
                      spy={true}
                      smooth={true}
                      style={{ cursor: "pointer" }}
                    >
                      CSS3
                    </Link>
                  </li>
                  <li className="sub-item">
                    <Link
                      to="JavaScript"
                      spy={true}
                      smooth={true}
                      style={{ cursor: "pointer" }}
                    >
                      JavaScript
                    </Link>
                  </li>
                  <li className="sub-item">
                    <Link
                      to="React"
                      spy={true}
                      smooth={true}
                      style={{ cursor: "pointer" }}
                    >
                      React
                    </Link>
                  </li>
                </ul>
                <li className="sub-item">Bazy danych</li>
                <ul className="sub-menu">
                  <li className="sub-item">
                    <Link
                      to="T-SQL"
                      spy={true}
                      smooth={true}
                      style={{ cursor: "pointer" }}
                    >
                      T-SQL
                    </Link>
                  </li>
                  <li className="sub-item">
                    <Link
                      to="MSSQL"
                      spy={true}
                      smooth={true}
                      style={{ cursor: "pointer" }}
                    >
                     MSSQL
                    </Link>
                  </li>
                </ul>
                <li className="sub-item">Inne</li>
                <ul className="sub-menu">
                  <li className="sub-item">
                    <Link
                      to="Git"
                      spy={true}
                      smooth={true}
                      style={{ cursor: "pointer" }}
                    >
                      Git
                    </Link>
                  </li>
                  <li className="sub-item">
                    <Link
                      to="GitHub"
                      spy={true}
                      smooth={true}
                      style={{ cursor: "pointer" }}
                    >
                      GitHub
                    </Link>
                  </li>
                  <li className="sub-item">
                    <Link
                      to="Taiga"
                      spy={true}
                      smooth={true}
                      style={{ cursor: "pointer" }}
                    >
                      Taiga
                    </Link>
                  </li>
                </ul>
              </ul>
              <li className="sub-item">
                <Link
                  to="creators"
                  spy={true}
                  smooth={true}
                  style={{ cursor: "pointer" }}
                >
                  Twórcy projektu
                </Link>
              </li>
            </ul>
          </ul>
        </nav>
        <img src={MapUniversity} alt="" />
        <h1>{props.headerTitle}</h1>
      </div>
      <a href={props.headerLink} className="btn">
        {props.headerLinkText}
      </a>
    </header>
  );
}

export default Header;
