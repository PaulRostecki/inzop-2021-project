import React from "react";
import aboutProject from "../../svg/main-website/SVG-pic-o-projekcie.svg";

const AboutPage = () => {
  return (
    <>
      <section className="project" id="project">
        <div className="item1">
          <img src={aboutProject} alt="" />
        </div>
        <div className="item2">
          <h2>O projekcie</h2>
          <p>
            Naszym głównym założeniem w projekcie było utworzenie wygodnej
            aplikacji, przypominającej znane nam już dotychczas dzienniki
            elektroniczne, stosowane w szkołach oraz uniwersytetach.
          </p>
        </div>
      </section>
    </>
  );
};

export default AboutPage;
