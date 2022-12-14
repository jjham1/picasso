package picasso.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;

import picasso.model.Pixmap;
import picasso.util.ThreadedCommand;
import picasso.view.commands.*;

/**
 * Main container for the Picasso application
 *
 * @author Robert Duvall (rcd@cs.duke.edu)
 *
 */
@SuppressWarnings("serial")
public class Frame extends JFrame {

	static Input input;
	static JTextArea foo = new JTextArea();

	public static JTextField bar = new JTextField();
	static Canvas canvas;
	public static Color COLOR = Color.PINK;

	public Frame(Dimension size) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// create GUI components
		canvas = new Canvas(this);
		canvas.setSize(size);
		canvas.setBackground(COLOR);
		
		// create tabbed panes
		TabPanel pane = new TabPanel(canvas);
		pane.setBackground(COLOR);
		
		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		commands.add("Evaluate", new ThreadedCommand<Pixmap>(canvas, new Evaluator()));
		commands.add("Save", new Writer());
//		commands.add("History", new HistoryLog());

		commands.setBackground(COLOR);
		
		// add our text container to Frame and show it
		getContentPane().add(canvas, BorderLayout.CENTER);
//		getContentPane().add(pane, BorderLayout.WEST);
		getContentPane().add(commands, BorderLayout.NORTH);
		getContentPane().add(foo, BorderLayout.SOUTH);
		getContentPane().add(bar, BorderLayout.SOUTH);
				
		getContentPane().setBackground(COLOR);

		// create an ActionListener
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				
				// the enter key has been pressed
				if (actionEvent.getSource() == bar) {
					Input.setInput(Frame.getBar());
					new Evaluator().execute(canvas.getPixmap());
					canvas.refresh();
				}
				
			}
		};
		
		bar.addActionListener(actionListener);
		pack();
		
//		setBackground(COLOR);

		

	}
		
	public static Canvas getCanvas() {
		return canvas;
	}
	
	public static String getBar() {
		return bar.getText();
	}
		
}
