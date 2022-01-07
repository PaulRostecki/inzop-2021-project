package model;

import constant.AcademicTitlesEnum;
import constant.MarkValuesEnum;
import model.model.AbstractPerson;
import model.model.Lecturer;
import model.model.Mark;
import model.model.Student;
import model.model.UniversitySubject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Equals tests between objects od different classes
 *
 * @author created: Mikołaj Mumot on 14.12.2021
 * @author last changed:
 */

class InterclassTest {
    private static Lecturer lecturerOne, lecturerTwo;
    private static Student studentOne;
    private static Mark mark;
    private static UniversitySubject subject;
    private static Set<AbstractPerson> setOne, setTwo, setThree;

    @BeforeAll
    static void setUp() {
        lecturerOne = new Lecturer( "Jan","Kowalski", "12345678910",
                "Mickiewicza 10 Poznan",  LocalDate.of( 1996, 10, 16 ),
                 "555444999",  "Jankowalski@gmail.com",  AcademicTitlesEnum.MASTER.getTitle(),
                "Sroda 13:00",  23 ); //basic lecturer (1)

        lecturerTwo = new Lecturer( "Adam","Nowak", "10987654321",
                "Chrobrego 20 Poznan",  LocalDate.of( 1992, 12, 13 ),
                "555777999",  "adamnowak@gmail.com",  AcademicTitlesEnum.DOCTOR.getTitle(),
                "Wtorek 12:00",  25 ); //completely different lecturer (2)

        studentOne = new Student( "Jan","Kowalski", "12345678910",
                "Mickiewicza 10 Poznan",  LocalDate.of( 1996, 10, 16 ),
                "555444999", "Jankowalski@gmail.com", "464444" );
                //student which also is the lecturer assigned (1)

        mark = new Mark( 464444, 23, 1, MarkValuesEnum.FOUR.getMarkValue() );
        subject = new UniversitySubject( 1, "Math Analysis", "Functions and stuff", 5 );

        setOne = new HashSet<>();
        setOne.add( studentOne );

        setTwo = new HashSet<>();
        setTwo.add( lecturerOne );
    }

    @Test
    void testAbstractPerson() {
        assertEquals( lecturerOne, studentOne );
        assertNotEquals( lecturerTwo, studentOne );

    }

    @Test
    void testRemaining() {
        assertNotEquals( lecturerOne, mark );
        assertNotEquals( studentOne, mark );

        assertNotEquals( mark, subject );
        assertNotEquals( subject, studentOne );
        assertNotEquals( subject, lecturerTwo );
    }

    @Test
    void hashTest() {
        assertEquals( setOne,setTwo );

        assertFalse( setOne.add( lecturerOne ) );
    }
}