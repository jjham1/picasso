package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

public class Multiplication extends BinaryFunction {

	public Multiplication(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
		
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor leftResult = left.evaluate(x, y);
		RGBColor rightResult = right.evaluate(x, y);
		double red = leftResult.getRed() * rightResult.getRed();
		double green = leftResult.getGreen() * rightResult.getGreen();
		double blue = leftResult.getBlue() * rightResult.getBlue();

		return new RGBColor(red, green, blue);
	}

}
