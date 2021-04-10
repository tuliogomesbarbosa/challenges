package core.java.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Semaphores {

	public static void main(String[] args) {
		var executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 200; i++) {
			executorService.execute(() -> {
				try {
					Connection.getInstance().connect();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
	}

	private static class Connection {
		private volatile static Connection INSTANCE;
		private final Semaphore semaphore = new Semaphore(10);
		private final AtomicInteger connections = new AtomicInteger();

		private Connection() {
		}

		public static Connection getInstance() {
			if (INSTANCE == null) {
				synchronized (Connection.class) {
					if (INSTANCE == null) {
						synchronized (Connection.class) {
							INSTANCE = new Connection();
						}
					}
				}
			}
			return INSTANCE;
		}

		public void connect() throws InterruptedException {
			semaphore.acquire();
			try {
				doConnect();
			} finally {
				semaphore.release();
			}
		}

		private void doConnect() throws InterruptedException {
			// why should we use synchronized or atomic integer to keep the number of connections under 10? Because semaphores allows race conditions unless N is 1
			//synchronized (this) {
			connections.incrementAndGet();
			System.out.printf("Current connections: %s%n", connections.get());
			//}
			Thread.sleep(2000);
			//synchronized (this) {
			connections.decrementAndGet();
			//}
		}
	}
}