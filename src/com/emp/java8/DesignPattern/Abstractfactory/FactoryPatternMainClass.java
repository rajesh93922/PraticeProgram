package com.emp.java8.DesignPattern.Abstractfactory;

import java.util.Optional;

public class FactoryPatternMainClass {

    public static void main(String[] args) {
        AbstractFactory abstractFactory =AbstractFactoryProducer.getProfession(true);
        Profession engg = abstractFactory.getProfession("Engineer");
        engg.print();
    }

}