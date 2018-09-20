package newCalc;

public class DivideOperation implements Operation {

	@Override
	public Number execute(Number oper2, Number oper1) throws ArithmeticException {
		if (oper1.toString().equals("0.0")) {
			throw new ArithmeticException("Can not divide by 0");
		} else {
		return new Double(oper2.doubleValue() / oper1.doubleValue());
		}
	}

	@Override
	public String toString() {
		return " / ";
	}

}
