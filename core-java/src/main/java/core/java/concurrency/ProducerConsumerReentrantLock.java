package core.java.concurrency;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerReentrantLock {
	private LinkedList<Integer> events;
	private ReentrantLock reentrantLock;
	private Condition notEmpty;
	private Condition notFull;
	private static final int LIMIT = 10;

	public ProducerConsumerReentrantLock() {
		events = new LinkedList<>();
		reentrantLock = new ReentrantLock();
		notEmpty = reentrantLock.newCondition();
		notFull = reentrantLock.newCondition();
	}

	private void produce() throws InterruptedException {
		int value = 0;
		while (true) {
			try {
				reentrantLock.lock();
				while (events.size() == LIMIT) {
					notFull.await();
				}
				events.add(value++);
				notEmpty.signal();
			} finally {
				reentrantLock.unlock();
			}
		}
	}

	private void consume() throws InterruptedException {
		var random = new Random();
		while (true) {
			try {
				reentrantLock.lock();
				while (events.isEmpty()) {
					notEmpty.await();
				}
				System.out.printf("List size is %s; value is %s%n", events.size(), events.removeFirst());
				notFull.signal();
			} finally {
				reentrantLock.unlock();
			}
			Thread.sleep(random.nextInt(1000));
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ProducerConsumerReentrantLock producerConsumer = new ProducerConsumerReentrantLock();
		var t1 = new Thread(() -> {
			try {
				producerConsumer.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		var t2 = new Thread(() -> {
			try {
				producerConsumer.consume();
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