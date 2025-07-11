package com.java8StreamAndLambdaMoviesStmt2;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class MovieStreamAndLambda {
    public static void main(String[] args) {
        List<Movie> movieList = MovieDatabase.getMovies();
        List<Rental> rentalList = MovieDatabase.getRentals();
        MoviesUtility moviesUtility = new MoviesUtility();

        Map<String, List<Movie>> groupeddMovies = MoviesUtility.retrieveMoviesGroupedByGenre(movieList.stream());

        groupeddMovies.forEach((genre, movie) -> {
            System.out.println(genre);
            movie.forEach(moviesList -> {
                System.out.println(moviesList.getTitle() + "  "
                        + moviesList.getQuantityAvailable() + " "
                        + moviesList.getDirector() + " "
                        + moviesList.getRentalPrice() );
            });
        });

        Map<String, Double>rentalMovieSpecfictitle = MoviesUtility.getDirectorsAndPricesByTitle(movieList.stream(),"Joker");
       // System.out.println(rentalMovieSpecfictitle);

        int daysLate =2;
        double totalFees= RentalUtility.calculateLateFees(rentalList,daysLate);
        System.out.println(totalFees);

        Stream<String> genSummaryReport = MoviesUtility.generateSummaryReport(movieList);
       //genSummaryReport.forEach(System.out::println);

       List<Movie> searchedMoviesByDirector = MoviesUtility.searchMoviesByDirector(movieList.stream(),"Christopher Nolan");
       // System.out.println(searchedMoviesByDirector);

        boolean ascendingOrder = true ;
        List<Movie> sortedMoviesByPrice = MoviesUtility.sortMoviesByPrice(movieList, ascendingOrder);
       // System.out.println(sortedMoviesByPrice);

    }
}
