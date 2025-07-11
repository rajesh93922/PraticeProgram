package com.lambdaExpression;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@FunctionalInterface
interface ArithmeticOperation {
double operate(double a, double b);
}

public class LambdaExpression {
    public static void main(String[] args) {

                           //Lambda expression assignments
        //1. Write an application to perform basic arithmetic operations like add,subtract, multiply & divide. You need to define a functional interface first.

        ArithmeticOperation add = (a, b) -> a + b;
        ArithmeticOperation subtract = (a, b) -> a - b;
        ArithmeticOperation multiply = (a, b) -> a * b;
        ArithmeticOperation divide = (a, b) -> a / b;

//        System.out.println("Add: " + add.operate(10, 5));
//        System.out.println("Subtract: " + subtract.operate(10, 5));
//        System.out.println("Multiply: " + multiply.operate(10, 5));
//        System.out.println("Divide: " + divide.operate(10, 5));


        //2. Write an application using lambda expressions to print Orders having 2 criteria implemented: 1) order price more than 10000 2) order status is ACCEPTED or COMPLETED.

        List<Order> orders = Arrays.asList(
                new Order(12000, "ACCEPTED"),
                new Order(8000, "PENDING"),
                new Order(15000, "COMPLETED"),
                new Order(5000, "REJECTED")
        );

        List<Order> orderPrice = orders.stream().filter(order -> order.getPrice() > 1000
                && (order.getStatus().equals("ACCEPTED") || order.getStatus().equals("COMPLETED")))
                .collect(Collectors.toList());
//          System.out.println(orderPrice);


        //3. Use the functional interfaces Supplier, Consumer, Predicate & Function to invoke built-in methods from Java API.

        Supplier<String> supplier = () -> "Hello from Supplier!";
        Consumer<String> consumer = s -> System.out.println("Consumed: " + s);
        Predicate<String> predicate = s -> s.length() > 5;
        Function<String, Integer> function = String::length;

        String value = supplier.get();
        consumer.accept(value);
//        System.out.println("Is length > 5? " + predicate.test(value));
//        System.out.println("Length: " + function.apply(value));



        //4. Remove the words that have odd lengths from the list. HINT: Use one of the new methods from JDK 8. Use removeIf() method from Collection interface.
        List<String> words = new ArrayList<>(Arrays.asList("Java", "Lambda", "Stream", "API"));
        words.removeIf(word -> word.length() % 2 != 0);
       // System.out.println(words); // Removes "Java" and "Stream"


        //5. Create a string that consists of the first letter of each word in the list of
        //Strings provided. HINT: Use Consumer interface & a StringBuilder to
        //construct the result.

        List<String> firstLetter = Arrays.asList("Java", "Lambda", "Stream");
        StringBuilder result = new StringBuilder();

        firstLetter.forEach(word -> result.append(word.charAt(0)));
       // System.out.println(result.toString()); // Output: "JLS"


        //6. Replace every word in the list with its upper case equivalent. Use
        //replaceAll() method & UnaryOperator interface.
        List<String> repalceUppcase = Arrays.asList("Java", "Lambda", "Stream");
        repalceUppcase.replaceAll(String::toUpperCase);
        System.out.println(repalceUppcase);



        //7. Convert every key-value pair of the map into a string and append them all
        //into a single string, in iteration order. HINT: Use Map.entrySet() method & a
        //StringBuilder to construct the result String.
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "Java");
        map.put(2, "Lambda");
        map.put(3, "Stream");
        System.out.println(map);

        StringBuilder singleString = new StringBuilder();
        map.entrySet().forEach(entry -> singleString.append(entry.getKey()).append("=").append(entry.getValue()).append(" "));

        //System.out.println(singleString.toString().trim()); // Output: "1=Java 2=Lambda 3=Stream"

        //8. Create a new thread that prints the numbers from the list. Use class Thread
        //& interface Consumer.

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Thread thread = new Thread(() -> {
            numbers.forEach(System.out::println);
        });
        thread.start();


    }
}
