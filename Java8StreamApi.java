import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8StreamApi{

    record Car(String type , String make , String model, Integer engineCapacity){}

    public static void main(String[] args) {
           List<Car> cars = List.of(
                   new Car("sedan" , "BMW", "530",1998),
                   new Car("sedan", "AUDi", "A5" , 1998),
                   new Car("sedan", "mercedes", "E-class", 2500),
                   new Car("hatchBack" , "skoda", "Octavia", 1600),
                   new Car("hatchBack", "Toyata", "TypeR",1450)
           );
         // the above questions i written a code please correct if any mistake and provide me correct code



        //1. **Find the only hatchback in the list of cars.**
        List<Car> hatchBack = cars.stream().filter(e -> e.type.equalsIgnoreCase("hatchBack")).toList();
       // System.out.println("only hatchback" + hatchBack);

        //2. **Filter all cars with an engine capacity greater than 2000cc.**
        List<Car> engineCapacityGreaterthan = cars.stream().filter(e -> e.engineCapacity > 2000).toList();
       // System.out.println("engineCapacityGreaterthan" + engineCapacityGreaterthan);
        
        //3. **Find all cars that are of type "sedan" in the list.**
        List<Car> sedanAllCars = cars.stream().filter(e -> e.type.equalsIgnoreCase("sedan")).toList();
        //System.out.println("sedanAllCars" + sedanAllCars);

        //4. **Get the car with the highest engine capacity.**
        Optional<Car> highestEngineCapacity = cars.stream().max(Comparator.comparingInt(Car::engineCapacity));
      // System.out.println("highestEngineCapacity"+highestEngineCapacity);
        
        //5. **Count how many cars are of type "sedan."**
        Long countSedan = cars.stream().filter(e -> e.type.equalsIgnoreCase("sedan")).collect(Collectors.counting());
       // System.out.println("count" +  countSedan);
        
        //6. **Find all cars made by BMW.**
        List<Car> findBmw = cars.stream().filter(e -> e.make.equalsIgnoreCase("BMW")).toList();
      //  System.out.println("findBMWCar" + findBmw);

        //7. **Get a list of all car makes in uppercase.**
        List<String> allCarMake = cars.stream().map(Car::make).map(String::toUpperCase).toList();
       // System.out.println("allCarMake" + allCarMake);

        //8. **Check if there is any car in the list with a capacity less than 1500cc.**
        Car capacityLessThan1500cc = cars.stream().filter(e -> e.engineCapacity < 1500).findAny()
                .orElseThrow(() -> new IllegalArgumentException("Not avaliable 1500 ..."));
       // System.out.println("capacityLessThan1500cc" + capacityLessThan1500cc);

        //9. **Sort the cars by engine capacity in descending order.**
        List<Integer> descendingEngineCapacity = cars.stream().map(Car::engineCapacity).
                sorted(Comparator.reverseOrder()).collect(Collectors.toList());
       // System.out.println("descendingEngineCapacity" + descendingEngineCapacity);
        
        //10. **Find the first car made by Toyota.**
        List<Car> findToyata = cars.stream().filter(e -> e.make.equalsIgnoreCase("Toyata")).collect(Collectors.toList());
       // System.out.println("findToyata" + findToyata);

        //11. **Group the cars by their type (e.g., sedan, hatchback).**
        List<Car> groupSedanAndHatchBack = cars.stream().filter(e -> e.type.equalsIgnoreCase("sedan")
                || e.type.equalsIgnoreCase("hatchBack")).collect(Collectors.toList());
       // System.out.println("groupSedanAndHatchBack " + groupSedanAndHatchBack);
        
        //12. **Get a list of all unique car makes.**
        List<String> allUniqueCarMakes = cars.stream().map(Car::make).distinct().collect(Collectors.toList());
        //System.out.println("allUniqueCarMakes" + allUniqueCarMakes);

        //13. **Find all cars with an engine capacity less than 2000cc.**
        List<Car> capacityLessThan2000cc = cars.stream().filter(e -> e.engineCapacity < 2000).collect(Collectors.toList());
       // System.out.println("capacityLessThan2000cc" + capacityLessThan2000cc);

        //14. **Calculate the average engine capacity of all cars in the list.**
        OptionalDouble averageEngineCapacity = cars.stream().mapToInt(Car::engineCapacity).average();
      //  System.out.println("averageEngineCapacity" + averageEngineCapacity);

        //15. **Find the car with the smallest engine capacity.**
        Optional<Car> smallestEngineCapacity = cars.stream().min(Comparator.comparingInt(Car::engineCapacity));
       // System.out.println("smallestEngineCapacity " + smallestEngineCapacity);

        //16. **List all cars where the make starts with 'B'.**
        List<Car> StartWithB = cars.stream().filter(e -> e.make.startsWith("B")).collect(Collectors.toList());
       // System.out.println("StartWithB" + StartWithB);

        //17. **Filter all cars made by "Mercedes" and have an engine capacity over 2500cc.**
        List<Car> mercedesAndEngine = cars.stream().filter(e -> e.make.equalsIgnoreCase("Mercedes")
                && e.engineCapacity > 2500).collect(Collectors.toList());

        mercedesAndEngine.forEach(car -> System.out.println(car));
       // System.out.println("mercedesAndEngine  " + mercedesAndEngine);

        //18. **Check if all cars are sedans.**
        boolean checkIfSedan = cars.stream().allMatch(e -> e.type.equalsIgnoreCase("sedan"));
       // System.out.println("checkIfSedan " + checkIfSedan);

        //19. **Find the car with the longest model name.**
        List<String> longestModelName = cars.stream().map(Car::model)
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).stream().collect(Collectors.toList());
        //System.out.println("LongestModelName " + longestModelName);

        //20. **Sort the cars alphabetically by their model names.**
        List<String> alphabeticallyOrderModel = cars.stream().map(Car::model).sorted().collect(Collectors.toList());
       // System.out.println("alphabeticallyOrderModel " + alphabeticallyOrderModel);

        //21. **Find if there is any car of type "hatchback" with an engine capacity greater than 1500cc.**
        boolean hatchbackAndEngine = cars.stream()
                .anyMatch(car -> car.type().equalsIgnoreCase("hatchBack") && car.engineCapacity() > 1500);

       // System.out.println("hatchbackAndEngine " + hatchbackAndEngine);

        //22. **Get the total sum of engine capacities of all cars.**
        int sumEngineCapa = cars.stream().mapToInt(Car::engineCapacity).sum();
       // System.out.println("sumEngineCapa " + sumEngineCapa);

        //23. **Find all cars where the model name contains the letter "A."**
        List<Car> modelLetterA = cars.stream().filter(e -> e.model.contains("A")).collect(Collectors.toList());
       // System.out.println("modelLetterA " + modelLetterA);
        
        //24. **Remove all cars of type "sedan" from the list.**

     /*   List<Car> toRemoveSedan  = new ArrayList<>();
        for(Car carss : cars){
            if(carss.type.equalsIgnoreCase("sedan")){
                toRemoveSedan.add(carss);
            }
        }
        cars.removeAll(toRemoveSedan);
      //  System.out.println(cars);
        // java to java8
      cars = cars.stream()
                .filter(car -> !car.type().equalsIgnoreCase("sedan"))  // Keep only cars that are not of type "sedan"
                .collect(Collectors.toList());  // Collect the filtered results back into a list
                
      */


        //25. **Get the car with the second highest engine capacity.**
        List<Car> sortedSecondHighestEng1 = cars.stream().sorted(Comparator.comparingInt(Car::engineCapacity).reversed())
                .skip(1).findFirst().stream().collect(Collectors.toList());
        Optional<Integer> sortedSecondHighestEng = cars.stream().map(Car::engineCapacity).sorted(Comparator.reverseOrder())
                .skip(1).findFirst();
       // System.out.println("sortedSecondHighestEng" + sortedSecondHighestEng);

        //26. **Find all cars whose make ends with "a."**
        List<Car> endWithA = cars.stream().filter(e -> e.make.endsWith("a")).collect(Collectors.toList());
       // System.out.println("endWithA" + endWithA);

        //27. **List all cars sorted by their make in ascending order.**
        List<String> ascedingOrderMake = cars.stream().map(Car::make).sorted().collect(Collectors.toList());
        //System.out.println("ascedingOrderMake " +ascedingOrderMake);

        //28. **Get a map of car types to lists of cars.**
        List<String> listofTypes = cars.stream().map(Car::type).collect(Collectors.toList());
       // System.out.println("listofTypes " + listofTypes);

        //29. **Find the average engine capacity of hatchback cars only.**
        OptionalDouble OnlyHatchCapAverage = cars.stream().filter(e -> e.type.equals("hatchBack")).mapToInt(Car::engineCapacity).average();
        if(OnlyHatchCapAverage.isPresent()) {
            //System.out.println("OnlyHatchCapAverage" + OnlyHatchCapAverage);
        }
        else {
           // System.out.println("OnlyHatchCapAverage Not found" );

        }


        //30. **Check if there is a car with an engine capacity exactly equal to 1998cc.**
        List<Car> exactEqualCap = cars.stream().filter(e -> e.engineCapacity.equals(1998)).collect(Collectors.toList());
       // System.out.println("exactEqualCap" + exactEqualCap);

        //31. **Create a list of all car models that are from "Audi" and "BMW" only.**
        List<String> allModelAudiBMW = cars.stream().filter(e -> e.make.equalsIgnoreCase("AUDi")
                || e.make.equalsIgnoreCase("BMW")).map(car ->  car.model).collect(Collectors.toList());
        //System.out.println("allModelAudiBMW "  + allModelAudiBMW);

        //32. **Find the make of the car with the longest engine capacity.**
        //Answwer 4th

        //33. **Get a list of all "sedan" cars, sorted by their model names.**
        List<Car> allSedanSortByModel = cars.stream().filter(e -> e.type.equalsIgnoreCase("sedan"))
                .sorted(Comparator.comparing(Car::model)).collect(Collectors.toList());
       // System.out.println("allSedanSortByModel"  + allSedanSortByModel);

        //34. **Find if there is a car whose model name is exactly "A5."**
       // 35. **Create a map of car types to the count of cars of each type.**
        Map<String, Long> eachCarTypeCount = cars.stream().map(Car::type).map(String::toUpperCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
       // System.out.println("eachCarTypeCount  " + eachCarTypeCount);
        
        //36. **Get a list of all cars with an engine capacity between 1500 and 2000cc:**
        //    `[530, A5, Octavia]`
        List<String> capacityBetween = cars.stream().filter(e-> e.engineCapacity > 1500 && e.engineCapacity <2000)
                .map(Car::model).collect(Collectors.toList());
       // System.out.println("capacityBetween  " + capacityBetween);

        //37. **Find the first car of type "hatchback":**
        //    `Octavia`
        List<String> firstCarHatchBack1 = cars.stream().filter(e -> e.type.equalsIgnoreCase("hatchBack"))
                .map(Car::model).findFirst().stream().toList();
      //  System.out.println("firstCarHatchBack1  " + firstCarHatchBack1);


        //38. **Group the cars by their engine capacity ranges (e.g., less than 1500cc, 1500-2000cc, etc.):**
         //`{<1500cc=[TypeR], 1500-2000cc=[Octavia, A5, 530], >2000cc=[E-class]}`

        Map<String, List<String>> groupByEngCapEachModel = cars.stream().collect(Collectors.groupingBy(
                car -> {
                    if (car.engineCapacity < 1500)
                        return "<1500CC";
                    else if (car.engineCapacity <= 2000)
                        return "1500 - 2000CC";
                    else return ">2000CC";
                },
                Collectors.mapping(Car::model, Collectors.toList())
        ));
        //System.out.println("groupByEngCapEachModel ...!" + groupByEngCapEachModel);

        Map<String, List<String>> grpCarByMakeandListModel = cars.stream().collect(Collectors.groupingBy(Car::make,
                Collectors.mapping(Car::model, Collectors.toList())));
       // System.out.println("grpCarByMakeandListModel....." + grpCarByMakeandListModel);
        
        
        //List all unique car types
        List<String> uniqueCar = cars.stream().map(Car::type).distinct().collect(Collectors.toList());
        //System.out.println("uniqueCar..." + uniqueCar);

        Map<Boolean, List<Car>> partitSedan = cars.stream().collect(Collectors.partitioningBy(car -> car.type.equals("sedan")));
        //System.out.println(partitSedan);

        //49. **Return the list of all cars whose make is not "BMW":** `[A5, E-class, Octavia, TypeR]`
        List<String> notBMW = cars.stream().filter(e -> e.make != "BMW").map(Car::model).collect(Collectors.toList());
       // System.out.println("notBMW ......!" + notBMW);

        //39. **List all car makes in the list and display the car count for each make in descending order:**
        // `[BMW: 1, AUDi: 1, mercedes: 1, skoda: 1, Toyata: 1]`
        Map<String, Long> countEachMake = cars.stream().map(Car::make).sorted().collect(Collectors
                .groupingBy(Function.identity(), Collectors.counting()));
       // System.out.println("countEachMake ....!" + countEachMake);



    }
}
