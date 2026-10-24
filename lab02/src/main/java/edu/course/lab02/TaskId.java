
package edu.course.lab02;

public final class TaskId {

    private final String value;

    public TaskId(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "Идентификатор не может быть пустым"
            );
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof TaskId)) {
            return false;
        }

        TaskId other = (TaskId) object;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }
}
