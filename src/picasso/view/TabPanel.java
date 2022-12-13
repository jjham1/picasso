package picasso.view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabPanel {
	
	JTabbedPane tabbedPane;
	

	public TabPanel() {
	    // Create a JTabbedPane
	    tabbedPane = new JTabbedPane();
	}
	
	public void addPanel() {
	    // Create a panel for each tab
	    JPanel panel = new JPanel();

	    // Add the panels to the tabbed pane
	    tabbedPane.addTab("Canvas", panel);

	}

}
