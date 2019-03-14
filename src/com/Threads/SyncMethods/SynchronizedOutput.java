package com.Threads.SyncMethods;

public  class SynchronizedOutput  {

	// if the 'synchronized' keyword is removed, the message
		// is displayed in random fashion
		public static synchronized void displayList(String name, String list[]) {
			for (int i = 0; i < list.length; i++) {
				SyncMethodsExample t = (SyncMethodsExample) Thread.currentThread();
				t.randomWait();
				System.out.println(name + list[i]);
				
			}
		}

}

