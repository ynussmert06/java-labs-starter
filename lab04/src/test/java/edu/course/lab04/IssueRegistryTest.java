package edu.course.lab04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IssueRegistryTest {

    @Test
    void differentInstancesOfEqualIdFindSameValue() {
        IssueRegistry registry = new IssueRegistry();

        IssueId firstId = new IssueId("JAVA", 10);
        IssueId secondId = new IssueId("JAVA", 10);

        ProjectTask task = new ProjectTask("Implement login");

        registry.add(firstId, task);

        assertEquals(task, registry.get(secondId));
    }

    @Test
    void addingEqualKeyReplacesValueWithoutIncreasingSize() {
        IssueRegistry registry = new IssueRegistry();

        IssueId firstId = new IssueId("JAVA", 10);
        IssueId secondId = new IssueId("JAVA", 10);

        ProjectTask firstTask = new ProjectTask("Create login");
        ProjectTask secondTask = new ProjectTask("Fix login");

        registry.add(firstId, firstTask);
        registry.add(secondId, secondTask);

        assertEquals(1, registry.size());
        assertEquals(secondTask, registry.get(firstId));
    }

    @Test
    void operationsAddGetRemoveContainsAndSizeWork() {
        IssueRegistry registry = new IssueRegistry();

        IssueId id = new IssueId("JAVA", 20);
        ProjectTask task = new ProjectTask("Write tests");

        assertEquals(0, registry.size());
        assertFalse(registry.contains(id));

        registry.add(id, task);

        assertTrue(registry.contains(id));
        assertEquals(task, registry.get(id));
        assertEquals(1, registry.size());

        registry.remove(id);

        assertFalse(registry.contains(id));
        assertNull(registry.get(id));
        assertEquals(0, registry.size());
    }

    @Test
    void collidingKeysKeepDifferentValues() {
        IssueRegistry registry = new IssueRegistry();

        IssueId firstId = new IssueId("Aa", 1);
        IssueId secondId = new IssueId("BB", 1);

        ProjectTask firstTask = new ProjectTask("First task");
        ProjectTask secondTask = new ProjectTask("Second task");

        assertNotEquals(firstId, secondId);
        assertEquals(firstId.hashCode(), secondId.hashCode());

        registry.add(firstId, firstTask);
        registry.add(secondId, secondTask);

        assertEquals(2, registry.size());
        assertEquals(firstTask, registry.get(firstId));
        assertEquals(secondTask, registry.get(secondId));
    }
}