package com.javaassignment.collectionsassignment;

import com.javaassignment.collectionsassignment.model.AccountManager;
import com.javaassignment.collectionsassignment.model.User;

import java.util.Scanner;

public class OnlineBookStore {

    private static Scanner sc = new Scanner(System.in);
    static AccountManager accountManager = new AccountManager();


    public static void main(String[] args) {

        while (true){
            System.out.println("Choose an action:\n register\nlogin\nget user by username\nreset password\nupdate email\ndelete user\nexit");
            String action = sc.nextLine().toLowerCase();
            switch (action){
                case "register":
                    registerUser();
                    break;
                case "login":
                    loginUser();
                    break;
                case "get user by username":
                    getUserByUserName();
                    break;
                case "reset password":
                    resetPassword();
                    break;
                case "update email":
                    updateEmail();
                    break;
                case "delete user":
                    deleteUser();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid action. Please try again");
            }
        }
    }

    private static void deleteUser() {
        System.out.println("Enter UserName: ");
        String userName = sc.nextLine();

        accountManager.deleteUser(userName);
    }

    private static void getUserByUserName() {
        System.out.println("Enter UserName: ");
        String userName = sc.nextLine();

        User userByUserName = accountManager.getUserByUserName(userName);
        System.out.println("User retrieved successfully : " + userByUserName);
    }

    private static void updateEmail() {

        System.out.println("Enter UserName: ");
        String userName = sc.nextLine();
        System.out.println("Enter Update Email: ");
        String updateEmail = sc.nextLine();

        accountManager.updateEmail(userName, updateEmail);
    }

    private static void resetPassword() {

        System.out.println("Enter UserName: ");
        String userName = sc.nextLine();
        System.out.println("Enter New Password: ");
        String newPassword = sc.nextLine();

        accountManager.resetPassword(userName, newPassword);
    }

    private static void loginUser() {

        System.out.println("Enter UserName: ");
        String userName = sc.nextLine();
        System.out.println("Enter Password: ");
        String password = sc.nextLine();

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);

        accountManager.login(user);
    }

    private static void registerUser() {

        System.out.println("Enter UserName: ");
        String userName = sc.nextLine();
        System.out.println("Enter Password: ");
        String password = sc.nextLine();
        System.out.println("Enter Email: ");
        String email = sc.nextLine();

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);

        accountManager.addUser(user);
    }
}
