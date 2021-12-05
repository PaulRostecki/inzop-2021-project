package constants;

/**
 * Constants for mark values supported in our programme.
 *
 * @author created: Michał Musiałowicz on 04.12.2021
 * @author last changed:
 */
public enum MarkValuesEnum
{
    TWO( 2.0 ),

    THREE( 3.0 ),

    THREE_PLUS( 3.5 ),

    FOUR( 4.0 ),

    FOUR_PLUS( 4.5 ),

    FIVE( 5.0 );

    private final double markValue;

    MarkValuesEnum( double aMarkValue )
    {
        markValue = aMarkValue;
    }

    public double getMarkValue()
    {
        return markValue;
    }
}
