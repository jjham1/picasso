package picasso.view.commands;


import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * Main container for window showing input history
 * 
 * @author Julie Ham
 *
 */

@SuppressWarnings("serial")
public class HistoryLog extends JFrame {
	
	static JTextArea foo;
	static JFrame history = new JFrame();

//	List<String> list = new ArrayList<String>();
	
	
	public HistoryLog(Dimension Size) {
		
		setSize(Size);
		
		// creating textarea for history
		foo = new JTextArea("HISTORY\n");
		
		// adding textarea to container
		getContentPane().add(foo, BorderLayout.CENTER);
	}
	
	/**
	 * Takes in user input and adds it to display container
	 * 
	 * @param String a
	 */
	public static void addLine(String equation) {
		foo.append(equation + "\n");
//		System.out.println(foo.getText());
	}
	
//	public void print() {
//		Frame.history.setVisible(true);
//	}
}
