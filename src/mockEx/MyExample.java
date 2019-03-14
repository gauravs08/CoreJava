package mockEx;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
 
/* Name of the class has to be "Main" only if the class is public. */
 
// Creates a thread pool and separate tasks to count 
// the length of each word passed in on the command line. 
 
 
public class MyExample {
 
  public static class MyWordLength implements Callable {
    private String word;
    public MyWordLength(String word) {
      this.word = word;
    }
    public Integer call() {
      return Integer.valueOf(word.length());
    }
  }
 
   static public void main(String args[]) throws Exception {
	  int i =-1; i=i>>>5;
	  System.out.println(i);
    ExecutorService pool = Executors.newFixedThreadPool(3);
    Set<Future<Integer>> set = 
        new HashSet<Future<Integer>>();
    for (String word: args) {
      Callable<Integer> xxx = new MyWordLength(word);
      Future<Integer> future = pool.submit(xxx);
      set.add(future);
    }
    int sum = 0;
    for (Future<Integer> future : set) {
      sum += future.get();
    }
    System.out.printf("The sum of lengths is %s%n", sum);
    System.exit(sum);
  }
}