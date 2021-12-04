package model;

import constants.MarkValuesEnum;

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
    public double getMarkValue()
    {
        return markValue.getMarkValue();
    }
}
