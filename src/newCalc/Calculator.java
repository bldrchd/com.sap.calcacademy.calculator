package newCalc;

public class Calculator extends Main {

	public void calculate(String[] args) {
		if (args.length != 0) {
			InputPreDetermination ipd = new InputPreDetermination();
			//InputParser ip = new InputParser();
			String string = ipd.preValidation(args);
			InputDetermination id = new InputDetermination();
			id.determinate(string);

		} else {
			System.err.println("There is no input to calculate.");
			System.exit(1);
		}
	}
}
