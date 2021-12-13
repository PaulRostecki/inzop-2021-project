package model.extensions;

/**
 * Implementation for Announcement.
 *
 * @author created: Michał Musiałowicz on 12.12.2021
 * @author last changed:
 */
public class Announcement implements AnnouncementIf
{
    private final int lecturerId;

    private final String details;

    public Announcement ( int aLecturerId, String aDetails )
    {
        lecturerId = aLecturerId;
        details = aDetails;
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
}
