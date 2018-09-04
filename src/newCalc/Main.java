package newCalc;

public class Main {
	public static void main(String[] args){
		Calculator c = new Calculator();
		Number result = c.calculate(args);
		System.out.println(result);
	}
}
