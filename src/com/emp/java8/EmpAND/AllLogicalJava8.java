package com.emp.java8.EmpAND;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AllLogicalJava8 {
    public static void main(String[] args) {

        String str1 = "badasgffgwxb";
        String str2 = "xcaxbabg";
        //find common duplicate in String
        //out put: [a, a, b, b, g, g, x] print common duplicate
        findCommonDuplicate(str1,str2);

        //output :[4, 1, 2, 3]
        //[3, 4, 1, 2]
        //[2, 3, 4, 1]
        //[1, 2, 3, 4]
        int[] w = {1,2, 3,4};
       rotatePossiableNumber(w);

       //output : abc
        String text = "abcabcbb";
        findCommonSubString(text);

        //output : [s, r, h, a]
        String s = "ramesh";
        String s1 = s.replaceAll("me", "");
        matchCharReverseOrder(s1);

        //output :  most repeated char: r -> 2
        String input = "rajesh mogga rajesh";
        secondMostRepeatedChar(input);


    }

    private static void secondMostRepeatedChar(String input) {
        Map<Character, Long> freqMap = input.replaceAll(" ", "")
                .chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Map.Entry<Character, Long>> sorted = freqMap.entrySet()
                .stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .collect(Collectors.toList());

        if (sorted.size() > 1) {
            System.out.println(" most repeated char: " + sorted.get(1).getKey() +
                    " -> " + sorted.get(1).getValue());
        } else {
            System.out.println("Not enough unique characters.");
        }
    }

    private static void matchCharReverseOrder(String s1) {
        List<Character> collectrr = s1.chars().mapToObj(c -> (char) c)
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(collectrr + "  match char me reverse the order ");
    }

    private static void findCommonSubString(String text) {
        int start =0; int end =0; int max_lenght=0; int max_substring =0;

        List<Character> list = new ArrayList<>();

        while (end < text.length()){
            char endChar = text.charAt(end);
            char startChar = text.charAt(start);

            if(!list.contains(end)){
                list.add(endChar);
                end ++;
                if(list.size()> max_lenght){
                    max_lenght = list.size();
                    max_substring = start;
                }
            }else {
                list.remove(Character.valueOf(startChar));
                start++;
            }
        }
        String substring = text.substring(max_substring, max_substring + max_lenght);
        System.out.println(substring);
        System.out.println(max_lenght);
    }

    private static void rotatePossiableNumber(int[] w) {
        List<Integer> collect = Arrays.stream(w).boxed().collect(Collectors.toList());
        for (int i =0; i < 4; i++){
            Collections.rotate(collect , 1);
            System.out.println(collect.toString().replaceAll("//s+" ,""));
        }
    }

    private static void findCommonDuplicate(String str1, String str2) {
        List<Character> duplicateOne = str1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> duplicateTwo = str2.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        List<Character> commonDuplicate = duplicateOne.stream().filter(duplicateTwo::contains).collect(Collectors.toList());
        List<String> duplicate = commonDuplicate.stream().sorted().map(String::valueOf).collect(Collectors.toList());
        System.out.println(duplicate + " print common duplicate");

    }
}
