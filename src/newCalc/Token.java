package newCalc;

public class Token {
	
	private String type;
	private Number value;
	private char operator;
	private int prio;
	
	public Token(){
		type = "UNKNOWN";
	}
	public Token(double x) {
	       type = "NUMBER";
	       value = x;
	}
	
	public String getType(){
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
            type = "OPERATOR";
            operator = contents.charAt(0);
            prio = 1;
            break;
        case "-":
            type = "OPERATOR";
            operator = contents.charAt(0);
            prio = 1;
            break;
        case "*":
            type = "OPERATOR";
            operator = contents.charAt(0);
            prio = 2; 
            break;
        case "/":
            type = "OPERATOR";
            operator = contents.charAt(0);
            prio = 2;
            break;
        case "(":
            type = "LEFT_PARENTHESIS";
            break;
        case ")":
            type = "RIGHT_PARENTHESIS";
            break;
        default:
            type = "NUMBER";
            try {
                value = Double.parseDouble(contents);
            } catch (Exception ex) {
                type = "UNKNOWN";
            }
		}
	}
	//move this functionality in Expression? 
	Expression evaluate(Number operand1, Number operand2){
	//Token evaluate(Number operand1, Number operand2){
		Expression expr = null;
		//Number result = 0;
		switch(operator){
		case '+':
			Operation add = new AddOperation();
           // result = add.execute(operand1, operand2);
            expr = new Expression(add, operand1, operand2);
            break;
        case '-':
        	Operation subtract = new SubtractOperation();
          //  result = subtract.execute(operand1, operand2);
            expr = new Expression(subtract, operand1, operand2);
            break;
        case '*':
        	Operation multiply = new MultiplyOperation();
          //  result = multiply.execute(operand1, operand2);
            expr = new Expression(multiply, operand1, operand2);
            break;
        case '/':
        	Operation divide = new DivideOperation();
          //  result = divide.execute(operand1, operand2);
            expr = new Expression(divide, operand1, operand2);
            break;
		}
		return expr;
		//return new Token(result.doubleValue());
	}
}
