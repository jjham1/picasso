package picasso.view.commands;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import picasso.Main;
import picasso.model.Pixmap;
import picasso.util.ThreadedCommand;
import picasso.view.Canvas;
import picasso.view.Frame;

/**
 * Open the chosen image file and display in the Pixmap target.
 * 
 * @author Robert C Duvall
 */
public class NewWindow {
	
//	public Dimension SIZE = Main.SIZE;
	public Frame frame;
		
	public NewWindow(Dimension size) {
		frame = new Frame(size);
//		frame.add(Frame.tabs);
		frame.setVisible(true);
	}
	
	public static void addWindow(Dimension size) {
		Frame newFrame = new Frame(size);
//		newFrame.add(Frame.tabs);
		newFrame.setVisible(true);
		}

}
