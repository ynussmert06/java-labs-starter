package edu.course.lab04;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void booksWithSameIsbnFindSameValueInHashMap() {
        Book first = new Book("978-5-17-123456-7", "Java Basics");
        Book second = new Book("978-5-17-123456-7", "Java Programming");

        Map<Book, String> books = new HashMap<>();
        books.put(first, "Книга найдена");

        assertEquals("Книга найдена", books.get(second));
    }

    @Test
    void booksWithDifferentIsbnAreNotEqual() {
        Book first = new Book("978-5-17-123456-7", "Java Basics");
        Book second = new Book("978-5-17-765432-1", "Java Basics");

        assertNotEquals(first, second);
    }
}