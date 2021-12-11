package model;

import constant.MarkValuesEnum;

/**
 * Implementation for Mark.
 *
 * @author created: Michał Musiałowicz on 04.12.2021
 * @author last changed:
 */
public class Mark implements MarkIf
{
    private final int studentId;

    private final int lecturerId;

    private final int universitySubjectId;

    private final MarkValuesEnum markValue;

    public Mark( int aStudentId, int aLecturerId, int aUniversitySubjectId, MarkValuesEnum aMarkValue )
    {
       studentId = aStudentId;
       lecturerId = aLecturerId;
       universitySubjectId = aUniversitySubjectId;
       markValue = aMarkValue;
    }

    @Override
    public int getStudentId()
    {
        return studentId;
    }

    @Override
    public int getLecturerId()
    {
        return lecturerId;
    }

    @Override
    public int getUniversitySubjectId()
    {
        return universitySubjectId;
    }

    @Override
    public float getMarkValue()
    {
        return markValue.getMarkValue();
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
        if( ( comparedMark.getStudentId() == this.getStudentId() ) &&
                ( comparedMark.getUniversitySubjectId() == this.getUniversitySubjectId() ) )
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
