package com.stringHandling.utility;

public class MessageEncoder {
    public static String encodeMessage(String message) {

        int length = message.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : message.toCharArray()) {
            char value = (char)(c - length);
            stringBuilder.append(value);
        }

        return stringBuilder.toString();
    }
}

