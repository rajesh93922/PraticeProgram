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
