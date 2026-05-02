package com.java8StreamAndLambdaLibraryStmt4;

import com.java8StreamAndLambdaBooksStmt1.BookUtility;

import java.util.List;
import java.util.Scanner;

public class LibraryStream {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            List<Book> books = BookDatabase.getBooks();
            LibraryUtil util = new LibraryUtil();

            // Retrieve by Book ID
            System.out.print("Enter the Book ID to retrieve details: ");
            String bookId = scanner.nextLine();
            Book book = util.retrieveBookDetailsById(books.stream(), bookId);
            if (book != null) {
                System.out.println(book.getBookId() + " " + book.getTitle() + " " + book.getAuthor() + " " +
                        book.getGenre() + " " + book.getPrice() + " " + book.isAvailable());
            } else {
                System.out.println("Book not found.");
            }

            // Retrieve by Genre
            System.out.print("\nEnter the Genre to retrieve details: ");
            String genre = scanner.nextLine();
            List<Book> genreBooks = util.retrieveBooksByGenre(books.stream(), genre);
            if (!genreBooks.isEmpty()) {
                for (Book b : genreBooks) {
                    System.out.println(b.getBookId() + " " + b.getTitle() + " " + b.getAuthor() + " " +
                            b.getGenre() + " " + b.getPrice() + " " + b.isAvailable());
                }
            } else {
                System.out.println("No books found for the given genre.");
            }

            // Retrieve by Price Range
            System.out.print("\nEnter the minimum and maximum price range to show book IDs: ");
            double minPrice = scanner.nextDouble();
            double maxPrice = scanner.nextDouble();
            List<String> ids = util.retrieveBookIdsInPriceRange(books.stream(), minPrice, maxPrice);
            if (!ids.isEmpty()) {
                System.out.println("Book IDs within the price range are:");
                ids.forEach(System.out::println);
            } else {
                System.out.println("No books found in the given price range.");
            }

            scanner.close();
        }
    }
