import React from "react";
import aboutCreators from "../../svg/main-website/SVG-o-tworcach.svg";

const Creators = () => {
  return (
    <section className="creators" id="creators">
      <div className="item1">
        <img src={aboutCreators} alt="" />
      </div>
      <div className="item2">
        <h2>O twórcach</h2>
        <p>
          Cały projekt powstał w oparciu o pracę trzynastu osób. W skład zespołu
          wchodzili m.in.:
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
        <a href="#" className="btn">
          Więcej
        </a>
      </div>
    </section>
  );
};

export default Creators;
