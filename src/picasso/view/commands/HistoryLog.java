package picasso.view.commands;

import picasso.model.Pixmap;
import picasso.util.FileCommand;
import picasso.view.Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * 
 * @author julieham
 *
 */

@SuppressWarnings("serial")
public class HistoryLog extends JFrame {
	
	static JTextArea foo;
	static JFrame history = new JFrame();

//	List<String> list = new ArrayList<String>();
	
	public HistoryLog(Dimension Size) {
		
		setSize(Size);
		
		foo = new JTextArea("HISTORY\n");
		getContentPane().add(foo, BorderLayout.CENTER);
//		history.getContentPane().add(foo, BorderLayout.CENTER);
	}
	
	public static void addLine(String equation) {
//		list.add(equation);
		foo.append(equation + "\n");
		System.out.println(foo.getText());
	}
	
//	public void print() {
//		Frame.history.setVisible(true);
//	}
}
