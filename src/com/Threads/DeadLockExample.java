package com.Threads;

public class DeadLockExample {

	String o1 = "Lock ";
	String o2 = "Step ";
	Thread t1 = (new Thread("Printer1") {

		public void run() {
			
			while (true) {
				synchronized (o1) {
					synchronized (o2) {
						System.out.println(o1 + o2);
					}
				}
			}
		}
	});
	Thread t2 = (new Thread("Printer2") {

		public void run() {
			while (true) {
				synchronized (o2) {
					synchronized (o1) {
						System.out.println(o2 + o1);
					}
				}
			}
		}
	});
	public static void main(String[] args) {
		DeadLockExample dLock = new DeadLockExample();
		dLock.t1.start();
		dLock.t2.start();
		
		try {
			System.out.println("Wait for the child threads to finish.");
			dLock.t1.join();
			if (!dLock.t1.isAlive())
				System.out.println("Thread T1 is not alive.");
			dLock.t2.join();
			if (!dLock.t2.isAlive())
				System.out.println("Thread T2 is not alive.");
		} catch (InterruptedException e) {
			System.out.println("Main Thread interrupted.");
		}
		System.out.println("Exit from Main Thread.");
	}
}
