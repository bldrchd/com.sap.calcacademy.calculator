package newCalc;

public class DivideOperation implements Operation {

	@Override
	public Number execute(Number oper1, Number oper2) {
		if (oper2.toString().equals("0")) {
			throw new ArithmeticException("Can not divide by 0");
		}
		System.out.println("Operation"+oper2.doubleValue() + "/" + oper1.doubleValue());
		return new Double(oper2.doubleValue() / oper1.doubleValue());
	}

	@Override
	public String toString() {
		return " / ";
	}

}
