package c.creatingThread;

public class Main {

	public static void main(String[] args) {
		MyRunnable r =new MyRunnable();
		Thread t1 = new Thread (r, "t1-r");
		Thread t2 = new Thread (r, "t2-r");
		Thread t3 = new Thread (r, "t3-r");

		t1.start();
		t2.start();
		t3.start();
	}
}
