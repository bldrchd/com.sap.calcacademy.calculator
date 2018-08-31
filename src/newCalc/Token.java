package newCalc;

public class Token implements IToken{
	
	private int type;
	private Number value;
	private char operator;
	private int prio;
	
	public Token(){
		type = UNKNOWN;
	}
	public Token(double value) {
	       type = NUMBER;
	       this.value = value;
	}
	@Override
	public int getType() {
		return type;
	}
	public Number getValue(){
		return value;
	}
	public char getOperator(){
		return operator;
	}
	public int getPrio() {
		return prio;
	}
	
	public Token(String contents){
		switch (contents){
		case "+":
            type = OPERATOR;
            operator = contents.charAt(0);
            prio = 1;
            break;
        case "-":
            type = OPERATOR;
            operator = contents.charAt(0);
            prio = 1;
            break;
        case "*":
            type = OPERATOR;
            operator = contents.charAt(0);
            prio = 2; 
            break;
        case "/":
            type = OPERATOR;
            operator = contents.charAt(0);
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
	
	Expression evaluate(Number operand1, Number operand2){
		Expression expr = null;
		switch(operator){
		case '+':
			Operation add = new AddOperation();
            expr = new Expression(add, operand1, operand2);
            break;
        case '-':
        	Operation subtract = new SubtractOperation();
            expr = new Expression(subtract, operand1, operand2);
            break;
        case '*':
        	Operation multiply = new MultiplyOperation();
            expr = new Expression(multiply, operand1, operand2);
            break;
        case '/':
        	Operation divide = new DivideOperation();
            expr = new Expression(divide, operand1, operand2);
            break;
		}
		return expr;
	}
	
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Token)) 
			return false;
		Token e = (Token)obj;
		return e.getValue().equals(this.value) || e.getOperator() == this.operator || e.getPrio() == this.prio;
	}
}
