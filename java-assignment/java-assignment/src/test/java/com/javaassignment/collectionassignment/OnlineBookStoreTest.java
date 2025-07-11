package com.javaassignment.collectionassignment;

import com.javaassignment.collectionsassignment.OnlineBookStore;
import com.javaassignment.collectionsassignment.model.AccountManager;
import com.javaassignment.collectionsassignment.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnlineBookStoreTest {

    AccountManager accountManager = new AccountManager();

    @Test
    public void testMainMethod() {
        String simulatedInput = String.join(System.lineSeparator(),
                "register", "testuser", "testpass", "test@example.com",
                "login", "testuser", "testpass",
                "get user by username", "testuser",
                "reset password", "testuser", "newpass",
                "update email", "testuser", "new@example.com",
                "delete user", "testuser",
                "exit"
        ) + System.lineSeparator();

        // Backup original System.in and System.out
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        // Redirect input and output
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        try {
            System.setIn(inputStream);
            System.setOut(printStream);

            // Run the main method
            OnlineBookStore.main(new String[]{});

            // Capture and verify output
            String output = outputStream.toString();
            Assertions.assertNotNull(output);
        } finally {
            // Restore original System.in and System.out
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
    @Test
    void registerUserTest(){
        User user = new User();
        user.setUserName("test");
        user.setPassword("test");
        user.setEmail("test@gmail.com");
        user.hashCode();
        user.getEmail();
        User.registerUser(user);
    }

    @Test
    void authenticateUserTest(){
        User user = new User();
        user.setUserName("test");
        user.setPassword("test");
        user.setEmail("test@gmail.com");
        User user1 = User.authenticateUser(user);
    }
    @Test
    void resetPasswordTest(){
        User.resetPassword("test", "test1");
    }
    @Test
    void updateEmailTest(){
        User.updateEmail("test", "test1@gmail.com");
    }
    @Test
    void addUserTest(){
        User user = new User();
        user.setUserName("test");
        user.setPassword("test");
        user.setEmail("test@gmail.com");
        accountManager.setUserList(List.of(user));
        accountManager.addUser(user);
        Assertions.assertNotNull(accountManager.toString());
    }
}
