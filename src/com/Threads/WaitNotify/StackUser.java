package com.Threads.WaitNotify;
import java.util.Random;


abstract class StackUser extends Thread {

	protected StackClass stack;
	StackUser(String threadName, StackClass stack) {
		super(threadName);
		this.stack = stack;
		System.out.println(this);
		setDaemon(true);
		start();
	}
}

class StackPopper extends StackUser { // Stack Popper

	StackPopper(String threadName, StackClass stack) {
		super(threadName, stack);
	}
	public void run() {
		while (true) {
			stack.pop();
		}
	}
}
class StackPusher extends StackUser { // Stack Pusher
	static String userName[] ={"RAM" ,"BOB","SAM"};
	Random r = new Random();
	
	StackPusher(String threadName, StackClass stack) {
		super(threadName, stack);
	}
	public void run() {
		while (true) {
			//stack.push(new Integer(1));
			stack.push(userName[r.nextInt(userName.length)]);
		}
	}
}