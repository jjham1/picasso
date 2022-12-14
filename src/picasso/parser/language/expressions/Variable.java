package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.IdentifierAnalyzer;

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
		return ( IdentifierAnalyzer.idToExpression.get(this.name).evaluate(x,y));
	}

	public String getName() {
		return name;
	}

}
