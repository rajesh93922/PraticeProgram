package com.stringHandling;
import java.util.Scanner;

public class LongestCommonSubString {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        if (!isValid(s1) || !isValid(s2)){
            System.out.println("Invalid input");
            return;
        }

        String result = commonLongestSubString(s1, s2);
        System.out.println("longest common substring length "+result.length()+"\nlongest common substring in upper "+result.toUpperCase()+"\nlongest common substring in lower "+result.toLowerCase());

    }

    public static String commonLongestSubString(String s1, String s2) {
        int maxLen = 0;
        int endIndex = 0;
        int[][] ta = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    ta[i][j] = ta[i - 1][j - 1] + 1;
                    if (ta[i][j] > maxLen) {
                        maxLen = ta[i][j];
                        endIndex = i;
                    }
                }
            }
        }

        return s1.substring(endIndex - maxLen, endIndex);
    }

    public static boolean isValid(String s1) {
        return s1.matches("[a-zA-Z0-9 ]+");
    }
}
