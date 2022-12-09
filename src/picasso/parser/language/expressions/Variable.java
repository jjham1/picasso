package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a variable
 * 
 * @author Sara Sprenkle
 *
 */
public class Variable extends ExpressionTreeNode {

	private String name;

	public Variable(String name) {
		this.name = name;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		// Should be set to some value using assignment.
		return new RGBColor ( x+y, x+y, x+y);
	}

	public String getName() {
		return name;
	}

}
