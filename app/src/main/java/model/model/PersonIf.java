package model.model;

import java.time.LocalDate;

/**
 * Implementation for {@link Lecturer} and {@link Student} objects.
 *
 * @author created: Michał Musiałowicz on 04.12.2021
 * @author last changed:
 */
public interface PersonIf
{
    String getFirstName();

    String getLastName();

    String getFullName();

    String getPESEL();

    String getAddress();

    LocalDate getDateOfBirthAsDate();

    String getDateOfBirthAsString();

    String getPhoneNumber();

    String getEmail();

}
