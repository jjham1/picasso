package picasso.parser.tokens.operations;

import picasso.parser.tokens.chars.CharToken;
import picasso.parser.language.CharConstants;

public class ModuloToken extends CharToken implements OperationInterface{

	public ModuloToken() {
		super(CharConstants.MOD);
	}

}
