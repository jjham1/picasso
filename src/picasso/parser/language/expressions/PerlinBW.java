package picasso.parser.language.expressions;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;

public class PerlinBW extends BinaryFunction {

	public PerlinBW(ExpressionTreeNode xExpress, ExpressionTreeNode yExpress) {
		super(xExpress, yExpress);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor xRes = left.evaluate(x, y);
		RGBColor yRes = right.evaluate(x, y);
		
		double grey = ImprovedNoise.noise(xRes.getRed() + yRes.getRed(), xRes.getGreen() + yRes.getGreen(),
				xRes.getBlue() + yRes.getBlue());
		return new RGBColor(grey, grey, grey);
		

	}

}
