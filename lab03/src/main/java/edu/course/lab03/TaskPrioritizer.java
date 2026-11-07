package edu.course.lab03;

public class TaskPrioritizer {

    private final PriorityPolicy priorityPolicy;

    public TaskPrioritizer(PriorityPolicy priorityPolicy) {
        if (priorityPolicy == null) {
            throw new IllegalArgumentException("Policy cannot be null");
        }

        this.priorityPolicy = priorityPolicy;
    }

    public ProjectTask chooseMoreImportant(ProjectTask first, ProjectTask second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Tasks cannot be null");
        }

        int firstPriority = priorityPolicy.calculatePriority(first);
        int secondPriority = priorityPolicy.calculatePriority(second);

        if (firstPriority >= secondPriority) {
            return first;
        }

        return second;
    }
}