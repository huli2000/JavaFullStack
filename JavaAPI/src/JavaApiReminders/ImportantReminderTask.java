package JavaApiReminders;

import java.util.Calendar;

public class ImportantReminderTask implements Runnable {

	public Reminder reminder;

	public ImportantReminderTask(Reminder reminder) {
		super();
		this.reminder = reminder;
	}

	@Override
	public void run() {

		try {
			if (reminder.getExpiration().compareTo(Calendar.getInstance()) == 0) {
				int i = 0;
				while (i < 3) {
					System.out.println(reminder.toString());
					Thread.sleep(60_000);
					i++;
				}
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
