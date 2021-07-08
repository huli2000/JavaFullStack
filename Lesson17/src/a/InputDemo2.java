package a;
import javax.swing.JOptionPane;

public class InputDemo2 {

	public static void main(String[] args) {
		
		String userName = JOptionPane.showInputDialog("Enter your name");
		JOptionPane.showMessageDialog(null, "Hello " +userName);
				
	}
}
