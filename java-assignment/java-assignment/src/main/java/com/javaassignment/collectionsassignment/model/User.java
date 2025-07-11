package com.javaassignment.collectionsassignment.model;

import java.util.Objects;

public class User {
    private String userName;
    private String password;
    private String email;

    public User(){
        this.userName = "";
        this.password = "";
        this.email = "";
    }

    public static boolean registerUser(User newUser){

        AccountManager accountManager = new AccountManager();

        for (User user : accountManager.getUserList()){
            if (user.getUserName().equalsIgnoreCase(newUser.getUserName())
                    || user.getEmail().equalsIgnoreCase(newUser.getEmail())){
                System.out.println("User already registered please different details");
                return false;
            }else {
                accountManager.addUser(newUser);
                System.out.println("User Registered successfully");
                return true;
            }
        }

        return true;
    }

    public static User authenticateUser(User loginUser) {
        AccountManager accountManager = new AccountManager();

        for (User user : accountManager.getUserList()) {
            if (user.getUserName().equalsIgnoreCase(loginUser.getUserName()) && user.getPassword().equalsIgnoreCase(loginUser.getPassword())){
                System.out.println("User authenticated successfully \n User is : "+loginUser);
                return loginUser;
            }else {
                System.out.println("Invalid User credentials \n User is :"+null);
                return null;
            }
        }
        return null;
    }

    public static boolean resetPassword(String userName, String newPassword) {
        return updateUserByField(userName, newPassword, "password reset was success");
    }

    private static boolean updateUserByField(String userName, String newPassword, String msg) {
        AccountManager accountManager = new AccountManager();
        for (User user : accountManager.getUserList()) {
            if (user.getUserName().equalsIgnoreCase(userName)){
                if (msg.contains("password")){
                user.setPassword(newPassword);
                } else if (msg.contains("email")) {
                user.setEmail(newPassword);
                }

                System.out.println(msg +user);
                return true;
            }else {
                System.out.println("User not found");
                return false;
            }
        }
        return false;
    }

    public static boolean updateEmail(String userName, String email) {
        return updateUserByField(userName, email, "email update was success ");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, email);
    }
}
