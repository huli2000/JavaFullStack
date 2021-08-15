package d.Threads;

public class Tar1 {

	public static void main(String[] args) throws InterruptedException {
		Counter c1 = new Counter();
		c1.start();

		Thread.sleep(5000);
		c1.interrupt();
	}

}
