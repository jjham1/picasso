package picasso.parser.tokens.operations;

import picasso.parser.tokens.chars.CharToken;
import picasso.parser.language.CharConstants;

public class TimesToken extends CharToken implements OperationInterface {

	public TimesToken() {
		super(CharConstants.STAR);
		
	}

}
