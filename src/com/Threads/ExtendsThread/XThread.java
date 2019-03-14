package com.Threads.ExtendsThread;

public class XThread extends Thread{
	XThread() {
		super();
		System.out.println(this.getName()+"[Default name Assigned]");
	}
	XThread(String threadName) {
		super(threadName); // Initialize thread.
		System.out.println(this.getName());
		start();
	}
	public void run() {
		//Display info about this particular thread
		//while(true){ //for infinite running of a thread means 100% CPU Utilization
		
		//setting thread1 priority to 8
		/*if(Thread.currentThread().getName().equals("Thread-3"))
			{//Thread.currentThread().setPriority(8);
			System.out.println("Thread-3 Name::"+Thread.currentThread().getName());}*/
		
		System.out.println(Thread.currentThread().getName() + " [In run()]");
		//}
	}

}
