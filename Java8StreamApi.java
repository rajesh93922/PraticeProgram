import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8StreamApi{
    
   public static void main(String[] args) {
        int[] w = {1,2, 3,4};
        rotateNumber(w);

        String str = "abcabcbb";
        findSubString(str);
        //prime
        int n=50;
        primeNumber(n);

        //output : R
        String nonRepeated ="Rajesh";
        findFirstNonRepeatedChar(nonRepeated);
        
        String str11 = "badasgffgwxb";
        String str22 = "xcaxbabg";
        //find common duplicate in String
        //out put: [a, a, b, b, g, g, x] print common duplicate
        findCommonDuplicate(str11,str22);

        // palidrome
        String s4 = "madam";
        checkPalidrome(s4);

        //Anagram
        String str10 = "listen";
        String str20 = "silentg";
        checkAnagram(str10,str20);

        //find Vowels
        String inputVowels = "This is a sample string with vowels";
        findOutVowels(inputVowels);

        // find common word
        String[] commonStr = {"flow", "flight", "flower"};
        commonWord(commonStr);

        //Max and Min words lenght
        String minAndMax ="Rajesh mogga and rajesh";
       findMinAndMinWord(minAndMax);

        //Each word count
        String eachWordCount = "Java Developer Interview Java";
        eachCountWord(eachWordCount);


        //print reversenumber
        int reverseNumber = 12345;
        printReverseNum(reverseNumber);

        // get value of g OutPut : {g=2}
        String stri = "Rajesh Mogga Rajesh";
        countG(stri);

        // even and Odd [2, 4, 6, 8]even and odd[1, 3, 5, 7, 9]
        List<Integer> numss = List.of(1,2,3,4,5,6,7,8,9);
        printEvenAndOdd(numss);

        //missing number
        int[] arr = {1,2,4};
        int nu = 4;
        missingNumber(arr, nu);

        int[] numSum={3,4,7,2,-3,1};
        int k = 7;
        subArraySum(numSum,k);
        System.out.println(" print subarray "+subArraySum(numSum,k));

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int kk = 3;
        int nn = nums.length;
        kk = kk % nn;

        int[] rotated = new int[ nn ];
        System.arraycopy(nums, nn - kk, rotated, 0, kk);
        System.arraycopy(nums, 0, rotated, kk, nn - kk);
        System.out.println(Arrays.toString(rotated));

        int[] twoSum ={2,11,7,15};
        int target =9;
        twoSumProg(twoSum, target);
        System.out.println(Arrays.toString(twoSumProg(twoSum, target)));

        //check the number twice in int
        int[] i1 = {1, 2, 3, 1};
        checktwice(i1);
        System.out.println( checktwice(i1));

        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Charlie", "anna");
        long count = names.stream()
                .filter(name -> name.toLowerCase().startsWith("a"))
                .count();
        System.out.println("Count of names starting with 'a': " + count);

        //// Output: [2, 2]
        List<Integer> i11 = new ArrayList<>(Arrays.asList(1, 2, 2, 1));
        List<Integer> i22 = new ArrayList<>(Arrays.asList(2, 2));
        checkDuplicate(i11,i22);
        System.out.println("  Check Duplicate TWice" + checkDuplicate(i11,i22));

    }

    private static int[] checkDuplicate(List<Integer> i11, List<Integer> i22) {
        List<Integer> list = new ArrayList<>();
        for (Integer num : i22) {
            if (i11.contains(num)){
                list.add(num);
                list.remove(i11);
            }
        }
        return new int[] {};
    }

    private static boolean checktwice(int[] i1) {
        Set<Integer> set = new HashSet<>();
        for (Integer num :i1 ) {
            if (!set.add(num)){
                return true;
            }
        }
        return false;
    }

    private static int[] twoSumProg(int[] twoSum, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < twoSum.length; i++) {
            int component = target - twoSum[i];
            if (map.containsKey(component)){
                return  new int[] {map.get(component),i};
            }
            else {
                map.put(twoSum[i], i);
            }
        }
        return new int[] {};

    }


    private static int subArraySum(int[] numSum, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int ans =0;
        int sum =0;

        for (int i = 0; i < numSum.length; i++) {
            sum += numSum[i];

            if(map.containsKey( sum - k)){
                ans += map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum,0) +1);
        }
        return ans;
    }

    private static void missingNumber(int[] arr, int nu) {
        int expectedSum = nu * (nu + 1) / 2;
        int actualSum = Arrays.stream(arr).sum();

        System.out.println("Missing number is: " + (expectedSum - actualSum));


    }

    private static void printEvenAndOdd(List<Integer> numss) {
        Map<Boolean, List<Integer>> evenANDOdd = numss.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        List<Integer> even = evenANDOdd.get(true);
        List<Integer> Odd = evenANDOdd.get(false);
        System.out.println(even + "even and odd" + Odd);

    }

    private static void countG(String stri) {
        String ss = new StringBuilder(stri).reverse().toString();
        System.out.println(ss);

        Map<String, Long> collect3 = Arrays.stream(stri.split("")).filter(e -> e.equals("g"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect3 +" get value of g OutPut ");
    }

    private static void printReverseNum(int reverseNumber) {
        int reversed = Integer.parseInt(new StringBuilder(String.valueOf(reverseNumber))
                .reverse()
                .toString()
        );
        System.out.println("Reversed: " + reversed);

    }

    private static void eachCountWord(String eachWordCount) {
        Map<String, Long> wordCount1 = Arrays.stream(eachWordCount.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        wordCount1.forEach((k,v) -> System.out.println(k + " each word count by name" + v));
        List<String> list = Arrays.asList("apple banana cherry ","apple cherry" );

        Map<String, Long> collect = list.stream().flatMap(st -> Arrays.stream(st.trim().split("\\s+")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        collect.forEach((k, v) -> System.out.println(k + " " + v));



    }

    private static void findMinAndMinWord(String minAndMax) {
        Map<String, Long> collectMain = Arrays.stream(minAndMax.toLowerCase().split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map.Entry<String, Long> maxWOrd = collectMain.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
        Map.Entry<String, Long> minWord = collectMain.entrySet().stream().min(Map.Entry.comparingByValue()).orElse(null);

        System.out.println(maxWOrd + " max and min " + minWord);

    }

    private static void commonWord(String[] commonStr) {
        String prefix = Arrays.stream(commonStr)
                .reduce((s1, s2) -> {
                    int i = 0;
                    while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)) {
                        i++;
                    }
                    return s1.substring(0, i);
                })
                .orElse("");
    }

    private static void findOutVowels(String inputVowels) {
        Map<Character, Long> vowelCount = inputVowels.toLowerCase()
                .chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> "aeiou".indexOf(ch) != -1)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(vowelCount);
    }

    private static void checkAnagram(String str10, String str20) {
        String anagram1 = str10.replaceAll("\\s", "").toLowerCase();
        String anagram2 = str20.replaceAll("\\s", "").toLowerCase();

        boolean prgAnagram = anagram1.chars().sorted().boxed().collect(Collectors.toList())
                .equals(anagram2.chars().sorted().boxed().collect(Collectors.toList()));
        System.out.println(prgAnagram + " check the anangram");

        List<String> list4 = Arrays.asList("act", "tub", "god", "cat", "dog", "tac", "but");
        Collection<List<String>> result = list4.stream()
                .collect(Collectors.groupingBy(s -> {
                    char[] chars = s.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }))
                .values();

        System.out.println(result + " anagram check ");

    }

    private static void checkPalidrome(String s4) {
        String reverse = new StringBuilder(s4).reverse().toString();
        if(s4.equals(reverse)){
            System.out.println("its palidorme");
        }else {
            System.out.println("not palidrome");
        }
        List<String> rightStr = Arrays.asList("mission","nissan","tit","tat","oyo");

        String sy = rightStr.stream().filter(e -> e.equalsIgnoreCase(new StringBuilder(e).reverse().toString()))
                .findFirst().get();
        System.out.println(sy);
    }

    private static void findCommonDuplicate(String str1, String str2) {
        List<Character> duplicateOne = str1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> duplicateTwo = str2.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        List<Character> commonDuplicate = duplicateOne.stream().filter(duplicateTwo::contains).collect(Collectors.toList());
        List<String> duplicate = commonDuplicate.stream().sorted().map(String::valueOf).collect(Collectors.toList());
        System.out.println(duplicate + " print common duplicate");

    }
    

    private static void findFirstNonRepeatedChar(String nonRepeated) {

        String key = Arrays.stream(nonRepeated.split(""))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(v -> v.getValue() == 1).findFirst().get().getKey();
        System.out.println(key);
    }

    private static void primeNumber(int n) {

        for(int i =2; i <= n; i++){
            boolean isPrime = true;
            for (int j =2; j <= i/2; j++){
                if( i%j == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                System.out.println(i +" is prime");
            }
        }
    }


    private static void findSubString(String str) {
        int start =0; int end = 0; int max_lenght =0 ;  int max_Sustring =0;

        List<Character> list = new ArrayList<>();

        while (end < str.length()){

            char endChar = str.charAt(end);
            char startChar = str.charAt(start);

            if (!list.contains(endChar)){
                list.add(endChar);
                end++;
                if(list.size() > max_lenght){
                    max_lenght = list.size();
                    max_Sustring = start;
                }
             }
            else {
                list.remove(Character.valueOf(startChar));
                start++;
            }
         }
        String substring = str.substring(max_Sustring, max_Sustring + max_lenght);
        System.out.println(substring);
        System.out.println(max_lenght);
    }

    private static void rotateNumber(int[] w) {
        List<Integer> collect = Arrays.stream(w).boxed().collect(Collectors.toList());
        for(int i =0 ; i < 4; i++ ){
            Collections.rotate(collect , 1);
            System.out.println(collect.toString().replaceAll("[\\[\\]]","" + "rotate values "));
        }

    }
    
}
