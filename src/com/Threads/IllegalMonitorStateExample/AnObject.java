package com.Threads.IllegalMonitorStateExample;

//An Object class 
class AnObject {
	int myNum = 0;
	int maxCapacity =2;
	synchronized void incr() throws InterruptedException {
		if (myNum == maxCapacity ) {
			System.out.println("ready to incr but muNum is MaxCapacity +++++++++++++++");
			wait();
		}
		myNum++;
		print("produced : ");
		notify();
	}

	synchronized void decr() throws InterruptedException {
		if (myNum == 0) {
			System.out.println("ready to decr but myNum is Zero ----------");
			wait();
		}
		myNum--;
		print("consumed : ");
		notify();
	}

	void print(String s) {
		System.out.println(s + "  " + myNum);
	}

}

// an Increment Class 
class IncrUser implements Runnable {
	AnObject a;

	IncrUser() {
	}

	IncrUser(AnObject a) {
		this.a = a;
	}

	public void run() {
		while (true) {
			try {
				a.wait(); //IllegalMonitorState Exception remove comments
				a.incr();
				Thread.sleep(500);
				 //a.notify(); //IllegalMonitorState Exception remove comments
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

		}
	}
}

//a Decrement Class
class DecrUser implements Runnable {
	AnObject a;

	DecrUser() {
	}

	DecrUser(AnObject a) {
		this.a = a;
	}

	public void run() {
		while (true) {
			try {
				a.decr();
				Thread.sleep(600);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}
