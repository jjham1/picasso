package picasso.parser.language.expressions;

import java.util.HashMap;

import java.util.Map;
import java.util.TreeMap;

import picasso.parser.language.ExpressionTreeNode;

import picasso.parser.IdentifierAnalyzer;

public class Assignment extends BinaryFunction {

	
	//Parameters should be Variable (expression tree node), and the definiton we want)
	public Assignment(Variable left, ExpressionTreeNode right) {
		super(left, right);
		// map the variable to the expression here
		
		IdentifierAnalyzer.idToExpression.put(left.getName(), right);
			
	}
	
	@Override
	public RGBColor evaluate(double x, double y) {
		//Should evaluate the expression 
		return right.evaluate(x, y);
	}

}