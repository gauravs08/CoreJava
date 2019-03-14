package com.ConcurrentAPI;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

	public static void main(String[] args) {
		for(int i=0 ; i<20 ;i++) {
			Thread t = new Thread(new RunnableThread(),"T"+i); 
			t.start();
		}
	}
}


class RunnableThread implements Runnable {

	Thread runner;
	public static final ConcurrentHashMap<Integer, String> concHM = new ConcurrentHashMap(2, .75f, 1);
	public RunnableThread() {
	}
	
	public RunnableThread(String threadName) {
		runner = new Thread(this, threadName); // (1) Create a new thread.
		System.out.println(runner.getName());
		runner.start(); // (2) Start the thread.
	}
	
	@Override
	public void run() {
		
		while(true) {
		try {
			concHM.put(1, "a");
			System.out.println(Thread.currentThread().getName() +" ::Write a");
		if(concHM.get(1)=="a")
		 System.out.println(Thread.currentThread().getName() +":: 1=" +concHM.get(1));
		 
			Thread.currentThread().sleep(1000);
		
		
		concHM.put(1, "b");
		System.out.println(Thread.currentThread().getName() +" :: Write b");
			if(concHM.get(1) == "b")
		System.out.println(Thread.currentThread().getName() +":: 2="+concHM.get(1));
		
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	}
}


