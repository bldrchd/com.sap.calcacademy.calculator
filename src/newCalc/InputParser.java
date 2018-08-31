package newCalc;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class InputParser  {
	
	private TokenStack operatorStack;
	private TokenStack valueStack;
	Operation operation;
	Number operand1;
	Number operand2;
	
	int UNKNOWN = -1;
	int NUMBER = 0;
	int OPERATOR = 1;
	int LEFT_PARENTHESIS = 2;
	int RIGHT_PARENTHESIS = 3;
	
	public InputParser(){
		operatorStack = new TokenStack();
		valueStack = new TokenStack();
		
	}
	
	public static String formatingJoinedString(String[] inputString){
		StringBuilder builder = new StringBuilder();
		String joinedString = null;
		
		try {
			if (inputString!=null){
				for(String s : inputString){
					builder.append(s);
				}
			    joinedString = builder.toString();
				joinedString = String.join("",joinedString);
				joinedString = joinedString.replaceAll("\\s+","");
			}
		} catch (Exception e){ System.err.println(e);}
		return joinedString;
	}
	public static String[] formatStringToStrArr(String joinedString){
			String[] tokensInParts = joinedString.split("(?<=[-+*x/()])|(?=[-+*x/()])"); //{"1","+","2","-","3"}
		return tokensInParts;
	}
	
	public Expression parse(String[] inputArgs){
		
		String joinedString = formatingJoinedString(inputArgs); //1+2-3
		String[] tokensInParts = formatStringToStrArr(joinedString);
		Token[] tokens = new Token[tokensInParts.length];

		for (int i = 0; i < tokens.length; i++){
			tokens[i] = new Token(tokensInParts[i]);
		}
		
		Token t = new Token();
		
		for (int index = 0; index < tokens.length; index++){
			Token nextT = tokens[index];
			//TODO test this part
			if (nextT.getType() == NUMBER){ 
				valueStack.push(nextT);
			} else if (nextT.getType() == OPERATOR){
				if (operatorStack.isEmpty() || nextT.getPrio() > operatorStack.top().getPrio()) {
                    operatorStack.push(nextT);
				
				} else {
					while(!operatorStack.isEmpty() && nextT.getPrio() <= operatorStack.top().getPrio()){
						Token tokenToProcess = operatorStack.top(); //getting the operator from stack
						operatorStack.pop();
						valueStackCollection(); 
	                    t.evaluate(operand1, operand2);
						//pass it to Token.evaluate
					}
				}
			} else if (nextT.getType() == LEFT_PARENTHESIS){
				operatorStack.push(nextT);
			} else if (nextT.getType() == RIGHT_PARENTHESIS){
				while (!operatorStack.isEmpty() && (operatorStack.top().getType() == OPERATOR)) {
                    Token tokenToProcess = operatorStack.top();
                    operatorStack.pop();
                    valueStackCollection();
                    t.evaluate(operand1, operand2);
                  //pass it to Token.evaluate
                }
				if (!operatorStack.isEmpty() && (operatorStack.top().getType() == LEFT_PARENTHESIS)) {
                    operatorStack.pop();
                    valueStackCollection(); 
                    t.evaluate(operand1, operand2);
                  //pass it to Token.evaluate
                } else {
                	throw new IllegalArgumentException("No enouth Brackets");
                }
			}
		}
		return new Expression(operation, operand1, operand2);
	}
	
/*	
 * Getting values A and B - operand1 and operand2 as Tokens
 */	public void valueStackCollection(){
		Token A = null;
		Token B = null;
		if (valueStack.isEmpty()){
			throw new EmptyStackException(); //is it ok to throw an exception when there are no values? 
		} else {
			B = valueStack.top();
			valueStack.pop();
			operand2 = B.getValue();					
		}
		if (valueStack.isEmpty()){
			throw new EmptyStackException();
		} else {
			A = valueStack.top();
			valueStack.pop();
			operand1 = A.getValue();
		}
		//result to be an Expression(operator, operand1, operand2)
	//	Token result = tokenToProcess.evaluate(A.getValue(),B.getValue());

	}

	public static ArrayList<Token> getTokensFromInputString(String inputString) {
		ArrayList<Token> tokens = null;
	    //tokens stuff
		return tokens;
	}
	
	public static String createInputString(String[] args) {
	    String inputString = null;
		//make inputString an array list
		return inputString;
}
}
