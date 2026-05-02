package com.emp.java8.DesignPattern.factory;

public class FactoryMainClass {
    public static void main(String[] args) {
        ProfessionFactory professionFactory = new ProfessionFactory();
        Profession doc = professionFactory.getProfession("Doctor");
        doc.print();

    }
}
