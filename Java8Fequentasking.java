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
		 String input = "rajesh mogga rajesh";
      // second non repeat char by given string
        Map<Character, Long> freqMap = input.replaceAll(" ", "")
                .chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Map.Entry<Character, Long>> sorted = freqMap.entrySet()
                .stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .collect(Collectors.toList());

        if (sorted.size() > 1) {
            System.out.println("Second most repeated char: " + sorted.get(1).getKey() +
                    " -> " + sorted.get(1).getValue());
        } else {
            System.out.println("Not enough unique characters.");
        }
					
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


		  // palidrome
        String s4 = "madam";

        String reverse = new StringBuilder(s4).reverse().toString();
        if(s4.equals(reverse)){
            System.out.println("its palidorme");
        }else {
            System.out.println("not palidrome");
        }

        //Anagram
        String str1 = "listen";
        String str2 = "silent";

        String anagram1 = str1.replaceAll("\\s", "").toLowerCase();
        String anagram2 = str2.replaceAll("\\s", "").toLowerCase();

        boolean prgAnagram = anagram1.chars().sorted().boxed().collect(Collectors.toList())
                            .equals(anagram2.chars().sorted().boxed().collect(Collectors.toList()));
        System.out.println(prgAnagram);

        //find Vowels
        String inputVowels = "This is a sample string with vowels";
        Map<Character, Long> vowelCount = inputVowels.toLowerCase()
                .chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> "aeiou".indexOf(ch) != -1)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //common string
        String[] strArray = {"flow", "flight", "flower"};
        String commonString = Arrays.stream(strArray).reduce((s1, s2) -> {
            int i = 0;
            while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)) {
                i++;
            }
            return s1.substring(0, i);
        }).orElse("");
        System.out.println(commonString);

        //Max and Min words lenght
        String s ="Rajesh mogga and rajesh";

        Map<String, Long> collectMain = Arrays.stream(s.toLowerCase().split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map.Entry<String, Long> maxWOrd = collectMain.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);

        Map.Entry<String, Long> minWord = collectMain.entrySet().stream().min(Map.Entry.comparingByValue()).orElse(null);

        System.out.println(maxWOrd + "  " + minWord);

        //Each word count
        String input = "Java Developer Interview Java";
        Map<String, Long> wordCount1 = Arrays.stream(input.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        wordCount1.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(System.out::println);

        // print duplicate number
        int[] nums = {2,3,4,2,5,3};
        Set<Integer> seen = new HashSet<>();
        Set<Integer> collect = Arrays.stream(nums)
                .filter(n -> !seen.add(n))
                .boxed().collect(Collectors.toSet());
        System.out.println(collect);

        String inReverse = "jack";
        String string = new StringBuilder(inReverse).reverse().toString();
        System.out.println(string);
       // integer reverse 
		  int numbers =123;

        String ss = new StringBuilder(
                String.valueOf(numbers)
                        .chars()
                        .mapToObj(c -> String.valueOf((char) c))
                        .collect(Collectors.joining())
        ).reverse().toString();

        int reversedInt = Integer.parseInt(ss);

        System.out.println("Original: " + numbers);
        System.out.println("Reversed: " + reversedInt);


           

	}

}
