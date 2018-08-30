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
	public void testTokenStackArray(){
		ArrayList<Token> inputTokens = new ArrayList<>();
		Token t1 = new Token(1), t2 = new Token("+"), t3 = new Token(2);
		inputTokens.add(t1); inputTokens.add(t2); inputTokens.add(t3);
		
		TokenStack ts = new TokenStack();
		ts.push(t1); ts.push(t2); ts.push(t3);
		
		assertTrue(ts.equals(inputTokens));
		ts.pop();
		Token token = ts.top();
		assertTrue( token.equals(inputTokens.indexOf(inputTokens.size()-1)) );
	}
	
	@Test 
	public void testInputParser_ReturnTokenArr(){
		String[] args = {"1+", "2","-"," ","3"};
		//split + trim : 
		String inputString = null;
		inputString = InputParser.createInputString(args); //"1+2-3"
		
		//has to be tokenStack? 
		ArrayList<Token> t = new ArrayList<>(); //expecting : {"1","+","2","-","3"}
		//actual
		t = InputParser.getTokensFromInputString(inputString);
		
		//expected
		ArrayList<Token> arlt = new ArrayList<Token>();
		Token t1 = new Token(1), t2 = new Token("+"), t3 = new Token(2), t4 = new Token("-"), t5 = new Token(3);
		arlt.add(t1); arlt.add(t2); arlt.add(t3); arlt.add(t4); arlt.add(t5);
		
		for (int i=0; i<=arlt.size()-1; i++){
		assertTrue(equals(arlt.get(i).equals(t.get(i))));
		}
		assertTrue(t.equals(arlt));
		assertTrue(t.containsAll(arlt));
		assertTrue(t.size() == arlt.size());
		
	}

}
 