package unit9;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadsAddingOneWithSync {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(50);
		AddOneTask task = new AddOneTask();
		
		for (int i = 0; i < 50; i++) {
			executor.execute(task);
		}	
		executor.shutdown();
	}
	
	private static class AddOneTask implements Runnable {
		private static int sum = 0;
		
		public synchronized void run() {
			System.out.println(Thread.currentThread().getName() + " is adding 1 to sum.");
			System.out.println("Sum is now " + ++sum + ".");
		}
	}
	/* The output of this program is more pleasant than the other program, 
	 * which did not use synchronization. The threads go one at a time.
	 * The threads don't necessarily go in order by the number in their name,
	 * but the sum always displays the correct number after each time the task is completed.
	 */
}
