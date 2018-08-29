package newCalc;

public class Calculator extends Main{
	
	public Number calculate(String inputString){
		
		InputParser ip = new InputParser();
		Number result = ip.parse(inputString).execute();
		return result;
	}
	
}
