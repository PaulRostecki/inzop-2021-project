package model.extensions;

import model.model.Student;
import model.model.StudyGroup;

import java.util.List;

/**
 * Interface for {@link TimeTable}
 *
 * @author created: Michał Musiałowicz on 12.12.2021
 * @author last changed:
 */
@Deprecated
public interface TimeTableIf
{
    int getStudentId();

    List< StudyGroup > getStudyGroups();

    Student getStudent();
}
