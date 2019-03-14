package com.Threads.BlockingQueue;

/*
 * Read more: http://javarevisited.blogspot.com/2012/02/producer-consumer-design-pattern-with.html#ixzz2PUo5Z45e
 * */
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

	public class BlockingQueueProducerConsumerEx {

	    public static void main(String args[]){
	  
	     //Creating shared object
	     ArrayBlockingQueue arrayBQ = new ArrayBlockingQueue<Integer>(10);
	     BlockingQueue sharedQueue = new LinkedBlockingQueue();
	 
	     //Creating Producer and Consumer Thread
	     Thread prodThread = new Thread(new Producer(sharedQueue));
	     Thread consThread = new Thread(new Consumer(sharedQueue));

	     //Starting producer and Consumer thread
	     prodThread.start();
	     consThread.start();
	    }
	 
	}

	//Producer Class in java
	class Producer implements Runnable {

	    private final BlockingQueue sharedQueue;

	    public Producer(BlockingQueue sharedQueue) {
	        this.sharedQueue = sharedQueue;
	    }

	    @Override
	    public void run() {
	    	boolean bol = false;
	        for(int i=0; i<10; i++){
	            try {
	                System.out.println("Produced: " + i);
	                bol =  sharedQueue.offer(i);
	                System.out.println("while producing " + bol);
	            } catch(IllegalStateException e) {
	            	 Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, e);
	        }
	           
	    }

	}
	}
	//Consumer Class in Java
	class Consumer implements Runnable{

	    private final BlockingQueue sharedQueue;

	    public Consumer (BlockingQueue sharedQueue) {
	        this.sharedQueue = sharedQueue;
	    }
	  
	    @Override
	    public void run() {
	        while(true){
	            try {
	                System.out.println("Consumed: "+ sharedQueue.take());
	            } catch (InterruptedException ex) {
	                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	  
	  
	}


	