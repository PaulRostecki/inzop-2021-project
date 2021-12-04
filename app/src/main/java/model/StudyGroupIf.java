package model;

import java.time.LocalDateTime;
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

    LocalDateTime getDateAsDate();

    String getDateAsString();
}
