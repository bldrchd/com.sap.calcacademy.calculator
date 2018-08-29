package newCalc;

import java.util.ArrayList;

public class TokenStack {
	
	private ArrayList<Token> tokens;
	public TokenStack(){
		tokens = new ArrayList<Token>();
	}
	//get
	public boolean isEmpty(){
		return tokens.size() == 0;
	}
	public Token top(){
		return tokens.get(tokens.size()-1);
	}
	//set
	public void push(Token token){
		tokens.add(token);
	}
	public void pop(){
		tokens.remove(tokens.size()-1);
	}
}
