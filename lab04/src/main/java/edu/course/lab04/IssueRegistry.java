package edu.course.lab04;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IssueRegistry {

    private final Map<IssueId, ProjectTask> tasks = new HashMap<>();

    public void add(IssueId id, ProjectTask task) {
        Objects.requireNonNull(id, "не может быть null");
        Objects.requireNonNull(task, "не может быть null");

        tasks.put(id, task);
    }

    public ProjectTask get(IssueId id) {
        Objects.requireNonNull(id, "не может быть null");

        return tasks.get(id);
    }

    public void remove(IssueId id) {
        Objects.requireNonNull(id, "не может быть null");

        tasks.remove(id);
    }

    public boolean contains(IssueId id) {
        Objects.requireNonNull(id, "не может быть null");

        return tasks.containsKey(id);
    }

    public int size() {
        return tasks.size();
    }
}