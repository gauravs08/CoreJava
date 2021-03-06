package com.Threads.SyncUnSyncMethod;

public class MyThread extends Thread {
	private int id = 0;
	private ObjectFactory common;

	public MyThread(String name, int no, ObjectFactory object) {
		super(name);
		common = object;
		id = no;
	}

	public void run() {
		System.out.println("Running Thread" + this.getName());
		try {
			if (id == 0) {
				common.synchronizedMethod1();
			} else {
				common.synchronizedMethod2();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ObjectFactory c = new ObjectFactory();
		MyThread t1 = new MyThread("MyThread-1", 0, c);
		MyThread t2 = new MyThread("MyThread-2", 1, c);
		t1.start();
		t2.start();
	}
}
