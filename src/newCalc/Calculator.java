package newCalc;

public class Calculator extends Main{
	
	public Number calculate(String[] args){

		InputParser ip = new InputParser();
		Number result = ip.parse(args).execute();
		return result;
	}
	
}
