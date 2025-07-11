package com.java8StreamAndLambdaMoviesStmt2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoviesUtility {

    public static Map<String, List<Movie>> retrieveMoviesGroupedByGenre(Stream<Movie> movies) {
        return movies.collect(Collectors.groupingBy(Movie::getGenre));
    }

    public static   Map<String, Double> getDirectorsAndPricesByTitle(Stream<Movie> movieStream, String title) {
        return movieStream.filter(movie -> movie.getTitle().equalsIgnoreCase(title)).collect(Collectors.toMap(Movie::getDirector,Movie::getRentalPrice));
    }


        public static Stream<String> generateSummaryReport(List<Movie> movies) {
            // Total number of movies
            long totalMovies = movies.size();

            // Total revenue = sum of (rentalPrice * quantityAvailable) for each movie
            double totalRevenue = movies.stream()
                    .mapToDouble(movie -> movie.getRentalPrice() * movie.getQuantityAvailable())
                    .sum();

            // Average rental price
            double averagePrice = movies.stream()
                    .mapToDouble(Movie::getRentalPrice)
                    .average()
                    .orElse(0.0); // fallback if list is empty

            // Return a stream of formatted summary strings
            return Stream.of(
                    "Total movies: " + totalMovies,
                    "Total revenue: " + String.format("%.2f", totalRevenue),
                    "Average price: " + String.format("%.2f", averagePrice)
            );
        }

    public static List<Movie> searchMoviesByDirector(Stream<Movie> movieStream, String christopherNolan) {

        return movieStream.filter(movie -> movie.getDirector().equalsIgnoreCase(christopherNolan)).collect(Collectors.toList());
    }

    public static List<Movie> sortMoviesByPrice(List<Movie> movieList, boolean ascendingOrder) {

        if(ascendingOrder) {
            return movieList.stream().sorted(Comparator.comparingDouble(Movie::getRentalPrice))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}


