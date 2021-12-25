package model.extensions;

import cache.CacheProvider;
import model.model.Student;
import model.model.StudyGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation for TimeTable.
 *
 * @author created: Michał Musiałowicz on 12.12.2021
 * @author last changed:
 */
public class TimeTable implements TimeTableIf
{
    private final int studentId;

    private final List< StudyGroup > studyGroups;

    public TimeTable( int aStudentId )
    {
        studentId = aStudentId;
        studyGroups = new ArrayList<>();
    }

    @Override
    public int getStudentId()
    {
        return studentId;
    }

    @Override
    public List< StudyGroup > getStudyGroups()
    {
        return studyGroups;
    }

    @Override
    public Student getStudent()
    {
        return CacheProvider.getCacheProvider().getStudents().get( studentId );
    }
}
