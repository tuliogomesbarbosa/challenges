package core.java.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicOperation {
	private final AtomicInteger count = new AtomicInteger(); // CAS

	public void doWork() throws InterruptedException {
		var t1 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				count.incrementAndGet();
			}
		});

		var t2 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				count.incrementAndGet();
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Count " + count);
	}

	public static void main(String[] args) throws InterruptedException {
		var atomicOperation = new AtomicOperation();
		atomicOperation.doWork();
	}

}
