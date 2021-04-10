package core.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPools {

	public static class Processor implements Runnable {
		private final int id;

		public Processor(int id) {
			this.id = id;
		}

		@Override
		public void run() {
			System.out.printf("Starting %s from thread %s%n", id, Thread.currentThread().getName());

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.printf("Completed %s from thread %s%n", id, Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 5; i++) {
			executorService.submit(new Processor(i));
		}
		System.out.println("All tasks submitted");
		executorService.shutdown();
		if (executorService.awaitTermination(1, TimeUnit.DAYS)) {
			System.out.println("All tasks completed");
		}
	}
}