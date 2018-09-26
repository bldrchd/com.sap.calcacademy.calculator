package newCalc;

public class Calculator {
    private Number result = 0;

    public Number calculate(String[] args) {

        if (args.length != 0) {
            InputPreDetermination ipd = new InputPreDetermination();
            InputDetermination id = new InputDetermination();
            RevPolishNotation rpn = new RevPolishNotation();

            String string = ipd.preValidation(args);
            id.determinate(string);
            String[] postfixExpression = id.buildFinalPostfixExpression();

            rpn.evaluateRPN(postfixExpression);
            result = rpn.getResult();

        } else {
            System.err.println("There is no input to calculate.");
            System.exit(1);
        }
        return result;
    }

    /*
     * public Number getResult(String[] args) { // TODO calculate(args); return
     * result; }
     */
}
