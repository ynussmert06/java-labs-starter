package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseToolkitTest {
    //isEven
    @Test
    void rtnTrueIsEven() {
        boolean result = CourseToolkit.isEven(6);

        assertTrue(result);
    }

    @Test
    void rtnFalseIsEven() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }

    @Test
    void rtnNeggativeIsEven() {
        boolean result = CourseToolkit.isEven(-6);

        assertTrue(result);
    }
    //isPrime
    @Test
    void isPrimeTrue() {
        assertTrue(CourseToolkit.isPrime(3));
    }

    @Test
    void isPrimeeTrue() {
        assertTrue(CourseToolkit.isPrime(5));
    }
    @Test
        void isPrimeeeTrue() {
    assertTrue(CourseToolkit.isPrime(7));
    }
    @Test
        void isPrimefalse() {
    assertFalse(CourseToolkit.isPrime(8));
    }
    @Test
        void isPrimeefalse() {
    assertFalse(CourseToolkit.isPrime(10));
    }
    //is Palindrome
    @Test
    void isPalindrome() {
        boolean result1 = CourseToolkit.isPalindrome("а роза упала на лапу азора ");
        boolean result2 = CourseToolkit.isPalindrome("арозаупаланалапуазора");
        boolean result3 = CourseToolkit.isPalindrome("232");

        assertFalse(result1);
        assertTrue(result2);
        assertTrue(result3);
    }
    //average
    @Test
    void average() {
        double result1 = CourseToolkit.average(new int[] {1, 2, 3});
        int[] result2 = new int[0];
        double result3 = CourseToolkit.average(new int[] {-3, -3});

        assertEquals(2.0, result1);
        assertThrows(IllegalArgumentException.class, () -> {
            CourseToolkit.average(result2);
        });
        assertEquals(-3.0, result3);
    }
}