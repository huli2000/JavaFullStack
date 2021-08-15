package d.Threads;


public class Counter extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// thread was interrupted - count down
				for (int j = i; j >= 1; j--) {
					System.out.println(j);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				break;
			}
		}
	}
}