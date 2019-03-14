package com.Threads.ThreadLocal_Class;

public class SerialNum implements Runnable{

	/**
	 * INFO::ThreadLocal()
	 *  •	A thread-local variable effectively provides a separate copy of its value for each thread that uses it.
		•	ThreadLocal instances are typically private static fields in classes that wish to associate state with a thread
		•	In case when multiple threads access a ThreadLocal instance, separate copy of Threadlocal variable is maintained for each thread.

	 * 
	 * methods::
	 *   Object	get() -- Returns the value in the current thread's copy of this thread-local variable.
		protected  Object	initialValue() -- Returns the current thread's initial value for this thread-local variable.
 		void	set(Object value) --          Sets the current thread's copy of this thread-local variable to the specified value.
	 */
	
	 private static int nextSerialNum = 0;
	 
     private static ThreadLocal serialNum = new ThreadLocal() {
         protected synchronized Object initialValue() {
             return new Integer(nextSerialNum++);
         }
     };
 
     public static int get() {
         return ((Integer) (serialNum.get())).intValue();
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public void run() {
		while(true){
		System.out.println(Thread.currentThread());
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread is running::"+get());
		}
	}

}
