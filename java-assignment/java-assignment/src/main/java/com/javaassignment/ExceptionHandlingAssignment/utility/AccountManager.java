package com.javaassignment.ExceptionHandlingAssignment.utility;

import com.javaassignment.ExceptionHandlingAssignment.exception.InsufficientFundsException;
import com.javaassignment.ExceptionHandlingAssignment.exception.InvalidCredentialsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccountManager {

    private String username;
    private String password;
    private List<Double> currentBalance = new ArrayList<>();
    private static final Integer maxLimitDeposit = 10000;
    private static int withDrawlLimit = 3;

    public static void validateCredentials(String username, String password) throws InvalidCredentialsException {
      if (!isUserNameValid(username) || !isPassWordValid(password)){
          throw new InvalidCredentialsException("Invalid Credentials");
      }
    }

    private static boolean isPassWordValid(String password) {
        return password.length() >=8 && password.matches(".*[A-Z].*")
                && password.matches(".*[a-z].*")
                && password.matches(".*\\d.*")
                && password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*");
    }

    private static boolean isUserNameValid(String username) {
        return username.matches("^[a-zA-Z1-9]{6,}+$");
    }

    public void deposit(int depositAmount) {
        if (depositAmount < 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
        }else if (depositAmount >= maxLimitDeposit ){
            System.out.println("Deposit amount exceeds maximum limit of 10,000. Please enter a smaller amount.");
        }
        else if (this.currentBalance.isEmpty()){
        this.currentBalance.add(0,(double)depositAmount);
        System.out.println("Deposit Successful. New Balance: "+this.currentBalance.get(0));
        }
    }

    public void withDraw(int withDrawAmount) throws InsufficientFundsException {
        double updatedAmount = 0;
        if (withDrawlLimit == 0){
            System.out.println("Withdraw Limit exceeded. Try again later");
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        else if (withDrawAmount > this.currentBalance.get(0)){
            --withDrawlLimit;
            System.out.println("Insufficient Funds. Current Balance: " + this.currentBalance);
            throw new InsufficientFundsException("Balance is insufficient\nRemaining Withdraw Limit :"+withDrawlLimit);
        } else if (withDrawAmount < 0) {
            System.out.println("Withdraw Amount is more than 0 only");
        } else if (withDrawAmount > 0 && withDrawAmount <= this.currentBalance.get(0)){
            updatedAmount = (this.currentBalance.get(0) - withDrawAmount);
            this.currentBalance.set(0,updatedAmount);
            System.out.println("WithDraw Successful. Current Balance: "+updatedAmount);
        }
    }

    public double checkBalance() {
        if (!this.currentBalance.isEmpty()){
            return this.currentBalance.get(0);
        }
        return 0;
    }
}
