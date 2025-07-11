package com.javaassignment.ExceptionHandlingAssignment.utility;

import com.javaassignment.ExceptionHandlingAssignment.exception.InvalidHealthDataException;

public class HealthDataProcessor {

    public static boolean validatePatientDetails(int age, String gender, double height, double weight, int bloodPressure, double cholesterol) throws InvalidHealthDataException {

        if (age < 18 || age > 100){
            throw new InvalidHealthDataException("Invalid age");
        } else if (!gender.equals("Male") && !gender.equals("Female")) {
            throw new InvalidHealthDataException("Invalid gender");
        } else if (height < 0) {
            throw new InvalidHealthDataException("Invalid height");
        } else if (weight < 0) {
            throw new InvalidHealthDataException("Invalid weight");

        }else if (bloodPressure < 60 && bloodPressure > 220){
            throw new InvalidHealthDataException("Invalid blood pressure");
        } else if (cholesterol < 0) {
            throw new InvalidHealthDataException("Invalid Cholesterol");
        }

        return true;
    }

}
