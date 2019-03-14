package com.Threads.GenpactQ;

public class RunnableExample {

	static draw d = null;
	public static void main(String[] args) {
		baseDraw  bt = new baseDraw();
		
		Thread thread1 = new Thread(d, "thread1");
		Thread thread2 = new Thread(d, "thread2");
		
		
		//Start the threads
		thread1.start();
		//thread1.start();
		thread2.start();
		
		try {
			//delay for one second
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
		}
		//Display info about the main thread
		System.out.println(Thread.currentThread());
	}
	
	
	
}

