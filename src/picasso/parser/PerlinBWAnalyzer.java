package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.Token;
import picasso.parser.language.expressions.PerlinBW;

public class PerlinBWAnalyzer implements SemanticAnalyzerInterface {


	/**
	 * Handles parsing the perlinBW function.
	 * 
	 * @author Matthew Fritz
	 * 
	 */
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		
		ExpressionTreeNode newExpressionTreeY = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		ExpressionTreeNode newExpressionTreeX = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		
		return new PerlinBW(newExpressionTreeX, newExpressionTreeY);
		
	}

}
