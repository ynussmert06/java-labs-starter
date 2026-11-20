package edu.course.lab04;

import java.util.Objects;

public final class ProjectTask {

    private final String title;

    public ProjectTask(String title) {
        this.title = Objects.requireNonNull(title, "не может быть null");

        if (title.isBlank()) {
            throw new IllegalArgumentException("не может быть пустым");
        }
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "ProjectTask{title='" + title + "'}";
    }
}