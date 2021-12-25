package model.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation for Lecturer.
 *
 * @author created: Michał Musiałowicz on 04.12.2021
 * @author last changed:
 */

@Entity
@Table( name = "prowadzacy" )
public class Lecturer extends AbstractPerson implements LecturerIf
{
    @Id
    @Column( name = "id_prowadzacego" )
    private int id;

    @Column( name = "tytul" )
    private String academicTitle;

    @Column( name = "dyzur" )
    private String duty;

    @Transient
    private List< StudyGroup > studyGroups;

    /**
     * Default no-arg constructor for Hibernate ORM.
     */
    public Lecturer()
    {
        super();
    }

    public Lecturer( String aFirstName, String aLastName, String aPESEL, String aAddress, LocalDate aDateOfBirth,
                    String aPhoneNumber, String aEmail, String aAcademicTitle, String aDuty, Integer aId )
    {
        super( aFirstName, aLastName, aPESEL, aAddress, aDateOfBirth, aPhoneNumber, aEmail );
        academicTitle = aAcademicTitle;
        duty = aDuty;
        id = aId;
        studyGroups = new ArrayList<>();
    }

    @Override
    public int getId()
    {
        return id;
    }

    @Override
    public String getAcademicTitle()
    {
        return academicTitle;
    }

    @Override
    public String getDuty()
    {
        return duty;
    }

    @Override
    public void setId( int aId )
    {
        id = aId;
    }
}
