package com.java8StreamAndLambdaBooksStmt1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookUtility {

    public static Map<String, List<Book>> retrieveBooksGroupedByGenre(Stream<Book> stream) {
        return stream.collect(Collectors.groupingBy(Book::getGenre));
    }

    public static Map<String, Double> getAuthorsAndPricesByTitle(Stream<Book> stream, String pythonBasics) {
        return stream.filter(book -> book.getTitle().equals(pythonBasics))
                .collect(Collectors.toMap(Book::getAuthor, Book::getPrice));
    }


    public static Stream<String> generateSummaryReport(List<Book> bookList) {
        long totalBooks = bookList.size();
        double totalPrice = bookList.stream().mapToDouble(Book::getPrice).sum();
        int totalQuantity = bookList.stream().mapToInt(Book::getQuantity).sum();

        return Stream.of(
                "Total books: " + totalBooks,
                "Total price: " + totalPrice,
                "Total quantity: " + totalQuantity
        );
    }


}
