package edu.course.lab04;

import java.util.Objects;

public final class Book {

    private final String isbn;
    private final String title;

    public Book(String isbn, String title) {
        this.isbn = Objects.requireNonNull(isbn, "не может быть null");
        this.title = Objects.requireNonNull(title, "не может быть null");

        if (isbn.isBlank()) {
            throw new IllegalArgumentException("не может быть пустым");
        }

        if (title.isBlank()) {
            throw new IllegalArgumentException("не может быть пустым");
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Book)) {
            return false;
        }

        Book other = (Book) obj;
        return isbn.equals(other.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "Book{isbn='" + isbn + "', title='" + title + "'}";
    }
}