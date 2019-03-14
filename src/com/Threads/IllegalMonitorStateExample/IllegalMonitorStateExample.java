package com.Threads.IllegalMonitorStateExample;

public class IllegalMonitorStateExample {

	/**
	 * This exception is thrown when you try to call wait()/notify()/notifyAll()
	 *  any of these methods for an Object from a point in your program
	 *  where u are NOT having a lock on that object.
	 *  (i.e. u r not executing any synchronized block/method of that object and
	 *   still trying to call wait()/notify()/notifyAll()) wait(), notify() and notifyAll() 
	 *   all throw IllegalMonitorStateException. 
	 *   Since This exception is a subclass of RuntimeException so we r not bound to catch it (although u may if u want to).
	 *  and being a RuntimeException this exception is not mentioned in the signature of wait(), notify(), notifyAll() methods.
	 */
	public static void main(String[] args) {
		    AnObject o = new AnObject();
		    Thread inc = new Thread(new IncrUser(o));
		    Thread dec = new Thread(new DecrUser(o));
		    inc.start();
		    dec.start();
		  }


}
