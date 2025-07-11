package com.javaassignment.collectionsassignment.model;

import java.util.Comparator;

public class Sorting implements Comparator<Caffeine> {
    @Override
    public int compare(Caffeine o1, Caffeine o2) {
        return o1.getCoffeeBrand().compareTo(o2.getCoffeeBrand());
    }
}
