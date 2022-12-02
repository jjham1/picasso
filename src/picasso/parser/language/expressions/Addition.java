package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

public class Addition extends ExpressionTreeNode {

	ExpressionTreeNode left;
	ExpressionTreeNode right;

	public Addition(ExpressionTreeNode left, ExpressionTreeNode right) {
		this.left = left;
		this.right = right;

	}

	@Override
	public String toString() {
		String classname = this.getClass().getName();
		return classname.substring(classname.lastIndexOf(".")) + "(" + left + right + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Addition)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		Addition uf = (Addition) o;

		// check if their parameters are equal
		if (!this.left.equals(uf.left)) {
			return false;
		}
		if (!this.right.equals(uf.right)) {
			return false;
		}

		return true;
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the cosine of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the floor of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor leftResult = left.evaluate(x, y);
		RGBColor rightResult = right.evaluate(x, y);
		double red = leftResult.getRed() + rightResult.getRed();
		double green = leftResult.getGreen() + rightResult.getGreen();
		double blue = leftResult.getBlue() + rightResult.getBlue();

		return new RGBColor(red, green, blue);
	}

}
