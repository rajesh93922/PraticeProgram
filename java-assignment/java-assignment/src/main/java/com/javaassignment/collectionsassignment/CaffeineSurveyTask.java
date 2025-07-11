package com.javaassignment.collectionsassignment;

import com.javaassignment.collectionsassignment.model.Caffeine;
import com.javaassignment.collectionsassignment.model.CaffeineSurvey;

import java.util.ArrayList;
import java.util.List;

public class CaffeineSurveyTask {
    public static void main(String[] args) {

        List<Caffeine> caffeineList = new ArrayList<>();
        caffeineList.add(new Caffeine("NesCafe", 69.2f));
        caffeineList.add(new Caffeine("CarteNoir", 54.5f));

        CaffeineSurvey caffeineSurvey = new CaffeineSurvey();
        caffeineSurvey.caffeeList = caffeineList;

        caffeineSurvey.sortByBrandName();
        caffeineSurvey.getAvgPercentage();

    }
}
