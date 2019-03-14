package com.java.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReflectionTest {
	//Read more: https://javarevisited.blogspot.com/2012/05/how-to-access-private-field-and-method.html#ixzz5NC7x8e1D

    public static void main(String args[]) throws ClassNotFoundException {
      
        Class<Person> person = (Class<Person>) Class.forName("com.java.lang.reflect.Person");
      
        //getFields() does not return private field
        System.out.println("Fields : " + Arrays.toString(person.getFields()));
      
        //getDeclaredFields() return both private and non private fields using reflection
        System.out.println("Declared Fields : " + Arrays.toString(person.getDeclaredFields()));       
            
        //getDeclaredMethods() return both private and non private methods using reflection
        System.out.println("Declared methods : " + Arrays.toString(person.getDeclaredMethods()));
      
        try {
          
            //accessing value of private field using reflection in Java
            Person privateRyan = new Person("John" , "8989736353");
            Field privateField = person.getDeclaredField("phone");

            //this call allows private fields to be accessed via reflection
            privateField.setAccessible(true);
          
            //getting value of private field using reflection
            String value = (String) privateField.get(privateRyan);           
          
            //print value of private field using reflection
            System.out.println("private field: " + privateField + " value: " + value);
          
          
            //accessing private method using reflection
            Method privateMethod = person.getDeclaredMethod("call");
          
            //making private method accessible using reflection
            privateMethod.setAccessible(true);
          
            //calling private method using reflection in java
            privateMethod.invoke(privateRyan);
          
          
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(ReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ReflectionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
    }
}



