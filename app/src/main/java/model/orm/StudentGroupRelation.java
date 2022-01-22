package model.orm;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity for relation between Students and Study Groups.
 *
 * @author created: Michał Musiałowicz on 30.12.2021
 * @author last changed:
 */

@Entity
@Table( name = "student_grupa" )
public class StudentGroupRelation implements StudentGroupRelationIf
{
    @EmbeddedId
    private StudentGroupRelationId studentGroupRelationId;

    public StudentGroupRelation()
    {

    }

    @Override
    public String getStudentIndex()
    {
        return studentGroupRelationId.getStudentIndex();
    }

    @Override
    public int getStudyGroupId()
    {
        return studentGroupRelationId.getStudyGroupId();
    }

}
