package core.java;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadId {
	private static final AtomicInteger atomicInteger = new AtomicInteger(0);
	private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(atomicInteger::getAndIncrement);

	public static int get() {
		// var id = threadId.get();
		System.out.println(String.format("Thread %s Id %s", Thread.currentThread().getName(), threadId.get()));
		return threadId.get();
	}

	public static void main(String[] args) throws InterruptedException {
		new Thread(ThreadId::get).start();
		new Thread(ThreadId::get).start();
		new Thread(ThreadId::get).start();
		new Thread(ThreadId::get).start();
		new Thread(ThreadId::get).start();
	}
}