package newCalc;

public class Calculator extends Main {

	public void calculate(String[] args) {

		if (args.length != 0) {
			InputPreDetermination ipd = new InputPreDetermination();
			InputDetermination id = new InputDetermination();
			//TokenProcess tp = new TokenProcess();
			RevPolishNotation rpn = new RevPolishNotation();
			
			String string = ipd.preValidation(args);
			id.determinate(string);
			String[] postfixExpression = id.buildFinalPostfixExpression();
			//Number result = tp.parse(postfixExpression);
			rpn.evaluateRPN(postfixExpression);
			
			//System.out.println("Result = " + result);
			System.out.println("Expected result for 22+(3/5)+1-1-(-3) = 25.6");
		} else {
			System.err.println("There is no input to calculate.");
			System.exit(1);
		}
	}
}
