package com.javaassignment.collectionassignment;

import com.javaassignment.collectionsassignment.CaffeineSurveyTask;
import com.javaassignment.collectionsassignment.ProblemStatement4;
import com.javaassignment.collectionsassignment.model.Content;
import com.javaassignment.collectionsassignment.model.Size;
import com.javaassignment.collectionsassignment.model.WebPage;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ProblemStatement4Test {

    WebPage webPage = new WebPage();

    @Test
    void testMainMethod(){
        ProblemStatement4.main(new String[]{});
    }
    @Test
    void webPageTest(){
        Size size = new Size();
        size.setArea(2);
        WebPage webPage1 = new WebPage(size);
        webPage1.checkArea(size);
        webPage1.setPage(Map.of(1, Map.of(size, new Content())));
        webPage1.setTotalArea(size);
        webPage1.getTotalArea();
        webPage1.setIndex(1);
        webPage1.getIndex();
    }
}
