package model.extensions;

import cache.CacheProvider;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Implementation for Announcement.
 *
 * @author created: Michał Musiałowicz on 12.12.2021
 * @author last changed:
 */

@Entity
@Table( name = "komunikaty" )
public class Announcement implements AnnouncementIf
{
    @Id
    @Column( name = "id_komunikatu" )
    private int id;

    @Column( name = "id_prowadzacego" )
    private int lecturerId;

    @Column( name = "tresc" )
    private String details;

    @Column( name = "tytul" )
    private String title;

    public Announcement( int aId, int aLecturerId, String aTitle, String aDetails )
    {
        id = aId;
        lecturerId = aLecturerId;
        details = aDetails;
        title = aTitle;
    }

    /**
     * Default no-arg constructor for Hibernate ORM.
     */
    public Announcement()
    {

    }

    @Override
    public int getLecturerId()
    {
        return lecturerId;
    }

    @Override
    public String getDetails()
    {
        return details;
    }

    @Override
    public String getTitle()
    {
        return title;
    }

    @Override
    public int getId()
    {
        return id;
    }

    @Override
    public void setId( int aId )
    {
        id = aId;
    }

    @Override
    public void setLecturerId( int aLecturerId )
    {
        lecturerId = aLecturerId;
    }

    @Override
    public void setDetails( String aDetails )
    {
        details = aDetails;
    }

    @Override
    public void setTitle( String aTitle )
    {
        title = aTitle;
    }

    @Override
    public String getLecturerFirstName()
    {
        return CacheProvider.getCacheProvider().getLecturers().get( lecturerId ).getFirstName();
    }

    @Override
    public String getLecturerLastName()
    {
        return CacheProvider.getCacheProvider().getLecturers().get( lecturerId ).getLastName();
    }

    @Override
    public String getLecturerTitle()
    {
        return CacheProvider.getCacheProvider().getLecturers().get( lecturerId ).getAcademicTitle();
    }


}
