package model.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Implementation for UniversitySubject.
 *
 * @author created: Michał Musiałowicz on 04.12.2021
 * @author last changed: Mikołaj Mumot on 19.12.2021
 */

@Entity
@Table( name = "przedmioty" )
public class UniversitySubject implements UniversitySubjectIf
{
    @Id
    @Column( name = "id_przedmiotu" )
    private int id;

    @Column( name = "nazwa" )
    private String name;

    @Column( name = "opis" )
    private String description;

    @Column( name = "ects" )
    private int ectsPoints;

    /**
     * Default no-arg constructor for Hibernate ORM.
     */
    public UniversitySubject()
    {

    }

    public UniversitySubject(int aId, String aName, String aDescription, int aEctsPoints )
    {
       id = aId;
       name = aName;
       description = aDescription;
       ectsPoints = aEctsPoints;
    }

    @Override
    public int getId()
    {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getEctsPoints() {
        return ectsPoints;
    }

    /**
     * We consider UniversitySubject to be the same when they have the same name (name is not case-sensitive).
     */
    @Override
    public boolean equals( Object obj )
    {
        if( this == obj )
        {
            return true;
        }

        if( !( obj instanceof UniversitySubject ) )
        {
            return false;
        }

        UniversitySubject comparedUniversitySubject = (UniversitySubject) obj;
        if( comparedUniversitySubject.getName().toLowerCase().equals(this.getName().toLowerCase() ) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public int hashCode()
    {
        return 13 * getName().toLowerCase().hashCode();
    }
}
