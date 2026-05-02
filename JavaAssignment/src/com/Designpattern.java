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
