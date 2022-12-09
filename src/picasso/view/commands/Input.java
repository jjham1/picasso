package picasso.view.commands;

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
