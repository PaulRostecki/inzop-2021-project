package model;

import java.time.DayOfWeek;
import java.util.List;

/**
 * Interface for {@link StudyGroup}.
 *
 * @author created: Michał Musiałowicz on 04.12.2021
 * @author last changed:
 */
public interface StudyGroupIf
{
    int getGroupId();

    int getLecturerId();

    int getUniversitySubjectId();

    List< Student > getStudents();

    DayOfWeek getDay();

    String getStartTime();

    String getNumberOfStudents();

    String getLecturerLastName();

    String getLecturerFirstName();

    String getDayInPolish();

    String getUniversitySubjectName();
}
