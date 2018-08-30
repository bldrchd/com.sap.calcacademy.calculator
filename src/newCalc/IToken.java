package newCalc;

public interface IToken {
	
	   public static final int UNKNOWN = -1;
	   public static final int NUMBER = 0;
	   public static final int OPERATOR = 1;
	   public static final int LEFT_PARENTHESIS = 2;
	   public static final int RIGHT_PARENTHESIS = 3;
	   
	   int getType();
}
