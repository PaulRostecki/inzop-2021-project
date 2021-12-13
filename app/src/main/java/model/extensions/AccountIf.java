package model.extensions;

import constant.PermissionTypeEnum;

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

    PermissionTypeEnum getPermission();
}
