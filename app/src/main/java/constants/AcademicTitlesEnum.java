package constants;

/**
 * Constants for academic titles supported in our programme.
 *
 * @author created: Michał Musiałowicz on 04.12.2021
 * @author last changed:
 */
public enum AcademicTitlesEnum
{
    PROFESSOR ( "prof." ),

    DOCTOR( "dr." ),

    MASTER( "mgr." ),

    HABILITATION( "dr. hab." );

    private final String title;

    AcademicTitlesEnum( String aTitle )
    {
        title = aTitle;
    }

    public String getTitle()
    {
        return title;
    }
}
