package core.java.concurrency;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocks {
	private long count = 0L;
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition cond = lock.newCondition();

	private void increment() {
		System.out.printf("Calling increment from %s%n", Thread.currentThread().getName());
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}

	public void firstThread() {
		try {
			lock.lock();
			System.out.println("Waiting...");
			cond.await();
			System.out.println("Woken up!");
			increment();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void secondThread() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			lock.lock();
			System.out.println("Press the return key");
			new Scanner(System.in).nextLine();
			System.out.println("Got return key!");
			cond.signal();
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void count() {
		System.out.printf("Count is %s", count);
	}

	public static void main(String[] args) throws InterruptedException {
		ReentrantLocks reentrantLocks = new ReentrantLocks();
		var t1 = new Thread(reentrantLocks::firstThread);
		var t2 = new Thread(reentrantLocks::secondThread);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		reentrantLocks.count();
	}
}