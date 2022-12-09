package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

public class Exponentiate extends BinaryFunction {

	public Exponentiate(ExpressionTreeNode left, ExpressionTreeNode right) {
		super(left, right);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor leftResult = left.evaluate(x, y);
		RGBColor rightResult = right.evaluate(x, y);
		double red = Math.pow(leftResult.getRed(), rightResult.getRed());
		double green = Math.pow(leftResult.getGreen(), rightResult.getGreen());
		double blue = Math.pow(leftResult.getBlue(), rightResult.getBlue());

		return new RGBColor(red, green, blue);
	}

}
