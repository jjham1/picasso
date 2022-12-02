package picasso.parser;

import java.util.Stack;

public class ExpAnalyzer extends UnaryFunctionAnalyzer {
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the exponent token
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Exponent(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
