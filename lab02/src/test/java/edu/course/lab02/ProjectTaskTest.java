
package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTaskTest {

    @Test
    void shouldCreateValidTask() {
        ProjectTask task = new ProjectTask(
                "TASK-1",
                "Создать приложение",
                TaskStatus.TODO,
                10
        );

        assertEquals("TASK-1", task.getId());
        assertEquals("Создать приложение", task.getTitle());
        assertEquals(TaskStatus.TODO, task.getStatus());
        assertEquals(10, task.getEstimatedHours());
        assertFalse(task.isCompleted());
    }

    @Test
    void shouldRejectNullOrBlankId() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ProjectTask(
                        null, "Задача", TaskStatus.TODO, 1
                )
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new ProjectTask(
                        " ", "Задача", TaskStatus.TODO, 1
                )
        );
    }

    @Test
    void shouldRejectNullOrBlankTitle() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ProjectTask(
                        "TASK-1", null, TaskStatus.TODO, 1
                )
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new ProjectTask(
                        "TASK-1", "  ", TaskStatus.TODO, 1
                )
        );
    }

    @Test
    void shouldRejectNullStatus() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ProjectTask(
                        "TASK-1", "Задача", null, 1
                )
        );
    }

    @Test
    void shouldRejectNegativeEstimatedHours() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ProjectTask(
                        "TASK-1", "Задача", TaskStatus.TODO, -1
                )
        );
    }

    @Test
    void shouldChangeStatus() {
        ProjectTask task = new ProjectTask(
                "TASK-1",
                "Создать приложение",
                TaskStatus.TODO,
                10
        );

        task.changeStatus(TaskStatus.IN_PROGRESS);

        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
    }

    @Test
    void shouldRejectNullNewStatus() {
        ProjectTask task = new ProjectTask(
                "TASK-1", "Задача", TaskStatus.TODO, 1
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> task.changeStatus(null)
        );

        assertEquals(TaskStatus.TODO, task.getStatus());
    }

    @Test
    void shouldDetectCompletedTask() {
        ProjectTask task = new ProjectTask(
                "TASK-1", "Задача", TaskStatus.TODO, 1
        );

        assertFalse(task.isCompleted());

        task.changeStatus(TaskStatus.DONE);

        assertTrue(task.isCompleted());
    }

    @Test
    void shouldIncreaseEstimatedHours() {
        ProjectTask task = new ProjectTask(
                "TASK-1", "Задача", TaskStatus.TODO, 5
        );

        task.increaseEstimatedHours(3);

        assertEquals(8, task.getEstimatedHours());
    }

    @Test
    void shouldRejectNonPositiveHours() {
        ProjectTask task = new ProjectTask(
                "TASK-1", "Задача", TaskStatus.TODO, 5
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> task.increaseEstimatedHours(0)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> task.increaseEstimatedHours(-2)
        );

        assertEquals(5, task.getEstimatedHours());
    }

    @Test
    void shouldRejectEstimatedHoursOverflow() {
        ProjectTask task = new ProjectTask(
                "TASK-1",
                "Задача",
                TaskStatus.TODO,
                Integer.MAX_VALUE
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> task.increaseEstimatedHours(1)
        );

        assertEquals(Integer.MAX_VALUE, task.getEstimatedHours());
    }
}
