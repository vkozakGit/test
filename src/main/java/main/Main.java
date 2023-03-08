package main;

public class Main {
	public static void main(String[] args) {
		Thread thread = new Thread(new PrintingRunnable());
		thread.start();
	}

	public class MyApp {
		Thread t1 = new Thread(() -> System.out.println("Hello from Thread 1"));
		Thread t2 = new Thread(() -> System.out.println("Hello from Thread 2"));

		public void startThreads() throws InterruptedException {
			t1.start();
			t1.join();
			t2.start();
		}
	}
}
