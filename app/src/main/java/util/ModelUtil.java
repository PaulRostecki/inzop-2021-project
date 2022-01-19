package util;

import java.util.List;

/**
 * Class containing utils for Model.
 *
 * @author created: Michał Musiałowicz on 11.01.2022
 * @author last changed:
 */
public final class ModelUtil
{
    private ModelUtil()
    {

    }

    public static final List< Float > acceptedFloatMarks = List.of( 2.0f, 3.0f, 3.5f, 4.0f, 4.5f, 5.0f );

    public static final List< String > acceptedStringMarks = List.of( "2.0", "3.0", "3.5", "4.0", "4.5", "5.0" );

    public static final List< String > validAcademicTitles = List.of( "mgr.", "dr. hab.", "dr.", "prof." );

    public static final List< Integer > validEctsPoints = List.of( 1, 2, 3, 4, 5, 6 );

    public static final List< String > acceptedDays = List.of( "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek" );

    public static final List< String > acceptedStartTimes = List.of( "8:00", "10:00", "11:45", "13:45", "15:30", "17:00" );
}
