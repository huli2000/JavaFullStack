package JavaApiReminders;

public class ImportantReminderTask implements Runnable {

	public Reminder reminder;

	@Override
	public void run() {

	}

	public ImportantReminderTask(Reminder reminder) {
		super();
		this.reminder = reminder;
	}
}
