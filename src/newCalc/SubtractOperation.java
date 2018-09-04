package newCalc;

public class SubtractOperation implements Operation {

	@Override
	public Number execute(Number oper1, Number oper2) {
		return new Double(oper1.doubleValue() - oper2.doubleValue());
	}

}
