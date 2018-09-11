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

	public void removeFromStack() {
		tokens.remove(tokens.size() - 1);
	}

	public boolean equals(Object obj) { // TODO
		if (obj == null || !(obj instanceof TokenStack))
			return false;
		TokenStack e = (TokenStack) obj;
		int countOfNotEq = 0;
		while (obj != null) {
			if (!e.top().equals(this.top())) {
				countOfNotEq++;
			}
		}
		if (countOfNotEq != 0) {
			return false;
		} else {
			return true;
		}
		// return e.equals(obj) || e.top().equals(this.top()) ||
		// e.tokens.equals(this.tokens);

	}
}
