package com.Threads.MultiThreadingEx;

public class MultiTClass extends Thread {

	private String msg;
	private Integer index;
	
	public MultiTClass(String msgStr) {
	this.msg= msgStr;
		
	}

	public void run() {
		
	for(index = 0; index<=10;index++){
		System.out.println(msg);
		try {
			currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}

}
