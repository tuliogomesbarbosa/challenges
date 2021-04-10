package core.java.concurrency;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
	private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	private static final Random random = new Random();

	// TODO implement own take and put with ReentrantLock/Condition

	private static void produce() throws InterruptedException {
		while (true) {
			queue.put(random.nextInt(100));
		}
	}

	private static void consume() throws InterruptedException {
		while (true) {
			Thread.sleep(100);
			if (random.nextInt(10) == 0) {
				System.out.printf("Taken value %s; Queue size is %s%n", queue.take(), queue.size());
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		var t1 = new Thread(() -> {
			try {
				ProducerConsumer.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		var t2 = new Thread(() -> {
			try {
				ProducerConsumer.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}