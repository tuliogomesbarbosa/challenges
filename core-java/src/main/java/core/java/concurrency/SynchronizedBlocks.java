package core.java.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SynchronizedBlocks {
	private final Object lock1 = new Object();
	private final Object lock2 = new Object();

	private final List<Integer> list1 = new ArrayList<>();
	private final List<Integer> list2 = new ArrayList<>();
	private final Random random = new Random();

	private void stageOne() {
		synchronized (lock1) { // check performance against sync `this`
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Running stageOne for thread " + Thread.currentThread().getName());
			list1.add(random.nextInt(100));
		}
	}

	private void stageTwo() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Running stageTwo for thread " + Thread.currentThread().getName());
			list2.add(random.nextInt(100));
		}
	}

	private void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			System.out.println("Thread " + Thread.currentThread().getName() + " just ran stageOne");
			stageTwo();
			System.out.println("Thread " + Thread.currentThread().getName() + " just ran stageTwo");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting...");
		long start = System.currentTimeMillis();
		SynchronizedBlocks synchronizedBlocks = new SynchronizedBlocks();
		var t1 = new Thread(synchronizedBlocks::process);
		var t2 = new Thread(synchronizedBlocks::process);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		long end = System.currentTimeMillis();
		System.out.println("Time taken " + (end - start));
		System.out.println("List1 size " + synchronizedBlocks.list1.size() + "; List2 size " + synchronizedBlocks.list2.size());
	}
}