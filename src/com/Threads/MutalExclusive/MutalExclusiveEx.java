package com.Threads.MutalExclusive;

public class MutalExclusiveEx implements Runnable {

	 public static final Object obj = new Object();
	     int count = 0;  // unsigned global int
	     int next  = 0;  // unsigned global int

	     Thread runner;
	 	public MutalExclusiveEx() {
	 		super();
	 	}
	 	
	 	public MutalExclusiveEx(String threadName) {
	 		runner = new Thread(this, threadName); // (1) Create a new thread.
	 		//System.out.println(runner.getName());
	 		runner.start(); // (2) Start the thread.
	 	}

		public void doSomething() {
	       int my_number;  // my ticket number

	       // the critical section is small. Just pick your ticket number. Guarantee FIFO
	       synchronized (obj) { my_number = count ++; } 

	       // busy waiting
	       while (next != my_number);
	       System.out.println(Thread.currentThread() +"::"+ next +"::" + my_number);
	       // mutual exclusion

	       next++;  // only one thread will modify this global variable
	    }

		@Override
		public void run() {
				doSomething();
		}
}

