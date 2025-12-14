package com.lab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Password implementations.
 * 
 * To test different buggy versions, simply uncomment the corresponding
 * getPassword() method and comment out the others.
 * 
 * Available implementations:
 * - Password: Correct implementation
 * - BugDoesNotTrim: Does not trim whitespace
 * - BugToShortPassword: Allows passwords shorter than 12 characters
 * - BugVeryShort: Allows way to short passwords
 * - BugWrongExceptionMessage: Wrong exception message for short passwords
 * - BugMissingPasswordLengthCheck: Does not throw exception for short passwords
 * - BugMissingNumberCheck: Does not throw exception if password lacks a number
 * - BugIsPasswordSameAlwaysTrue: isPasswordSame always returns true
 * - BugWrongHashingAlgorithm: Wrong hashing algorithm
 */

public class PasswordTest {
    private IPassword getPassword(String s) throws Exception {
        // return (IPassword) new Password(s);
        // return (IPassword) new BugDoesNotTrim(s);
        // return (IPassword) new BugToShortPassword(s);
        // return (IPassword) new BugToShortPassword(s);
        // return (IPassword) new BugVeryShort(s);
        // return (IPassword) new BugWrongExceptionMessage(s);
        // return (IPassword) new BugMissingPasswordLengthCheck(s);
        // return (IPassword) new BugMissingNumberCheck(s);
        // return (IPassword) new BugIsPasswordSameAlwaysTrue(s);
        // return (IPassword) new BugWrongHashingAlgorithm(s);
         return (IPassword) new BugNew(s);
    }

    @Test //1
    public void shouldAlwaysPass() throws Exception {
        assertTrue(true);
    }

    @Test //2
    public void passwordShouldBeTrimmedForInputWithWhitespace() throws Exception {
        IPassword pw = getPassword("123456789101112");
        IPassword trimmedPW = getPassword("123456789101112    ");
        assertEquals(pw.getPasswordHash(), trimmedPW.getPasswordHash());
    }

    @Test //3
    public void isPasswordSameShouldReturnFalseForDifferentPassword() throws Exception {
        IPassword pw = getPassword("123456789101112");
        IPassword pw2 = getPassword("99999999999999999");
        assertFalse(pw.isPasswordSame(pw2));
    }

    @Test //4
    public void isPasswordSameShouldReturnTrueForSamePassword() throws Exception {
        IPassword pw = getPassword("Password123!");
        IPassword pw2 = getPassword("Password123!");
        assertTrue(pw.isPasswordSame(pw2));
    }

    @Test //5
    public void passwordConstructorShouldThrowExceptionForPasswordWithoutNumber() throws Exception {
        Exception e = assertThrows(Exception.class, () -> {
            getPassword("aaaaaaaaaaaaaaaaaaaa");
        });
        assertEquals(e.getMessage(), "Does not contain a number");
    }

    @Test //6
    public void passwordConstructorShouldThrowExceptionForTooShortPassword() throws Exception {
        Exception e = assertThrows(Exception.class, () -> {
            getPassword("12345678901");
        });
        assertEquals(e.getMessage(), "To short password");
    }

    @Test //7
    public void passwordConstructorShouldNotThrowExceptionForLongPassword() throws Exception {
        assertDoesNotThrow(() -> {
            getPassword("123456789012");
        });
    }

    @Test //8
    public void simpleHashShouldBeCorrectForPassword() throws Exception {
        IPassword pw = getPassword("Password123!");
        assertEquals(pw.getPasswordHash(), -1323532559);
    }
}
