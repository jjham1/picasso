package picasso;

import java.awt.Dimension;

import picasso.view.Frame;
import picasso.view.commands.HistoryLog;

/**
 * Starting point for Picasso.
 * 
 * @author Robert Duvall (rcd@cs.duke.edu)
 */
public class Main {
	public static final Dimension SIZE = new Dimension(600, 600);
	public static final Dimension SIZE2 = new Dimension(300, 300);
	public static HistoryLog log;
	
	public static void main(String[] args) {
		
		Frame frame = new Frame(SIZE);
		frame.setVisible(true);
		
		log = new HistoryLog(SIZE2);
//		log.setSize(SIZE2);
		log.setVisible(true);
		
		
		
	}
}
