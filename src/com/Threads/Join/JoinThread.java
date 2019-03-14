package com.Threads.Join;

public class JoinThread extends Thread {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		Thread t1 = new Thread("T1");
		Thread t2 = new Thread("T2");
		t1.start();
		t2.start();
		while( t2.isAlive()||t1.isAlive()){
		try {
			System.out.println("Wait for the child threads to finish.");
			t1.join();
			if (!t1.isAlive())
				System.out.println("Thread T1 is not alive.");
			t2.join();
			if (!t2.isAlive())
				System.out.println("Thread T2 is not alive.");
		} catch (InterruptedException e) {
			System.out.println("Main Thread interrupted.");
		}
		}
		System.out.println(Thread.currentThread());
		System.out.println("Exit from Main Thread.");
	}

}
