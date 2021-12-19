package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Equals tests between Student class objects
 *
 * @author created: Mikołaj Mumot on 14.12.2021
 * @author last changed:
 */

class StudentTest {
    private static Student studentOne, studentTwo, studentThree;
    private static Set<Student> setOne, setTwo, setThree, setFour;

    @BeforeAll
    static void setUp() {
        studentOne = new Student( "Jan","Kowalski", "12345678910",
                "Mickiewicza 10 Poznan",  LocalDate.of( 1996, 10, 16 ),
                "555444999", "Jankowalski@gmail.com", "464444" ); //basic student (1)
        studentTwo = new Student( "Adam", "Nowak", "10987654321",
                "Slowackiego 20 Poznan", LocalDate.of( 1992, 12, 15 ),
                "555777999", "Adamnowak@gmail.com", "464555" );
        //completely different student (2)
        studentThree = new Student( "Adam", "Nowak", "12345678910",
                "Slowackiego 20 Poznan", LocalDate.of( 1992, 12, 15 ),
                "555777999", "Adamnowak@gmail.com", "464555" );
        //student with PESEL of s.(1) and rem. values of s.(2)

        setOne = new HashSet<>();
        setOne.add( studentOne );

        setTwo = new HashSet<>();
        setTwo.add( studentTwo );

        setThree = new HashSet<>();
        setThree.add( studentOne ); setThree.add( studentTwo );

        setFour = new HashSet<>();
        setFour.add( studentTwo ); setFour.add( studentThree );
    }
    @Test
    void testEquals() {
        assertEquals( studentOne, studentOne );

        assertNotEquals( studentOne, studentTwo );

        assertEquals( studentOne, studentThree );
        assertNotEquals( studentTwo, studentThree );
    }

    @Test
    void testHash() {
        assertEquals( setOne, setOne );

        assertNotEquals( setOne, setTwo );

        assertEquals( setThree, setFour );

        assertTrue( setOne.contains( studentThree ) );
        assertFalse( setTwo.contains( studentOne ) );

        assertFalse( setThree.add( studentThree ) );
        //setThree.forEach(student -> {System.out.println(student.getFirstName());});
        // uncomment to check that with failed duplicate add old value did not get overwritten
    }
}