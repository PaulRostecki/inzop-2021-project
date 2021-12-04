package model;

import constants.AcademicTitlesEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation for Lecturer.
 *
 * @author created: Michał Musiałowicz on 04.12.2021
 * @author last changed:
 */
public class Lecturer extends AbstractPerson implements LecturerIf
{
    private final int id;

    private final AcademicTitlesEnum academicTitle;

    private final String duty;

    private final List< StudyGroup > studyGroups;

    public Lecturer( String aFirstName, String aLastName, String aPESEL, String aAddress, LocalDate aDateOfBirth,
                    String aPhoneNumber, String aEmail, AcademicTitlesEnum aAcademicTitle, String aDuty, Integer aId )
    {
        super( aFirstName, aLastName, aPESEL, aAddress, aDateOfBirth, aPhoneNumber, aEmail );
        academicTitle = aAcademicTitle;
        duty = aDuty;
        id = aId;
        studyGroups = new ArrayList<>();
    }

    @Override
    public int getId()
    {
        return id;
    }

    @Override
    public String getAcademicTitle()
    {
        return academicTitle.getTitle();
    }

    @Override
    public String getDuty()
    {
        return duty;
    }

    @Override
    public List< StudyGroup > getStudyGroups()
    {
        return studyGroups;
    }

    @Override
    public Integer getStudyGroupsCount()
    {
        return studyGroups.size();
    }
}
