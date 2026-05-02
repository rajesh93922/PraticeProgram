package com.java8;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Feq {
    public static void main(String[] args) {
        // print unique names
        List<List<String>> uniqueName = Arrays.asList(
                Arrays.asList("Alice", "Bob", "Charlie"),
                Arrays.asList("Bob", "David"),
                Arrays.asList("Eve", "Frank"));
        //printUniqueName(uniqueName);

        List<String> alphabetByName = Arrays.asList("Tom", "jerry", "Tim", "Jack", "Jill");
        checkIt(alphabetByName);
        //printAlphabetByName(alphabetByName);

        //5 2.) Print the Fibonacci value of given number
        int num =10; int a =0; int b =1;
        for (int i = 1; i < num; i++) {
            //System.out.println(a);
            int sum = a+b;
            a = b;
            b = sum;
        }
        //7 3.) Find the duplicate word in a list using streams & Find the duplicate word in a list (case sensitive)
        //output : Duplicate words (case-insensitive): [banana, apple]
        List<String> words = Arrays.asList("Apple", "Banana", "apple", "Banana", "Cherry", "apple");
        Set<String> findDuplicateWOrd = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toSet());
        //System.out.println(findDuplicateWOrd);

        //5.) Find the most repeated word from the paragraph.
        String paragraph = "Java is great. Java is powerful and Java is everywhere. I love Java programming.";
        Map.Entry<String, Long> mostRepeatedWord = Arrays.stream(paragraph.split(" ")).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
        //System.out.println(mostRepeatedWord);

        //.) Split the paragraph string by comma and store it in a array list
        String splitByComma = "Java is powerful, Java is everywhere, I love Java programming, It is platform independent";
        List<String> splitByCommaValues = Arrays.stream(splitByComma.split(",")).map(String::trim)
                .collect(Collectors.toList());
       // System.out.println(splitByCommaValues);
        //splitByCommaValues.forEach(System.out::println);

        //Lengthy string will be provided with multiple dots, we have to split the string and convert into list.
        // ex: String s = "China has been using artificial intelligence tools to weaken Taiwan's
        String splitByDotExample = "China has been using artificial intelligence tools to weaken Taiwan's morale. "
                + "The campaigns have been spreading misinformation. "
                + "They also target social media platforms.";
        List<String> checksplitByDotExample = Arrays.stream(splitByDotExample.split("\\."))
                .map(String::trim).filter(str -> !str.isEmpty()).collect(Collectors.toList());
       // System.out.println(checksplitByDotExample);
        //checksplitByDotExample.forEach(System.out::println);

        List<String> inputLines = Arrays.asList(
                "efHGEFght",
                "abAcdBCDL",
                "XzxYyZp"
        );
        transFormLetters(inputLines);
        System.out.println("=== Requirement 1: Uppercase First, Lowercase Later ===");
        inputLines.forEach(line ->{
            String uppercase = line.chars().filter(Character::isUpperCase).mapToObj(c -> String.valueOf((char) c))
                    .sorted().collect(Collectors.joining());
            String lowercase = line.chars().filter(Character::isLowerCase).mapToObj(c -> String.valueOf((char) c))
                    .sorted().collect(Collectors.joining());
            System.out.println(uppercase+lowercase);

        });
        System.out.println("\n Requirement 1: lowercase First, uppercase Later ===");

        inputLines.forEach(line ->{
            String lowercase = line.chars().filter(Character::isLowerCase).mapToObj(c -> String.valueOf((char) c))
                    .sorted().collect(Collectors.joining());
            String uppercase = line.chars().filter(Character::isUpperCase).mapToObj(c -> String.valueOf((char) c))
                    .sorted().collect(Collectors.joining());
            System.out.println(lowercase+uppercase);

        });

        //check the perfect parthensis
        String parthensis = "()[{}()]";
        if(checkParthensis(parthensis) == true)
            System.out.println("perfect parthensis");
        else
            System.out.println("not");

        // Extract domain name from emails
        List<String>emails = Arrays.asList("user@gmail.com" , "user2@yahoo.com");
        List<String> domain = emails.stream().map(e -> e.substring(e.indexOf("@") + 1)).collect(Collectors.toList());
        //System.out.println(domain);

        // find two sum of pair
        int [] twoValues = {1,2,5,9,1};
        int value =3;
        for (int i = 0; i < twoValues.length; i++) {
            for (int j = i; j < twoValues.length; j++) {
                if(twoValues[i] + twoValues[j] == value){
                    //System.out.println(twoValues[i] + " " +twoValues[j]);
                }
            }
        }
        //misssing number
        List<Integer>list = Arrays.asList(1,2,8);
        IntStream.range(1,8).filter(e -> !list.contains(e)).forEach(e -> System.out.println(e));




    }

    private static void transFormLetters(List<String> inputLines) {
        
        inputLines.forEach(e -> {
            e.chars().filter(Character::isUpperCase).mapToObj(c -> String.valueOf((char) c)).sorted().collect(Collectors.joining());
        });
    }

    private static void checkIt(List<String> alphabetByName) {
        Map<String, String> collect = alphabetByName.stream().collect(Collectors.groupingBy(e -> e.substring(0, 1).toLowerCase(),
                Collectors.mapping(e -> "\"" + e + "\"", Collectors.joining(","))));
        System.out.println(collect + "   yes");
    }

    private static boolean checkParthensis(String parthensis) {
        Stack<Character> stack = new Stack<>();

        for (char c : parthensis.toCharArray()) {
            if(c == '(' || c == '[' || c =='{')
                stack.push(c);
                else {
                    if (stack.isEmpty())
                        return false;
                char pop = stack.pop();
                if((c == ')' && pop == '(') || (c == ']' && pop == '[') || (c == '}' && pop == '{'))
                    continue;
                else
                    return false;
            }

        }
        return stack.isEmpty();
    }

    private static void printAlphabetByName(List<String> alphabetByName) {
        Map<String, String> collect = alphabetByName.stream().collect(Collectors.groupingBy(n -> n.substring(0, 1).toLowerCase(),
                Collectors.mapping(n -> "\"" + n + "\"", Collectors.joining(","))));
        System.out.println(collect);

    }

    private static void printUniqueName(List<List<String>> uniqueName) {
        //apporach 1
        List<String> collect = uniqueName.stream().flatMap(List::stream).distinct().collect(Collectors.toList());
        Set<String>set = new HashSet<>();
        Set<String> collect1 = uniqueName.stream().flatMap(List::stream).filter(e -> !set.contains(e)).collect(Collectors.toSet());
        System.out.println(collect1);
    }
}
