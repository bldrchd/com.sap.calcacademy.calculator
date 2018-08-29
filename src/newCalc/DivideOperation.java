package newCalc;

public class DivideOperation implements Operation{

	@Override
	public Number execute(Number oper1, Number oper2) {
		if ( oper2.toString().equals("0")){
				throw new ArithmeticException("Can not divide by 0");
		}
		return new Double(oper1.doubleValue() / oper2.doubleValue());
	}

}
