package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ImageClip;
import picasso.parser.tokens.StringToken;
import picasso.parser.tokens.Token;

public class ImageClipAnalyzer implements SemanticAnalyzerInterface {

	/**
	 * Handles parsing the imageClip function.
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
		
		StringToken image = (StringToken) tokens.pop();
		
		return new ImageClip(image.getName(), newExpressionTreeX, newExpressionTreeY);
		
	}

}
