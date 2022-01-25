package validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for regex matching.
 *
 * @author created: Michał Nowak on 25.01.2021
 * @author last changed:
 */

class RegexProviderTest {

    private static final String emailRegex = RegexProvider.EMAIL_REGEX;
    private static final String nameRegex = RegexProvider.NAME_REGEX;
    private static final String peselRegex = RegexProvider.PESEL_REGEX;
    private static final String phoneNumberRegex = RegexProvider.PHONE_NUMBER_REGEX;
    private static final String addressRegex = RegexProvider.ADDRESS_REGEX;
    private static final String dutyRegex = RegexProvider.DUTY_REGEX;


    @Test
    void emailRegexTest() {

        assertTrue("jankowalski2001@anymail.pl".matches(emailRegex));
        assertTrue("jan_______kowalski3000@anymail.com".matches(emailRegex));

        assertFalse("janKowAlskI3000anymail.com".matches(emailRegex));
        assertFalse("@janKowalskianymailru".matches(emailRegex));
    }

    @Test
    void nameRegexTest() {

        assertTrue("John Paul".matches(nameRegex));
        assertTrue("John".matches(nameRegex));

        assertFalse("".matches(nameRegex));
    }

    @Test
    void peselRegexTest() {

        assertTrue("21372137111".matches(peselRegex));

        assertFalse("213721372137".matches(peselRegex));
        assertFalse("2137abc2222".matches(peselRegex));
    }

    @Test
    void phoneNumberRegexTest() {

        assertTrue("213721372".matches(phoneNumberRegex));
        assertTrue("220000000".matches(phoneNumberRegex));

        assertFalse("666000abc".matches(phoneNumberRegex));
        assertFalse("111111111111111".matches(phoneNumberRegex));
        assertFalse("1111".matches(phoneNumberRegex));
    }

    @Test
    void addressRegexTest() {

        assertTrue("Jana Pawla 2 21/37".matches(addressRegex));

        assertFalse("Jana".matches(addressRegex));
        assertFalse("".matches(addressRegex));
    }

    @Test
    void dutyRegexTest() {

        assertTrue("Sroda 13:00".matches(dutyRegex));
        assertTrue("Wtorek".matches(dutyRegex));

        assertFalse("".matches(dutyRegex));
        assertFalse("@#@#@".matches(dutyRegex));
    }

}