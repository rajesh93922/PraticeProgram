package com.streamAssignment.database;

import com.streamAssignment.Fruit;
import com.streamAssignment.News;
import com.streamAssignment.Trader;
import com.streamAssignment.Transaction;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAssignementDataBase {

    public static void main(String[] args) {
        List<Fruit> fruits = List.of(
                new Fruit("Apple", 95, 30, "Red"),
                new Fruit("Banana", 105, 20, "Yellow"),
                new Fruit("Orange", 62, 25, "Orange"),
                new Fruit("Strawberry", 33, 15, "Red"),
                new Fruit("Grapes", 67, 40, "Green"));

        List<News> newsList = List.of(
                new News(2, "Alice", "Bob", "Great budget insights!"),
                new News(2, "Charlie", "David", "Budget planning is key."),
                new News(2, "Alice", "Eve", "Loved the budget breakdown."),
                new News(3, "Frank", "Bob", "Interesting news."),
                new News(1, "Alice", "David", "Budget again!"),
                new News(2, "Charlie", "Eve", "Nice article."));


        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Delhi");
        Trader brian = new Trader("Brian", "Pune");


        List<Transaction> transactionsList = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        //1.Display the fruit names of low calories fruits i.e. calories < 100 sorted in descending order of calories

        List<Fruit> descendingCalories = fruits.stream()
                .filter(fruit -> fruit.getCalories() < 100)
                .sorted(Comparator.comparingInt(Fruit::getCalories).reversed())
                .collect(Collectors.toList());
       // System.out.println(descendingCalories+"descending order of calories  < 100 sorted");

        //2.isplay color wise list of fruit names
        Map<String, List<String>> colorWiseFruits = fruits.stream()
                .collect(Collectors.groupingBy(Fruit::getColor,
                        Collectors.mapping(Fruit::getName, Collectors.toList())));
        //System.out.println(colorWiseFruits);

        //3. Display only RED color fruits sorted as per their price in ascending order.
        List<Fruit> redColorPriceAscending = fruits.stream()
                .filter(fruit -> fruit.getName()
                .equalsIgnoreCase("Strawberry") || fruit.getName().equalsIgnoreCase("Apple"))
                .sorted(Comparator.comparingInt(Fruit::getPrice))
                .collect(Collectors.toList());
       // System.out.println(redColorPriceAscending);

        //   News Entity Assigments

        //4. Find out the newsId which has received maximum comments.
        Stream<News> maxNewsIdComments = newsList.stream().max(Comparator.comparingInt(News::getNewsId)).stream().findFirst().stream().skip(1);
        System.out.println(maxNewsIdComments);

        //5. Find out how many times the word 'budget' arrived in user comments all news.
        long budgetCount = newsList.stream().filter(news -> news.getComment().toLowerCase().contains("budget")).count();
       // System.out.println(budgetCount);

        //6. Find out which user has posted maximum comments.
        Map<String, Long> postedCommentCount = newsList.stream()
                .collect(Collectors.groupingBy(News::getPostedByUser,
                Collectors.mapping(News::getComment, Collectors.counting())));
        System.out.println(postedCommentCount + "   posted");

        //7. Display commentByUser wise number of comments.
        Map<String, Long> userCommentCount = newsList.stream()
                .collect(Collectors.groupingBy(News::getCommentByUser,
                        Collectors.mapping(News::getComment, Collectors.counting())));
      //  System.out.println(userCommentCount);

        //8. Find all transactions in the year 2011 and sort them by value (small to high).

        List<Transaction> sortedbyValue = transactionsList.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue)).collect(Collectors.toList());

        // 9. What are all the unique cities where the traders work?
        List<String> uniqueCities = transactionsList.stream()
                .map(t -> t.getTrader().getCity()).distinct()
                .collect(Collectors.toList());
       // System.out.println(uniqueCities);

        // 10. Find all traders from Pune and sort them by name.


        // 11. Return a string of all traders’ names sorted alphabetically.

        List<String> uniqueName = transactionsList.stream()
                .map(t -> t.getTrader().getName()).distinct()
                .collect(Collectors.toList());
       // System.out.println(uniqueName);

        // 12. Are any traders based in Indore?
        boolean indore = transactionsList.stream().anyMatch(t -> t.getTrader().equals("indore"));
       // System.out.println(indore);


        // 13. Print all transactions’ values from the traders living in Delhi.
        List<Integer>  allTransDelhiValue = transactionsList.stream()
                .filter(t -> t.getTrader().getCity().equals("Delhi"))
                .map(Transaction::getValue).collect(Collectors.toList());
        System.out.println(allTransDelhiValue);


        // 14. What’s the highest value of all the transactions?
        Transaction highestValueTrans = transactionsList.stream()
                .max(Comparator.comparingInt(Transaction::getValue)).get();
        System.out.println(highestValueTrans);

        // 15. Find the transaction with the smallest value
        Transaction lowestValueTrans = transactionsList.stream()
                .min(Comparator.comparingInt(Transaction::getValue)).get();
        System.out.println(lowestValueTrans);
        


    }
}
