package com.javaassignment.collectionsassignment.model;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {

    private List<User> userList;

    public boolean addUser(User newUser){

        if (!userList.isEmpty()){
            for (User user : userList){
                if (user.getUserName().equalsIgnoreCase(newUser.getUserName())
                        || user.getEmail().equalsIgnoreCase(newUser.getEmail())){
                    System.out.println("User already registered please different details");
                    return false;
                }else {
                    this.userList.add(newUser);
                    System.out.println("User Registered successfully : " + newUser);
                    return true;
                }
            }
        } else {
            this.userList.add(newUser);
            System.out.println("User Registered successfully : " + newUser);
            return true;
        }
        return false;
    }

    public User deleteUser(String userName){

        User userByUserName = getUserByUserName(userName);
        userList.remove(userByUserName);

        System.out.println("User deleted successfully : "+userByUserName+"\n from "+userList);
        return userByUserName;

    }

    public boolean resetPassword(String userName, String newPassword) {
        return updateUserByField(userName, newPassword, "password reset was success");
    }

    private boolean updateUserByField(String userName, String newPassword, String msg) {
        for (User user : userList) {
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

    public boolean updateEmail(String userName, String email) {
        return updateUserByField(userName, email, "email update was success ");
    }

    public User getUserByUserName(String userName){
        for (User user : userList) {
            if (user.getUserName().equalsIgnoreCase(userName)){
                return user;
            }
        }
     return null;
    }

    public AccountManager(){
        this.userList = new ArrayList<>();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "AccountManager{" +
                "userList=" + userList +
                '}';
    }

    public User login(User loginUser) {
        for (User user : userList) {
            if (user.getUserName().equalsIgnoreCase(loginUser.getUserName()) && user.getPassword().equalsIgnoreCase(loginUser.getPassword())){
                System.out.println("User authenticated successfully \n By User : "+loginUser);
                return user;
            }else {
                System.out.println("Invalid User credentials \n User is :"+null);
                return null;
            }
        }
        return null;
    }
}
