package com.java8StreamAndLambdaMoviesStmt2;

import java.util.List;

public class RentalUtility {

    public static double calculateLateFees(List<Rental> rentalList, int daysLate) {
        double lateFeePerDay = 1.50;
        return rentalList.size() * daysLate *lateFeePerDay;
    }
}
