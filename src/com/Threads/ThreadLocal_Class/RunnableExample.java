package com.Threads.ThreadLocal_Class;

public class RunnableExample {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new SerialNum(), "thread1");
		Thread thread2 = new Thread(new SerialNum(), "thread2");
		//RunnableThread thread3 = new RunnableThread("thread3");
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