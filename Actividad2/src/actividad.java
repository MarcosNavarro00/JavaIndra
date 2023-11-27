import java.util.Scanner;

public class actividad {
    private double n;

    public actividad(double n) {
        this.n = n;
    }

    public double calculateFactorial() {
        if (n < 0) {
            System.out.println("There is no factorial for negative numbers");
            return 0;
        }
        double factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public double squareRoot() {
        if (n < 0) {
            System.err.println("You cannot calculate the square root of a negative number.");
            return 0;
        }
        return Math.sqrt(n);
    }

    public double absoluteValue() {
        return Math.abs(n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double n1 = scanner.nextDouble();
        actividad operation1 = new actividad(n1);

        System.out.print("Enter the second number: ");
        double n2 = scanner.nextDouble();
        actividad operation2 = new actividad(n2);

        System.out.print("Enter the third number: ");
        double n3 = scanner.nextDouble();
        actividad operation3 = new actividad(n3);

        System.out.println("Results of the first number :");
        System.out.println("Factorial of " + n1 + ": " + operation1.calculateFactorial());
        System.out.println("Square Root of " + n1 + ": " + operation1.squareRoot());
        System.out.println("Absolute value of " + n1 + ": " + operation1.absoluteValue());

        System.out.println("Results of the second number :");
        System.out.println("Factorial of " + n2 + ": " + operation2.calculateFactorial());
        System.out.println("Raíz cuadrada de " + n2 + ": " + operation2.squareRoot());
        System.out.println("Absolute value of " + n2 + ": " + operation2.absoluteValue());

        System.out.println("Results of the third number :");
        System.out.println("Factorial of " + n3 + ": " + operation3.calculateFactorial());
        System.out.println("Square Root of " + n3 + ": " + operation3.squareRoot());
        System.out.println("Absolute value of " + n3 + ": " + operation3.absoluteValue());

        scanner.close();
    }
}
