package newCalc;

public class Calculator extends Main {

	public void calculate(String[] args) {

		if (args.length != 0) {
			InputPreDetermination ipd = new InputPreDetermination();
			InputDetermination id = new InputDetermination();
			TokenProcess tp = new TokenProcess();

			String string = ipd.preValidation(args);
			id.determinate(string);
			Number result = tp.parse(id.buildFinalPostfixExpression());

			System.out.println("Result = " + result);
		} else {
			System.err.println("There is no input to calculate.");
			System.exit(1);
		}
	}
}
