package model;

import constant.AcademicTitlesEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Equals tests between Lecturer class objects
 *
 * @author created: Mikołaj Mumot on 14.12.2021
 * @author last changed:
 */

class LecturerTest {
    private static Lecturer lecturerOne, lecturerTwo, lecturerThree;
    private static Set<Lecturer> setOne, setTwo, setThree, setFour;

    @BeforeAll
    static void setUp() {
        lecturerOne = new Lecturer( "Jan", "Kowalski", "12345678910",
                "Mickiewicza 10 Poznan",  LocalDate.of(1996, 10, 16),
                "555444999", "Jankowalski@gmail.com", AcademicTitlesEnum.MASTER,
                "Sroda 13:00", 23 ); //basic lecturer (1)
        lecturerTwo = new Lecturer("Adam", "Nowak", "10987654321",
                "Chrobrego 20 Poznan",  LocalDate.of(1992, 12, 13),
                "555777999",  "adamnowak@gmail.com",  AcademicTitlesEnum.DOCTOR,
                "Wtorek 12:00",  25 ); //completely different lecturer (2)
        lecturerThree = new Lecturer( "Adam","Nowak", "12345678910",
                "Chrobrego 20 Poznan",  LocalDate.of(1992, 12, 13),
                "555777999",  "adamnowak@gmail.com",  AcademicTitlesEnum.DOCTOR,
                "Wtorek 12:00",  25 ); //lecturer with PESEL of l.(1), and rem. values of l.(2)

        setOne = new HashSet<>();
        setOne.add( lecturerOne );

        setTwo = new HashSet<>();
        setTwo.add( lecturerTwo );

        setThree = new HashSet<>();
        setThree.add( lecturerOne ); setThree.add( lecturerTwo );

        setFour = new HashSet<>();
        setFour.add( lecturerTwo ); setFour.add( lecturerThree );
    }

    @Test
    void testEquals() {
        assertEquals( lecturerOne, lecturerOne );

        assertNotEquals( lecturerOne, lecturerTwo );

        assertEquals( lecturerOne, lecturerThree );
        assertNotEquals( lecturerTwo, lecturerThree );

    }

    @Test
    void testHash() {
        assertEquals( setOne,setOne );

        assertNotEquals( setOne, setTwo );

        assertEquals( setThree,setFour );

        assertTrue( setOne.contains( lecturerThree ) );
        assertFalse( setTwo.contains( lecturerOne ) );

        assertFalse( setThree.add( lecturerThree ) );
        //setThree.forEach(lecturer -> {System.out.println(lecturer.getFirstName());});
        // uncomment to check that with failed duplicate add old value did not get overwritten
    }
}