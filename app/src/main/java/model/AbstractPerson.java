package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Abstract class for Person. It is extended by {@link Student} and {@link Lecturer}
 *
 * @author created: Michał Musiałowicz on 04.12.2021
 * @author last changed:
 */
public abstract class AbstractPerson implements PersonIf
{
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern( "dd-MM-yyyy" );

    private final String firstName;

    private final String lastName;

    private final String PESEL;

    private final String address;

    private final LocalDate dateOfBirth;

    private final String phoneNumber;

    private final String email;


    public AbstractPerson( String aFirstName, String aLastName, String aPESEL, String aAddress, LocalDate aDateOfBirth,
                          String aPhoneNumber, String aEmail )
    {
        firstName = aFirstName;
        lastName = aLastName;
        PESEL = aPESEL;
        address = aAddress;
        dateOfBirth = aDateOfBirth;
        phoneNumber = aPhoneNumber;
        email = aEmail;
    }

    @Override
    public String getFirstName()
    {
        return firstName;
    }

    @Override
    public String getLastName()
    {
        return lastName;
    }

    @Override
    public String getFullName()
    {
        return getFirstName() + " " + getLastName();
    }


    @Override
    public String getPESEL()
    {
        return PESEL;
    }

    @Override
    public String getAddress()
    {
        return address;
    }

    @Override
    public LocalDate getDateOfBirthAsDate()
    {
        return dateOfBirth;
    }

    @Override
    public String getDateOfBirthAsString()
    {
        return dateOfBirth.format( dateFormatter );
    }

    @Override
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    @Override
    public String getEmail()
    {
        return email;
    }

    /**
     * We consider Student/Lecturer to be the same when they have the same PESEL.
     */
    @Override
    public boolean equals( Object obj )
    {
        if ( this == obj )
        {
            return true;
        }

        if( !( obj instanceof PersonIf ) )
        {
            return false;
        }

        PersonIf comparedPerson = (PersonIf) obj;
        if( comparedPerson.getPESEL().equals( this.getPESEL() ) )
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
        return 43 * getPESEL().hashCode();
    }
}
