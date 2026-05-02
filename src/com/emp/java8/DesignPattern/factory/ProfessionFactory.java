package com.emp.java8.DesignPattern.factory;

public class ProfessionFactory {
    public Profession getProfession(String typeOfProfession){
        if (typeOfProfession ==null){
            return null;
        }else if (typeOfProfession.equalsIgnoreCase("Doctor")){
            return new Doctor();
        }
        else if (typeOfProfession.equalsIgnoreCase("Teacher")){
            return new Teacher();
        }
        else if (typeOfProfession.equalsIgnoreCase("Engineering")){
            return new Engineering();
        }
        return null;
    }

}
