
package edu.course.lab02;

public class ProjectTask {

    private final String id;
    private final String title;
    private TaskStatus status;
    private int estimatedHours;

    public ProjectTask(
            String id,
            String title,
            TaskStatus status,
            int estimatedHours
    ) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException(
                    "Идентификатор не может быть пустым"
            );
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(
                    "Название задачи не может быть пустым"
            );
        }

        if (status == null) {
            throw new IllegalArgumentException(
                    "Статус не может быть null"
            );
        }

        if (estimatedHours < 0) {
            throw new IllegalArgumentException(
                    "Трудоемкость не может быть отрицательной"
            );
        }

        this.id = id;
        this.title = title;
        this.status = status;
        this.estimatedHours = estimatedHours;
    }

    public void changeStatus(TaskStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException(
                    "Новый статус не может быть null"
            );
        }

        this.status = newStatus;
    }

    public boolean isCompleted() {
        return status == TaskStatus.DONE;
    }

    public void increaseEstimatedHours(int hours) {
        if (hours <= 0) {
            throw new IllegalArgumentException(
                    "Количество часов должно быть положительным"
            );
        }

        if (estimatedHours > Integer.MAX_VALUE - hours) {
            throw new IllegalArgumentException(
                    "Превышена допустимая трудоемкость"
            );
        }

        estimatedHours += hours;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }
}
