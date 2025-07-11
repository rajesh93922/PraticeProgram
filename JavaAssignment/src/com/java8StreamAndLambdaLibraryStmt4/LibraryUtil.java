package com.java8StreamAndLambdaLibraryStmt4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibraryUtil {

        public Book retrieveBookDetailsById(Stream<Book> bookStream, String bookId) {
            return bookStream
                    .filter(book -> book.getBookId().equals(bookId))
                    .findFirst()
                    .orElse(null);
        }

        public List<Book> retrieveBooksByGenre(Stream<Book> bookStream, String genre) {
            return bookStream
                    .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                    .collect(Collectors.toList());
        }

        public List<String> retrieveBookIdsInPriceRange(Stream<Book> bookStream, double minPrice, double maxPrice) {
            return bookStream
                    .filter(book -> book.getPrice() >= minPrice && book.getPrice() <= maxPrice)
                    .map(Book::getBookId)
                    .collect(Collectors.toList());
        }
    }


