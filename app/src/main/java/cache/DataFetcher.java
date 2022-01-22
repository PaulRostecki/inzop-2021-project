package cache;

import constant.PermissionTypeEnum;
import factory.AlertFactory;
import model.extensions.Account;
import model.extensions.Announcement;
import model.model.Lecturer;
import model.model.Mark;
import model.model.Student;
import model.model.StudyGroup;
import model.model.UniversitySubject;
import model.orm.StudentGroupRelation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Service for fetching objects from database.
 *
 * @author created: Michał Musiałowicz on 28.12.2021
 * @author last changed:
 */
public class DataFetcher
{
    private static final Logger LOGGER = LogManager.getLogger( DataFetcher.class );

    private static final CacheProvider cacheProvider = CacheProvider.getCacheProvider();

    protected void fetchUniversitySubjects( EntityManager aEntityManager )
    {
        LOGGER.info( "Fetching University Subjects from Database." );

        try
        {
            Query fetchUniversitySubjectsQuery = aEntityManager.createQuery( "SELECT x FROM UniversitySubject x" );
            List< UniversitySubject > universitySubjects = fetchUniversitySubjectsQuery.getResultList();
            universitySubjects.forEach( uS -> cacheProvider.getUniversitySubjects().put( uS.getId(), uS ) );
        }
        catch ( Exception e )
        {
            LOGGER.error( "Error during fetching University Subjects from Database." );
            e.printStackTrace();
            AlertFactory.popUpErrorAlert( e );
        }
    }

    protected void fetchStudyGroups( EntityManager aEntityManager )
    {
        LOGGER.info( "Fetching Study Groups from Database." );

        try
        {
            Query fetchStudyGroupsQuery = aEntityManager.createQuery( "SELECT x FROM StudyGroup x" );
            List< StudyGroup > studyGroups = fetchStudyGroupsQuery.getResultList();
            studyGroups.forEach( sG -> cacheProvider.getStudyGroups().put( sG.getGroupId(), sG ) );
        }
        catch ( Exception e )
        {
            LOGGER.error( "Error during fetching Study Groups from Database." );
            e.printStackTrace();
            AlertFactory.popUpErrorAlert( e );
        }
    }

    protected void fetchStudents( EntityManager aEntityManager )
    {
        LOGGER.info( "Fetching Students from Database." );

        try
        {
            Query fetchStudentsQuery = aEntityManager.createQuery( "SELECT x FROM Student x" );
            List< Student > students = fetchStudentsQuery.getResultList();
            students.forEach( st -> cacheProvider.getStudents().put( Integer.valueOf( st.getIndexNumber() ), st ) );
        }
        catch ( Exception e )
        {
            LOGGER.error( "Error during fetching Students from Database." );
            e.printStackTrace();
            AlertFactory.popUpErrorAlert( e );
        }
    }


    protected void fetchLecturers( EntityManager aEntityManager )
    {
        LOGGER.info( "Fetching Lecturers from Database." );

        try
        {
            Query fetchLecturersQuery = aEntityManager.createQuery( "SELECT x FROM Lecturer x" );
            List< Lecturer > lecturers = fetchLecturersQuery.getResultList();
            lecturers.forEach( lec -> cacheProvider.getLecturers().put( lec.getId(), lec ) );
        }
        catch ( Exception e )
        {
            LOGGER.error( "Error during fetching Lecturers from Database." );
            e.printStackTrace();
            AlertFactory.popUpErrorAlert( e );
        }
    }

    protected void fetchMarks( EntityManager aEntityManager )
    {
        LOGGER.info( "Fetching Marks from Database." );

        try
        {
            Query fetchMarksQuery = aEntityManager.createQuery( "SELECT x FROM Mark x" );
            List< Mark > marks = fetchMarksQuery.getResultList();
            cacheProvider.getMarks().addAll( marks );
        }
        catch ( Exception e )
        {
            LOGGER.error( "Error during fetching Marks from Database." );
            e.printStackTrace();
            AlertFactory.popUpErrorAlert( e );
        }
    }

    protected void fetchAnnouncements( EntityManager aEntityManager )
    {
        LOGGER.info( "Fetching Announcements from Database." );

        try
        {
            Query fetchAnnouncementsQuery = aEntityManager.createQuery( "SELECT x FROM Announcement x" );
            List< Announcement > announcements = fetchAnnouncementsQuery.getResultList();
            cacheProvider.getAnnouncements().addAll( announcements );
        }
        catch ( Exception e )
        {
            LOGGER.error( "Error during fetching Announcements from Database." );
            e.printStackTrace();
            AlertFactory.popUpErrorAlert( e );
        }
    }

    protected void fetchAccounts( EntityManager aEntityManager )
    {
        LOGGER.info( "Fetching Accounts from Database." );

        try
        {
            Query fetchAccountsQuery = aEntityManager.createQuery( "SELECT x FROM Account x" );
            List< Account > accounts = fetchAccountsQuery.getResultList();
            accounts.forEach( acc -> acc.setPermission( acc.getPermission() ) ); // set PermissionTypeEnum
            accounts.stream().filter( validEmailPredicate ).forEach( acc -> cacheProvider.getAccounts().put( acc.getEmail(), acc ) );
        }
        catch ( Exception e )
        {
            LOGGER.error( "Error during fetching Accounts from Database." );
            e.printStackTrace();
            AlertFactory.popUpErrorAlert( e );
        }
    }

    protected void fetchStudentGroupRelations( EntityManager aEntityManager )
    {
        LOGGER.info( "Fetching relations between Students and Study Groups from Database." );

        try
        {
            Query fetchStudentGroupRelationsQuery
                    = aEntityManager.createQuery( "SELECT x FROM StudentGroupRelation x" );
            List< StudentGroupRelation > studentGroupRelations = fetchStudentGroupRelationsQuery.getResultList();
            studentGroupRelations.forEach( addStudentToGroupConsumer );
        }
        catch ( Exception e )
        {
            LOGGER.error( "Error during fetching Accounts from Database." );
            e.printStackTrace();
            AlertFactory.popUpErrorAlert( e );
        }
    }

    /**
     * Predicate that checks whether Email in Account is valid. It has to belong to either Lecturer or Student, or this
     * Account has to have Moderator permissions.
     *
     * Check: {@link PermissionTypeEnum}
     */
    private final Predicate< Account > validEmailPredicate =
            acc ->  (
                    cacheProvider.getStudents().values().stream()
                        .map( Student::getEmail )
                        .collect( Collectors.toList() )
                        .contains( acc.getEmail() )
                                     ||
                    cacheProvider.getLecturers().values().stream()
                        .map( Lecturer::getEmail )
                        .collect( Collectors.toList() )
                        .contains( acc.getEmail() )
                    )
                    ||
                    acc.getPermissionType() == PermissionTypeEnum.MODERATOR;

    /**
     * Consumer function which adds Student to Study Group based on relation between them.
     */
    private final Consumer< StudentGroupRelation > addStudentToGroupConsumer
            = rel -> cacheProvider.getStudyGroups().get( rel.getStudyGroupId() )
                    .addStudentToTheGroup( cacheProvider.getStudents().get( Integer.valueOf( rel.getStudentIndex() ) ) );
}
