package cache;

import model.model.Lecturer;
import model.model.Mark;
import model.model.Student;
import model.model.StudyGroup;
import model.model.UniversitySubject;
import model.extensions.Account;
import model.extensions.Announcement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Cache Provider for all data in USOS. Integrated with Hibernate.
 *
 * @author created: Michał Musiałowicz on 12.12.2021
 * @author last changed:
 */
public final class CacheProvider
{
    private static final Logger LOGGER = LogManager.getLogger( CacheProvider.class );

    private static CacheProvider cacheProviderInstance = new CacheProvider();

    private static Map< Integer, Student > students; // key: studentId

    private static Map< Integer, Lecturer > lecturers; // key: lecturerId

    private static Map< Integer, StudyGroup > studyGroups; // key: studyGroupId

    private static Map< Integer, UniversitySubject > universitySubjects; // key: universitySubjectId

    private static Set< Mark > marks;

    private static Map< String, Account > accounts; // key: email

    private static List< Announcement > announcements;

    private static Map< Integer, Integer > timetables; // key: studentId, values: studyGroups' ids

    private CacheProvider()
    {
        students = new HashMap<>();
        lecturers = new HashMap<>();
        studyGroups = new HashMap<>();
        universitySubjects = new HashMap<>();
        marks = new HashSet<>();
        accounts = new HashMap<>();
        announcements = new ArrayList<>();
        timetables = new HashMap<>();

        LOGGER.info( "Created and initialized Cache Provider." );
    }

    /**
     * Method to get Singleton instance of CacheProvider.
     *
     * @return CacheProvider instance.
     */
    public static CacheProvider getCacheProvider()
    {
        if( cacheProviderInstance == null )
        {
            LOGGER.info( "Creating CacheProvider." );
            cacheProviderInstance = new CacheProvider();
        }
        return cacheProviderInstance;
    }

    public Map< Integer, Student > getStudents()
    {
        return students;
    }

    public Map< Integer, Lecturer > getLecturers()
    {
        return lecturers;
    }

    public  Map< Integer, StudyGroup > getStudyGroups()
    {
        return studyGroups;
    }

    public Map< Integer, UniversitySubject > getUniversitySubjects()
    {
        return universitySubjects;
    }

    public Set< Mark > getMarks()
    {
        return marks;
    }

    public Map< String, Account > getAccounts()
    {
        return accounts;
    }

    public List< Announcement > getAnnouncements()
    {
        return announcements;
    }

    public Map< Integer, Integer > getTimetables()
    {
        return timetables;
    }

}
