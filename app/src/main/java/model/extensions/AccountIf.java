package model.extensions;

/**
 * Interface for {@link Account}
 *
 * @author created: Michał Musiałowicz on 12.12.2021
 * @author last changed:
 */
public interface AccountIf
{
    String getEmail();

    String getPassword();

    String getPermission();

    void setEmail( String aEmail );

    void setPassword( String aPassword );

    void setPermission( String aPermission );
}
