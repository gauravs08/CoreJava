package com.java.lang.reflect;
public class Person{
    public String name;
    private String phone;
  
    public Person(String name, String phone){
        this.name = name;
        this.phone = phone;
    }
  
    private void call(){
        System.out.println("Calling " + this.name +" at " + this.phone);
    }
  
    public String getName(){
        return name;
    }
}