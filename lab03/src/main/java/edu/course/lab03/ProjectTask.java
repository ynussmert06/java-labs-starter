package edu.course.lab03;

public class ProjectTask {

    private final String name;
    private final int effort;
    private final String status;

    public ProjectTask(String name, int effort, String status) {
        if (name == null || status == null) {
            throw new IllegalArgumentException("Name and status cannot be null");
        }

        if (effort < 0) {
            throw new IllegalArgumentException("Effort cannot be negative");
        }

        this.name = name;
        this.effort = effort;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public int getEffort() {
        return effort;
    }

    public String getStatus() {
        return status;
    }
}