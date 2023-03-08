package main;

class PrintingRunnable implements Runnable {
	ThreadLocal<Double> value = new InheritableThreadLocal<>();

	@Override
	public void run() {
		value.set(Math.random());
		System.out.println(value.get());

		Thread childThread = new Thread(() -> System.out.println(value.get()));
		childThread.start();
	}
}
