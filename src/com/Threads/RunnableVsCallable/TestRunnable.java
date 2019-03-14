package com.Threads.RunnableVsCallable;

/*
A Callable needs to implement call() method while a Runnable needs to implement run() method.
A Callable can return a value but a Runnable cannot.
A Callable can throw checked exception but a Runnable cannot.
A Callable can be used with ExecutorService#invokeXXX methods but a Runnable cannot be.
 * 
 * 
` * 
1) Runnable interface is older than Callable, there from JDK 1.0, while Callable is added on Java 5.0.
2) Runnable interface has run() method to define task while Callable interface uses call() method for task definition.
3) run() method does not return any value, it's return type is void while call method returns value.
 Callable interface is a generic parameterized interface and Type of value is provided,
  when instance of Callable implementation is created.

4) Another difference on run and call method is that run method can not throw checked exception,
 while call method can throw checked exception in Java.*/
public class TestRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}


}
