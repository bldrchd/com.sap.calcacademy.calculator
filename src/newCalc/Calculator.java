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
        String[] postfixExpression = null;
        RevPolishNotation rpn = new RevPolishNotation();

        if (args.length != 0) {
            InputPreDetermination ipd = new InputPreDetermination();
            Determination dt = new Determination();
            String string = ipd.preValidation(args);
            postfixExpression = dt.determinate(string);
            return rpn.evaluateRPN(postfixExpression);
        } else {
            System.err.println("There is no input to calculate.");
            return 0;
        }
    }
}
