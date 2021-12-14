package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UniversitySubjectTest {
    private UniversitySubject subjectOne, subjectTwo, subjectThree, subjectFour, subjectFive, subjectSix;
    private Set<UniversitySubject> setOne, setTwo, setThree, setFour;

    @BeforeEach
    void setUp(){
        subjectOne = new UniversitySubject(1, "Math Analysis", "Functions and stuff", 5);//basic subject (1)
        subjectTwo = new UniversitySubject(2, "IT Basics", "basics of IT", 4);//completely different subject (2)

        subjectThree = new UniversitySubject(2, "Math Analysis", "basics of IT", 4);//(3) - subject with name of s.(1), rem. of s.(2)

        subjectFour = new UniversitySubject(1, "math analysis", "Functions and stuff", 5);//s.(1) but lowercase name
        subjectFive = new UniversitySubject(1, "MATH ANALYSIS", "Functions and stuff", 5);//s.(1) but uppercase name

        subjectSix = new UniversitySubject(2, "math analysis", "basics of IT", 4);//s.(3) but lowercase name

        setOne = new HashSet<>();
        setOne.add(subjectOne);

        setTwo = new HashSet<>();
        setTwo.add(subjectTwo);

        setThree = new HashSet<>();
        setThree.add(subjectOne); setThree.add(subjectTwo);

        setFour = new HashSet<>();
        setFour.add(subjectTwo); setFour.add(subjectThree);

    }

    @Test
    void testEquals() {
        assertEquals(subjectOne,subjectOne);

        assertNotEquals(subjectOne,subjectTwo);

        assertEquals(subjectOne,subjectThree);
        assertNotEquals(subjectTwo,subjectThree);

        assertEquals(subjectOne,subjectFour);
        assertEquals(subjectOne,subjectFive);

        assertEquals(subjectOne,subjectSix);
    }
    @Test
    void testHash() {
        assertEquals(setOne,setOne);

        assertNotEquals(setOne, setTwo);

        assertEquals(setThree,setFour);

        assertTrue(setOne.contains(subjectThree));

        assertTrue(setOne.contains(subjectFour)); //wywala błąd, hashcode nie ignoruje wielkości liter
        assertTrue(setOne.contains(subjectFive)); //to samo, do naprawy
        assertTrue(setOne.contains(subjectSix)); //też

        assertFalse(setTwo.contains(subjectOne));

        assertFalse(setThree.add(subjectThree));
    }

}