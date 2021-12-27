package model.extensions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Implementation for Account.
 *
 * @author created: Michał Musiałowicz on 12.12.2021
 * @author last changed:
 */

@Entity
@Table( name = "konto_uzytkownika" )
public class Account implements AccountIf
{
    @Id
    @Column( name = "email" )
    private String email;

    @Column( name = "haslo" )
    private String password;

    @Column( name = "typ_uprawnien" )
    private String permission;

    /**
     * Default no-arg constructor for Hibernate ORM.
     */
    public Account()
    {

    }

    public Account( String aEmail, String aPassword, String aPermission )
    {
        email = aEmail;
        password = aPassword;
        permission = aPermission;
    }

    @Override
    public String getEmail()
    {
        return email;
    }

    @Override
    public String getPermission()
    {
        return permission;
    }

    @Override
    public String getPassword()
    {
        return password;
    }

    @Override
    public void setEmail( String aEmail )
    {
        email = aEmail;
    }

    @Override
    public void setPassword( String aPassword )
    {
        password = aPassword;
    }

    @Override
    public void setPermission( String aPermission )
    {
        permission = aPermission;
    }
}
