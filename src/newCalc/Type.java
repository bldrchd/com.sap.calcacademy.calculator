package newCalc;

public class Type {
	
	//priorities :
	private String type;
/*	private int unknown = -1;
	private int number = 0;
	private int operator = 1;
	private int leftParenthesis = 2;
	private int rightParanthesis = 3;*/
	public final static String UNKNOWN = "unknown";
	public final static String OPERAND = "operand";
	public final static String OPERATOR = "operator";
	public final static String PATENTHESIS = "paranthesis";
	
	public Type(){
		type = UNKNOWN;
	}
	public Type(String type){
	}
	public Type(int type){		
	}
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}
	
	void evaluatePrio(String type){
		
	}
}
