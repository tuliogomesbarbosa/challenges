package core.java;

import java.util.Scanner;

public class Volatile extends Thread {
	private volatile boolean close;

	@Override
	public void run() {
		while (!close) {
			System.out.printf("My name is %s and i'm running%n", Thread.currentThread().getName());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Good bye!");
	}

	public void close() {
		System.out.println("Closing from " + Thread.currentThread().getName());
		close = true;
	}

	public static void main(String[] args) throws InterruptedException {
		var volatileTest = new Volatile();
		volatileTest.start();

		var scanner = new Scanner(System.in);
		scanner.nextLine();

		new Thread(volatileTest::close).start();
	}
}
