package c.creatingThread;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		Thread currntThread = Thread.currentThread();

		for (int i = 1; i <= 10; i++) {
			System.out.println(currntThread.getName() + ": " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}

	}
}
