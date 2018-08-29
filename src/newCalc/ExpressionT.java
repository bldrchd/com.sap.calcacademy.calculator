package newCalc;

import java.util.ArrayList;

public class ExpressionT extends Expression {

	private ArrayList<TokenType> parsedTokens = null;
	
	public ExpressionT(Operation operation, Number operand1, Number operand2) {
		super(operation, operand1, operand2);
	}
	
	public ExpressionT(ArrayList<TokenType> parsedTokens){
		this.parsedTokens = parsedTokens;
	}
	
	public boolean isEmpty(){
		return parsedTokens.size() == 0;
	}
	//set
	public void parsedTokensAdd(TokenType tt){
		parsedTokens.add(tt);
	}
	//get
	public TokenType getLastParsedToken(){
		return parsedTokens.get(parsedTokens.size()-1);
	}
	public TokenType getFirstParsedToken(){
		return parsedTokens.get(0);
	}
}
