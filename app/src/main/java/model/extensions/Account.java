package model.extensions;

import constant.PermissionTypeEnum;

/**
 * Implementation for Account.
 *
 * @author created: Michał Musiałowicz on 12.12.2021
 * @author last changed:
 */
public class Account implements AccountIf
{
    private final String email;

    private final String password;

    private final PermissionTypeEnum permission;

    public Account( String aEmail, String aPassword, PermissionTypeEnum aPermission )
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
    public PermissionTypeEnum getPermission()
    {
        return permission;
    }

    @Override
    public String getPassword()
    {
        return password;
    }
}
