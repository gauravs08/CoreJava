package com.Threads.WaitNotify;
/*INFO::
 * Thread.sleep()- 1)its a static method will always effect current thread even thought called like 
 * 						t.sleep() where t is a different thread; even then, it is the current thread that will sleep, not the t thread.
 * 				   2)Keeps the resource it has while sleep().
 * 
 * t.suspend() -    1) is deprecated. Using it is possible to halt a thread other than the current thread.
 * 					2) Keeps the resource it has while and since this state is not interruptable it is deadlock prone. 
 * 
 * object.wait()	1)Wait is called on a object, not a thread; we call this object the "lock object."
 * 					2)wait() allows thread to release the lock
 * 
 * */
class StackClass {

	private Object[] stackArray;
	private volatile int topOfStack;

	StackClass(int capacity) {
		stackArray = new Object[capacity];
		topOfStack = -1;
	}

	public synchronized Object pop() {
		System.out.println(Thread.currentThread() + ": popping");
		//to check is Stack is empty then it will wait() for pop
		while (isEmpty()) {
			try {
				System.out.println(Thread.currentThread() + ":Stack is Empty:: waiting to pop");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Object obj = stackArray[topOfStack];
		stackArray[topOfStack--] = null;
		System.out.println(Thread.currentThread() + ": notifying after pop "+obj);
		notify();
		return obj;
	}

	public synchronized void push(Object element) {
		System.out.println(Thread.currentThread() + ": pushing ");
		//to check is Stack is Full then it will wait() for pushing
		while (isFull()) {
			try {
				System.out.println(Thread.currentThread() + ":Stack is Full:: waiting to push");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		stackArray[++topOfStack] = element;
		System.out.println(Thread.currentThread() + ": notifying after push "+element );
		notify();
	}

	public boolean isFull() {
		return topOfStack >= stackArray.length - 1;
	}

	public boolean isEmpty() {
		return topOfStack < 0;
	}
}

