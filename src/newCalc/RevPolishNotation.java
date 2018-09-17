package newCalc;

public class RevPolishNotation {
		public void evaluateRPN(String[] postfixExpression) {
			for (int i = 0; i <= postfixExpression.length -1 ; i++) {
				String token = new String(postfixExpression[i]);
				//TODO RPN Algo
				System.out.println(i + " " + token);
			}
		}
}
