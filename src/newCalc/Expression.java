package newCalc;

public class Expression {
	
	private Operation operation;
	private Number operand1;
	private Number operand2;
	private String operator;
	
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
	public String operator(){
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
	public Expression(String operator, Number operand1, Number operand2){
		this.operator = operator;
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	
	public Number execute(){
		
		Operation add = new AddOperation();
		Operation subtract = new SubtractOperation();
		Operation multiply = new MultiplyOperation();
		Operation divide = new DivideOperation();
		Number result = 0;
		
		if (operation.getClass().isInstance(add)){
			result = add.execute(operand1, operand2);
		} else if (operation.getClass().isInstance(subtract)){
			result = subtract.execute(operand1, operand2);
			System.out.println(result);
		} else if (operation.getClass().isInstance(multiply)){
			result = multiply.execute(operand2, operand2);
			System.out.println(result);
		} else if (operation.getClass().isInstance(divide)){
			result = divide.execute(operand1, operand2);
			System.out.println(result);
		} else {
			System.out.println("Error, not matching operation");
			result = null;
		}
		return result;
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
	public void setOperator(String operator){
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
