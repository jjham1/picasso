package picasso.parser.language.expressions;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;


public class PerlinColor extends BinaryFunction {
	
	
	public PerlinColor(ExpressionTreeNode xExpress, ExpressionTreeNode yExpress) {
		super(xExpress, yExpress);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor xRes = left.evaluate(x, y);
		RGBColor yRes = right.evaluate(x, y);
		
		double red = ImprovedNoise.noise(xRes.getRed() + 0.3, yRes.getRed() + 0.3, 0);
		double blue = ImprovedNoise.noise(xRes.getBlue() + 0.1, yRes.getBlue() + 0.1, 0);
		double green = ImprovedNoise.noise(xRes.getGreen() - 0.8, yRes.getGreen() - 0.8, 0);
		return new RGBColor(red, green, blue);
		

	}
}
