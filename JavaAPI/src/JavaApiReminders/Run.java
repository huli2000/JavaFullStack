package JavaApiReminders;

public class Run {

	public static void main(String[] args) {
		ReminderSystem reminderSystem = new ReminderSystem();
		while (true) {
			reminderSystem.reminderMenu();
		}
	}

}
