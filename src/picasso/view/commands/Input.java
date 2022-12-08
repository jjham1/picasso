package picasso.view.commands;

import picasso.view.commands.Evaluator;

public class Input {
	
	public static String function;

	public Input() {
	}
		
	public static void setInput(String text) {
		function = text;
	}
	
	public static String getInput() {
		return function;
	}

}
