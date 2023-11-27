public class Operations {
    public static double sum(double a, double b) {
        return a + b;
    }

    public static double subt(double a, double b) {
        return a - b;
    }

    public static double mult(double a, double b) {
        return a * b;
    }

    public static double div(double a, double b) {
        if (b == 0) {
            System.err.println("Error: Cannot divide by zero.");
            return Double.NaN; // NaN representa "Not-a-Number" en Java
        } else {
            return a / b;
        }
    }
}