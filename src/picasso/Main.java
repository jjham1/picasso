package picasso;

import java.awt.Dimension;

import picasso.view.TabPanel;
import picasso.view.Frame;

/**
 * Starting point for Picasso.
 * 
 * @author Robert Duvall (rcd@cs.duke.edu)
 */
public class Main {
	public static final Dimension SIZE = new Dimension(600, 600);
	public static final Dimension SIZE2 = new Dimension(300, 300);

	public static void main(String[] args) {
		
		TabPanel panel = new TabPanel();
		Frame frame = new Frame(SIZE);
	    frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);

		frame.setVisible(true);
		
//		Frame frame2 = new Frame(SIZE2);
//		frame2.setVisible(true);
	}
}
