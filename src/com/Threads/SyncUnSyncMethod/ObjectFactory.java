package com.Threads.SyncUnSyncMethod;
/*Q1 Can a thread call a non-synchronized instance method of an Object when a synchronized method is being executed ?
Yes, a Non synchronized method can always be called without any problem.
 In fact Java does not do any check for a non-synchronized method. 
 The Lock object check is performed only for synchronized methods/blocks. 
 The decision of declaring a method as synchronized has to be based on critical section access. 
 If your method does not access a critical section (shared resource or data structure) it need not be declared synchronized. 
 Below is the example which demonstrates this, 
 The Common Object class has two methods synchronizedMethod1() and method1() 
 MyThread class is calling both the methods in separate threads,
*/
/*Q2 Can two threads call two different synchronized instance methods of an Object?
No. If a object has synchronized instance methods then
 the Object itself is used a lock object for controlling the synchronization.
 Therefore all other instance methods need to wait until previous method call is completed.
  See the below sample code which demonstrate it very clearly.
   The Class Common has 2 methods called synchronizedMethod1()
    and synchronizedMethod2() MyThread class is calling both the methods
try all teh combinations both sync, both async , one sync other sync and one static sync and other only sync and both static sync.

*/
public class ObjectFactory {

	//public synchronized void syncMethod1() {
	public static synchronized void synchronizedMethod1() {
		System.out.println("synchronizedMethod1 called");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("synchronizedMethod1 done");
	}

	//	public   void synchronizedMethod2(){
	//	public   synchronized void synchronizedMethod2(){
		public static synchronized void synchronizedMethod2(){
		System.out.println("Method 2 called");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Method 2 done");
	}

}
