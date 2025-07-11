package com.javaassignment.collectionsassignment.model;

public class Caffeine {
    private String coffeeBrand;
    private Float caffeinePercentage;

    public Caffeine(){}

    public Caffeine(String coffeeBrand, Float caffeinePercentage) {
        this.coffeeBrand = coffeeBrand;
        this.caffeinePercentage = caffeinePercentage;
    }

    public String getCoffeeBrand() {
        return coffeeBrand;
    }

    public void setCoffeeBrand(String coffeeBrand) {
        this.coffeeBrand = coffeeBrand;
    }

    public Float getCaffeinePercentage() {
        return caffeinePercentage;
    }

    public void setCaffeinePercentage(Float caffeinePercentage) {
        this.caffeinePercentage = caffeinePercentage;
    }

    @Override
    public String toString() {
        return "Caffeine{" +
                "coffeeBrand='" + coffeeBrand + '\'' +
                ", caffeinePercentage=" + caffeinePercentage +
                '}';
    }


}
