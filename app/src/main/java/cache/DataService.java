package cache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Parent Service for whole data transfer and Object-Relational Mapping.
 *
 * @author created: Michał Musiałowicz on 27.12.2021
 * @author last changed:
 */
public final class DataService
{
    private static final Logger LOGGER = LogManager.getLogger( DataService.class );

    private final DataFetcher dataFetcher;

    private EntityManager entityManager;

    private static DataService dataService;

    private DataService()
    {
        LOGGER.info( "Initializing Data Service." );
        dataFetcher = new DataFetcher();
        createEntityManager();
    }

    public static DataService getDataService()
    {
        if ( dataService == null )
        {
            LOGGER.info( "Creating DataService." );
            dataService = new DataService();
        }
        return dataService;
    }

    private void createEntityManager()
    {
        LOGGER.info( "Creating EntityManager." );

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory( "usos-persistence" );
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void fetchDataFromDatabase()
    {
        LOGGER.info( "Fetching data from database." );

        fetchUniversitySubjects();
        fetchStudyGroups();
        fetchStudents();
        fetchLecturers();
        fetchMarks();
        fetchAnnouncements();
        fetchAccounts();
        fetchStudentGroupRelations();
    }

    private void fetchUniversitySubjects()
    {
        dataFetcher.fetchUniversitySubjects( entityManager );
    }

    private void fetchStudyGroups()
    {
        dataFetcher.fetchStudyGroups( entityManager );
    }

    private void fetchStudents()
    {
        dataFetcher.fetchStudents( entityManager );
    }

    private void fetchLecturers()
    {
        dataFetcher.fetchLecturers( entityManager );
    }

    private void fetchMarks()
    {
        dataFetcher.fetchMarks( entityManager );
    }

    private void fetchAnnouncements()
    {
        dataFetcher.fetchAnnouncements( entityManager );
    }

    private void fetchAccounts()
    {
        dataFetcher.fetchAccounts( entityManager );
    }

    private void fetchStudentGroupRelations()
    {
        dataFetcher.fetchStudentGroupRelations( entityManager );
    }
}
