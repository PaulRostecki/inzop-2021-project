package cache;

import model.extensions.Account;
import model.extensions.Announcement;
import model.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for Create & Update & Delete operations from/to Database.
 *
 * @author created: Michał Musiałowicz on 11.01.2022
 * @author last changed:
 */
public class DataRegistrar
{
    private static final Logger LOGGER = LogManager.getLogger( DataRegistrar.class );

    private static final CacheProvider cacheProvider = CacheProvider.getCacheProvider();

    protected void addNewMark( EntityManager aEntityManager, Mark aMark )
    {
        try
        {
            aEntityManager.getTransaction().begin();
            aEntityManager.persist( aMark );
            aEntityManager.getTransaction().commit();

            LOGGER.info( aMark.toString() + " added to database." );
        }
        catch ( Exception e )
        {
            LOGGER.warn( "Exception " + e.getClass().getSimpleName()
                    + " thrown during adding new mark: " + aMark.toString() );
        }
    }

    protected void updateMark( EntityManager aEntityManager, Mark aMark )
    {
        try
        {
            aEntityManager.getTransaction().begin();
            aEntityManager.merge( aMark );
            aEntityManager.getTransaction().commit();

            LOGGER.info( aMark.toString() + " updated in database." );
        }
        catch ( Exception e )
        {
            LOGGER.warn( "Exception " + e.getClass().getSimpleName()
                    + " thrown during updating mark: " + aMark.toString() );
        }
    }

    protected void addNewAnnouncement( EntityManager aEntityManager, Announcement aAnnouncement )
    {
        try
        {
            aEntityManager.getTransaction().begin();
            aEntityManager.persist( aAnnouncement );
            aEntityManager.getTransaction().commit();

            LOGGER.info( aAnnouncement.toString() + " added to database." );
        }
        catch ( Exception e )
        {
            LOGGER.warn( "Exception " + e.getClass().getSimpleName() +
                    " thrown during adding new announcement: " + aAnnouncement.toString() );
        }
    }

    protected void deleteObject( EntityManager aEntityManager, Object aModelObject )
    {
        try
        {
            aEntityManager.getTransaction().begin();
            if( aModelObject instanceof Student )
            {
                deleteStudentFromDatabase( aEntityManager, (Student) aModelObject );
            }
            if( aModelObject instanceof Lecturer )
            {
                deleteLecturerFromDatabase( aEntityManager, (Lecturer) aModelObject );
            }
            if( aModelObject instanceof UniversitySubject )
            {
                deleteUniversitySubjectFromDatabase( aEntityManager, (UniversitySubject) aModelObject );
            }
            if( aModelObject instanceof StudyGroup )
            {
                deleteStudyGroupFromDatabase( aEntityManager, (StudyGroup)aModelObject );
            }
            aEntityManager.getTransaction().commit();

            LOGGER.info( aModelObject.toString() + " deleted from database." );
        }
        catch ( Exception e )
        {
            LOGGER.warn( "Exception " + e.getClass().getSimpleName() +
                    " thrown during deleting: " + aModelObject.toString() );
        }
    }

    private void deleteStudentFromDatabase( EntityManager aEntityManager, Student aStudent )
    {
        aEntityManager.createNativeQuery("delete from Studenci where PESEL = :pesel")
                .setParameter("pesel", aStudent.getPESEL() )
                .executeUpdate();

        cacheProvider.getStudents().remove( Integer.valueOf( aStudent.getIndexNumber() ) );
        List< Mark > marksToBeRemoved = cacheProvider.getMarks().stream()
                .filter( mark -> mark.getMarkId().getStudentId() == Integer.parseInt( aStudent.getIndexNumber() ) )
                .collect( Collectors.toList() );

        cacheProvider.getMarks().removeAll( marksToBeRemoved );
        List< StudyGroup > studyGroupsToRemoveStudentFrom = cacheProvider.getStudyGroups().values().stream()
                .filter( sG -> sG.getStudents().contains( aStudent ) )
                .collect( Collectors.toList() );
        studyGroupsToRemoveStudentFrom.forEach( sG -> sG.getStudents().remove( aStudent ) );

        List< Account > accountsToReRemoved = cacheProvider.getAccounts().values().stream()
                .filter( acc -> acc.getEmail().equals( aStudent.getEmail() ) )
                .collect( Collectors.toList() );
        accountsToReRemoved.forEach( acc -> cacheProvider.getAccounts().remove( acc.getEmail() ) );
        accountsToReRemoved.forEach( aEntityManager::remove );
    }

    private void deleteLecturerFromDatabase( EntityManager aEntityManager, Lecturer aLecturer )
    {
        aEntityManager.remove( aLecturer );
        cacheProvider.getLecturers().remove( aLecturer.getId() );

        List< Account > accountsToReRemoved = cacheProvider.getAccounts().values().stream()
                .filter( acc -> acc.getEmail().equals( aLecturer.getEmail() ) )
                .collect( Collectors.toList() );
        accountsToReRemoved.forEach( acc -> cacheProvider.getAccounts().remove( acc.getEmail() ) );
        accountsToReRemoved.forEach( aEntityManager::remove );
    }

    private void deleteUniversitySubjectFromDatabase( EntityManager aEntityManager, UniversitySubject aUniversitySubject )
    {
        aEntityManager.remove( aUniversitySubject );
        cacheProvider.getUniversitySubjects().remove( aUniversitySubject.getId() );
        List< Integer > studyGroupsIDsToBeRemoved =  cacheProvider.getStudyGroups().values().stream()
                .filter( sG -> sG.getUniversitySubjectId() == aUniversitySubject.getId() )
                .map( StudyGroup::getGroupId )
                .collect( Collectors.toList() );
        studyGroupsIDsToBeRemoved.forEach( sgID -> cacheProvider.getStudyGroups().remove( sgID ) );
    }

    private void deleteStudyGroupFromDatabase( EntityManager aEntityManager, StudyGroup aStudyGroup )
    {
        aEntityManager.remove( aStudyGroup );
        cacheProvider.getStudyGroups().remove( aStudyGroup.getGroupId() );
    }
}
