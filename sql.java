java design pattern 
 Q) What do we need Design pattern
*   As Design Patterns are well documented and understood by software architects, designers and developers, then their application within a specific solution will likewise be well understood.
*   Patterns give a software developer an array of tried and tested solutions to common problems, thus reducing the technical risk to the project by not having to employ a new and untested design, thus saving time and effort during the implementation stage of the software development lifecycle
*   They are language neutral and so can be applied to any language that supports object-orientation.
*   By using well understood and documented solutions, the final product will have a much higher degree of comprehension. If the solution is easier to comprehend, then by extension, it will also be easier to maintain.

Q) What are the Creational Patterns?
*   Creational design patterns are related to the way of creating objects.
*   This pattern is used to define and describe how objects are created at class instantiation time
*   E.G.
*   Employee emp = new EmployeeO; here we are creating the instance using the new keyword.

Q) Categories Java Design patterns?
Creational patterns 
       |
Factory method
Abstract Factory
Builder
Prototype
Singleton


Q) What Is Factory Pattern? 
• In the Factory pattern, we don't expose the creation logic to the client and refer the created object using a standard interface.
• The Factory Pattern is also known as Virtual Constructor.
o. Steps：
1) create main class which call factory class.
• 2) Factory class returns required class instance

Main class → Factory class → Profession
                                                ↓
                              ┌─────────┴─────────┐
                      Engineer         Doctor         Teacher
Would you like to see a code implementation of this Factory Pattern in a specific programming language?




Q) What Is Abstract Factory Pattern?

This factory is also called as factory of factories.
Abstract Factory lets a class returns a factory of classes.
• So, this is the reason that Abstract Factory Pattern is one level higher than the Factory Pattern.
• An Abstract Factory Pattern is also known as Kit.
Steps:
1.    create main class which call factory of factory class.
2.    Factory of factory / factory Producer creates instance of factory class.
• 3) Factory class returns required class instance

Here is the text representation of the Abstract Factory Pattern diagram:
Main class
     ↓
AbstractFactoryProducer
     ↓
Abstract factory
     ├──────────────────────────────┐
Profession Abstract Factory     Trainee Profession Abstract Factory
     ↓                                                ↓
Profession                                  Profession
     ├──────────────┐                          ├──────────────┐
Engineer        Teacher          Trainee Engineer  Trainee Teacher

This diagram shows a more complex structure than the first one. Would you like to know the key differences between this Abstract Factory and the simple Factory pattern we looked at previously?





Q) What Is Singleton Design Pattern?
Two ways to create singleton design pattern
1. Eager load
2. Lazy load
Which I implemented the code eager load design pattern
Feature [1, 2, 3, 4, 5, 6, 7, 8]	Eager Loading	Lazy Loading
Analogy	Switching all lights on when entering a house.	Motion sensors turning lights on only in used rooms.
Startup	Slower (more work at start).	Faster (less work at start).
Resource Use	High (created even if unused).	Efficient (created on demand).
Thread Safety	Built-in by JVM.	Requires manual sync (e.g., Double-Checked Locking).
Singleton pattern is one of the simplest design patterns in Java.
*   This pattern involves a single class which is responsible to create an object while making sure that only single object gets created.
*   This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.



Q) What Is Prototype Design Pattern?
In real time application many times you called DATABASE CALLS VERY COSTLY , to resolve this we are using prototypes
*   Prototype pattern refers to creating duplicate object while keeping performance in mind.
*   It involves implementing a prototype interface which tells to create a clone of the current object.
*   This pattern is used when creation of object directly is costly. For example it requires data base calls or required too much of processing that will take a lot of memory.
*   What can be done ? : We can cache the object, returns its clone on next request
*   Steps:
*   1) create main class which call Cachelmpl Class.
*   2) Cachelmpl class has 2 methods : 1st to load the key value in map and create the cache. 2nd to return the required cloned object.
*   3) The main class , parent of all reuired concerete class contains cloning technique. Rest concrete class are normal POJOs, nothing special.



Q) What Is Builder Design Pattern?
*   Builder Pattern refers to approach that focuses on constructing a complex object from simple objects using step-by-step approach.
*   Major roles used in this design patterns are :
*   Complex Object / Final Product - e.g. house - complex object which we will generate with builder design pattern
*   Builder - abstract class / interface that defines all ways to create the product. It also has getFinalProduct method that will finally return complex object.
*   ConcreteBuilder - multiple Builder Impls that will give different final objects which are complex to design,
*   Director: Controls complex object creation. It has 2 main goals : 1st to call appropriate concrete builder class to create correct complex object. 2nd to return that complex object.

What Is Builder Design Pattern?
*   Steps: Create complex class POJO.
*   Create Builder Interface/ Abstract class which has definitions.
*   Create concrete Builder class that has implementations.
*   Create Director that will have responsibility to call correct concrete Builder and then return final object.
*   Create main class that will initialize Director, and call method of director finally which will in turn return complex object instance required.
/////////////////////////////////////////////////

 Docker cmd

 Learn Devops :Docker , Kubernates , Terraform and Azure Devops

Devops : 
Devops team brings  teams together business, development, operations 
Automation operation :  create template , provision server , install software, configuration  software, deploy app

Docker   :
What is Docker containerization ?
In a microservices architecture (for example, Java and Python services), managing different environments and configurations in a CI/CD pipeline can be complex and error-prone.
Docker containerization solves this problem by packaging each microservice along with its required dependencies into a Docker image.
Once the image is created, it can be deployed consistently across different environments without worrying about configuration differences.

Here’s a clean, correct, and professional version of your explanation:

Docker Compose Concept (Corrected Explanation):
In a microservices architecture, suppose we have 4 different microservices. To run them without Docker Compose, we usually need to open separate terminals for each service and start them individually. This approach becomes complex and difficult to manage as the number of services increases.
To simplify this process, we use Docker Compose. First, we install Docker Compose and then create a single YAML file (commonly named docker-compose.yml) where we define and configure all the microservices, including their images, ports, environment variables, and dependencies.
With Docker Compose, we can start all the microservices at once using a single command (docker-compose up) in one terminal. This makes the process much easier, organized, and efficient.

Here’s a simple and real-time docker-compose.yml example for 4 microservices + one database, along with the commands you need.

✅ Sample docker-compose.yml
version: '3.8'

services:

  service1:
    image: service1:latest
    container_name: service1
    ports:
      - "8081:8081"
    depends_on:
      - mysql
    environment:
      - SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/mydb
      - SPRING_DATASOURCE_USERNAME=root
      - SPRING_DATASOURCE_PASSWORD=root

  service2:
    image: service2:latest
    container_name: service2
    ports:
      - "8082:8082"
    depends_on:
      - mysql

  service3:
    image: service3:latest
    container_name: service3
    ports:
      - "8083:8083"

  service4:
    image: service4:latest
    container_name: service4
    ports:
      - "8084:8084"

  mysql:
    image: mysql:8
    container_name: mysql
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: mydb
    ports:
      - "3306:3306"

✅ Important Points
* Each microservice runs as a separate container
* depends_on ensures DB starts first
* All services are connected automatically in the same Docker network
* Use service name (mysql) as hostname inside containers

✅ Commands to Run
1. Build Docker Images (if not already built)
docker build -t service1 .
docker build -t service2 .
docker build -t service3 .
docker build -t service4 .

2. Start All Services
docker-compose up
👉 Run in background:
docker-compose up -d

3. Stop All Services
docker-compose down

4. View Running Containers
docker ps

✅ Interview Short Answer
Docker Compose allows us to define and run multiple microservices using a single YAML file. Instead of running each service manually in different terminals, we can start all services together using a single command like docker-compose up.

If you want next level 🚀 I can give:
* Spring Boot microservices with Eureka + API Gateway + MySQL (full real-time setup)
* Production-level Docker Compose (with networks, volumes, health checks)


# Run a Docker container with a Node.js hello world application
sperate termincal running the application 
docker run -p 5000:5000 in28min/hello-world-python:0.0.1.RELEASE
docker run -p 5000:5000 in28min/hello-world-java:0.0.1.RELEASE
docker run -p 5000:5000 in28min/hello-world-nodejs:0.0.1.RELEASE

# Run a Docker container with a Node.js hello world application
same  termincal running the application 
docker run  -p 5000:5000 in28min/hello-world-java:0.0.1.RELEASE
docker run  -p 5001:5000 in28min/hello-world-python:0.0.1.RELEASE
5001 - application 
5000 - docker containeraztion port 

 # Run a Docker container with a Node.js hello world application in detached mode (check the application logs provject wise and we get a id : 04e52ff9270f5810eefe1f77222852dc1461c22440d4ecd6228b5c38f09d838e)
docker run -d -p 5000:5000 in28min/hello-world-nodejs:0.0.1.RELEASE
docker run -d -p 5001:5000 in28min/hello-world-python:0.0.1.RELEASE


# View the logs of a Docker container
docker logs 04e52ff9270f5810eefe1f77222852dc1461c22440d4ecd6228b5c38f09d838e
# View the logs of a Docker container with a given container ID or name 
docker logs 04e5  or docker logs -f 04e5

# List Docker images
docker images

# List running containers
docker container ls

# List all containers, including stopped ones
docker container ls -a

# Stop a running container with a given container ID
docker container stop f708b7ee1a8b

# Search for Docker images in a registry
docker search mysql

# Show the history of a Docker image
docker image history in28min/hello-world-java:0.0.1.RELEASE

# Show the history of a Docker image with a given image ID
docker image history 100229ba687e

# Inspect a Docker image or we could see lot of details on docker images
docker image inspect 100229ba687e

# Remove a Docker image
docker image remove mysql

 --------- remove images -----
to remove image first we need to follow below steps

step 1:
# stop a Docker container with a given container ID or name
docker container stop  3e657ae9bd16

step 2 :
# Remove a Docker container with a given container ID or name
docker container rm 3e657ae9bd16

step 3 :
# Remove a Docker image with a given image name and tag
docker image remove in28min/hello-world-java:0.0.1.RELEASE

# delete all images data 
docker system prune -a --volumes

--------------- docker conatiner ---------------

# Pause a running container with a given container ID or name
docker container pause 832
pause mean if you refresh page ,we arent getting any response

# Unpause a paused container with a given container ID or name
docker container unpause 832

# Stop a running container with a given container ID or name
docker container stop 832

# Kill a running container with a given container ID or name
docker kill 763e1a00808e

#To check how many images are present and not only image info, other info like memory , container , local volumes , build caches
docker system df


#The below cmd purpose, how many container are present running & how many containers was stopped; exclude the running app remove stopped conatiner data from docker
docker system prune -a


#To build a project use cmd
step 1:
docker build -t dockerapp .

step 2:
docker run -p 8080:8080 dockerapp

Stop Existing App
🔹 Step 1: Find process using port 8080
lsof -i :8080

🔹 Step 2: Kill process
Mac/Linux:
kill -9 <PID>

------------- microservices -----------

# Run a Docker container with a currency conversion service, linked to the currency exchange service and environment variable set
docker run -d -p 8100:8100 --env CURRENCY_EXCHANGE_SERVICE_HOST=http://currency-exchange --name=currency-conversion --link currency-exchange in28min/currency-conversion:0.0.1-RELEASE



# Run a Docker container with a currency conversion service, linked to the currency exchange service and environment variable set
docker run -d -p 8100:8100 --env CURRENCY_EXCHANGE_SERVICE_HOST=http://currency-exchange --name=currency-conversion --link currency-exchange in28min/currency-conversion:0.0.1-RELEASE


# Run a Docker container with a currency exchange service, connected to the currency-network
docker run -d -p 8000:8000 --name=currency-exchange --network=currency-network in28min/currency-exchange:0.0.1-RELEASE

# Run a Docker container with a currency conversion service, connected to the currency-network and environment variable set
docker run -d -p 8100:8100 --env CURRENCY_EXCHANGE_SERVICE_HOST=http://currency-exchange --name=currency-conversion --network=currency-network in28min/currency-conversion:0.0.1-RELEASE


Feature	docker stop	docker kill
Primary Signal	SIGTERM (Request to exit)	SIGKILL (Forced termination)
Grace Period	10 seconds (default) before killing	None; immediate


AWS complete course :
Here’s a clear, interview-ready + real-time explanation of AWS IAM basics 👇

🔐 AWS Identity and Access Management (IAM)
👉 IAM =
IAM is a security service in AWS that helps you control who can access what resources.
👉 In simple words:
IAM = Authentication (who are you?) + Authorization (what can you do?)

👤 Users
👉 Users =
An IAM User represents one individual person or application.
Example:
* Rajesh (Developer)
* Anil (Tester)
* Payment Service (application)
Each user gets:
* Username
* Password (for login)
* Access Key (for APIs)

🔹 Real-Time Example
Imagine your company uses AWS:
User Name	Role	Access
Rajesh	Developer	Can deploy code
Anil	Tester	Can only view logs
Admin	Manager	Full access
👉 Each of these is an IAM User

👥 Groups
👉 Groups =
A Group is a collection of IAM Users.
👉 Instead of assigning permissions individually, you assign them to a group.

🔹 Example
You create groups like:
Group Name	Permissions
Developers	EC2, S3 full access
Testers	Read-only logs
Admins	Full access
Now:
* Add Rajesh → Developers group
* Add Anil → Testers group
👉 Automatically, they inherit permissions

🔥 Why Groups are Important
Without groups ❌
* You must assign permissions to each user manually
With groups ✅
* One change → applies to all users in that group

🎯 Easy Analogy (Very Important for Interviews)
Think of a Company Office 🏢
* IAM = Security system
* Users = Employees
* Groups = Departments
Department	Access
IT Team	Server access
HR Team	Employee data
Finance	Billing
👉 Employee joins IT → gets IT access automatically

🧠 Key Points to Remember
* IAM is global service (not region-specific)
* One user can belong to multiple groups
* Groups cannot contain other groups ❗
* Permissions are given using Policies (JSON rules)

🚀 Quick Summary
Concept	Meaning
IAM	Access control system
User	Individual identity
Group	Collection of users
Benefit	Easy permission management

//////////////////////////////////

 


SQl   interview questions
Here's a handy breakdown of essential SQL commands, grouped by their purpose. Whether you're just starting out or brushing up your skills, this list covers the core building blocks of SQL:

📦 Data Definition Language (DDL)
These commands define and manage database structure.
* CREATE TABLE – Creates a new table
* ALTER TABLE – Modifies an existing table
* DROP TABLE – Deletes a table
* TRUNCATE TABLE – Removes all rows from a table quickly

🧮 Data Manipulation Language (DML)
Used to manage data within tables.
* SELECT – Retrieves data from one or more tables
* INSERT INTO – Adds new rows to a table
* UPDATE – Modifies existing data
* DELETE – Removes rows from a table

🔍 Data Querying & Filtering
These help refine your queries.
* WHERE – Filters rows based on conditions
* ORDER BY – Sorts results
* GROUP BY – Groups rows for aggregation
* HAVING – Filters grouped data
* DISTINCT – Removes duplicate rows
* LIMIT / TOP – Restricts number of results

🔗 Joins & Relationships
Used to combine data from multiple tables.
* INNER JOIN – Returns matching rows from both tables
* LEFT JOIN – Returns all rows from the left table and matched rows from the right
* RIGHT JOIN – Opposite of LEFT JOIN
* FULL JOIN – Returns all rows when there's a match in either table

🧠 Logical & Comparison Operators
Used in conditions.
* AND, OR, NOT – Combine multiple conditions
* IN, BETWEEN, LIKE – Match specific patterns or ranges
* IS NULL – Checks for missing values

🛡️ Transaction Control
Used to manage changes safely.
* BEGIN TRANSACTION – Starts a transaction
* COMMIT – Saves changes
* ROLLBACK – Reverts changes
* SAVEPOINT – Sets a point to rollback to

🧰 Other Useful Commands
* AS – Renames columns or tables (aliasing)
* UNION / UNION ALL – Combines results from multiple queries
* EXISTS – Checks for existence of rows
* CASE – Implements conditional logic




How to fetch unique records from a table?
SELECT DISTINCT department FROM Employee;

Find second highest salary from Employee table. ?
 SELECT DISTINCT salary 
FROM Employee 
ORDER BY salary DESC 
LIMIT 1 OFFSET 1;

Find highest salary per department.
SELECT department, MAX(salary) 
FROM Employee 
GROUP BY department

Find min and max salary together.
SELECT MIN(salary), MAX(salary) FROM Employee;

Get count of employees in each department.
SELECT department, COUNT(*) 
FROM Employee 
GROUP BY department;


🧾 Table: Employee
EmpID	Name	DeptID	Salary
1	Alice	101	50000
2	Bob	102	60000
3	Charlie	101	55000
4	Diana	103	70000
5	Evan	NULL	45000

🏢 Table: Department
DeptID	DeptName
101	HR
102	IT
103	Finance
104	Marketing


Inner join :  select employees.name , employees.salary, department.name from employee e  inner join Department d  on where e.empid = d.deptid;

Name	DeptName	Salary
Alice	HR	50000
Bob	IT	60000
Charlie	HR	55000
Diana	Finance	70000

Left Join : select employees.name, employees.salary , department.name  from employees  e left join Department  d on where 	e.empid = d.deptid
Name	DeptName	Salary
Alice	HR	50000
Bob	IT	60000
Charlie	HR	55000
Diana	Finance	70000
Evan	NULL	45000

Right join : Select employees. name , employees.salary , department.name from employees e right join Department  d On where e.empid = d.deptid;

Name	DeptName	Salary
Alice	HR	50000
Charlie	HR	55000
Bob	IT	60000
Diana	Finance	70000
NULL	Marketing	NULL

Full join : Select employees.name , employees.salary , department.name from employees  e full join Department d On where e.empid = d.depid

Name	DeptName	Salary
Alice	HR	50000
Charlie	HR	55000
Bob	IT	60000
Diana	Finance	70000
Evan	NULL	45000
NULL	Marketing	NULL


Indexs : imagine there is users table , inside of millions of records stored in that student .  Our requirements we need to fetch record based on our requirements , to fetch table data faster can you use index
Indexs are three types 
1. Structure   
* Cluster 
* Non cluster
2.Storage
* Rowstore index
* Column store index
3. Functions
* Unique index
* Filtered index

Clustered index is assign asec order

Clustered Index in SQL
Definition: A clustered index determines the physical order of the rows in a table based on the indexed column(s). In other words, the data in the table is physically sorted on the indexed column(s), and there can be only one clustered index per table.
Syntax :
CREATE CLUSTERED INDEX index_name
ON table_name (column_name1,..);

CREATE CLUSTERED INDEX index_familyName(row name)
ON user (familyName);


Non clustered index
Non-Clustered Index in SQL
Definition: A non-clustered index creates a separate data structure that contains a sorted list of references to the rows in the table. Unlike clustered indexes, the data in the table remains unordered, and there can be multiple non-clustered indexes per table.

Syntax :
CREATE NONCLUSTERED INDEX index_name (row name)
ON table_name (column_name1, column_name2, ...);

CREATE NONCLUSTERED INDEX index_age
ON student (age);

Stored procedure :
All operations are included in that procedure is called Stored procedures like update , delete , insert 
SQL Server Stored Procedures
A stored procedure is a group of one or more pre-compiled SQL statements into a logical unit. It
is stored as an object inside the database server. It is a subroutine or a subprogram in the common computing language that has been created and stored in the database. Each procedure in SQL Server always contains a name, parameter lists, and Transact-SQL statements.
The SQL Database Server stores the stored procedures as named objects. We can invoke the
procedures by using triggers, other procedures, and applications such as Java, Python, PHP, etc. It can support almost all relational database systems.
SQL Server builds an execution plan when the stored procedure is called the first time and
stores them in the cache memory. The plan is reused by SQL Server in subsequent executions of the
stored procedure, allowing it to run quickly and efficiently.

Features of Stored Procedures in SQL Server
*  Reduced Traffic: A stored procedure reduces network traffic between the application and the database server, resulting in increased performance. It is because instead of sending several SQL statements, the application only needs to send the name of the stored procedure and its parameters.
*  Stronger Security: The procedure is always secure because it manages which processes and activities we can perform. It removes the need for permissions to be granted at the database object level and simplifies the security layers.
*  Reusable: Stored procedures are reusable. It reduces code inconsistency, prevents unnecessary rewrites of the same code, and makes the code transparent to all applications or users.
*  Easy Maintenance: The procedures are easier to maintain without restarting or deploying the application.
*  Improved Performance: Stored Procedure increases the application performance. Once we create the stored procedures and compile them the first time, it creates an execution plan reused for subsequent executions. The procedure is usually processed quicker because the query processor does not have to
create a new plan.

Types of Stored Procedures
1.    User-defined Stored Procedures
2.    System Stored Procedures
1. User-defined Stored Procedures
Database developers or database administrators build user-defined stored procedures. These
procedures provide one or more SQL statements for selecting, updating, or removing data from database tables. A stored procedure specified by the user accepts input parameters and returns output parameters. DDL and DML commands are used together in a user-defined procedure.
We can further divide this procedure into two types:
*  T-SQL Stored Procedures: Transact-SQL procedures are one of the most popular types of SQL Server procedures. It takes parameters and returns them. These procedures handle INSERT, UPDATE, and DELETE statements with or without parameters and output row data.
*  CLR Stored Procedures: The SQL Server procedures are a group of SQL commands, and the CLR indicates the common language runtime. CLR stored procedures are made up of the CLR and a stored procedure, which is written in a CLR-based language like VB.NET or C#. CLR procedures are .Net objects that run in the SQL
Server database's memory.

2. System Stored Procedures
The server's administrative tasks depend primarily on system stored procedures. When SQL Server is installed, it creates system procedures. The system stored procedures prevent the administrator from querying or modifying the system and database catalog tables directly. Developers often ignore system
stored procedures.
SQL Server Stored Procedures Syntax
CREATE PROCEDURE [schema_namel procedure_name
@parameter_name data_type,
@parameter_name data_type
AS
BEGIN
-  - SQL statements
-   SELECT, INSERT, UPDATE, or DELETE statement
END

Example of stored producer 
Select * from emp 
The employees table we have many rows age ,first name, last name, emp id, salary ,ocafication

We want to based on first name , last name, emp id

Select first name , last name, emp id from emo

The above select query your repeactly calling , better create stored producers

Create producer  EmpProdc
As
Begin
Select first name , last name, emp id from emo
END;
Once create stored producer name is EmpProdc ,we just run this EmpProdc in sql cmd .It will automatically get data

Differnce b/w view and stored producers
View is not stored data any where, it virtual table 
stored producers is stored the data 

Create procedure EmpPod
@emp_id Int,
@emp_gender varchar(50)
AS
Select first name , last name, emp id from emo
Where emp_id = @emp_id and @first_name and @last_name
END;

EXEC EmpPod 1, ‘MALE’


Triggers
Definition
*   Triggers are statements that are executed automatically in the order of occurrence of any event.
*   It is executed whenever there is any change or modification in database.
*   It will execute if any of the operations is performed in database. It might be -
* DML- Data Manipulation Language ( INSERT|UPDATE|DELETE ) DDL- Data Definition Language ( CREATE| ALTER|DROP ) LogOn - It is executed in order to occurrence of logOn Event

Real life Examples:
  A kid starts crying while seeing any emotional scene in a movie.
  A person starts running when he sees a lion chasing him.
Practical example in Database:
• Applying a trigger on database to send a confirmation mail to flight passengers.

Syntax Explanation
create trigger trigger_name - declare a trigger with name
before| after - It describes whether the trigger is executed before or after an ongoing event.
insert |update | delete - These are DML Operations.
on table_name - Trigger is applied on a particular table.
for each row - trigger is executed whenever there is any modification or change in row.
Trigger Body - Operations are performed when a trigger is executed.

Query :
create trigger flight 
before insert
on passenger
for each row 
set new.charges = new.charges - 2000


BUILT IN FUNCTIONS:
SQL Server provides a lot of functions, which can be used as calculated fields as part of column lists in a select statement. Such functions are called as Built-in Functions.
Types of Built-in Functions:
1.    Aggregate Functions
SELECT SUM (SALARY) as "Total Salary" from EMP

SELECT AVG (SALARY) as "Average Salary" from EMP

SELECT MIN (SALARY) as "MIN Salary" from EMP

SELECT COUNT (SALARY) as "No.of Emp" from EMP

1.    Numeric Functions
2.    Date and Time Functions
3.    String Functions.
