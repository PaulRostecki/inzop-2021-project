package model.orm;

import model.model.Mark;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Class that represents embedded primary key of Mark entity.
 *
 * @author created: Michał Musiałowicz on 27.12.2021
 * @author last changed:
 */

@Embeddable
public class MarkId implements MarkIdIf, Serializable
{
    private static final long serialVersionUID = 97497279L;

    @Column( name = "nr_albumu_studenta" )
    private int studentId;

    @Column( name = "id_przedmiotu" )
    private int universitySubjectId;

    /**
     * Default no-arg constructor for Hibernate ORM.
     */
    public MarkId()
    {

    }

    public MarkId( int aStudentId, int aUniversitySubjectId )
    {
        studentId = aStudentId;
        universitySubjectId = aUniversitySubjectId;
    }

    @Override
    public int getStudentId() {
        return studentId;
    }

    @Override
    public int getUniversitySubjectId()
    {
        return universitySubjectId;
    }

    @Override
    public boolean equals( Object obj )
    {
        if( this == obj )
        {
            return true;
        }
        if( !(obj instanceof Mark) )
        {
            return false;
        }

        if( ( getStudentId() == this.getStudentId() ) &&
                ( getUniversitySubjectId() == this.getUniversitySubjectId() ) )
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
        return 7 * getStudentId() + 11 * getUniversitySubjectId();
    }
}
