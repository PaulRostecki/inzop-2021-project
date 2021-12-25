package model.orm;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Class that represents embedded primary key of StudentGroupRelation entity.
 *
 * @author created: Michał Musiałowicz on 27.12.2021
 * @author last changed:
 */

@Embeddable
public class StudentGroupRelationId implements Serializable
{
    private static final long serialVersionUID = 1234567890L;

    @Column( name = "nr_albumu_studenta" )
    private String studentIndex;

    @Column( name = "id_grupy" )
    private int studyGroupId;


    /**
     * Default no-arg constructor for Hibernate ORM.
     */
    public StudentGroupRelationId()
    {

    }

    public String getStudentIndex()
    {
        return studentIndex;
    }

    public int getStudyGroupId()
    {
        return studyGroupId;
    }
}
