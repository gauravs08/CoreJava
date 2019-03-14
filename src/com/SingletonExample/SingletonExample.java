package com.SingletonExample;

import java.lang.reflect.Constructor;

public class SingletonExample {
	//Note: Singleton Instance is declared as volatile variable to ensure * every thread see updated value for _instance.
	
	//volatile keyword in Java guarantees that value of the volatile variable will always be read from main memory and not from Thread's local cache.

	//Read more: https://javarevisited.blogspot.com/2011/06/volatile-keyword-java-example-tutorial.html#ixzz5NBrauYK9
	
	/*
	 * If we do not make the _instance variable volatile than the Thread which is 
	 * creating instance of Singleton is not able to communicate other thread, 
	 * that instance has been created until it comes out of the Singleton block, 
	 * so if Thread A is creating Singleton instance and just after creation lost the CPU,
	 *  all other thread will not be able to see value of _instance as not null and they will believe its still null.

	 * */
	
	
	private static volatile SingletonExample _instance = null;

	private SingletonExample() {
	}

	public static synchronized SingletonExample getInstance() {

		if (_instance == null) {
			synchronized (SingletonExample.class) {
				//double checked locking - because second check of Singleton instance with lock
				if (_instance == null) {
					_instance = new SingletonExample();
				}
			}
		}
		return _instance;
	}

	public static void main(String[] args) {

		SingletonExample SingObj = new SingletonExample();
		System.out.println(SingObj.getInstance());
		

	}

	
	//Note: examples of singleton class is 
	//Read more: https://javarevisited.blogspot.com/2011/03/10-interview-questions-on-singleton.html#ixzz5NBpoWzKE 
	//1) java.lang.runtime which provide getRuntime() since on whole java application only one runtime environment can be possible making Runtime
	//2) Popup in GUI application, if you want to show popup with message you can have one PopUp class on whole GUI application and anytime just get its instance, and call show() with message.

	
	

}
