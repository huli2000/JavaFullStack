package JavaApiReminders;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ReminderTask implements Runnable {

	public List<Reminder> reminders = new ArrayList<>();

	public ReminderTask (List<Reminder> reminders) {
		this.reminders = (List<Reminder>) reminders;
	}

	@Override
	public void run() {
		for (Reminder reminder : reminders) {
			if (reminder.isImportant()) {
				ImportantReminderTask task = new ImportantReminderTask(reminder);
				new Thread(task).start();
				reminder.setPopped(true);
				continue;

			}

			if (reminder.getExpiration().compareTo(Calendar.getInstance()) == 0) {
				if (!reminder.isPopped()) {
					System.out.println(reminder.toString());
					reminder.setPopped(true);
				}
			}
		}

	}

}
