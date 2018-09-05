package newCalc;

public class Calculator extends Main {

	public void calculate(String[] args) {
		if (args.length != 0) {
			InputParser ip = new InputParser();
			Number result = ip.parse(args);
			System.out.println(result);
		} else {
			System.err.println("There is no input to calculate.");
			System.exit(1);
		}
	}
}
