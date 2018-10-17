package newCalc;

public class Calculator {

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
