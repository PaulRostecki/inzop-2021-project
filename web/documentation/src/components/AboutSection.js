function AboutSection(props) {
  let lessThan = '<'
  let greaterThan = ' >'
  return (
    <article className="sub-container" id={props.Id}>
      <h2> { lessThan } {props.sectionTitle} / { greaterThan }</h2>
      <p> { props.sectionText } </p>
    </article>
  );
}

export default AboutSection;
