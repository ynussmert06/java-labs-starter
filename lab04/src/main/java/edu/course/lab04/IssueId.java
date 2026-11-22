package edu.course.lab04;

import java.util.Objects;

public final class IssueId {

    private final String projectCode;
    private final int number;

    public IssueId(String projectCode, int number) {
        this.projectCode = Objects.requireNonNull(
                projectCode, "Не может быть null"
        );

        if (projectCode.isBlank()) {
            throw new IllegalArgumentException("Не может быть пустым");
        }

        if (number <= 0) {
            throw new IllegalArgumentException("ток положительные");
        }

        this.number = number;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof IssueId)) {
            return false;
        }

        IssueId other = (IssueId) obj;

        return number == other.number
                && projectCode.equals(other.projectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectCode, number);
    }

    @Override
    public String toString() {
        return "IssueId{projectCode='" + projectCode
                + "', number=" + number + "}";
    }
}