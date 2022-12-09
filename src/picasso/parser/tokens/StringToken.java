package picasso.parser.tokens;

public class StringToken extends Token {
	
	private final String myName;

	public StringToken(String value) {
		super("String Token");
		myName = value;
		
	}
	
	public boolean equals(Object o) {
		if( o == this ) {
			return true;
		}
		if (!(o instanceof StringToken)) {
			return false;
		}
		StringToken rhs = (StringToken) o;
		return myName.equals(rhs.myName);
	}

	public String getName() {
		return myName;
	}

	public String toString() {
		return super.toString() + ": " + myName;
	}

	@Override
	public boolean isConstant() {
		return false;
	}

	@Override
	public boolean isFunction() {
		return false;
	}

}
