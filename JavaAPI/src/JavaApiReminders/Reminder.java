package JavaApiReminders;

import java.util.Calendar;
import java.util.Objects;

public class Reminder implements Comparable <Reminder>{


	public Calendar expiration;
	public String text;
	public boolean important;
	public boolean popped;


	@Override
	public int compareTo(Reminder reminder) {
		int timeComparison = expiration.compareTo(reminder.expiration);
		return timeComparison == 0 ? text.compareTo(reminder.text) : timeComparison;

	}

	public Reminder() {
		super();
	}

	public Reminder(Calendar expiration, String text, boolean important, boolean popped) {
		super();
		this.expiration = expiration;
		this.text = text;
		this.important = important;
		this.popped = popped;
	}

	public Calendar getExpiration() {
		return expiration;
	}

	public void setExpiration(Calendar expiration) {
		this.expiration = expiration;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isImportant() {
		return important;
	}

	public void setImportant(boolean important) {
		this.important = important;
	}

	public boolean isPopped() {
		return popped;
	}

	public void setPopped(boolean popped) {
		this.popped = popped;
	}

	@Override
	public int hashCode() {
		return Objects.hash(expiration, important, popped, text);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reminder other = (Reminder) obj;
		return Objects.equals(expiration, other.expiration) && important == other.important && popped == other.popped
				&& Objects.equals(text, other.text);
	}



}
