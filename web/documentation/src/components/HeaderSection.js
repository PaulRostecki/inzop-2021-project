function HeaderSection(props) {
  let lessThan = "<";
  let greaterThan = " >";
  return (
    <h1>
      {lessThan} {props.title} / {greaterThan}
    </h1>
  );
}

export default HeaderSection;
