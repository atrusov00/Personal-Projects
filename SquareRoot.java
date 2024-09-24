public class SquareRoot {

    public static final double EPSILON = 1e-7;

    public static double sqrt(double num, double epsilon) {
        if (Double.isNaN(num) || num < 0) {
            return Double.NaN;
        } else if (num == 0 || num == Double.POSITIVE_INFINITY) {
            return num;
        } else {
            double currentGuess = num;
            double previousGuess = 0;

            // Note to self: this is the Babylonian loop
            do {
                previousGuess = currentGuess;
                currentGuess = 0.5 * (previousGuess + (num / previousGuess));
            } while (Math.abs(currentGuess - previousGuess) > epsilon);

            return currentGuess;
        }
    }

    public static void main(String[] args) {
        if (args.length < 1 || args.length > 2) {
            System.err.println("Usage: java SquareRoot <value> [epsilon]");
            System.exit(1);
        }

        double num = 0;
        double epsilon = EPSILON;

        try {
            num = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Error: Value argument must be a double.");
            System.exit(1);
        }

        if (args.length == 2) {
            try {
                epsilon = Double.parseDouble(args[1]);
                if (epsilon <= 0) {
                    System.err.println("Error: Epsilon argument must be a positive double.");
                    System.exit(1);
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Epsilon argument must be a positive double.");
                System.exit(1);
            }
        }

        System.out.printf("%.8f\n", sqrt(num, epsilon));
    }


}