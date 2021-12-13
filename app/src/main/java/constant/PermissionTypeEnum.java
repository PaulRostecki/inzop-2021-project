package constant;

/**
 * Permission types in USOS.
 *
 * @author created: Michał Musiałowicz on 12.12.2021
 * @author last changed:
 */
public enum PermissionTypeEnum
{
    STUDENT( "student" ),

    LECTURER( "lecturer" ),

    MODERATOR( "moderator" );

    private final String value;

    PermissionTypeEnum( String aValue )
    {
        value = aValue;
    }

    public String getValue()
    {
        return value;
    }
}
