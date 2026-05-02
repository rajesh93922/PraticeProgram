package com.emp.java8.DesignPattern.Singleton;

import com.emp.java8.DesignPattern.factory.Teacher;

public class MainClass {
    public static void main(String[] args) {
        SingeltonClass singeltonObject = SingeltonClass.getInstance();
        singeltonObject.simpleMethod();

        SingeltonClass singeltonObject2 = SingeltonClass.getInstance();
        singeltonObject2.simpleMethod();

        Teacher teacher = new Teacher();
        System.out.println(teacher);

        Teacher teacher2 = new Teacher();
        System.out.println(teacher2);
    }

}