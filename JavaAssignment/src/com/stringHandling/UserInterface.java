package com.stringHandling;



import com.stringHandling.utility.MessageEncoder;

import java.util.Scanner;

public class UserInterface {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        System.out.println("Enter message: ");
        String message = sc.nextLine();

        try{
            messageValidation(message);

            String encodeMessage = MessageEncoder.encodeMessage(message);

            System.out.println("Encoded message: "+encodeMessage);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    public static void messageValidation(String message) throws Exception {

        if (message.length() < 4){
            throw new Exception("The string "+message+" has minimum length");
        }else if (message.contains(" ")){
            throw new Exception("The string "+message+" should not contain space");
        }

    }
}

