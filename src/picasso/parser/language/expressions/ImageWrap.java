package picasso.parser.language.expressions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import picasso.parser.language.ExpressionTreeNode;


/**
 * Represents imageClip in the Picasso language
 * 
 * @author Matthew Fritz
 */
public class ImageWrap extends ExpressionTreeNode {
	
	ExpressionTreeNode xFunc;
	ExpressionTreeNode yFunc;
	
	String fileName;
	
	private String myFileName;
	private BufferedImage myImage;
	private Dimension mySize;
	
	/**
	 * Wraps a read in image, based on an
	 * expression that takes as parameters the given expressions
	 * 
	 * @param fileName the name of the file to be read, including tag
	 * @param x the expression to manipulate the x
	 * @param y the expression to manipulate the y
	 */
	public ImageWrap(String fileName, ExpressionTreeNode x, ExpressionTreeNode y) {
		//process image in constructor
		this.fileName = "images/" + fileName;
		readFile(this.fileName);
		this.xFunc = x;
		this.yFunc = y;
	}
	
	/**
	 * Evaluates this expression at the given x,y point by wrapping the image 
	 * based on the expressions passed as the function's parameters.
	 * 
	 * @return the color from evaluating the wrapping of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		
		
		RGBColor xResult = xFunc.evaluate(x, y); //create a wrap function, test each part using easy colors
		double newX = xResult.getRed();
		double wrappedX = wrap(newX);
		
		RGBColor yResult = yFunc.evaluate(x, y);
		double newY = yResult.getRed();
		double wrappedY = wrap(newY);

		//return new RGBColor(result.getRed(), result.getGreen(), result.getBlue());
		
		return new RGBColor(new Color(myImage.getRGB
				(domainToImageScale(wrappedX, myImage.getWidth()), 
						domainToImageScale(wrappedY, myImage.getHeight()))));
		
				
	}
	
	public int domainToImageScale(double value, int bound) { 
		
		int center = (bound -1)/2;
		return (int) (value * center) + center;
		
	}
	
	
	
	/**
	 * Creates a function that wraps the numbers
	 * 
	 * @param x		the coord after manipulating expression
	 */
	public double wrap(double x) {
		
		double moddedX = x % 2;
		if (moddedX < -1) {
			return moddedX + 2;
		}
		if (moddedX > 1) {
			return moddedX - 2;
		}
		return moddedX;
	}
	
	/**
	 * Read the image named by fileName
	 * 
	 * @param fileName the name of the image file to be read in
	 */
	public void readFile(String fileName) {
		
		try {
			myFileName = fileName;
			myImage = ImageIO.read(new File(myFileName));
			mySize = new Dimension(myImage.getWidth(), myImage.getHeight());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	/**
	 * Returns the string representation of the function in the format "<ClassName>:
	 * <parameter>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String classname = this.getClass().getName();
		return classname.substring(classname.lastIndexOf(".")) + "(" + fileName + xFunc + yFunc + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof ImageWrap)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		ImageWrap uf = (ImageWrap) o;

		// check if their parameters are equal
		if (!this.xFunc.equals(uf.xFunc)) {
			return false;
		}
		if (!this.yFunc.equals(uf.yFunc)) {
			return false;
		}

		return true;
	}
}
