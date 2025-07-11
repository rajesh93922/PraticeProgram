package com.javaassignment.collectionsassignment.model;

import java.util.HashMap;
import java.util.Map;

public class WebPage {
    public Map<Integer, Map<Size,Content>> page = new HashMap<>();
    public Size totalArea;
    public int index;

    public WebPage(){}

    public WebPage(Size totalArea) {
        this.totalArea = totalArea;
    }

    public String addPage(Size size, Content content){

        if (size.getArea() > totalArea.getArea()){
            return "No space";
        }

        Map<Size,Content> map = new HashMap<>();
        if (canCompress(content)){
            map.put(size, content);
            page.put(compressSize(size), map);
            index++;
            return "Page added after compress";
        }

        if (!canCompress(content)){
            map.put(size, content);
            page.put(index, map);
            index++;
            return "Page added";
        }

        return null;
    }
    public boolean checkArea(Size size){
        if (totalArea.getArea() >= size.getArea()){
            return true;
        }
        return false;
    }
    public boolean canCompress(Content content){
        if (content.getText().length() > 100 && content.isImage()){
            return true;
        }
        return false;
    }
    public int compressSize(Size size){
        if (size.getArea() > 100){
            return size.getArea()*(int)0.75;
        }
        return size.getArea();
    }

    public Map<Integer, Map<Size, Content>> getPage() {
        return page;
    }

    public void setPage(Map<Integer, Map<Size, Content>> page) {
        this.page = page;
    }

    public Size getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Size totalArea) {
        this.totalArea = totalArea;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

