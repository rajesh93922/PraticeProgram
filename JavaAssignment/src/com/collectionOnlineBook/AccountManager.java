package com.collectionOnlineBook;

import java.util.List;

public class AccountManager {
    private List<User>userList;

    public AccountManager(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
