package model;

import java.util.List;

/**
 * Interface for Lecturer.
 *
 * @author created: Michał Musiałowicz on 04.12.2021
 * @author last changed:
 */
public interface LecturerIf extends PersonIf
{
    int getId();

    String getAcademicTitle();

    String getDuty();

    List< StudyGroup > getStudyGroups();

    Integer getStudyGroupsCount();
}
