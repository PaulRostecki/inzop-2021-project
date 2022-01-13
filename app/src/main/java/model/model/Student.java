package model.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Implementation for Student.
 *
 * @author created: Michał Musiałowicz on 04.12.2021
 * @author last changed:
 */
@Entity
@Table( name = "studenci" )
public class Student extends AbstractPerson
{
    @Id
    @Column( name = "nr_albumu" )
    private String indexNumber; // id

    /**
     * Default no-arg constructor for Hibernate ORM.
     */
    public Student()
    {
        super();
    }

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

    @Override
    public String toString()
    {
        return getFullName() + " (" + getPESEL() + ")";
    }
}
