package newCalc;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

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

		ts.pop();
		Token token = ts.top();
		assertTrue( token.equals(inputTokens.indexOf(inputTokens.size()-1)) );
	}
	
	@Test 
	public void matchElements(){
		Token t1 = new Token(1), t2 = new Token("/"), t3 = new Token(135);
		
		ArrayList<Token> inputTokens = new ArrayList<>();
		inputTokens.add(t1); inputTokens.add(t2); inputTokens.add(t3);
		
		TokenStack ts = new TokenStack();
		ts.push(t1); ts.push(t2); ts.push(t3);
		
		boolean match = false;
		ts.pop();
		for (int i = inputTokens.size(); i == 0 ; i --){
			if (inputTokens.contains(ts.top())){
				ts.pop();
				match = true;
			}
		}
		assertEquals(true, match);
	}
	
	@Test
	public void testInput(){
		String[] args = {"1+", "2","-"," ","3"};
		String inputString = null;
		inputString = InputParser.formatingJoinedString(args); //"1+2-3"
		assertEquals("1+2-3", inputString);
	}
	
	@Test 
	public void testInputParser_ReturnStringArr(){
		String inputString = "1+2-3";
		String[] expecting = {"1","+","2","-","3"};
		String[] strArr = InputParser.formatStringToStrArr(inputString);
		assertArrayEquals(expecting, strArr);

	}


}
 