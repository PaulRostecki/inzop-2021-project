package model;

import constant.MarkValuesEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MarkTest {
    private Mark markOne, markTwo, markThree, markFour, markFive;
    private Set<Mark> setOne, setTwo, setThree, setFour;

    @BeforeEach
    void setUp(){
        markOne = new Mark(464444, 23, 1, MarkValuesEnum.FOUR); //basic mark (1)
        markTwo = new Mark(464555, 25, 2, MarkValuesEnum.FIVE); //completely different mark (2)

        markThree = new Mark(464444, 25, 1, MarkValuesEnum.TWO); //mark with student id & subject id of (1), rem. fields of (2)

        markFour = new Mark(464442, 23, 1, MarkValuesEnum.FOUR); //m.(1) but with different student id
        markFive = new Mark(464444, 23, 5, MarkValuesEnum.FOUR); //m.(1) but with different subject id


        setOne = new HashSet<>();
        setOne.add(markOne);

        setTwo = new HashSet<>();
        setTwo.add(markTwo);

        setThree = new HashSet<>();
        setThree.add(markOne); setThree.add(markTwo);

        setFour = new HashSet<>();
        setFour.add(markTwo); setFour.add(markThree);
    }
    @Test
    void testEquals() {
        assertEquals(markOne, markOne);

        assertNotEquals(markOne,markTwo);

        assertEquals(markOne,markThree);
        assertNotEquals(markTwo,markThree);

        assertNotEquals(markOne, markFour);
        assertNotEquals(markOne, markFive);

    }

    @Test
    void testHash() {
        assertEquals(setOne,setOne);

        assertNotEquals(setOne, setTwo);

        assertEquals(setThree,setFour);

        assertTrue(setOne.contains(markThree));

        assertFalse(setOne.contains(markFour));
        assertFalse(setOne.contains(markFive));

        assertFalse(setTwo.contains(markOne));

        assertFalse(setThree.add(markThree));
    }
}