package cache;

import model.*;
import model.extensions.Account;
import model.extensions.Announcement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Cache Provider for model. Integrated with Hibernate.
 *
 * @author created: Michał Musiałowicz on 12.12.2021
 * @author last changed:
 */
public final class CacheProvider
{
    private static final CacheProvider cacheProviderInstance = new CacheProvider();

    private static Map< Integer, Student > students; // key: studentId

    private static Map< Integer, Lecturer > lecturers; // key: lecturerId

    private static Map< Integer, StudyGroup > studyGroups; // key: studyGroupId

    private static Map< Integer, UniversitySubject > universitySubjects; // key: universitySubjectId

    private static List< Mark > marks;

    private static Map< String, Account > accounts; // key: email

    private static List< Announcement > announcements;

    private CacheProvider()
    {
        students = new HashMap<>();
        lecturers = new HashMap<>();
        studyGroups = new HashMap<>();
        universitySubjects = new HashMap<>();
        marks = new ArrayList<>();
        accounts = new HashMap<>();
        announcements = new ArrayList<>();
    }

    /**
     * Method to get Singleton instance of CacheProvider.
     *
     * @return CacheProvider instance.
     */
    public static CacheProvider getCacheProvider()
    {
        return cacheProviderInstance;
    }

    public static Map< Integer, Student > getStudents()
    {
        return students;
    }

    public static Map< Integer, Lecturer > getLecturers()
    {
        return lecturers;
    }

    public static Map< Integer, StudyGroup > getStudyGroups()
    {
        return studyGroups;
    }

    public static Map< Integer, UniversitySubject > getUniversitySubjects()
    {
        return universitySubjects;
    }

    public static List< Mark > getMarks()
    {
        return marks;
    }

    public static Map< String, Account > getAccounts()
    {
        return accounts;
    }

    public static List< Announcement > getAnnouncements()
    {
        return announcements;
    }
}
