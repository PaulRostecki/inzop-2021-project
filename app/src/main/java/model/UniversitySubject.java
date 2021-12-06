package model;

/**
 * Implementation for UniversitySubject.
 *
 * @author created: Michał Musiałowicz on 04.12.2021
 * @author last changed:
 */
public class UniversitySubject implements UniversitySubjectIf
{
    private final int id;

    private final String name;

    private final String description;

    private final int ectsPoints;

    public UniversitySubject( int aId, String aName, String aDescription, int aEctsPoints )
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
        if( comparedUniversitySubject.getName().equalsIgnoreCase( this.getName() ) )
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
        return 13 * getName().hashCode();
    }
}
