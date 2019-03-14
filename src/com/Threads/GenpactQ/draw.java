package com.Threads.GenpactQ;

 class draw implements Runnable {

	public void display() {
		System.out.println("display");
	}

	@Override
	public void run() {
		
		
			draw d = new draw();
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				d.display();
			
	}
	
}

 class baseDraw implements Runnable{

	public void display() {
		System.out.println("display");
	}

	@Override
	public void run() {
		display();
		try {
			Thread.currentThread().sleep(3000);
			if(Thread.currentThread().getName()=="thread1") {
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
class thread1 implements Runnable {
	
@Override
public void run() {
	draw d1 = new draw();
	d1.display();
	
	
}
}

class thread2 implements Runnable {
	

@Override
public void run() {
	draw d2 = new draw();
	d2.display();
	
}
}