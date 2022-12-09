/**
 *
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;

/**
 * Tests of the evaluation of x
 *
 * @author Sara Sprenkle
 *
 */
public class EvaluatorTests {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	@Test
	public void testConstantEvaluation() {
		ExpressionTreeNode e = new RGBColor(1, -1, 1);
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(1, -1, 1), e.evaluate(i, i));
		}
	}

	@Test
	public void testXEvaluation() {
		X x = new X();
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), x.evaluate(i, i));
		}
	}

	@Test
	public void testFloorEvaluation() {
		Floor myTree = new Floor(new X());

		// some straightforward tests
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double floorOfTestVal = Math.floor(testVal);
			assertEquals(new RGBColor(floorOfTestVal, floorOfTestVal, floorOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(floorOfTestVal, floorOfTestVal, floorOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}

	// TODO: More tests of evaluation

	@Test
	public void testTangentEvaluation() {
		Tangent myTree = new Tangent(new X());

		// some straightforward tests
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(0, -2));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(Math.PI/4, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(7 * Math.PI/4, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			double value = Math.tan(i);
			assertEquals(new RGBColor(value, value, value), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(value, value, value), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double tanOfTestVal = Math.tan(testVal);
			assertEquals(new RGBColor(tanOfTestVal, tanOfTestVal, tanOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(tanOfTestVal, tanOfTestVal, tanOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}

	@Test
	public void testCosEvaluation() {
		Cosine myTree = new Cosine(new X());

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			double cosOfTestVal = Math.cos(i);
			assertEquals(new RGBColor(cosOfTestVal, cosOfTestVal, cosOfTestVal), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(cosOfTestVal, cosOfTestVal, cosOfTestVal), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5, 0};

		for (double testVal : tests) {
			double cosOfTestVal = Math.cos(testVal);
			assertEquals(new RGBColor(cosOfTestVal, cosOfTestVal, cosOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(cosOfTestVal, cosOfTestVal, cosOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}

	@Test
	public void testAbsEvaluation() {
		Absolute myTree = new Absolute(new X());

		// some straightforward tests
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(1, -1));
		assertEquals(new RGBColor(0,0,0), myTree.evaluate(0, -1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(-1, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			double absOfTestVal = Math.abs(i);
			assertEquals(new RGBColor(absOfTestVal, absOfTestVal, absOfTestVal), myTree.evaluate(-i, -i));
			assertEquals(new RGBColor(absOfTestVal, absOfTestVal, absOfTestVal), myTree.evaluate(-i, i));
			assertEquals(new RGBColor(absOfTestVal, absOfTestVal, absOfTestVal), myTree.evaluate(i, -i));
		}

		double[] tests = { -.7, -.00001, .000001, .5, 0};

		for (double testVal : tests) {

      

			double absOfTestValue = Math.abs(testVal);
			assertEquals(new RGBColor(absOfTestValue, absOfTestValue, absOfTestValue), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(absOfTestValue, absOfTestValue, absOfTestValue), myTree.evaluate(testVal, 1));
		}
	}


	public void testSineEvaluation() {
		Sine myTree = new Sine(new X());

		// some straightforward tests
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {

			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {

			double SineOfTestVal = Math.sin(testVal);
			assertEquals(new RGBColor(SineOfTestVal, SineOfTestVal, SineOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(SineOfTestVal, SineOfTestVal, SineOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
		}
	


	@Test
	public void testExpEvaluation() {
		Exponent myTree = new Exponent(new X());


		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			double expOfTestVal = Math.exp(i);
			assertEquals(new RGBColor(expOfTestVal, expOfTestVal, expOfTestVal), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(expOfTestVal, expOfTestVal, expOfTestVal), myTree.evaluate(i, i));
		}

		double[] tests = { -.5, -.1, .1, .5, 0};

		for (double testVal : tests) {
			double expOfTestVal = Math.exp(testVal);
			assertEquals(new RGBColor(expOfTestVal, expOfTestVal, expOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(expOfTestVal, expOfTestVal, expOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}
	
	@Test
	public void testCeilEvaluation() {
		Ceil myTree = new Ceil(new X());

		// some straightforward tests
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double ceilOfTestVal = Math.ceil(testVal);
			assertEquals(new RGBColor(ceilOfTestVal, ceilOfTestVal, ceilOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(ceilOfTestVal, ceilOfTestVal, ceilOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}
	
	@Test
	public void testClampEvaluation() {
		Clamp myTree = new Clamp(new X());

		// some straightforward tests
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double ClampOfTestVal = Math.max(-1, Math.min(1, testVal));
			assertEquals(new RGBColor(ClampOfTestVal, ClampOfTestVal, ClampOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(ClampOfTestVal, ClampOfTestVal, ClampOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}
	
	@Test
	public void testWrapEvaluation() {
		Wrap myTree = new Wrap(new X());

		// some straightforward tests 
		assertEquals(new RGBColor(.4, .4, .4), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(.999, .999, .999), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(.8, .8, .8), myTree.evaluate(-1.2, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			// need to fix wrap
			double WrapOfTestVal = Math.max(-1, Math.min(1, testVal));
			assertEquals(new RGBColor(WrapOfTestVal, WrapOfTestVal, WrapOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(WrapOfTestVal, WrapOfTestVal, WrapOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}
	
	@Test
	public void testATanEvaluation() {
		Atan myTree = new Atan(new X());

		// some straightforward tests
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double AtanOfTestVal = Math.atan(testVal);
			assertEquals(new RGBColor(AtanOfTestVal, AtanOfTestVal, AtanOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(AtanOfTestVal, AtanOfTestVal, AtanOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}
	
	@Test
	public void testLogEvaluation() {
		Log myTree = new Log(new X());

		// some straightforward tests
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double LogOfTestVal = Math.log(Math.abs(testVal));
			assertEquals(new RGBColor(LogOfTestVal, LogOfTestVal, LogOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(LogOfTestVal, LogOfTestVal, LogOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}
	
	@Test
	public void testRgbToYCrCbEvaluation() {
		RgbToYCrCb myTree = new RgbToYCrCb(new X());

		// some straightforward tests
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}
	}
	
	@Test
	public void testYCrCbToRGBbEvaluation() {
		YCrCbToRGB myTree = new YCrCbToRGB(new X());

		// some straightforward tests
		
//		for (int i = -1; i <= 1; i++) {
//			double value = Math.tan(i);
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}
	}
	
}
