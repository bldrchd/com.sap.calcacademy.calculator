package newCalc;

import java.util.ArrayList;
import org.junit.Test;


public class TokenTest {
	
	@Test
	public void testParsedTokensConstruction(){
		ArrayList<TokenType> parsedTokens = null;
		//TokenType(value, Type);
		TokenType t1 = new TokenType(1325,number);
		TokenType t3 = new TokenType("+", operator);
		TokenType t4 = new TokenType(987, number);
		parsedTokens.add(t1); parsedTokens.add(t2); parsedTokens.add(t3); parsedTokens.add(t4); 
		Expression expression = new ExpressionT(parsedTokens);
		Expression toCompare = new ExpressionT(add,1325,987);
		//have to return (operator, operand1, operand2)
		assertEquals(toCompare.equals(expression.construct(parsedTokens))); 
	}
	
	@Test
	public void testInputTokens_ToParsedTokens(){
		
	}
}
