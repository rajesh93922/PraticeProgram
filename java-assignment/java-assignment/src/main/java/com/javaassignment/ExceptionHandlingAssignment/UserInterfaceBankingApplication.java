package com.javaassignment.ExceptionHandlingAssignment;

import com.javaassignment.ExceptionHandlingAssignment.exception.InsufficientFundsException;
import com.javaassignment.ExceptionHandlingAssignment.exception.InvalidCredentialsException;
import com.javaassignment.ExceptionHandlingAssignment.utility.AccountManager;

import java.util.Scanner;

public class UserInterfaceBankingApplication {

    static AccountManager accountManager = new AccountManager();

    private static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Enter login details");

        System.out.println("username");
        String username = sc.nextLine();

        System.out.println("password");
        String password = sc.nextLine();

        while (true) {

            try {

                AccountManager.validateCredentials(username, password);

            System.out.println("""
                        Choose an Option:
                        1. Deposit
                        2. Withdraw
                        3. Check Balance
                        4. Exit""");
                System.out.println("Enter Option:");
                String prompt = sc.nextLine();

                switch (prompt) {
                    case "1":
                        deposit();
                        break;
                    case "2":
                        withDraw();
                        break;
                    case "3":
                        checkBalance();
                        break;
                    case "4":
                        System.out.println("Logout Successful.");
                        return;
                    default:
                        System.out.println("Invalid credentials. Please try again");
                }
            } catch (InvalidCredentialsException | InsufficientFundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void checkBalance() {
        double currentBalance = accountManager.checkBalance();
        System.out.println("Current Balance :"+currentBalance);

    }

    private static void withDraw() throws InsufficientFundsException {

        System.out.println("Enter Amount to Withdraw: ");
        int withDrawAmount = Integer.parseInt(sc.nextLine());
        accountManager.withDraw(withDrawAmount);

    }

    private static void deposit() {
        System.out.println("Enter Amount to Deposit: ");
        int depositAmount = Integer.parseInt(sc.nextLine());
        accountManager.deposit(depositAmount);
    }
}
