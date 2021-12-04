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
}
