package e.drills;

public class Deamon extends Thread {
	{
	setDaemon(true);
}
	
	@Override
	public synchronized void start() {
		super.start();
	}
}