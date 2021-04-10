package core.java.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatches {

	private static class Processor implements Runnable {
		private final CountDownLatch countDownLatch;

		public Processor(CountDownLatch countDownLatch) {
			this.countDownLatch = countDownLatch;
		}

		@Override
		public void run() {
			System.out.printf("Started by thread %s%n", Thread.currentThread().getName());

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			countDownLatch.countDown();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(3);
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 3; i++) {
			executorService.submit(new Processor(countDownLatch));
		}
		countDownLatch.await();
		executorService.shutdown();
		System.out.println("All tasks completed");
	}
}