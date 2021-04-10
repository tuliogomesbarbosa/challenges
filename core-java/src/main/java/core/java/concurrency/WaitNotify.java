package core.java.concurrency;

import java.util.Scanner;

public class WaitNotify {
	private void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread running");
			wait();
			System.out.println("Resumed");
		}
	}

	private void consume() throws InterruptedException {
		var scanner = new Scanner(System.in);
		Thread.sleep(2000);
		synchronized (this) {
			System.out.println("Waiting for return key");
			scanner.nextLine();
			System.out.println("Return key pressed");
			notifyAll();
		}
	}

	private static Thread newProducerThread(WaitNotify waitNotify) {
		return new Thread(() -> {
			try {
				waitNotify.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}

	public static void main(String[] args) throws InterruptedException {
		var waitNotify = new WaitNotify();
		var p1 = newProducerThread(waitNotify);
		var p2 = newProducerThread(waitNotify);
		var t2 = new Thread(() -> {
			try {
				waitNotify.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		p1.start();
		p2.start();
		t2.start();
		p1.join();
		p2.join();
		t2.join();
	}
}