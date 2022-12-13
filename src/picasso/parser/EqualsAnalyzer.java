package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.NumberToken;
import picasso.parser.tokens.Token;
import picasso.parser.language.expressions.Assignment;
import picasso.parser.language.expressions.Variable;

public class EqualsAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		System.out.println(tokens);
		tokens.pop(); // Remove the equals token

		// the parameters are the next tokens on the stack. All tokens but our
		// identifier token (While loop unitl Semantic.getinstance is identifier token?)
		// But, they need to be processed
		ExpressionTreeNode newExpressionTreeRight = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		// Get the token
		System.out.println(tokens);
		Token token = tokens.pop();
		// Check if its idetifier
		//doesn't give guidance otherwise!!! (if not identifier token..?
		if (token instanceof IdentifierToken) {
			// cast as idetfier token
			IdentifierToken t = (IdentifierToken) token;
			// Create variable
			String id = t.getName();
			Variable newVar = new Variable(id);
			// Want left parameter to be the variable and right to be expression. How?
			return new Assignment(newVar, newExpressionTreeRight);
		}
//error handling 
		throw new ParseException("No variable assigned");
		//Add error handling for final implementation 

	}

}
