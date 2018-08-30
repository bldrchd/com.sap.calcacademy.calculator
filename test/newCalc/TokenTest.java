package newCalc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;


public class TokenTest {
	
	@Test
	public void testParsedTokens_ConstructExpression(){

	}
	
	@Test
	public void testInputTokens_ToProcessedTokens(){
		ArrayList<Token> inputTokens = new ArrayList<>();
		Token t1 = new Token(1), t2 = new Token("+"), t3 = new Token(2);
		inputTokens.add(t1); inputTokens.add(t2); inputTokens.add(t3);
		
		
	}
	
	@Test 
	public void testInputParser_ReturnTokenArr(){
		String[] args = {"1+", "2","-"," ","3"};
		
		String inputString = null;
		inputString = InputParser.makeInputString(args);
		
		//actual
		ArrayList<Token> tokens = new ArrayList<Token>();
		tokens = InputParser.getTokensFromInputString(inputString);
		
		//expected
		ArrayList<Token> arlt = new ArrayList<Token>();
		Token t1 = new Token(1), t2 = new Token("+"), t3 = new Token(2);
		arlt.add(t1); arlt.add(t2); arlt.add(t3);
		
		for (int i=0; i<=arlt.size()-1; i++){
		equals(arlt.get(i).equals(tokens.get(i)));
		}
	}

}
