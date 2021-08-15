package b.creatingThread;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread();
		t1.start();
		Thread.sleep(3000);
		System.out.println("main 1");
		Thread.sleep(1000);
		System.out.println("main 2");
		Thread.sleep(1000);
		System.out.println("main 3");
		System.out.println("end of main");
	}
}