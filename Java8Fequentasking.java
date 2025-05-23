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

           

	}

}
