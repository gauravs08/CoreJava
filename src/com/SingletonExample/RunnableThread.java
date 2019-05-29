package com.SingletonExample;

 public class RunnableThread implements Runnable {

	Thread runner;
	public RunnableThread() {
	}
	
	public RunnableThread(String threadName) {
		runner = new Thread(this, threadName); // (1) Create a new thread.
		System.out.println(runner.getName());
		runner.start(); // (2) Start the thread.
	}
	
	@Override
	public void run() {
		//Display info about this particular thread
		System.out.println(Thread.currentThread());
		//SingletonExample instance = new SingletonExample(); this is invalid
		SingletonExample instance = SingletonExample.getInstance();
		System.out.println(instance);
		System.out.println(instance.i);
	}

}


