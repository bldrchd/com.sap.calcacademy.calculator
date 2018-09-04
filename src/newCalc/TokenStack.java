package newCalc;

import java.util.ArrayList;

public class TokenStack {

	private ArrayList<Token> tokens;

	public TokenStack() {
		tokens = new ArrayList<Token>();
	}

	// get
	public boolean isEmpty() {
		return tokens.size() == 0;
	}

	public Token top() {
		return tokens.get(tokens.size() - 1);
	}

	// set
	public void push(Token token) {
		tokens.add(token);
	}

	public void pop() { //TODO rename
		tokens.remove(tokens.size() - 1);
	}

	public boolean equals(Object obj) { //TODO
		if (obj == null || !(obj instanceof TokenStack))
			return false;
		TokenStack e = (TokenStack) obj;
		return e.equals(obj) || e.top().equals(this.top()) || e.tokens.equals(this.tokens);

	}
}
