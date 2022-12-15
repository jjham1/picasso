package picasso.view.commands;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Main container for window showing input history
 * 
 * @author Julie Ham
 *
 */

@SuppressWarnings("serial")
public class HistoryLog extends JFrame {
	
	static JTextField title;
	static JTextArea details;
	static JFrame history = new JFrame();
	
	
	public HistoryLog(Dimension Size) {
		
		setSize(Size);
		
		// creating textarea for history
		
		title = new JTextField("HISTORY");
		title.setEditable(false);
		details = new JTextArea();
		details.setEditable(false);
		
		// adding textarea to container
		getContentPane().add(title, BorderLayout.NORTH);
		getContentPane().add(details, BorderLayout.CENTER);
	}
	
	/**
	 * Takes in user input and adds it to display container
	 * 
	 * @param String userInput text from user input
	 */
	public static void addLine(String userInput) {
		details.append(userInput + "\n");
	}
}