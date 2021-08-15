package a;

public class MainThread {
public static void main(String[] args) throws InterruptedException {
	
	Thread mainThread = Thread.currentThread();
	System.out.println(mainThread.getName());
		Thread.sleep(3000);
		System.out.println("main 1");
		Thread.sleep(1000);
		System.out.println("main 2");
		Thread.sleep(1000);
		System.out.println("main 3");

}
}
