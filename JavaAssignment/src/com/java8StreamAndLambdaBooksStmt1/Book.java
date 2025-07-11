package com.java8StreamAndLambdaBooksStmt1;

public class Book {
    private String title;
    private String genre;
    private String author;
    private int quantity;
    private double price;

    // Constructors
    public Book() {}

    public Book(String title, String genre, String author, int quantity, double price) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.quantity = quantity;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

