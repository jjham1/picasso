package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.ExpressionTreeGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import picasso.view.commands.HistoryLog;
/**
 * Represents the random function in the Picasso language.
 * 
 * @author Julie
 * @author Matthew
 * @author Harry
 * @author Grace
 * 
 */

public class Rand extends ExpressionTreeNode{

	/**
	 * Create a cosine expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to cosine
	 */
	
	ExpressionTreeGenerator expTreeTwo = new ExpressionTreeGenerator();
	ExpressionTreeNode result;
	Random random = new Random();
	int HardStop = 0; 
	double red1;
	double green1;
	double blue1;
	
	private static List<String> UnaryfunctionsList= new ArrayList<String>();
	private static List<String> BinaryfunctionsList= new ArrayList<String>();
	private static List<String> MultifunctionsList= new ArrayList<String>();
	
	
	
	public Rand() {
		UnaryfunctionsList.add("floor");
		UnaryfunctionsList.add("cos");
		UnaryfunctionsList.add("sin");
		UnaryfunctionsList.add("tan");
		UnaryfunctionsList.add("abs");
		UnaryfunctionsList.add("exp");
		UnaryfunctionsList.add("ceil");
		UnaryfunctionsList.add("clamp");
		UnaryfunctionsList.add("wrap");
		UnaryfunctionsList.add("atan");
		UnaryfunctionsList.add("log");
		UnaryfunctionsList.add("rgbToYCrCb");
		UnaryfunctionsList.add("yCrCbToRGB");
		UnaryfunctionsList.add("!");
		
		BinaryfunctionsList.add("+");
		BinaryfunctionsList.add("-");
		BinaryfunctionsList.add("*");
		BinaryfunctionsList.add("/");
		BinaryfunctionsList.add("%");
		BinaryfunctionsList.add("^");
		
		MultifunctionsList.add("perlinColor");
		MultifunctionsList.add("perlinBW");
		MultifunctionsList.add("combine");
		
		String Expression = (makeRand(15));
		HistoryLog.addLine(Expression);
		result = expTreeTwo.makeExpression(Expression);
	}


	public String makeRand(int length) {
		
		String randomExpression = "";
		int Count = random.nextInt(length);
		int index; 
		
		//start equation off with either x or y
		if (Count % 2 == 0) {
			randomExpression = "x";
		}
		else {
			randomExpression = "y";
		}
		
		
		for (int i = 0; i < Count; i++) {
			HardStop += 1;
			//fix values for path <>><>
			int path = random.nextInt(100);
			if (path < 50) {
				index = random.nextInt(14);
				randomExpression = UnaryfunctionsList.get(index) +"("+ randomExpression+")";
			}
			else if (path < 80) {
				index = random.nextInt(6);
				randomExpression = randomExpression + BinaryfunctionsList.get(index) + makeRand(10);
			}
			else if (path < 85) {
				index = random.nextInt(3);
				randomExpression = MultifunctionsList.get(index) + "("+  randomExpression + "," + makeRand(10) + ")";
			}	
			else {
				/////
				red1 = random.nextDouble();
				green1 = random.nextDouble();
				blue1 = random.nextDouble();
				index = random.nextInt(2);
				if (index == 1) {
					red1 = red1 * -1;
				}
				index = random.nextInt(2);
				if (index == 1) {
					green1 = green1 * -1;
				}
				index = random.nextInt(2);
				if (index == 1) {
					blue1 = blue1 * -1;
				}
				randomExpression =  randomExpression + "+"+ "[" + red1+ "," + green1 + "," + blue1 + "]";
			}	
			randomExpression = "(" + randomExpression + ")";
			System.out.println("Random so far:" + randomExpression + "~~~~~~~~" + HardStop);
			if (HardStop > 50) {
				return(randomExpression);
				
			}
		}
		return (randomExpression);
	}
	/**
	 * Evaluates this expression at the given x,y point by evaluating the cosine values of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the cosine value of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor RGBResult = result.evaluate(x, y);
		double red = (RGBResult.getRed());
		double green = (RGBResult.getGreen());
		double blue = (RGBResult.getBlue());

		return new RGBColor(red, green, blue);
	}

}