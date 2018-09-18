package newCalc;

public class Calculator extends Main {

	public void calculate(String[] args) {

		if (args.length != 0) {
			InputPreDetermination ipd = new InputPreDetermination();
			InputDetermination id = new InputDetermination();
			RevPolishNotation rpn = new RevPolishNotation();
			
			String string = ipd.preValidation(args);
			id.determinate(string);
			String[] postfixExpression = id.buildFinalPostfixExpression();

			rpn.evaluateRPN(postfixExpression);
			
		} else {
			System.err.println("There is no input to calculate.");
			System.exit(1);
		}
	}
}
