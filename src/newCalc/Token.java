package newCalc;

public class Token {

	public static final int UNKNOWN = -1;
	public static final int NUMBER = 0;
	public static final int OPERATOR = 1;
	public static final int LEFT_PARENTHESIS = 2;
	public static final int RIGHT_PARENTHESIS = 3;

	private int type;
	private Number value;
	private String operator;
	private int prio;
	private Operation operation = null;

	public Token() {
		type = UNKNOWN;
	}

	public Token(double value) {
		type = NUMBER;
		this.value = value;
	}

	public int getType() {
		return type;
	}

	public Number getValue() {
		return value;
	}

	public String getOperator() {
		return operator;
	}

	public int getPrio() {
		return prio;
	}
	/*
	 * public Double toDoubleV(double value){ return this.value.doubleValue() =
	 * value; }
	 */

	public Token(String contents) {
		switch (contents) {
		case "+":
			type = OPERATOR;
			this.operator = contents; // contents.charAt(0);
			prio = 1;
			break;
		case "-":
			type = OPERATOR;
			this.operator = contents;// contents.charAt(0);
			prio = 1;
			break;
		case "*":
			type = OPERATOR;
			this.operator = contents;
			// operator = contents.charAt(0);
			prio = 2;
			break;
		case "/":
			type = OPERATOR;
			this.operator = contents;
			// operator = contents.charAt(0);
			prio = 2;
			break;
		case "(":
			type = LEFT_PARENTHESIS;
			break;
		case ")":
			type = RIGHT_PARENTHESIS;
			break;
		default:
			type = NUMBER;
			try {
				value = Double.parseDouble(contents);
			} catch (Exception ex) {
				type = UNKNOWN;
			}
		}
	}

	Expression evaluate(String operator, Number operand1, Number operand2) {
		Expression expr = null;
		switch (operator) {
		case "+":
			this.operation = new AddOperation();
			// Operation add = new AddOperation();
			expr = new Expression(operation, operand1, operand2);
			break;
		case "-":
			this.operation = new SubtractOperation();
			// Operation subtract = new SubtractOperation();
			expr = new Expression(operation, operand1, operand2);
			break;
		case "*":
			this.operation = new MultiplyOperation();
			expr = new Expression(operation, operand1, operand2);
			break;
		case "/":
			this.operation = new DivideOperation();
			expr = new Expression(operation, operand1, operand2);
			break;
		default:
			System.out.println("Not found");
		}
		return expr;
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Token))
			return false;
		Token e = (Token) obj;
		return e.getValue().equals(this.value) || e.getOperator() == this.operator || e.getPrio() == this.prio;
	}

	public String operatorToString(Object obj) {
		Token t = (Token) obj;
		return String.valueOf(t.getOperator());
	}

	public Double operandToDouble(Object obj) {
		Token t = (Token) obj;
		return Double.valueOf(t.getValue().doubleValue());
	}
}
