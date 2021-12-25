package model.model;

import model.orm.MarkId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Implementation for Mark.
 *
 * @author created: Michał Musiałowicz on 04.12.2021
 * @author last changed:
 */
@Entity
@Table( name = "oceny" )
public class Mark implements MarkIf
{
    @EmbeddedId
    private MarkId markId;

    @Column( name = "id_prowadzacego" )
    private int lecturerId;

    @Column( name = "wartosc" )
    private float markValue;

    /**
     * Default no-arg constructor for Hibernate ORM.
     */
    public Mark()
    {

    }

    public Mark( int aStudentId, int aLecturerId, int aUniversitySubjectId, float aMarkValue )
    {
        lecturerId = aLecturerId;
        markValue = aMarkValue;
        markId = new MarkId( aStudentId, aUniversitySubjectId );
    }

    public Mark( int aLecturerId, float aMarkValue )
    {
       lecturerId = aLecturerId;
       markValue = aMarkValue;
    }

    @Override
    public int getLecturerId()
    {
        return lecturerId;
    }

    @Override
    public float getMarkValue()
    {
        return markValue;
    }

    public MarkId getMarkId() {
        return markId;
    }

    public void setMarkId( MarkId aMarkId )
    {
        markId = aMarkId;
    }

    /**
     * We consider Marks to be equal when they belong to the same Student AND they are from the same UniversitySubject.
     */
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

        Mark comparedMark = (Mark) obj;
        if( ( comparedMark.getMarkId().getStudentId() == this.getMarkId().getStudentId() ) &&
                ( comparedMark.getMarkId().getUniversitySubjectId() == this.getMarkId().getUniversitySubjectId() ) )
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
        return 7 * getMarkId().getStudentId() + 11 * getMarkId().getUniversitySubjectId();
    }
}
