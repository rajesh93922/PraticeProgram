package com.stringHandling;

import java.util.Scanner;

public class LibraryPINGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the membership ID");
        String membershipID = scanner.nextLine();

        // 1. Check length
        if (membershipID.length() != 8) {
            System.out.println(membershipID.length() + " is an invalid length");
            return;
        }

        // 2. Check format: 3 letters followed by 5 digits
        String letters = membershipID.substring(0, 3);
        String digits = membershipID.substring(3);

        if (!letters.matches("[A-Za-z]{3}") || !digits.matches("\\d{5}")) {
            System.out.println(membershipID + " is an invalid format");
            return;
        }

        // 3. Check first digit is not '0'
        if (digits.charAt(0) == '0') {
            System.out.println("0 is an invalid digit");
            return;
        }

        // 4. Check last digit matches age category
        int lastDigit = Character.getNumericValue(digits.charAt(4));
        if (lastDigit < 1 || lastDigit > 9) {
            System.out.println(lastDigit + " is an invalid category");
            return;
        }

        // Generate PIN: even-positioned digits (0-indexed)
        StringBuilder pin = new StringBuilder();
        for (int i = 0; i < digits.length(); i++) {
            if (i % 2 == 0) {
                pin.append(digits.charAt(i));
            }
        }

        System.out.println("PIN: " + pin.toString());
    }
}

