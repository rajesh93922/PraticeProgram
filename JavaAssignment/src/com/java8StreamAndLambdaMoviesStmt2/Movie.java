package com.java8StreamAndLambdaMoviesStmt2;

public class Movie {
    private String title;
    private String genre;
    private String director;
    private int quantityAvailable;
    private double rentalPrice;

    public Movie() {}

    public Movie(String title, String genre, String director, int quantityAvailable, double rentalPrice) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.quantityAvailable = quantityAvailable;
        this.rentalPrice = rentalPrice;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public String getDirector() { return director; }
    public int getQuantityAvailable() { return quantityAvailable; }
    public double getRentalPrice() { return rentalPrice; }

    public void setTitle(String title) { this.title = title; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setDirector(String director) { this.director = director; }
    public void setQuantityAvailable(int quantityAvailable) { this.quantityAvailable = quantityAvailable; }
    public void setRentalPrice(double rentalPrice) { this.rentalPrice = rentalPrice; }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", quantityAvailable=" + quantityAvailable +
                ", rentalPrice=" + rentalPrice +
                '}';
    }
}

