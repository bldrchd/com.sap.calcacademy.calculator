package newCalc;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class InputParser  {
	
	private TokenStack operatorStack;
	private TokenStack valueStack;
	Operation operation;
	Number operand1;
	Number operand2;
	
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
	
	public Expression parse(String[] inputArgs){
		String joinedString = formatingJoinedString(inputArgs);
        Token t = new Token();
        		System.out.println(joinedString);
		//String[] parts = inputString.split(" ");
		String[] tokens = joinedString.split("(?<=[-+*x/()])|(?=[-+*x/()])");
		//Token[] tokens = new Token[joinedString.length()];
		
		//TODO
		for (int i = 0; i < tokens.length; i++){
			tokens[i] = new Token(parts[i]);
		}
		
		for (int index = 0; index < tokens.length; index++){
			Token nextT = tokens[index];
			
			if (nextT.getType().equals(0)){
				valueStack.push(nextT);
			} else if (nextT.getType().equals("OPERATOR")){
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
			} else if (nextT.getType().equals("LEFT_PARENTHESIS")){
				operatorStack.push(nextT);
			} else if (nextT.getType().equals("RIGHT_PARENTHESIS")){
				while (!operatorStack.isEmpty() && operatorStack.top().getType().equals("OPERATOR")) {
                    Token tokenToProcess = operatorStack.top();
                    operatorStack.pop();
                    valueStackCollection();
                    t.evaluate(operand1, operand2);
                  //pass it to Token.evaluate
                }
				if (!operatorStack.isEmpty() && operatorStack.top().getType().equals("LEFT_PARENTHESIS")) {
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
