package edu.course.lab01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CourseToolkitTest {

    @Test
    void testIsEven() {
        assertTrue(CourseToolkit.isEven(4));
        assertTrue(CourseToolkit.isEven(-8));
        assertFalse(CourseToolkit.isEven(5));
    }

    @Test
    void testIsPrime() {
        // Числа меньше 2 и составные
        for (int n : new int[]{-10, 0, 1, 4, 49, 100}) {
            assertFalse(CourseToolkit.isPrime(n));
        }
        // Простые числа
        for (int n : new int[]{2, 3, 17, 31}) {
            assertTrue(CourseToolkit.isPrime(n));
        }
    }

    @Test
    void testIsPalindrome() {
        assertTrue(CourseToolkit.isPalindrome(""));
        assertTrue(CourseToolkit.isPalindrome("a"));
        assertTrue(CourseToolkit.isPalindrome("radar"));
        assertTrue(CourseToolkit.isPalindrome("шалаш"));

        assertFalse(CourseToolkit.isPalindrome("Radar"));
        assertFalse(CourseToolkit.isPalindrome("a ba"));

        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.isPalindrome(null));
    }

    @Test
    void testAverage() {
        int[] input = {1, 2, 3, 4};
        assertEquals(2.5, CourseToolkit.average(input), 1e-9);
        assertArrayEquals(new int[]{1, 2, 3, 4}, input); // массив не изменился

        assertEquals(-20.0, CourseToolkit.average(new int[]{-10, -20, -30}), 1e-9);

        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(null));
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(new int[]{}));
    }
}