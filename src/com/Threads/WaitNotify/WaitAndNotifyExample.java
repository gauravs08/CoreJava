package com.Threads.WaitNotify;

public class WaitAndNotifyExample {

	public static void main(String[] args) {
		StackClass stack = new StackClass(3);
		new StackPusher("One", stack);
		new StackPusher("Two", stack);
		new StackPopper("Three", stack);
		//System.out.println("Main Thread sleeping.");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Exit from Main Thread.");
	}
}

