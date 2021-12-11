package constant;

/**
 * Constants for mark values supported in our programme.
 *
 * @author created: Michał Musiałowicz on 04.12.2021
 * @author last changed:
 */
public enum MarkValuesEnum
{
    TWO( 2.0F ),

    THREE( 3.0F ),

    THREE_PLUS( 3.5F ),

    FOUR( 4.0F ),

    FOUR_PLUS( 4.5F ),

    FIVE( 5.0F );

    private final float markValue;

    MarkValuesEnum( float aMarkValue )
    {
        markValue = aMarkValue;
    }

    public float getMarkValue()
    {
        return markValue;
    }
}
