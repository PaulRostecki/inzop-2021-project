package model.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static cache.CacheProvider.getCacheProvider;

/**
 * Implementation for StudyGroup.
 *
 * @author created: Michał Musiałowicz on 04.12.2021
 * @author last changed:
 */
@Entity
@Table( name = "grupy" )
public class StudyGroup implements StudyGroupIf
{
    private static final Logger LOGGER = LogManager.getLogger( StudyGroup.class );

    @Id
    @Column( name = "id_grupy" )
    private int groupId;

    @Column( name = "id_prowadzacego" )
    private int lecturerId;

    @Column( name = "id_przedmiotu" )
    private int universitySubjectId;

    @Transient
    private List< Student > students;

    @Deprecated
    @Transient
    private DayOfWeek day;

    @Column( name = "dzien_zajec" )
    private String dayString;

    @Column( name = "godzina_zajec" )
    private String startTime;

    /**
     * Default no-arg constructor for Hibernate ORM.
     */
    public StudyGroup()
    {
        students = new ArrayList<>();
    }

    public StudyGroup( int aGroupId, int aLecturerId, int aUniversitySubjectId, List<Student> aStudents, DayOfWeek aDay,
                      String aStartTime )
    {
        groupId = aGroupId;
        lecturerId = aLecturerId;
        universitySubjectId = aUniversitySubjectId;
        students = aStudents;
        day = aDay;
        startTime = aStartTime;
        dayString = aDay.toString();
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
    public List< Student > getStudents()
    {
        return students;
    }

    @Override
    public DayOfWeek getDay()
    {
        return day;
    }

    @Override
    public String getStartTime()
    {
        return startTime;
    }

    @Override
    public String getUniversitySubjectName()
    {
        try
        {
            Optional< UniversitySubject > universitySubject = Optional.of( getCacheProvider().getUniversitySubjects().get( universitySubjectId ) );
            if ( universitySubject.isPresent() )
            {
                return universitySubject.get().getName();
            }
            return StringUtils.EMPTY;
        }
        catch ( Exception e )
        {
            return StringUtils.EMPTY;
        }
    }

    public void setDayString ( String aDayString )
    {
        dayString = aDayString;
    }

    public String getDayString()
    {
        return dayString;
    }

    @Deprecated
    @Override
    public String getDayInPolish()
    {
        switch ( day )
        {
            case MONDAY:
                return "Poniedziałek";
            case TUESDAY:
                return "Wtorek";
            case WEDNESDAY:
                return "Środa";
            case THURSDAY:
                return "Czwartek";
            case FRIDAY:
                return "Piątek";
            default:
                LOGGER.warn( "Wrong day selected for Study Group." );
                return StringUtils.EMPTY;
        }
    }

    @Override
    public String getLecturerFirstName()
    {
        try
        {
            Optional< Lecturer > lecturer = Optional.of( getCacheProvider().getLecturers().get( lecturerId ) );
            if ( lecturer.isPresent() )
            {
                return lecturer.get().getFirstName();
            }
            return StringUtils.EMPTY;
        }
        catch ( Exception e )
        {
            return StringUtils.EMPTY;
        }
    }

    @Override
    public String getLecturerLastName()
    {
        try
        {
            Optional< Lecturer > lecturer = Optional.of( getCacheProvider().getLecturers().get( lecturerId ) );
            if ( lecturer.isPresent() )
            {
                return lecturer.get().getLastName();
            }
            return StringUtils.EMPTY;
        }
        catch ( Exception e )
        {
            return StringUtils.EMPTY;
        }
    }
    @Override
    public String getNumberOfStudents()
    {
        return String.valueOf( students.size() );
    }

    @Override
    public boolean addStudentToTheGroup( Student aStudent )
    {
        return students.add( aStudent );
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
                ( comparedStudyGroup.getStartTime().equals( this.getStartTime() ) ) &&
                ( comparedStudyGroup.getDayString().equals( this.getDayString() ) ) )
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
        return 17 * getLecturerId() + 31 * getStartTime().hashCode() + 77 * getDayString().hashCode();
    }

    @Override
    public String toString()
    {
        // we cut milliseconds for better readability, so we only retrieve first five chars from startTime property.
        return getUniversitySubjectName() + " (gr." + getGroupId() + ") - " + getStartTime().substring( 0, 5 );
    }
}
