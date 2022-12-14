package picasso.view.commands;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFileChooser;

import picasso.model.Pixmap;
import picasso.util.ThreadedCommand;
import picasso.view.Frame;

/**
 * Open the chosen image file and display in the Pixmap target.
 * 
 * @author Robert C Duvall
 */
public class NewWindow extends ThreadedCommand<Frame>{

	/**
	 * Creates a Reader object, which prompts users for image files to open
	 */
	public NewWindow() {
		super(myView, myCommand);
	}

	public void execute(Pixmap target) {
		
	}
}
