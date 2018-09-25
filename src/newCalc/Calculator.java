package newCalc;

public class Calculator extends Main {
	private Number result = 0;
	public void calculate(String[] args) {

		if (args.length != 0) {
			InputPreDetermination ipd = new InputPreDetermination();
			InputDetermination id = new InputDetermination();
			RevPolishNotation rpn = new RevPolishNotation();
			
			String string = ipd.preValidation(args);
			id.determinate(string);
			String[] postfixExpression = id.buildFinalPostfixExpression();

			rpn.evaluateRPN(postfixExpression);
			result = rpn.getResult();
			
		} else {
			System.err.println("There is no input to calculate.");
			System.exit(1);
		}
	}
	public Number getResult(String[] args) {
		calculate(args);
		return result;
	}
}
