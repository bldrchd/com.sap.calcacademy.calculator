package newCalc;

public class Type {
	
	private String type;
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
	
	void evaluateType(String type){
		
	}
}
