package com.javaassignment.ExceptionHandlingAssignment;

import com.javaassignment.ExceptionHandlingAssignment.exception.InvalidHealthDataException;
import com.javaassignment.ExceptionHandlingAssignment.model.UserInterface;
import com.javaassignment.ExceptionHandlingAssignment.utility.HealthDataProcessor;

import java.util.Scanner;

public class SmartHealth {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        UserInterface userInterface = new UserInterface();

        while (true){

        System.out.println("Enter Name");
        String name = sc.nextLine();
        userInterface.setName(name);

        System.out.println("Enter Age");
        int age = Integer.parseInt(sc.nextLine());
        userInterface.setAge(age);

        System.out.println("Enter Gender");
        String gender = sc.nextLine();
        userInterface.setGender(gender);

        System.out.println("Enter Height (in meters)");
        double height = Double.parseDouble(sc.nextLine());
        userInterface.setHeight(height);

        System.out.println("Enter Weight (in kg)");
        double weight = Double.parseDouble(sc.nextLine());
        userInterface.setWeight(weight);

        System.out.println("Enter Blood Pressure (mmHg)");
        int bloodPressure = Integer.parseInt(sc.nextLine());
        userInterface.setBloodPressure(bloodPressure);

        System.out.println("Enter Cholesterol Level");
        double cholesterol = Double.parseDouble(sc.nextLine());
        userInterface.setCholesterol(cholesterol);
        try{
        boolean isValid = HealthDataProcessor.validatePatientDetails(age, gender, height, weight, bloodPressure, cholesterol);

        if (isValid){
           double premium = calculateInsurancePremium(height, weight, bloodPressure, cholesterol);
            System.out.println("Total Insurance Premium: "+premium);
        }
        }catch (InvalidHealthDataException e){
            System.out.println(e.getMessage());
        }
        }

    }

    private static double calculateInsurancePremium(double height, double weight, int bloodPressure, double cholesterol) {
      double premium = 0.0d;
      if (bloodPressure <= 120){
          premium = 750;
      }else if (bloodPressure > 120 && bloodPressure <= 140){
          premium = 1000;
      } else if (bloodPressure > 140) {
          premium = 1500;
      }
      return premium;
    }
}
