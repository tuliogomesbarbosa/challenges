package core.java.concurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlocks {
	private final CountDownLatch countDownLatch;
	private final Lock lock1 = new ReentrantLock();
	private final Lock lock2 = new ReentrantLock();
	private final Account acc1 = new Account();
	private final Account acc2 = new Account();
	private final Random random = new Random();

	public Deadlocks(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	private void acquireLocks(Lock firstLock, Lock secondLock) throws InterruptedException {
		while (true) {
			boolean gotFirstLock = false;
			boolean gotSecondLock = false;
			try {
				gotFirstLock = firstLock.tryLock();
				gotSecondLock = secondLock.tryLock();
			} finally {
				if (gotFirstLock && gotSecondLock) return;
				if (gotFirstLock) firstLock.unlock();
				if (gotSecondLock) secondLock.unlock();
			}
			Thread.sleep(1);
		}
	}

	public void firstThread() {
		for (int i = 0; i < 10000; i++) {
			try {
				acquireLocks(lock1, lock2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				Account.transfer(acc1, acc2, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
		countDownLatch.countDown();
	}

	public void secondThread() {
		for (int i = 0; i < 10000; i++) {
			try {
				acquireLocks(lock2, lock1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				Account.transfer(acc2, acc1, random.nextInt(100));
			} finally {
				lock2.unlock();
				lock1.unlock();
			}
		}
		countDownLatch.countDown();
	}

	public void summary() {
		System.out.printf("Account 1 balance is %s%n", acc1.getBalance());
		System.out.printf("Account 2 balance is %s%n", acc2.getBalance());
		System.out.printf("Total balance is %s%n", acc1.getBalance() + acc2.getBalance());
	}

	public static void main(String[] args) throws InterruptedException {
		var countDownLatch = new CountDownLatch(2);
		var deadLocks = new Deadlocks(countDownLatch);
		var t1 = new Thread(deadLocks::firstThread);
		var t2 = new Thread(deadLocks::secondThread);
		t1.start();
		t2.start();
		countDownLatch.await();
		deadLocks.summary();
	}

	private static class Account {
		private long balance = 10000;

		public void withdraw(long amount) {
			this.balance -= amount;
		}

		public void deposit(long amount) {
			this.balance += amount;
		}

		public static void transfer(Account acc1, Account acc2, long amount) {
			acc1.withdraw(amount);
			acc2.deposit(amount);
		}

		public long getBalance() {
			return this.balance;
		}
	}
}