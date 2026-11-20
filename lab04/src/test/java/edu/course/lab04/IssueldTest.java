package edu.course.lab04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IssueIdTest {

    @Test
    void equalIdsHaveSameHashCode() {
        IssueId first = new IssueId("JAVA", 10);
        IssueId second = new IssueId("JAVA", 10);

        assertNotSame(first, second);
        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    void idsWithDifferentFieldsAreNotEqual() {
        IssueId first = new IssueId("JAVA", 10);
        IssueId second = new IssueId("JAVA", 11);
        IssueId third = new IssueId("WEB", 10);

        assertNotEquals(first, second);
        assertNotEquals(first, third);
    }

    @Test
    void comparisonWithNullAndAnotherTypeReturnsFalse() {
        IssueId id = new IssueId("JAVA", 10);

        assertFalse(id.equals(null));
        assertFalse(id.equals("JAVA-10"));
    }
}