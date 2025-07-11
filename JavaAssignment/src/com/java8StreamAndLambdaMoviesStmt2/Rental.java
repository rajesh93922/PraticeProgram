package com.java8StreamAndLambdaMoviesStmt2;

import java.time.LocalDate;

public class Rental {
    private String customerName;
    private String movieTitle;
    private LocalDate rentalDate;
    private int daysRented;

    public Rental() {}

    public Rental(String customerName, String movieTitle, LocalDate rentalDate, int daysRented) {
        this.customerName = customerName;
        this.movieTitle = movieTitle;
        this.rentalDate = rentalDate;
        this.daysRented = daysRented;
    }

    // Getters and Setters
    public String getCustomerName() { return customerName; }
    public String getMovieTitle() { return movieTitle; }
    public LocalDate getRentalDate() { return rentalDate; }
    public int getDaysRented() { return daysRented; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setMovieTitle(String movieTitle) { this.movieTitle = movieTitle; }
    public void setRentalDate(LocalDate rentalDate) { this.rentalDate = rentalDate; }
    public void setDaysRented(int daysRented) { this.daysRented = daysRented; }
}

