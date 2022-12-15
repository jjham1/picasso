package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.PerlinColor;
import picasso.parser.tokens.Token;

public class PerlinColorAnalyzer implements SemanticAnalyzerInterface {

	/**
	 * Handles parsing the perlinColor function.
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
		
		return new PerlinColor(newExpressionTreeX, newExpressionTreeY);
		
	}

}
