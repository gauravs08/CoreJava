package com.Threads.Deadlock;

public class DeadLockSituation implements Runnable{

public static synchronized void getMethod(){
	System.out.println("Getting lock");
	getMethod1();
}

public static synchronized void getMethod1(){
	System.out.println("Getting lock");
	getMethod();
}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t1 = new Thread(new DeadLockSituation());
		t1.start();
	}

	@Override
	public void run() {
		
		try {
			System.out.println("in run Method");
			getMethod();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
