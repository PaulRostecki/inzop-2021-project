package model;

import java.time.LocalDate;

/**
 * Implementation for Student.
 *
 * @author created: Michał Musiałowicz on 04.12.2021
 * @author last changed:
 */
public class Student extends AbstractPerson
{
    private final String indexNumber; // id

    public Student( String aFirstName, String aLastName, String aPESEL, String aAddress, LocalDate aDateOfBirth,
                   String aPhoneNumber, String aEmail, String aIndexNumber )
    {
        super( aFirstName, aLastName, aPESEL, aAddress, aDateOfBirth, aPhoneNumber, aEmail );
        indexNumber = aIndexNumber;
    }

    public String getIndexNumber()
    {
        return indexNumber;
    }
}
