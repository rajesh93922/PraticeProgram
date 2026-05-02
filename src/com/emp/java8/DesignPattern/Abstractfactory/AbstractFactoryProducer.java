package com.emp.java8.DesignPattern.Abstractfactory;

// this is factory of factory , gives u factory instance which wil in turn give u required class object
public class AbstractFactoryProducer {

    public static AbstractFactory getProfession(boolean isTrainee) {
        if(isTrainee) {
            //return new TraineeProfessionAbstractFactory();
            return new ProfessionAbstractFactory();
        }
        else {
            //return new ProfessionAbstractFactory();
            return new TraineeProfessionAbstractFactory();
        }
    }

}