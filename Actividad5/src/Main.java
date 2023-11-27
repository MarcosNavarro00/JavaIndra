
/*
Autor: Marcos Navarro

Trabajamos para una cadena de Supermecados y nos solicitaron que desarrollamos un nuevo sistema para sus productos. El mismo debe tener la capacidad de pedir por consola
los siguientes campos:
- Nombre del producto
- Precio
- Fecha de caducidad (Tipo de campo DATE)
Para ello el programa debe poder realizar las siguientes acciones:
- Informar la cantidad de dias que falta para que el producto caduque. Fecha Actual - Fecha de Caducidad
- Informar El precio con descuento. Precio - (Precio * 0.25)
Generar un fichero de salida con la información final, y, hacerlo para al menos 5 productos.


 */


import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            for (int i = 0; i<5; i++){
                System.out.println("Ingrese la información del Producto " + i + ":");

                System.out.println("Nombre del Producto: ");
                String nombre = sc.nextLine();

                System.out.println("Precio del Producto: ");
                double precio = sc.nextDouble();

                sc.nextLine();
                System.out.println("Fecha de caducidad del Producto: ");
                String fechaCaducidad = sc.nextLine();

                Producto p = new Producto(nombre,precio,fechaCaducidad);
                System.out.println(p.toString());
                p.enviarATxt();



            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }
}