package com.interview.code.javatechie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Fequentasking {
	
	public static void main(String[] args) {
		
		/*  1. find each char occure */
		
		String input = "ilovejavatechie";
		
		String[] split = input.split("");
		
		//System.out.println(Arrays.toString(split));
		
		Map<String, List<String>> collect = Arrays.stream(input.split("")).collect(Collectors.groupingBy(t -> t));
		
		//System.out.println(collect);
		
		Map<String, Long> collectResult = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.println("count each chartertar " + "  "+collectResult);

        /* find all duplicate elements */
		
		List<String> duplicateResult = Arrays.stream(input.split(""))
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream()
		.filter(x -> x.getValue() >1)
		.map(Map.Entry::getKey)
		.collect(Collectors.toList());
		
		System.out.println("Duplicate number  " + " " +duplicateResult);
		
		List<String> uniqueResult = Arrays.stream(input.split(""))
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet().stream()
				.filter(x -> x.getValue()==1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
				
		System.out.println("uniqueResult number   " + " " +uniqueResult);

		// find first non repeat element by given String
				
				 String fristNonRepate = Arrays.stream(input.split(""))
						.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
						.entrySet().stream()
						.filter(x -> x.getValue()==1)
						.findFirst().get().getKey();
				 
					System.out.println(" non repeat : "+ "  " +fristNonRepate);
					
		//java program to find second highest number from given array
					
			int []numbers = {5,9 , 11, 2, 8 ,21,1};	
			
			Integer secondHighestnumber = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
			
			System.out.println(" secondHighestnumber  : "+ " " +secondHighestnumber);

			//java program to find second lowest number from given array
			
           int []numbersLowest = {5,9 , 11, 2, 8 ,21,1};	
			
			Integer secondLowestnumber = Arrays.stream(numbersLowest).boxed().sorted().skip(1).findFirst().get();
			
			System.out.println(" secondLowestnumber : "+ "  " +secondLowestnumber);
			
		// java program to find longest string from given array
			
			String [] strarray = {"java" , "techie" , "Springboot" ,"Microservices"};
			
			String longeststring = Arrays.stream(strarray)
					.reduce((word1 , word2) -> word1.length() > word2.length() ? word1 : word2)
					.get();
			System.out.println(" longeststring : "+ " " +  longeststring);
			
			
	  //java program to find all elements from array who start with 1
			
			List<String> startwithone = Arrays.stream(numbers)
					.boxed().map(s -> s + " ")
					.filter(s -> s.startsWith("1"))
					.collect(Collectors.toList());
			
			System.out.println(" startwithone : "+ " " +  startwithone);
			
			// java program string.join method 
			
			List<String> asList = Arrays.asList("1" ,"2", "3" ,"4");
			
			String join = String.join(",", asList);
			
			System.out.println(" join : "+ " " +  join);

			// Skip and limit method use case based example
			
			IntStream.rangeClosed(1, 10).skip(1).limit(8).forEach(System.out::println);

			final List<String> list = new ArrayList<>();
			list.add("rajesh");
			
			//list = new ArrayList<>();
			
			// swap two number without third variable
			
			int x = 10;
			int y =20;
			
			System.out.println();
			
			x = x+y; //10+20 =30
			
			y = x-y ; // 30 -20 =10
			
			x = x-y ; //30 - 10 =20
			
			System.out.println(x + "  " +y);

					
			/// prime number
			System.out.println("enter the String :");
	    	Scanner sc = new Scanner(System.in);
	    	int num = sc.nextInt();
			// int num = 10;
			 int count =0;
			 
           for(int i = 1 ; i <= num ; i++) {
        	   if(num %i ==0) {
        		   count ++;
        	   }
           }
           if(count ==2) {
        	   System.out.println("prime" + num);
           }else {
        	   System.out.println("not prime" + num);
           }
           
         ////////////////////////////////////////  
           String rom = "Geeks for Geeks";

           StringBuilder input1 = new StringBuilder();

           // append a string into StringBuilder input1
           input1.append(rom);

           // reverse StringBuilder input1
           input1.reverse();

           System.out.println(input1);
           
     ////////////////////////////////////////////////      
           String [] log = {"kil" ,"road" ,"iphone 15 plus"};
           
           String string = Arrays.stream(log).reduce((word1 , word2) -> word1.length() >word2.length() ? word1 :word2).get();
           
           System.out.println(string);

		////////////////////////////////

		  System.out.println("Start");
        List<String> words = List.of("apple", "pineapple", "ball", "cat", "apricot", "dog", "bourbon");
        groupByWordLength(words);

        countOfEachCharInStr();
//        String str = "WordsInCamelCase";
//        camelCaseToSentence(str);

//        sumOfNumbers();

//        getNthMaxNumber();

//        countWordHavingChar();

//        getAvg();

//        getLongestStr();

//        get1stNonRepeatingEle();

//        listOf1stNonRepeatingChar();

//            groupAnagramWords();

//        listNonRepeatingEle();



        HashMap<String, Integer> map = new HashMap<>();
        map.put(new String("Jone"), 1);
        map.put("Jone", 2);

//        map.values().forEach(System.out::println);

    }

    private static void groupAnagramWords() {

        List<String> list = List.of("cat" , "dog", "god" , "eat" , "ate");

        Map<String, List<String>> m = list.stream().collect(Collectors.groupingBy(w -> {
            char[] chars = w.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }));

        m.values().forEach(System.out::println);
    }

    public static void groupByWordLength(List<String> list){
        System.out.println("Start: Group the words by length and sort them");
        list.stream().collect(Collectors.groupingBy(String::length)).entrySet().stream().collect(
                Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream().sorted().toList()
                )
        ).forEach(
                (k,v) -> System.out.println(k + "=" + v)
        );
    }

    public static void camelCaseToSentence(String str){
        System.out.println("Start camelCaseToSentence");
        String result = str.chars().mapToObj(c -> (char) c)
                .map(ch -> Character.isUpperCase(ch) ? " " + ch : ch.toString())
                .peek(c -> System.out.println(c))
                .collect(Collectors.joining()).trim(); // To remove leading space if the first character is uppercase
        System.out.println(result);
    }


    public static void countOfEachCharInStr(){
        String str = "Now is the winter";
        str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + ": " + value));
//        or
        Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static void countWordHavingChar() {
        char c = 'a';
        List<String> words = List.of("apple", "mango", "rat", "ball", "cat", "apricot", "dog", "banana");
        Long count = words.stream().filter(w -> w.contains(String.valueOf(c))).count();
        System.out.println(count);

    }

    public static void getLongestStr() {
        List<String> words = List.of("apple", "mango", "rat", "ball", "cat", "apricot", "dog", "banana");
        String word = words.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println(word);
//        or
        word = words.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println(word);

    }

    public static void mergeAndGetDistinct() {



    }

    public static void groupByAnagram(){
        List<String> words = List.of("apple", "leppa", "god", "ball", "cat", "apricot", "dog", "banana");

        System.out.println(words);
    }

    public static void listOf1stNonRepeatingChar() {
        List<String> words = List.of("apple", "pineapple", "ball", "cat", "apricot", "dog", "bourbon");
        words.stream().map(word -> word.chars().mapToObj(c -> (char)c).collect(
                        Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey)
                .findFirst()).forEach(o -> o.ifPresent(System.out::println));
    }

    public static void listNonRepeatingEle() {
        int[] arr = {2, 1, 3, 7, 4, 2, 6, 1, 6, 3};

        // Wrong as it will create stream of one element arr
        Stream.of(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

        // Right approach
        Stream.of(2, 1, 3, 7, 4, 2, 6, 1, 6, 3).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

        // Right approach
        Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);


    }

    public static void get1stNonRepeatingEle() {
        List<Integer> numbers = List.of(2, 1, 3, 7, 4, 2, 6, 1, 6, 3);
        int firstNonRep =
                numbers.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                        .entrySet().stream().filter(entry ->  entry.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(-1);
        System.out.println(firstNonRep);

    }

    public static void sumOfNumbers(){

        List<Integer> numbers = List.of(10, 20, 67, 98, 24, 50);
        //OPTION 1
        int sum = numbers.stream().reduce((i, j) -> i +=  j).orElse(0);
        System.out.println(sum);

        //OPTION 2
        sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }

    public static void getNthMaxNumber() {
        List<Integer> numbers = List.of(10, 20, 67, 98, 24, 50);
        int max =
                numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);
        System.out.println(max);

    }

    public static void getAvg() {
        List<Integer> numbers = List.of(10, 20, 67, 98, 24, 50);
        double avg =
                numbers.stream().collect(Collectors.averagingLong(Integer::longValue));
        System.out.println(avg);

    }

//    public static void getPrimeList() {
//        List<Integer> numbers = List.of(2, 3, 8, 11, 24, 9);
//        numbers.stream().map(n -> n%(n/2))
//    }

           

	}

}
