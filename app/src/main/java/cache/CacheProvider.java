package cache;

import constant.AcademicTitlesEnum;
import model.*;
import model.extensions.Account;
import model.extensions.Announcement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Cache Provider for all data in USOS. Integrated with Hibernate.
 *
 * @author created: Michał Musiałowicz on 12.12.2021
 * @author last changed:
 */
public final class CacheProvider
{
    private static final Logger LOGGER = LogManager.getLogger( CacheProvider.class );

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

        LOGGER.info( "Created and initialized Cache Provider." );

        addDemoData(); // to be deleted after integration with DB
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

    public List< Mark > getMarks()
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

    // to be deleted after integration with DB
    private void addDemoData()
    {
        Student studentOne = new Student("Jan","Kowalski", "12345678910",
                "Mickiewicza 10 Poznan",  LocalDate.of(1996, 10, 16),
                "555444999", "Jankowalski@gmail.com", "464444");
        Student studentTwo = new Student("Adam", "Nowak", "10987654321",
                "Slowackiego 20 Poznan", LocalDate.of(1992, 12, 15),
                "555777999", "Adamnowak@gmail.com", "464555");

        students.put( Integer.parseInt( studentOne.getIndexNumber() ), studentOne );
        students.put( Integer.parseInt( studentTwo.getIndexNumber() ), studentTwo );

        Lecturer lecturerOne = new Lecturer("Jan","Kowalski", "12345678910",
                "Mickiewicza 10 Poznan",  LocalDate.of(1996, 10, 16),
                "555444999",  "Jankowalski@gmail.com",  AcademicTitlesEnum.MASTER,
                "Sroda 13:00",  23); //basic lecturer (1)
        Lecturer lecturerTwo = new Lecturer("Adam","Nowak", "10987654321",
                "Chrobrego 20 Poznan",  LocalDate.of(1992, 12, 13),
                "555777999",  "adamnowak@gmail.com",  AcademicTitlesEnum.DOCTOR,
                "Wtorek 12:00",  25); //completely different lecturer (2)

        lecturers.put(lecturerOne.getId(), lecturerOne );
        lecturers.put(lecturerTwo.getId(), lecturerTwo );

        UniversitySubject subjectOne = new UniversitySubject(1, "Math Analysis", "Functions and stuff",
                5);//basic subject (1)
        UniversitySubject subjectTwo = new UniversitySubject(2, "IT Basics", "basics of IT",
                4);//completely different subject (2)
        universitySubjects.put( subjectOne.getId(), subjectOne );
        universitySubjects.put( subjectTwo.getId(), subjectTwo );


        StudyGroup sgOne = new StudyGroup(1, 23, 1, List.of(studentOne, studentTwo),
                DayOfWeek.MONDAY,"12:00");//basic study group (1)
        StudyGroup sgTwo = new StudyGroup(2, 25, 2, List.of(studentOne, studentOne),
                DayOfWeek.TUESDAY,"14:00");//different study group (2)

        studyGroups.put( sgOne.getGroupId(), sgOne );
        studyGroups.put( sgTwo.getGroupId(), sgTwo );
    }
}
