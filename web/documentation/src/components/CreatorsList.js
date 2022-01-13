const creatorsData = [
  {
    fullName: "Michał Musiałowicz",
    role: "Project Manager, Java Developer",
    githubLink: "https://github.com/micmus4",
    linkedinLink: "https://pl.linkedin.com/in/mmusialowicz?trk=people-guest_people_search-card",
  },
  {
      fullName: "Michał Nowak",
      role: "Process Engineer, Java Developer",
      githubLink: "https://github.com/michalnowak18",
      linkedinLink: "https://www.linkedin.com/in/micha%C5%82-nowak-11505414a/?miniProfileUrn=urn%3Ali%3Afs_miniProfile%3AACoAACP1UKEBQ8pPCyMAcgwQOLhsqcn3u0HCDzg"
  },
  {
      fullName: "Krzysztof Raczyński",
      role: "Software Architect/Database Designer",
      githubLink: "https://github.com/KrzRac",
      linkedinLink: null
  },
  {
      fullName: "Miłosz Konarski",
      role: "Software Architect/Database Designer",
      githubLink: "https://github.com/milekmilek",
      linkedinLink: null
  },
  {
      fullName: "Paweł Rostecki",
      role: "System Administrator",
      githubLink: "https://github.com/PaulRostecki",
      linkedinLink: "https://pl.linkedin.com/in/pawel-rostecki?trk=public_profile_browsemap"
  },
  {
      fullName: "Jędrzej Wesołowski",
      role: "Front-End Developer",
      githubLink: "https://github.com/happy531",
      linkedinLink: "https://www.linkedin.com/in/j%C4%99drzej-weso%C5%82owski-2455941a4/?miniProfileUrn=urn%3Ali%3Afs_miniProfile%3AACoAAC_IsVUBdbPdyzuaWJhO0aY4W2oLJ08-w-8"
  },
  {
      fullName: "Szymon Mazurek",
      role: "Front-End Developer",
      githubLink: "https://github.com/xcaho",
      linkedinLink: ""
  },
  {
      fullName: "Mateusz Cwojdziński",
      role: "Front-End Developer",
      githubLink: "https://github.com/mcwojdzinski",
      linkedinLink: "https://pl.linkedin.com/in/mateuszcwojdzinski?trk=public_profile_browsemap"
  },
  {
      fullName: "Jędrzej Rybczyński",
      role: "Developer, System Administrator (Support)",
      githubLink: "https://github.com/directtt",
      linkedinLink: "https://www.linkedin.com/in/jedrzej-rybczynski/"
  },
  {
      fullName: "Dominika Leśniewska",
      role: "System Analyst, UI Designer",
      githubLink: "https://github.com/kwasiarkowy",
      linkedinLink: "https://www.linkedin.com/in/dominika-lesniewska/"
  },
  {
      fullName: "Maciej Maciejewski",
      role: "System Analyst",
      githubLink: "https://github.com/MaciejM1",
      linkedinLink: ""
  },
  {
      fullName: "Maksymilian Łasecki",
      role: "System Tester (Manual testing), Course Developer",
      githubLink: "https://github.com/Maskuu",
      linkedinLink: ""
  },
  {
      fullName: "Mikołaj Mumot",
      role: "Test Manager, System Tester (Automatic testing)",
      githubLink: "https://github.com/mikmum",
      linkedinLink: ""
  }
];

const creatorsItems = creatorsData.map((item, index) => {
  return (
    <li className="item">
        <p> { item.fullName } - { item.role } </p>
        <div className="item-Socials">
            <a href={item.githubLink} className="git"></a>
            <a href={item.linkedinLink} className="linkedin"></a>
        </div>
    </li>
  );
});

function CreatorsList() {
  return <ul>{creatorsItems}</ul>;
}

export default CreatorsList;
