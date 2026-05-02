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

         ////////////////////////////////////////  
           String rom = "Geeks for Geeks";

           StringBuilder input1 = new StringBuilder();

           // append a string into StringBuilder input1
           input1.append(rom);

           // reverse StringBuilder input1
           input1.reverse();

           System.out.println(input1);
                     

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


		

        List<Employee> collect = employees.stream().map(employee -> {
            if (employee.getSalary() > 1000) {
                employee.setSalary(employee.getSalary() + 1000);
            }
                    return employee;
                })
                .collect(Collectors.toList());
        System.out.println(collect);


      int  empFindById  =1002 ;
        Optional<Employee> first = employees.stream().filter(e -> e.getId() == empFindById).findFirst();

        first.ifPresentOrElse( employee -> System.out.println(" emp found" + employee),
                () -> System.out.println("not fourd" ));

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


           
        listEmp.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))))
                .forEach((dep,salary) -> System.out.println(dep + "dept wise salary " +salary));


	}

}
