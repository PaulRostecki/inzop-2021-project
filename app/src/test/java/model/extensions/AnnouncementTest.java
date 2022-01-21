package model.extensions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AnnouncementTest {
    private static Announcement announcementOne, announcementTwo, announcementThree, announcementFour, announcementFive;
    private static Set<Announcement> setOne, setTwo, setThree, setFour, setFive;

    @BeforeAll
    static void setUp() {
        announcementOne = new Announcement( 1, 101, "Nauka zdalna", "Od jutra zdalne" );

        /* Same as announcementOne */
        announcementTwo = new Announcement( 1, 101, "Nauka zdalna", "Od jutra zdalne" );

        /* Different announcement than announcementOne */
        announcementThree = new Announcement( 3, 103, "Nauka stacjonarna",
                "Od jutra stacjo" );

        /* Same fields as announcementOne besides aID */
        announcementFour = new Announcement(2, 101, "Nauka zdalna", "Od jutra zdalne" );

        /* Same fields as announcementOne but different title */
        announcementFive = new Announcement( 1, 101, "Zdalne", "Od jutra zdalne" );

        setOne = new HashSet<>();
        setOne.add( announcementOne );

        setTwo = new HashSet<>();
        setTwo.add( announcementTwo );

        setThree = new HashSet<>();
        setThree.add( announcementThree );

        setFour = new HashSet<>();
        setFour.add( announcementFour );

        setFive = new HashSet<>();
        setFive.add( announcementFive );
    }


    @Test
    void testEquals() {
        assertEquals( announcementOne, announcementOne );
        assertEquals( announcementOne, announcementTwo );
        assertEquals( announcementOne, announcementFour );

        assertNotEquals( announcementOne, announcementThree );
        assertNotEquals( announcementOne, announcementFive );
    }

    @Test
    void testHash() {
        assertEquals( setOne, setOne );
        assertEquals( setOne, setTwo );
        assertEquals( setOne, setFour );

        assertNotEquals( setOne, setThree );
        assertNotEquals( setOne, setFive );

        assertTrue( setOne.contains( announcementOne ) );
        assertTrue( setOne.contains( announcementTwo ) );

        assertFalse( setOne.contains( announcementThree ) );
        assertFalse( setOne.contains( announcementFive ) );

        assertFalse( setOne.add( announcementFour ) );
    }
}