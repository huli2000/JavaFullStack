package JavaApiReminders;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReminderTask implements Runnable {

	public Set<Reminder> reminders = new HashSet<>();

	public ReminderTask(List<Reminder> reminders2) {
		super();
		this.reminders = (Set<Reminder>) reminders2;
	}

	@Override
	public void run() {
		
		

	}

}
