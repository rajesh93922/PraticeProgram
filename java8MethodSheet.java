import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class java8MethodSheet {
    public static void main(String[] args) {
        List<Employee> allEmployees = EmployeeDataBase.getAllEmployees();
        // foreach concept
        // Old approaches
        for(Employee e : allEmployees){
           // System.out.println(e.getName());
        }
        //new Approaches
       // allEmployees.forEach(employee -> System.out.println(employee.getName()+"..."+ employee.getGender()));

        //filter
        List<Employee> empFromDevDeptsList = allEmployees.stream()
                .filter(e -> e.getDept().equals("Development") && e.getSalary()>80000)
                .collect(Collectors.toList());

        Set<Employee> empFromDevDeptsSet = allEmployees.stream()
                .filter(e -> e.getDept().equals("Development") && e.getSalary()>80000)
                .collect(Collectors.toSet());

        Map<Integer,String> empFromDevDeptsMap = allEmployees.stream()
                .filter(e -> e.getDept().equals("Development") && e.getSalary()>80000)
                .collect(Collectors.toMap(Employee::getId, Employee::getName));
        //Map
        //distinct
        List<String>deptsmap = allEmployees.stream()
                .map(Employee::getDept)
                .distinct().collect(Collectors.toList());

        List<Stream<String>>projectNames = allEmployees.stream()
                .map(e -> e.getProjects().stream()
                        .map(p -> p.getName())).collect(Collectors.toList());

        //System.out.println(projectNames);
        // FlatMap
        List<String>deptsflatmap = allEmployees.stream()
                .flatMap(e->e.getProjects().stream())
                .map(p->p.getName())
                .distinct().collect(Collectors.toList());
        //Sorted
        //Asc
        List<Employee>ascEmployee = allEmployees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
       // ascEmployee.forEach(System.out::println);

        //desc
        List<Employee>descEmployee = allEmployees.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Employee::getSalary)))
                .collect(Collectors.toList());
       // descEmployee.forEach(System.out::println);

        //Min && max
        Optional<Employee>highestEmp = allEmployees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));

        Optional<Employee>lowestEmp = allEmployees.stream()
                .min(Comparator.comparingDouble(Employee::getSalary));

        // groupingBy
        Map<String,List<Employee>> empGroup = allEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getGender));

        //Gender ->[Name]
        Map<String,List<String>> empGroupName = allEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.mapping(Employee::getName,Collectors.toList())));
        //Gender -> [count]
        Map<String,Long> empGroupCountMap = allEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.counting()));
        //findFirst
        Optional<Employee>findFirstElement = allEmployees.stream()
                .filter(e-> e.getDept().equals("Development")).findFirst();

        Employee findFirstElementThrow = allEmployees.stream()
                .filter(e-> e.getDept().equals("Development")).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Employee Not Found ..!"));
        //findAny
        Employee findAnyElement= allEmployees.stream()
                .filter(e-> e.getDept().equals("Development")).findAny()
                .orElseThrow(() -> new IllegalArgumentException("Employee Not Found ..!"));
      //  System.out.println("findAnyElement" + findAnyElement);

        //anyMatch , allMatch , noneMatch
        boolean developmentEmpAnyMatch = allEmployees.stream()
                .anyMatch(e->e.getDept().equals("Development"));
       // System.out.println("is there any match form deve dept"+developmentEmpAnyMatch);

        boolean developmentEmpAllMatch = allEmployees.stream()
                .allMatch(e->e.getSalary()>50000);
       // System.out.println("is there all match form deve dept"+developmentEmpAllMatch);

        boolean developmentEmpNonMatch = allEmployees.stream()
                .noneMatch(e->e.getDept().equals("HR"));
       // System.out.println("is there non match form deve dept"+developmentEmpNonMatch);

        //Limit(Long)
        List<Employee>topPaidEmployee = allEmployees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(4).collect(Collectors.toList());
      //  topPaidEmployee.forEach(e->System.out.println(e.getName()));

        //Skip
        List<Employee>skipEmployee = allEmployees.stream().skip(10).collect(Collectors.toList());

        Map<String, Stream<Employee>> eachDeptAndSalary = allEmployees.stream().collect(Collectors.groupingBy(Employee::getDept,
                Collectors.collectingAndThen(Collectors.toList(),
                        emp -> emp.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()))));

        eachDeptAndSalary.forEach((k,v) ->{
            System.out.println(k);
            System.out.println(v.collect(Collectors.toList()));
        });

    }
}