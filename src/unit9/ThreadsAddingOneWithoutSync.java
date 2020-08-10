package unit9;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadsAddingOneWithoutSync {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(50); //Creates a pool of 50 threads
		AddOneTask task = new AddOneTask();
		
		for (int i = 0; i < 50; i++) {
			executor.execute(task); //Together, the 50 threads will complete the same task 50 times
		}	
		executor.shutdown(); 
	}
	
	private static class AddOneTask implements Runnable {
		private static int sum = 0;
		
		public void run() {
			//Add one and display to console
			System.out.println(Thread.currentThread().getName() + " is adding 1 to sum.");
			System.out.println("Sum is now " + ++sum + "."); 
		}
	}
	
	/* In the output of this program, you can see that there is often conflict between the threads. 
	 * Because a thread might start while another thread is running, this could cause the console to 
	 * display strange things. For example, it might display "sum is now 30" after "sum is now 31".
	 * The ending sum doesn't seem to be affected. */
}
