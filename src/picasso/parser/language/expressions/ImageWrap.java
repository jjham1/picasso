package picasso.parser.language.expressions;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import picasso.parser.language.ExpressionTreeNode;


public class ImageWrap extends ExpressionTreeNode {
	
	ExpressionTreeNode xFunc;
	ExpressionTreeNode yFunc;
	
	String fileName;
	
	private String myFileName;
	private BufferedImage myImage;
	private Dimension mySize;
	
	private Graphics g;

	public ImageWrap(String fileName, ExpressionTreeNode x, ExpressionTreeNode y) {
		//process image in constructor
		this.fileName = fileName;
		readFile("images/beholder.jpg");
		this.xFunc = x;
		this.yFunc = y;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		double wrappedX = wrap(x);
		double wrappedY = wrap(y);
		
		RGBColor xResult = xFunc.evaluate(wrappedX, wrappedY); //create a wrap function, test each part using easy colors
		//RGBColor yResult = yFunc.evaluate(wrappedX, wrappedY);
		

		return xResult;
	}
	
	/**
	 * Creates a function that wraps the numbers
	 * 
	 * @param x		the coord after manipulating expression
	 */
	public double wrap(double x) {
		double moddedX = x % 3;
		
		if (moddedX < -1) {
			moddedX += 2;
		}
		
		if (moddedX > 1) {
			moddedX -= 2;
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
			//g.drawImage(myImage, 0, 0, mySize.width, mySize.height, null);
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
