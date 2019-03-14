package com.Threads.ExtendsThread;

public class ThreadExample {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		System.out.println("Active Count ::"+Thread.activeCount() +" ::Returns the number of active threads in the current thread's thread group.");
		
		Thread thread0 = new Thread(new XThread(), "thread-0");
		Thread thread1 = new Thread(new XThread(), "thread-1");
		
		//	    The below 2 threads are assigned default names
		Thread thread2 = new XThread();
		Thread thread3 = new XThread();
		
		Thread thread5 = new XThread("thread-5");
		//Start the threads
		thread0.start();
		thread1.start();
		thread3.start();
		thread2.start();
		
		/*System.out.println("thread1 name : "+thread0.getName());
		System.out.println("thread2 name : "+thread1.getName());
		System.out.println("thread3 name : "+thread3.getName());
		System.out.println("thread4 name : "+thread4.getName());*/
		//thread3.run(); //if run() called directly  it will not create a separate thread .
		/*start method when called will create a new thread on the jvm,
		 *  whereas calling the run method will be like a normal method call i.e. no new thread will be created.*/
		
		//thread5.start();  // already started in Constructor XThread(String threadName) {...}
		try {
			System.out.println("Active Count ::"+Thread.activeCount() +" ::Returns the number of active threads in the current thread's thread group.");
	//The sleep() method is invoked on the main thread to cause a one second delay.
			System.out.println("Name::"+Thread.currentThread().getName()+" will sleep for 2 sec");
			
			Thread.currentThread().sleep(2000);
		
		} catch (InterruptedException e) {
		}
		//Display info about the main thread
		System.out.println(Thread.currentThread());
	}
}