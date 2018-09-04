package newCalc;

public class Calculator extends Main{
	
	public void calculate(String[] args){

		InputParser ip = new InputParser();
		Number result = ip.parse(args);
		System.out.println(result);
	}
}
