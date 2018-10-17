package newCalc;

public class Calculator {

    /**
     * Calculates expression from user input
     * 
     * @param args
     *            User input (expression) as arguments
     * @param string
     *            User input converted to String
     * @return Result from the calculation and 0 if no input is available
     */
    Number calculate(String[] args) {
        if (args.length != 0) {
            InputPreDetermination ipd = new InputPreDetermination();
            String string = ipd.preValidation(args);
            String[] postfixExpression = null;
            Determination dt = new Determination();
            postfixExpression = dt.determinate(string);
            return new RevPolishNotation().evaluateRPN(postfixExpression);
        } else {
            System.err.println("There is no input to calculate.");
            return 0;
        }
    }
}
