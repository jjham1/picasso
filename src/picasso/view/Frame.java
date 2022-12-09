package picasso.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

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
	static JTextField bar = new JTextField();

	public Frame(Dimension size) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// create GUI components
		Canvas canvas = new Canvas(this);
		canvas.setSize(size);

		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		commands.add("Evaluate", new ThreadedCommand<Pixmap>(canvas, new Evaluator()));
		commands.add("Save", new Writer());

		// add our text container to Frame and show it
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		getContentPane().add(foo, BorderLayout.SOUTH);
		getContentPane().add(bar, BorderLayout.SOUTH);
		
		// create an ActionListener
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				
				// the enter key has been pressed
				if (actionEvent.getSource() == bar) {
					Input.setInput(bar.getText());		
					
					System.out.println("input: " + Input.getInput());
					
					new Evaluator().execute(canvas.getPixmap());

				// the enter key has been pressed
				if (actionEvent.getSource() == bar) {
					new Evaluator().execute(canvas.getPixmap());

          canvas.refresh();
				}
			}
		};
		
		bar.addActionListener(actionListener);
		pack();

	}
	
	public static String getBar() {
		return bar.getText();
	}
		
}
