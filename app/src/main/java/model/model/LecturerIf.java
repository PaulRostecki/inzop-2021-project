package model.model;

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

    void setId( int aId );

}
