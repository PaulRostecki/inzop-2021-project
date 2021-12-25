package model.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Abstract class for Person. It is extended by {@link Student} and {@link Lecturer}
 *
 * @author created: Michał Musiałowicz on 04.12.2021
 * @author last changed:
 */
@MappedSuperclass
public abstract class AbstractPerson implements PersonIf
{
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern( "dd-MM-yyyy" );

    @Column( name = "imie" )
    private String firstName;

    @Column( name = "nazwisko" )
    private String lastName;

    @Column( name = "pesel" )
    private String PESEL;

    @Column( name = "adres" )
    private String address;

    @Column( name = "data_ur" )
    private LocalDate dateOfBirth;

    @Column( name = "nr_tel" )
    private String phoneNumber;

    @Column( name = "mail" )
    private String email;


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

    /**
     * Default no-arg constructor for Hibernate ORM.
     */
    public AbstractPerson()
    {

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

    public LocalDate getDateOfBirth()
    {
        return dateOfBirth;
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
