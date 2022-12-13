package picasso.view.commands;

import picasso.model.Pixmap;
import picasso.util.FileCommand;
import picasso.view.Frame;

import java.util.*;

/**
 * 
 * @author julieham
 *
 */
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HistoryLog {
    
	List<String> list = new ArrayList<String>();
	
	public void add(String equation) {
		list.add(equation);
	}
	
	public void print() {
		System.out.println("History: " + list.toString());
	}
}
