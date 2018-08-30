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
	
	public Expression parse(String inputString){
        Token t = new Token();
		String[] parts = inputString.split(" ");
		Token[] tokens = new Token[parts.length];
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

public static String makeInputString(String[] args) {
    String inputString = null;
	//make inputString an array list
	return inputString;
}
	
/*	Evaluated in Token class
 * private boolean isOperand(String operand){
		return operand.matches("\\d+");
	}
	
	private boolean isOperator(String operator){
		switch (operator){
			case "+": return true; 
			case "-": return true; 
			case "x": return true; 
			case "*": return true; 
			case "/": return true; 
			default: return false; 
		}
	}*/
}
