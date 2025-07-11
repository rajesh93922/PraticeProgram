package com.stringHandling;


import java.util.Scanner;

public class ProblemStatement3 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int N = Integer.parseInt(sc.nextLine());

        if (N <= 0) {
            System.out.println("The number of sequences must be greater than zero");
            return;
        }

        String[] sequences = new String[N];

        // Read sequences
        for (int i = 0; i < N; i++) {
            sequences[i] = sc.nextLine().trim();
        }

        // Validate equal length
        int length = sequences[0].length();
        for (int i = 1; i < N; i++) {
            if (sequences[i].length() != length) {
                System.out.println("All sequences are not of the same length");
                return;
            }
        }

        int purineCount = 0;
        int pyrimidineCount = 0;

        // Loop through each position (column)
        for (int i = 0; i < length; i++) {
            boolean allPurine = true;
            boolean allPyrimidine = true;

            for (int j = 0; j < N; j++) {
                char base = sequences[j].charAt(i);
                if (base != 'A' && base != 'G') {
                    allPurine = false;
                }
                if (base != 'C' && base != 'T') {
                    allPyrimidine = false;
                }
            }

            if (allPurine) purineCount++;
            if (allPyrimidine) pyrimidineCount++;
        }

        System.out.println(purineCount + " " + pyrimidineCount);

    }
}

