package model.extensions;

/**
 * Interface for {@link Announcement}
 *
 * @author created: Michał Musiałowicz on 12.12.2021
 * @author last changed:
 */
public interface AnnouncementIf
{
    int getLecturerId();

    int getId();

    String getDetails();

    String getTitle();

    String getLecturerFirstName();

    String getLecturerLastName();

    String getLecturerTitle();

    void setId( int aId );

    void setLecturerId( int aLecturerId );

    void setDetails( String aDetails );

    void setTitle( String aTitle );
}
