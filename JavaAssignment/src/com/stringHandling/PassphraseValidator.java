package com.stringHandling;

import java.util.Scanner;

public class PassphraseValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the passphrase:");
        String input = scanner.nextLine();

        String[] words = input.trim().split("\\s+");

        for (String word : words) {
            if (!word.matches("[A-Za-z]+")) {
                System.out.println(word + " is not a valid word");
                continue;
            }

            int len = word.length();
            int mid = len / 2;

            String firstHalf = word.substring(0, mid);
            String secondHalf = (len % 2 == 0) ? word.substring(mid) : word.substring(mid + 1);

            int sumFirst = getAlphabetSum(firstHalf);
            int sumSecond = getAlphabetSum(secondHalf);

            if (sumFirst == sumSecond) {
                System.out.println(word + " is a valid word");
            } else {
                System.out.println(word + " is not a valid word");
            }
        }
    }

    private static int getAlphabetSum(String part) {
        int sum = 0;
        for (char c : part.toCharArray()) {
            sum += Character.toLowerCase(c) - 'a' + 1;
        }
        return sum;
    }
}

