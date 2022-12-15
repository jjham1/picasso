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
	public static int frameCount;
		
	public NewWindow(Dimension size) {
		frameCount ++;
		frame = new Frame(size);
		frame.setVisible(true);
	}
	
	public static void addWindow(Dimension size) {
		frameCount ++;
		Frame newFrame = new Frame(size);
//		newFrame.add(Frame.tabs);
		newFrame.setVisible(true);
		}

}
