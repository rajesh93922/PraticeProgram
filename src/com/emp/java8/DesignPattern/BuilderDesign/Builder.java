package com.emp.java8.DesignPattern.BuilderDesign;


interface Builder {

    public void buildFloor();

    public void buildWalls();

    public void bulidTerrace();


    public Home getComplexHomeObject();

}
