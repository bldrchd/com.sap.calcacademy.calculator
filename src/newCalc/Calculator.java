package newCalc;

public class Calculator {

    /**
     * Calculates expression from user input
     * 
     * @param args
     *            User input (expression) as arguments
     * @param string
     *            User input converted to String
     * @return result Result from the calculation
     */
    Number calculate(String[] args) {
        Number result = 0;

        if (args.length != 0) {
            InputPreDetermination ipd = new InputPreDetermination();
            RevPolishNotation rpn = new RevPolishNotation();
            Determination dt = new Determination();

            String string = ipd.preValidation(args);
            String[] postfixExpression = dt.determinate(string);

            result = rpn.evaluateRPN(postfixExpression);
        } else {
            System.err.println("There is no input to calculate.");
            System.exit(1);
        }
        return result;
    }
}
