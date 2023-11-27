import java.util.*;

public class Main {
    public static void main(String[] args) {

        double num1, num2, result = 0;
        char op;

        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("Welcome to the CALCULATOR");
        System.out.println("Enter the first number");
        num1 = sc.nextDouble();

        System.out.println("Enter the operation (Possible operations +,-,*,/)");
        op = sc.next().charAt(0);

        System.out.println("Enter the second number");
        num2 = sc.nextDouble();

        switch (op) {
            case '+':
                result = Operations.sum(num1, num2);
                break;
            case '-':
                result = Operations.subt(num1, num2);
                break;
            case '*':
                result = Operations.mult(num1, num2);
                break;
            case '/':
                result = Operations.div(num1, num2);
                break;
            default:
                System.err.println("Invalid operation");
                break;
        }


        System.out.println("The result of the operation " + op + "is: " + result);
        sc.close();

    }
}