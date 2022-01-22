package model.extensions;

import constant.PermissionTypeEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;

/**
 * Implementation for Account.
 *
 * @author created: Michał Musiałowicz on 12.12.2021
 * @author last changed: Mikołaj Mumot 0n 20.01.2022
 */

@Entity
@Table( name = "konto_użytkownika" )
public class Account implements AccountIf
{
    @Transient
    private static final Logger LOGGER = LogManager.getLogger( Account.class );

    @Id
    @Column( name = "student_email" )
    private String email;

    @Column( name = "haslo" )
    private String password;

    @Column( name = "typ_uprawnien" )
    private String permission;

    @Transient
    private PermissionTypeEnum permissionType;

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
        if( aPermission.equalsIgnoreCase( "STUDENT" ) )
        {
            permissionType = PermissionTypeEnum.STUDENT;
        }
        else if( aPermission.equalsIgnoreCase( "LECTURER" ) )
        {
            permissionType = PermissionTypeEnum.LECTURER;
        }
        else if( aPermission.equalsIgnoreCase( "MODERATOR" ) )
        {
            permissionType = PermissionTypeEnum.MODERATOR;
        }
        else
        {
            LOGGER.error( "Wrong permissions type for Account: " + aPermission + "." );
            permissionType = null;
        }
    }

    public PermissionTypeEnum getPermissionType()
    {
        return permissionType;
    }


    /**
     * We consider Accounts to be the same when they have the same email.
     */
    @Override
    public boolean equals( Object obj )
    {
        if ( this == obj )
        {
            return true;
        }

        if( !( obj instanceof AccountIf) )
        {
            return false;
        }

        AccountIf comparedAccount = (AccountIf) obj;
        if( comparedAccount.getEmail().equalsIgnoreCase( this.getEmail() ) )
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
        return 37 * getEmail().toLowerCase().hashCode();
    }
}
