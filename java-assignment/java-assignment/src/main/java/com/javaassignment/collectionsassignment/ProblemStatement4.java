package com.javaassignment.collectionsassignment;

import com.javaassignment.collectionsassignment.model.Content;
import com.javaassignment.collectionsassignment.model.Size;
import com.javaassignment.collectionsassignment.model.WebPage;

public class ProblemStatement4 {
    public static void main(String[] args) {

        Size totalArea = new Size(150);
        Size size = new Size(20);
        Content content = new Content("Hi web", false);
        WebPage webPage = new WebPage(totalArea);
        String msg = webPage.addPage(size, content);
        System.out.println(msg);
        Content content1 = new Content("Hi WebHi WebHi WebHi WebHi WebHi WebHi WebHi WebHi WebHi WebHi WebHi WebHi WebHi WebHi webHi webHi webHi web",
                true);
        String msg1 = webPage.addPage(size, content1);
        System.out.println(msg1);

    }
}
