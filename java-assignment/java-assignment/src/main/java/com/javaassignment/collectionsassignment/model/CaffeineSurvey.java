package com.javaassignment.collectionsassignment.model;

import java.util.List;

public class CaffeineSurvey {
    public List<Caffeine> caffeeList;

    public List<Caffeine> sortByBrandName(){
        List<Caffeine> newCaffeineList = caffeeList;
        newCaffeineList.sort(new Sorting());
        System.out.println(newCaffeineList);
        return newCaffeineList;
    }

    public double getAvgPercentage(){
        float sum = 0f;
        int c = 0;
        for (Caffeine caffeine : caffeeList){
            sum+=caffeine.getCaffeinePercentage();
            c++;
        }
        double avg = (double) sum / c;
        System.out.println(avg);
        return avg;
    }

}
