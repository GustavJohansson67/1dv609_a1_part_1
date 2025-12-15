package com.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class SwedishSocialSecurityNumberTest {
    
    private SSNHelper helper;
    //private BuggySSNHelperAllowDayUpTo30 helper;
    //private BuggySSNHelperAllowMonth0 helper;
    //private BuggySSNHelperIncorrectFormat helper;
    //private BuggySSNHelperIncorrectFormatFalse helper;
    //private BuggySSNHelperMessyLuhn helper;
    //private BuggySSNHelperWrongLength helper;
    
    @BeforeEach
    public void setUp() {
        helper = new SSNHelper();
        //helper = new BuggySSNHelperAllowDayUpTo30();
        //helper = new BuggySSNHelperAllowMonth0();
        //helper = new BuggySSNHelperIncorrectFormat();
        //helper = new BuggySSNHelperIncorrectFormatFalse();
        //helper = new BuggySSNHelperMessyLuhn();
        //helper = new BuggySSNHelperWrongLength();
    }

    @Test
    public void isValidDayShouldReturnTrueForDayInput31() throws Exception {
        assertTrue(helper.isValidDay("31"));
    }

    @Test
    public void isValidDayShouldReturnFalseForDayInput32() throws Exception {
        assertFalse(helper.isValidDay("32"));
    }

    @Test
    public void isValidDayShouldReturnFalseForDayInput0() throws Exception {
        assertFalse(helper.isValidDay("00"));
    }

    @Test
    public void isValidMonthShourdReturnFalseForMounthInput0() throws Exception {
        assertFalse(helper.isValidMonth("00"));
    }

    @Test
    public void isValidMonthShourdReturnTrueForMounthInput1() throws Exception {
        assertTrue(helper.isValidMonth("01"));
    }

    @Test
    public void isValidMonthShourdReturnFalseForMounthInput13() throws Exception {
        assertFalse(helper.isValidMonth("13"));
    }

    @Test
    public void isCorrectFormatShouldReturnFalseForWrongFormat() throws Exception {
        assertFalse(helper.isCorrectFormat("0408181111"));
    }

    @Test
    public void isCorrectFormatShouldReturnTrueForCorrectFormat() throws Exception {
        assertTrue(helper.isCorrectFormat("040818-1111"));
    }

    @Test
    public void luhnIsCorrectShouldReturnTrueForKnownTrueValue() throws Exception {
        assertTrue(helper.luhnIsCorrect("900101-0017"));
    }

    @Test
    public void luhnIsCorrectShouldReturnFalseForKnownFalseValue() throws Exception {
        assertFalse(helper.luhnIsCorrect("900101-0011"));
    }

    @Test
    public void isCorrectLengthShouldReturnFalseForLongInput() throws Exception {
        assertFalse(helper.isCorrectLength("900101-00170"));
    }

    @Test
    public void isCorrectLengthShouldReturnTrueForValidInput() throws Exception {
        assertTrue(helper.isCorrectLength("900101-0017"));
    }
}