package newCalc;

public class Main {
	public static void main(String[] args){
		String intpuString = args.toString();
		Calculator c = new Calculator();
		c.calculate(intpuString);
	}
}
