package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityPolicyTest {

    @Test
    void effortPolicyChoosesTaskWithHigherEffort() {
        PriorityPolicy policy = new EffortPriorityPolicy();

        ProjectTask first = new ProjectTask("Task 1", 10, "NEW");
        ProjectTask second = new ProjectTask("Task 2", 50, "NEW");

        assertEquals(50, policy.calculatePriority(second));

        TaskPrioritizer prioritizer = new TaskPrioritizer(policy);

        assertSame(second, prioritizer.chooseMoreImportant(first, second));
    }

    @Test
    void effortPolicyWorksWithEqualEffort() {
        PriorityPolicy policy = new EffortPriorityPolicy();

        ProjectTask first = new ProjectTask("Task 1", 20, "NEW");
        ProjectTask second = new ProjectTask("Task 2", 20, "DONE");

        TaskPrioritizer prioritizer = new TaskPrioritizer(policy);

        assertSame(first, prioritizer.chooseMoreImportant(first, second));
    }

    @Test
    void statusPolicyPrioritizesUrgentTasks() {
        PriorityPolicy policy = new StatusPriorityPolicy();

        ProjectTask first = new ProjectTask("Task 1", 100, "NEW");
        ProjectTask second = new ProjectTask("Task 2", 10, "URGENT");

        assertEquals(4, policy.calculatePriority(second));

        TaskPrioritizer prioritizer = new TaskPrioritizer(policy);

        assertSame(second, prioritizer.chooseMoreImportant(first, second));
    }

    @Test
    void statusPolicyPrioritizesInProgressTasks() {
        PriorityPolicy policy = new StatusPriorityPolicy();

        ProjectTask task = new ProjectTask("Task", 10, "IN_PROGRESS");

        assertEquals(3, policy.calculatePriority(task));
    }

    @Test
    void differentPoliciesCanBeUsedWithoutChangingPrioritizer() {
        ProjectTask first = new ProjectTask("Task 1", 100, "NEW");
        ProjectTask second = new ProjectTask("Task 2", 10, "URGENT");

        TaskPrioritizer prioritizer =
                new TaskPrioritizer(new EffortPriorityPolicy());

        assertSame(first, prioritizer.chooseMoreImportant(first, second));

        prioritizer =
                new TaskPrioritizer(new StatusPriorityPolicy());

        assertSame(second, prioritizer.chooseMoreImportant(first, second));
    }
}