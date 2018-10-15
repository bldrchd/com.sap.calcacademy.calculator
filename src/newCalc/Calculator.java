package newCalc;

public class Calculator {
    private Number result = 0;

    public Number calculate(String[] args) {

        if (args.length != 0) {
            InputPreDetermination ipd = new InputPreDetermination();
            InputDetermination id = new InputDetermination();
            RevPolishNotation rpn = new RevPolishNotation();
            Determination dt = new Determination();

            String string = ipd.preValidation(args);
            // id.determinate(string);
            dt.deteminate(string);
            // String[] postfixExpression = id.buildFinalPostfixExpression();
            String[] postfixExpression = dt.buildFinalPostfixExpression();

            rpn.evaluateRPN(postfixExpression);
            result = rpn.getResult();

        } else {
            System.err.println("There is no input to calculate.");
            System.exit(1);
        }
        return result;
    }
}
