package picasso.view.commands;

import picasso.view.Frame;

/**
 * Tracks equation to pass to evaluator.
 * 
 * @author Julie Ham
 *
 */

public class Input {
	
	static String function;

	public Input() {
	}
	
	/**
	 * Saves equation in private variable
	 * 
	 * @param text the equation to pass
	 */
	public static void setInput(String text) {
		function = text;
	}
	
	
	/**
	 * Passes reference of equation
	 * 
	 * @return function the equation
	 */
	public static String getInput() {
		return function;
	}

}
