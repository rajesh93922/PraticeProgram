package com.java8StreamAndLambdaLibraryStmt4;

import java.util.Arrays;
import java.util.List;

public class BookDatabase {
    public static List<Book> getBooks() {
        return Arrays.asList(
                new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 12.99, true),
                new Book("B002", "Algorithms Unlocked", "Thomas Cormen", "Computer Science", 34.50, true),
                new Book("B003", "Java Programming", "John Doe", "Computer Science", 45.00, true),
                new Book("B004", "Pride and Prejudice", "Jane Austen", "Fiction", 9.99, true)
        );
    }
}
