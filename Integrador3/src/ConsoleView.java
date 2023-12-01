//Se corresponde con la vista


import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleView {

    static void mostrarInformacionFinanciera(double gananciaBruta, double gananciaNeta, double perdidaProyectada,ArrayList<Long> diferenciaDias) {
        System.out.println("----- Información Financiera -----");
        System.out.println("Ganancia Bruta: " + gananciaBruta);
        System.out.println("Ganancia Neta: " + gananciaNeta);
        System.out.println("Perdida Proyectada: " + perdidaProyectada);

        for (int i = 0; i < diferenciaDias.size(); i++) {
            System.out.println("Días de diferencia Producto " + i + ": " + diferenciaDias.get(i));
        }
    }

    static void mostrarInformacionStock(ArrayList<Producto> stock) {
        System.out.println("----- Información de Stock -----");
        for (Producto producto : stock) {
            System.out.println("Nombre: " + producto.nombre);
            System.out.println("Color: " + producto.color);
            System.out.println("Peso: " + producto.peso);
            System.out.println("Precio: " + producto.precio);
            System.out.println("Unidades Vendidas: " + producto.unidadesVendidas);
            System.out.println("Fecha de Elaboración: " + producto.fechaElaboracion);
            System.out.println("Fecha de Vencimiento: " + producto.fechaVencimiento);
            System.out.println("------------------------------");
        }
    }

    static int mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué información quieres ver?");
        System.out.println("1. Stock");
        System.out.println("2. Información Financiera");
        return scanner.nextInt();
    }
}


