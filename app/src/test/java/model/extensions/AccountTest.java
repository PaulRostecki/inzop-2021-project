package model.extensions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Equals tests between Accout class objects
 *
 * @author created: Mikołaj Mumot on 20.01.2022
 * @author last changed:
 */

class AccountTest {
    private static Account accountOne, accountTwo, accountThree, accountFour;
    private static Set<Account> setOne, setTwo, setThree, setFour;

    @BeforeAll
    static void setUp(){
        accountOne = new Account( "jankowalski@gmail.com", "password123", "STUDENT" );

        /* Same email as accountOne */
        accountTwo = new Account( "jankowalski@gmail.com", "randomwords4321", "MODERATOR" );

        /* Different account */
        accountThree = new Account( "adamnowak@wp.pl", "uczelnia4321", "LECTURER" );

        /* Different email, other fields same as accountOne */
        accountFour = new Account("panandrzej@gmail.com", "password123", "STUDENT" );

        setOne = new HashSet<>();
        setOne.add( accountOne );

        setTwo = new HashSet<>();
        setTwo.add( accountTwo );

        setThree = new HashSet<>();
        setThree.add( accountThree );

        setFour = new HashSet<>();
        setFour.add( accountFour );


    }

    @Test
    void testEquals() {
        assertEquals( accountOne, accountOne );
        assertEquals( accountOne, accountTwo );

        assertNotEquals( accountOne, accountThree );
        assertNotEquals( accountOne, accountFour );
    }

    @Test
    void testHash() {
        assertEquals( setOne, setOne );
        assertEquals( setOne, setTwo );

        assertNotEquals( setOne, setThree);
        assertNotEquals( setOne, setFour );

        assertTrue( setOne.contains( accountOne ) );
        assertTrue( setOne.contains( accountTwo ) );

        assertFalse( setOne.contains( accountFour ) );
        assertFalse( setOne.add( accountTwo ) );
    }



}