package model;

import constant.AcademicTitlesEnum;
import constant.MarkValuesEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class InterclassTest {
    private Lecturer lecturerOne, lecturerTwo;
    private Student studentOne;
    private Mark mark;
    private UniversitySubject subject;
    private Set<AbstractPerson> setOne, setTwo, setThree;

    @BeforeEach
    void setUp() {
        lecturerOne = new Lecturer("Jan","Kowalski", "12345678910",  "Mickiewicza 10 Poznan",  LocalDate.of(1996, 10, 16),
                 "555444999",  "Jankowalski@gmail.com",  AcademicTitlesEnum.MASTER,  "Sroda 13:00",  23); //basic lecturer (1)
        lecturerTwo = new Lecturer("Adam","Nowak", "10987654321",  "Chrobrego 20 Poznan",  LocalDate.of(1992, 12, 13),
                "555777999",  "adamnowak@gmail.com",  AcademicTitlesEnum.DOCTOR,  "Wtorek 12:00",  25); //completely different lecturer (2)

        studentOne = new Student("Jan","Kowalski", "12345678910",  "Mickiewicza 10 Poznan",  LocalDate.of(1996, 10, 16),
                "555444999", "Jankowalski@gmail.com", "464444");//student which also is the lecturer assigned (1)

        mark = new Mark(464444, 23, 1, MarkValuesEnum.FOUR);
        subject = new UniversitySubject(1, "Math Analysis", "Functions and stuff", 5);

        setOne = new HashSet<>();
        setOne.add(studentOne);

        setTwo = new HashSet<>();
        setTwo.add(lecturerOne);
    }

    @Test
    void testAbstractPerson() {
        assertEquals(lecturerOne, studentOne);
        assertNotEquals(lecturerTwo, studentOne);

    }

    @Test
    void testRemaining() {
        assertNotEquals(lecturerOne, mark);
        assertNotEquals(studentOne, mark);

        assertNotEquals(mark, subject);
        assertNotEquals(subject, studentOne);
        assertNotEquals(subject, lecturerTwo);
    }

    @Test
    void hashTest() {
        assertEquals(setOne,setTwo);

        assertFalse(setOne.add(lecturerOne));
    }
}