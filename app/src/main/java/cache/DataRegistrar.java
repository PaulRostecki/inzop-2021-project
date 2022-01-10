package cache;

import model.extensions.Announcement;
import model.model.Mark;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;

/**
 * Service for Create & Update & Delete operations from/to Database.
 *
 * @author created: Michał Musiałowicz on 11.01.2022
 * @author last changed:
 */
public class DataRegistrar
{
    private static final Logger LOGGER = LogManager.getLogger( DataRegistrar.class );

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
                    " thrown during adding new annoucement: " + aAnnouncement.toString() );
        }
    }
}
