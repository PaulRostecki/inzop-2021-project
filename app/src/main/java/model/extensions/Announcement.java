package model.extensions;

import cache.CacheProvider;

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

    private final String title;

    public Announcement ( int aLecturerId, String aTitle, String aDetails )
    {
        lecturerId = aLecturerId;
        details = aDetails;
        title = aTitle;
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
