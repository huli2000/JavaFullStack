package JavaApiReminders;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.*;

public class ReminderSystem {

	public List<Reminder> reminders = new ArrayList<>();
	public ReminderTask task;

	public ReminderSystem() {
		super();
	}

	public boolean addReminder(Reminder reminder) {
		if (reminder != null) {
			boolean before = reminder.getExpiration().before(Calendar.getInstance());
			boolean contains = reminders.contains(reminder);
			if (before || contains) {
				return false;
			}
			reminders.add(reminder);
			return true;
		}
		return false;

	}

	public List<Reminder> getReminders() {
		if (!reminders.isEmpty()) {
			Comparator<Reminder> byDate = new Comparator<Reminder>() {
				public int compare(Reminder r1, Reminder r2) {
					return r1.getExpiration().compareTo(r2.getExpiration());

				}
			};

			reminders.sort(byDate);
			return reminders;
		}
		return null;
	}

	public void reminderMenu() {

		if (reminders != null) {
			ReminderTask task = new ReminderTask(reminders);
			new Thread(task).start();
		}

		Scanner scanner = new Scanner(System.in);
		System.out.println("Hello, choose one option from the list:\n" + "1 - Add new reminder\n"
				+ "2 - View all reminders\n" + "3 - Quit :(");

		int choice = scanner.nextInt();

		if (choice == 1) {
			Reminder reminder = CreateReminder(scanner);

			boolean isAdded = addReminder(reminder);
			if (isAdded) {
				System.out.println("Reminder is added successfully!");
			} else {
				System.out.println("Cant add the reminder");
			}

		}
		if (choice == 2) {
			List<Reminder> reminders = getReminders();
			if (reminders != null && !reminders.isEmpty()) {
				int i = 1;
				for (Reminder reminder : reminders) {
					System.out.println(i + ": " + reminder.toString() + "\n");
					i++;
				}
			} else {
				System.out.println("no reminders found , sorry....");
			}

		}
		if (choice == 3) {
			System.exit(0);
		}

	}

	private Reminder CreateReminder(Scanner scanner) {
		Reminder reminder = new Reminder();
		// Set text
		System.out.println("Enter Text:");
		reminder.setText(scanner.next());

		// Set expiration
		System.out.println("Enter expiration in the following order: Year,Month,Day");
		Calendar exp = Calendar.getInstance();
		exp.set(Calendar.YEAR, scanner.nextInt());
		exp.set(Calendar.MONTH, scanner.nextInt());
		exp.set(Calendar.DATE, scanner.nextInt());
		reminder.setExpiration(exp);

		// Set important
		System.out.println("This reminder important?");
		reminder.setImportant(scanner.nextBoolean());

		// Default value
		reminder.setPopped(false);

		return reminder;
	}

}
