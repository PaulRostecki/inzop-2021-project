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

    String getDetails();

    String getTitle();

    String getLecturerFirstName();

    String getLecturerLastName();

    String getLecturerTitle();
}
