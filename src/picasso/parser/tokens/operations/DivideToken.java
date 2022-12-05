package picasso.parser.tokens.operations;

import picasso.parser.tokens.chars.CharToken;
import picasso.parser.language.CharConstants;

public class DivideToken extends CharToken implements OperationInterface{
	public DivideToken() {
		super(CharConstants.SLASH);
		
	}

}
