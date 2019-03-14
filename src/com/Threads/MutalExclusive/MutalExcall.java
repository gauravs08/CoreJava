package com.Threads.MutalExclusive;


public class MutalExcall {


	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		Thread thread1 = new Thread(new MutalExclusiveEx(), "thread1");
		Thread thread2 = new Thread(new MutalExclusiveEx(), "thread2");
		MutalExclusiveEx thread3 = new MutalExclusiveEx("thread3");
		//Start the threads
		thread1.start();
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
