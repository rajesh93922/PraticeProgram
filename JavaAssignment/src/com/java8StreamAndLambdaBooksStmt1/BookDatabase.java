package com.java8StreamAndLambdaBooksStmt1;

import java.util.Arrays;
import java.util.List;

public class BookDatabase {

    public static List<Book> getBooks() {
        return Arrays.asList(
                new Book("Java Programming", "Computer Science", "John Doe", 10, 45.99),
                new Book("Python Basics", "Computer Science", "Jane Smith", 8, 39.95),
                new Book("Data Structures", "Computer Science", "John Doe", 5, 55.50),
                new Book("The Alchemist", "Fiction", "Paulo Coelho", 12, 25.00),
                new Book("Clean Code", "Software Engineering", "Robert C. Martin", 7, 49.99),
                new Book("Effective Java", "Software Engineering", "Joshua Bloch", 6, 59.99),
                new Book("The Hobbit", "Fantasy", "J.R.R. Tolkien", 9, 29.99)
        );
    }
}

