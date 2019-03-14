package com.Threads.MultiThreadingEx;

public class MultiThreadCaller {

	public static void main(String[] args) {
		
		MultiTClass t1 = new MultiTClass("Hello");
		MultiTClass t2 = new MultiTClass("World");
		t1.start();
		t2.start();
		
	}

}
