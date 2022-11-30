package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

public class Tangent extends UnaryFunction {
	
	/**
	 * Create a cosine expression that takes as a parameter the given expression
	 * 
	 * @param param the expression that cosine acts on
	 */
	public Tangent(ExpressionTreeNode param) {
		super(param);
	}
	
	/**
	 * Evaluates this expression at the given x,y point by evaluating the cosine of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the floor of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.tan(result.getRed());
		double green = Math.tan(result.getGreen());
		double blue = Math.tan(result.getBlue());

		return new RGBColor(red, green, blue);
	}

}
