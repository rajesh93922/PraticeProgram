package com.stringHandling;

import java.util.Scanner;

public class VowelWordReverser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String sentence = scanner.nextLine();

        // Check for invalid characters
        if (!sentence.matches("[A-Za-z ]+")) {
            System.out.println(sentence + " is an invalid sentence");
            return;
        }

        String[] words = sentence.trim().split("\\s+");

        // Check sentence length
        if (words.length < 2) {
            System.out.println("Invalid sentence length");
            return;
        }

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (startsAndEndsWithVowel(word)) {
                result.append(new StringBuilder(word).reverse().toString());
            } else {
                result.append(word);
            }
            result.append(" ");
        }

        System.out.println(result.toString().trim());
    }

    private static boolean startsAndEndsWithVowel(String word) {
        if (word.length() < 1) return false;
        char first = Character.toLowerCase(word.charAt(0));
        char last = Character.toLowerCase(word.charAt(word.length() - 1));
        return isVowel(first) && isVowel(last);
    }

    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}

