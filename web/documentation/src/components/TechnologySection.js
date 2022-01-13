function TechnologySection(props) {
  return (
    <div id={props.Id}>
      <h4>{ props.technologyTitle }</h4>
      <p>
        { props.technologyText }
      </p>
      <a className="zastosowanie" target="_blank" rel="noreferrer" href={props.technologyLink}>
        Wiecej o tej technologii
      </a>
    </div>
  );
}

export default TechnologySection