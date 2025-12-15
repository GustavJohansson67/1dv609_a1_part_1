package com.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Example tests demonstrating how to use mocks with the SSN classes.
 * 
 * To use Mockito, add to build.gradle:
 * testImplementation 'org.mockito:mockito-core:5.+'
 * testImplementation 'org.mockito:mockito-junit-jupiter:5.+'
 */
public class MockExampleTest {
    
    private SSNHelper mockHelper;
    
    @BeforeEach
    public void setUp() {
        mockHelper = mock(SSNHelper.class);
    }
    
    @Test
    public void shouldCreateValidSSNWhenAllChecksPass() throws Exception {
        when(mockHelper.isCorrectLength("900101-0017")).thenReturn(true);
        when(mockHelper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(mockHelper.isValidMonth("01")).thenReturn(true);
        when(mockHelper.isValidDay("01")).thenReturn(true);
        when(mockHelper.luhnIsCorrect("900101-0017")).thenReturn(true);
        
        SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber("900101-0017", mockHelper);
        
        // Assert: Verify the SSN was created and methods work
        assertEquals("90", ssn.getYear());
        assertEquals("01", ssn.getMonth());
        assertEquals("01", ssn.getDay());
        assertEquals("0017", ssn.getSerialNumber());
        
        // Verify that the mock methods were called
        verify(mockHelper).isCorrectLength("900101-0017");
        verify(mockHelper).isCorrectFormat("900101-0017");
        verify(mockHelper).isValidMonth("01");
        verify(mockHelper).isValidDay("01");
        verify(mockHelper).luhnIsCorrect("900101-0017");
    }

    private SwedishSocialSecurityNumber getSSN(String ssn) throws Exception {return new SwedishSocialSecurityNumber(ssn, mockHelper);}
    //private BuggySwedishSocialSecurityNumberNoLenCheck getSSN(String ssn) throws Exception {return new BuggySwedishSocialSecurityNumberNoLenCheck(ssn, mockHelper);}
    //private BuggySwedishSocialSecurityNumberNoLuhn getSSN(String ssn) throws Exception {return new BuggySwedishSocialSecurityNumberNoLuhn(ssn, mockHelper);}
    //private BuggySwedishSocialSecurityNumberNoTrim getSSN(String ssn) throws Exception {return new BuggySwedishSocialSecurityNumberNoTrim(ssn, mockHelper);}
    //private BuggySwedishSocialSecurityNumberWrongYear getSSN(String ssn) throws Exception {return new BuggySwedishSocialSecurityNumberWrongYear(ssn, mockHelper);}

    @Test
    public void constructorShouldThrowExceptionForInvalidLength() throws Exception {
        when(mockHelper.isCorrectLength("900101-001")).thenReturn(false);
        when(mockHelper.isCorrectFormat("900101-001")).thenReturn(true);
        when(mockHelper.isValidMonth("01")).thenReturn(true);
        when(mockHelper.isValidDay("01")).thenReturn(true);
        when(mockHelper.luhnIsCorrect("900101-001")).thenReturn(true);

        Exception e = assertThrows(Exception.class, () -> {
            getSSN("900101-001");
        });
        assertEquals(e.getMessage(), "To short, must be 11 characters");
    }

    @Test
    public void constructorShouldThrowExceptionForInvalidLuhn() throws Exception {
        when(mockHelper.isCorrectLength("900101-0011")).thenReturn(true);
        when(mockHelper.isCorrectFormat("900101-0011")).thenReturn(true);
        when(mockHelper.isValidMonth("01")).thenReturn(true);
        when(mockHelper.isValidDay("01")).thenReturn(true);
        when(mockHelper.luhnIsCorrect("900101-0011")).thenReturn(false);

        Exception e = assertThrows(Exception.class, () -> {
            getSSN("900101-0011");
        });
        assertEquals(e.getMessage(), "Invalid SSN according to Luhn's algorithm");
    }

    @Test
    public void constructorShouldThrowExceptionForInvalidFormat() throws Exception {
        when(mockHelper.isCorrectLength("90010100177")).thenReturn(true);
        when(mockHelper.isCorrectFormat("90010100177")).thenReturn(false);
        when(mockHelper.isValidMonth("01")).thenReturn(true);
        when(mockHelper.isValidDay("01")).thenReturn(true);
        when(mockHelper.luhnIsCorrect("90010100177")).thenReturn(true);

        Exception e = assertThrows(Exception.class, () -> {
            getSSN("90010100177");
        });
        assertEquals(e.getMessage(), "Incorrect format, must be: YYMMDD-XXXX");
    }

    @Test
    public void constructorShouldThrowExceptionForInvalidMounth() throws Exception {
        when(mockHelper.isCorrectLength("901301-0017")).thenReturn(true);
        when(mockHelper.isCorrectFormat("901301-0017")).thenReturn(true);
        when(mockHelper.isValidMonth("13")).thenReturn(false);
        when(mockHelper.isValidDay("01")).thenReturn(true);
        when(mockHelper.luhnIsCorrect("901301-0017")).thenReturn(true);

        Exception e = assertThrows(Exception.class, () -> {
            getSSN("901301-0017");
        });
        assertEquals(e.getMessage(), "Invalid month in SSN");
    }

    @Test
    public void constructorShouldThrowExceptionForInvalidDay() throws Exception {
        when(mockHelper.isCorrectLength("900100-0017")).thenReturn(true);
        when(mockHelper.isCorrectFormat("900100-0017")).thenReturn(true);
        when(mockHelper.isValidMonth("01")).thenReturn(true);
        when(mockHelper.isValidDay("00")).thenReturn(false);
        when(mockHelper.luhnIsCorrect("900100-0017")).thenReturn(true);

        Exception e = assertThrows(Exception.class, () -> {
            getSSN("900100-0017");
        });
        assertEquals(e.getMessage(), "Invalid day in SSN");
    }

    @Test
    public void constructorShouldTrimForInputWithSpaces() throws Exception {
        when(mockHelper.isCorrectLength("900101-0017")).thenReturn(true);
        when(mockHelper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(mockHelper.isValidMonth("01")).thenReturn(true);
        when(mockHelper.isValidDay("01")).thenReturn(true);
        when(mockHelper.luhnIsCorrect("900101-0017")).thenReturn(true);

        assertDoesNotThrow(() -> {
            getSSN("900101-0017     ");
        });
    }

    @Test
    public void getYearShouldReturnFirst2Numbers() throws Exception {
        when(mockHelper.isCorrectLength("900101-0017")).thenReturn(true);
        when(mockHelper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(mockHelper.isValidMonth("01")).thenReturn(true);
        when(mockHelper.isValidDay("01")).thenReturn(true);
        when(mockHelper.luhnIsCorrect("900101-0017")).thenReturn(true);

        assertEquals(getSSN("900101-0017").getYear(), "90");
    }

    @Test
    public void getSSNShouldReturnAllOfSSN() throws Exception {
        when(mockHelper.isCorrectLength("900101-0017")).thenReturn(true);
        when(mockHelper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(mockHelper.isValidMonth("01")).thenReturn(true);
        when(mockHelper.isValidDay("01")).thenReturn(true);
        when(mockHelper.luhnIsCorrect("900101-0017")).thenReturn(true);

        assertEquals(getSSN("900101-0017").getSSN(), "900101-0017");
    }
}