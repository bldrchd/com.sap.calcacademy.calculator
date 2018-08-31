package newCalc;

public class Expression {
	
	private Operation operation;
	private Number operand1;
	private Number operand2;
	private char operator;
	
	public Operation getOperation(){
		return operation;
	}
	public Number getOperand1(){
		return operand1;
	}
	public Number getOperand2(){
		return operand2;
	}
	//not needed anymore:
	public char operator(){
		return operator;
	}
	public Expression(){
		
	}	
	public Expression(Operation operation, Number operand1, Number operand2){
		this.operation = operation;
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	//not needed anymore:
	public Expression(char operator, Number operand1, Number operand2){
		this.operator = operator;
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	
	public Number execute(){
		//TODO
		System.out.println(operand1.doubleValue());
		System.out.println(operand2.doubleValue());
		return Operation.execute(operand1, operand2);
	}
	
	public void setOperand1(Number operand1){
		this.operand1 = operand1;
	}
	public void setOperand2(Number operand2){
		this.operand2 = operand2;
	}
	public void setOperation(Operation operation){
		this.operation = operation;
	}
	//not needed anymore:
	public void setOperator(char operator){
		this.operator = operator;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Expression)) 
			return false;
		Expression e = (Expression)obj;
		return e.getOperand1().equals(this.operand1) && e.getOperand2().equals(this.operand2) && e.getOperation().equals(this.operation);
	}
	public String toString(Object obj){
		Expression e = (Expression)obj;
		String s = "Expression = "+ e.operand1 + " " + e.operator + " " + e.operand2;  
		return s;
		
	}
}
