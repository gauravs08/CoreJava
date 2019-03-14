package com.Threads.Deadlock;

public class deadlockExample extends Thread{
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new deadlockThread("Thread -1"));
		Thread t2 = new Thread(new deadlockThread("Thread -2"));
		
		t1.start();
		t1.start();
	}
}


class deadlockThread implements Runnable {

    public deadlockThread(String sharedQueue) {
        new Thread(sharedQueue);
    }

    @Override
    public void run() {
    	while(true){
    	method1();
    	method2();
    	}
}
	public void method1() {
		synchronized (String.class) {
			System.out.println("Acquired lock on String.class object");

			synchronized (Integer.class) {
				System.out.println("Acquired lock on Integer.class object");
			}
		}
		method2();
	}

	public void method2() {
		synchronized (Integer.class) {
			System.out.println("Acquired lock on Integer.class object");

			synchronized (String.class) {
				System.out.println("Acquired lock on String.class object");
			}
		}
		method1();
	}
}



class syncClass {
	
	synchronized static void  syncmethod1(){
		System.out.println("Acquired lock on String.class object");
	}
	synchronized static void  syncmethod2(){
		System.out.println("Acquired lock on String.class object");
	}
}