package com.java8StreamAndLambdaMoviesStmt2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MovieDatabase {
    public static List<Movie> getMovies() {
        return Arrays.asList(
                new Movie("Inception", "Sci-Fi", "Christopher Nolan", 10, 3.99),
                new Movie("The Matrix", "Sci-Fi", "Lana Wachowski", 8, 2.99),
                new Movie("The Dark Knight", "Action", "Christopher Nolan", 5, 4.99),
                new Movie("Joker", "Drama", "Todd Phillips", 6, 3.49),
                new Movie("Interstellar", "Sci-Fi", "Christopher Nolan", 7, 3.79)
        );
    }

    public static List<Rental> getRentals() {
        return Arrays.asList(
                new Rental("Alice", "Inception", LocalDate.of(2025, 6, 20), 3),
                new Rental("Bob", "Joker", LocalDate.of(2025, 6, 21), 2),
                new Rental("Charlie", "Interstellar", LocalDate.of(2025, 6, 22), 4)
        );
    }
}

