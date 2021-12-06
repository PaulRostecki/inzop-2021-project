package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

/**
 * Implementation for StudyGroup.
 *
 * @author created: Michał Musiałowicz on 04.12.2021
 * @author last changed:
 */
public class StudyGroup implements StudyGroupIf
{
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" );

    private final int groupId;

    private final int lecturerId;

    private final int universitySubjectId;

    private final List< Student > students;

    private final LocalDateTime date;

    public StudyGroup( int aGroupId, int aLecturerId, int aUniversitySubjectId, List<Student> aStudents, LocalDateTime aDate )
    {
        groupId = aGroupId;
        lecturerId = aLecturerId;
        universitySubjectId = aUniversitySubjectId;
        students = aStudents;
        date = aDate;
    }

    @Override
    public int getGroupId()
    {
        return groupId;
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
    public List<Student> getStudents()
    {
        return students;
    }

    @Override
    public LocalDateTime getDateAsDate()
    {
        return date;
    }

    @Override
    public String getDateAsString()
    {
        return date.format( dateTimeFormatter );
    }

    /**
     * We consider StudyGroups to be the same when they are scheduled at the same date
     * and are lectured by the same lecturer.
     */
    @Override
    public boolean equals( Object obj )
    {
        if( this == obj )
        {
            return true;
        }

        if( !( obj instanceof StudyGroup ) )
        {
            return false;
        }

        StudyGroup comparedStudyGroup = (StudyGroup) obj;
        if( ( comparedStudyGroup.getLecturerId() == this.getLecturerId() ) &&
                ( comparedStudyGroup.getDateAsDate() == this.getDateAsDate() ) )
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
        return 17 * getLecturerId()  + 31 * date.hashCode();
    }
}
