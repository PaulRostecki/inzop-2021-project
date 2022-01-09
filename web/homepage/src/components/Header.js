import React, { useState } from "react";
import { Link } from "react-scroll";

const Header = () => {
  const [show, setShow] = useState(false);
  const handleShow = () => {
    setShow((prevState) => !prevState);
  };

  return (
    <header>
      <nav id="nav-grabber" className={`${show ? "nav-bgc" : ""}`}>
        <h1>eDzienniczek</h1>
        <button
          className="navbar-toggler"
          style={{ cursor: "pointer" }}
          onClick={handleShow}
        >
          <div
            className={
              show ? "navbar-toggler-icon aft bfr none" : "navbar-toggler-icon"
            }
          ></div>
        </button>
        <ul className={show ? "navbar-collapse show" : "navbar-collapse"}>
          <li className="item">
            <Link
              to="front-page"
              spy={true}
              smooth={true}
              style={{ cursor: "pointer" }}
            >
              Strona główna
            </Link>
          </li>
          <li className="item">
            <Link
              to="project"
              spy={true}
              smooth={true}
              style={{ cursor: "pointer" }}
            >
              O projekcie
            </Link>
          </li>
          <li className="item">
            <Link
              to="functions"
              spy={true}
              smooth={true}
              style={{ cursor: "pointer" }}
            >
              Funkcjonalności
            </Link>
          </li>
          <li className="item">
            <Link
              to="creators"
              spy={true}
              smooth={true}
              style={{ cursor: "pointer" }}
            >
              O twórcach
            </Link>
          </li>
          <li className="item">
            <Link
              to="contact"
              spy={true}
              smooth={true}
              style={{ cursor: "pointer" }}
            >
              Kontakt
            </Link>
          </li>
        </ul>
      </nav>
    </header>
  );
};

export default Header;
