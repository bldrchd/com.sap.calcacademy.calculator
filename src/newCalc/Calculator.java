package newCalc;

public class Calculator extends Main {

	public void calculate(String[] args) {
		if (args.length != 0) {
			InputPreDetermination id = new InputPreDetermination();
			//InputParser ip = new InputParser();
			id.preValidation(args);

		} else {
			System.err.println("There is no input to calculate.");
			System.exit(1);
		}
	}
}
