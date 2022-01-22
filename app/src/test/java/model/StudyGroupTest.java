package model;

import model.model.Student;
import model.model.StudyGroup;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Equals tests between StudyGroup class objects
 *
 * @author created: Mikołaj Mumot on 14.12.2021
 * @author last changed:
 */

class StudyGroupTest {

    private static Student studentOne, studentTwo, studentThree;
    private static StudyGroup sgOne, sgTwo, sgThree, sgFour, sgFive, sgSix;
    private static Set<StudyGroup> setOne, setTwo, setThree, setFour;
    @BeforeAll
    static void setUp(){
        studentOne = new Student( "Jan","Kowalski", "12345678910",
                "Mickiewicza 10 Poznan",  LocalDate.of( 1996, 10, 16 ),
                "555444999", "Jankowalski@gmail.com", 464444 ); //basic student (1)
        studentTwo = new Student( "Adam", "Nowak", "10987654321",
                "Slowackiego 20 Poznan", LocalDate.of( 1992, 12, 15 ),
                "555777999", "Adamnowak@gmail.com", 464555 );
                //completely different student (2)
        studentThree = new Student( "Eryk", "Pawlak", "5642311111",
                "Brzechwy 30 Poznan", LocalDate.of( 1999, 10, 4 ),
                "555888999", "Erykpawlak@gmail.com", 464666 );
                //completely different student (3)


        sgOne = new StudyGroup( 1, 23, 1, List.of( studentOne, studentTwo ),
                DayOfWeek.MONDAY,"12:00" );//basic study group (1)
        sgTwo = new StudyGroup( 2, 25, 2, List.of( studentOne, studentThree ),
                DayOfWeek.TUESDAY,"14:00" );//different study group (2)

        sgThree = new StudyGroup( 1, 23, 2, List.of( studentOne, studentThree ),
                DayOfWeek.MONDAY,"12:00" );//study group with lecturer and date of (1) and rem. fields of (2)

        sgFour = new StudyGroup( 1, 8, 1, List.of( studentOne, studentTwo ),
                DayOfWeek.MONDAY,"12:00" );//(1) but different lecturer
        sgFive = new StudyGroup( 1, 23, 1, List.of( studentOne, studentTwo ),
                DayOfWeek.MONDAY,"15:00" );//(1) but different hour
        sgSix = new StudyGroup( 1, 23, 1, List.of( studentOne, studentTwo ),
                DayOfWeek.FRIDAY,"12:00" );//(1) but different day

        setOne = new HashSet<>();
        setOne.add( sgOne );

        setTwo = new HashSet<>();
        setTwo.add( sgTwo );

        setThree = new HashSet<>();
        setThree.add( sgOne ); setThree.add( sgTwo );

        setFour = new HashSet<>();
        setFour.add( sgTwo ); setFour.add( sgThree );
    }

    @Test
    void testEquals() {
        assertEquals( sgOne, sgOne );

        assertNotEquals( sgOne, sgTwo );

        assertEquals( sgOne, sgThree );
        assertNotEquals( sgTwo, sgThree );

        assertNotEquals( sgOne, sgFour );
        assertNotEquals( sgOne, sgFive );
        assertNotEquals( sgOne, sgSix );
    }

    @Test
    void testHash() {
        assertEquals( setOne, setOne );

        assertNotEquals( setOne, setTwo );

        assertEquals( setThree, setFour );

        assertTrue( setOne.contains( sgThree ) );

        assertFalse( setOne.contains( sgFour ) );
        assertFalse( setOne.contains( sgFive ) );
        assertFalse( setOne.contains( sgFive ) );

        assertFalse( setTwo.contains( sgOne ) );

        assertFalse( setThree.add( sgThree ) );
    }
}