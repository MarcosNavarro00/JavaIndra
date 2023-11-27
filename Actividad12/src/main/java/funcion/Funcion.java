package funcion;

import org.springframework.stereotype.Component;

@Component //Para indicar que esta clase es un componente de Spring, entonces debe de ser detectada durante el escaneo
public class Funcion
{

    public int sumar(int a, int b) {
        return a + b;
    }

    public int restar(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public int dividir(int a, int b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("No se puede dividir por cero");
        }
    }
}
