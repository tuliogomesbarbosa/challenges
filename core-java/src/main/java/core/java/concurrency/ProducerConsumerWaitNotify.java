package core.java.concurrency;

import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumerWaitNotify {
	private final Object lock = new Object();
	private final LinkedList<Integer> events = new LinkedList<>();
	private static final int LIMIT = 10;
	private final Random random = new Random();

	// TODO implement own take and put with ReentrantLock/Condition

	private void produce() throws InterruptedException {
		int value = 0;
		while (true) {
			synchronized (lock) {
				while (events.size() == LIMIT) {
					lock.wait();
				}
				events.add(value++);
				lock.notify();
			}
		}
	}

	private void consume() throws InterruptedException {
		while (true) {
			synchronized (lock) {
				while (events.isEmpty()) {
					lock.wait();
				}
				System.out.printf("List size is %s; value is %s%n", events.size(), events.removeFirst());
				lock.notify();
			}

			// Thread.sleep(random.nextInt(1000));
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ProducerConsumerWaitNotify producerConsumerWaitNotify = new ProducerConsumerWaitNotify();
		var t1 = new Thread(() -> {
			try {
				producerConsumerWaitNotify.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		var t2 = new Thread(() -> {
			try {
				producerConsumerWaitNotify.consume();
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