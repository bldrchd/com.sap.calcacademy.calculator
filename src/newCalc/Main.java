package newCalc;

public class Main {

    public static void main(String[] args) {
        String buildedString = buildString(args);
        Calculator c = new Calculator();
        System.out.println("MAIN RESULT: " + c.calculate(buildedString));
    }

    /**
     * Returns user input arguments as one string
     */
    // TODO - ? The static here (because main is also static)
    private static String buildString(String[] inputArgs) {
        StringBuilder builder = new StringBuilder();
        if (inputArgs != null) {
            for (String s : inputArgs) {
                builder.append(s);
            }
        }
        return builder.toString();
    }
}
