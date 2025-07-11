package com.java8StreamAndLambdaBooksStmt1;

import java.util.List;
import java.util.Map;

public class BookStreamAndLambda {

    public static void main(String[] args) {
        // 1.	PROBLEM STATEMENT
        List<Book> bookList = BookDatabase.getBooks();

        Map<String, List<Book>> grouped = BookUtility.retrieveBooksGroupedByGenre(bookList.stream());
        grouped.forEach((genre, books) -> {
            System.out.println(genre);
            books.forEach(book ->
                    System.out.println(book.getTitle() + " "
                            + book.getQuantity() + " "
                            + book.getAuthor() + " "
                            + book.getPrice()));
        });

        Map<String, Double> authorsPrices  =  BookUtility.getAuthorsAndPricesByTitle(bookList.stream(), "Python Basics");
        authorsPrices.forEach((author, price) -> System.out.println(author + " authoPrices " + price));

           BookUtility.generateSummaryReport(bookList).forEach(System.out::println);

    }
}
