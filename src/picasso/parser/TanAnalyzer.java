package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Tangent;
import picasso.parser.tokens.Token;

public class TanAnalyzer extends UnaryFunctionAnalyzer {
	
	/**
	 * Handles parsing the tan or "tangent function".
	 * 
	 * @author Matthew Fritz
	 * 
	 */
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
		return new Tangent(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
