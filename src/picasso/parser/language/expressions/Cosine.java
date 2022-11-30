package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;


public class Cosine extends UnaryFunction{
	
	/**
	 * Create a cosine expression that takes as a parameter the given expression
	 * 
	 * @param param the expression that cosine acts on
	 */
	public Cosine(ExpressionTreeNode param) {

		/**
		 * Represents the cosine function in the Picasso language.
		 * 
		 * @author Julie
		 * @author Matthew
		 * @author Harry
		 * @author Grace
		 * 
		 */


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
		double red = Math.cos(result.getRed());
		double green = Math.cos(result.getGreen());
		double blue = Math.cos(result.getBlue());

		return new RGBColor(red, green, blue);
	}

}
