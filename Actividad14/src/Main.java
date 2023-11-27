
/*
Ejercicio integrador N° 3:
Desarrollar un programa que implemente los siguientes componentes:
- Hilos
- MVC
- Funciones
Nos contrataron de la empresa Pepito Y Asociados (Venta de vehiculos) para diseñar un software a medida. El mismo esta orientado a la información contable de los clientes. Donde se lleva un registro
de toda la data financiera de la empresa. Ademas de esto, el sistema debe poder almacenar información asociada al stock de los productos.
(Modelo - Hilo 1)
Modulo de stock (pedir por pantalla):
- Detalle del producto
- Color
- Peso
- Precio
- Unidades vendidas
- Fecha de elaboración
- Fecha de Vencimiento

(Controlador - Hilo 2)
Modulo de Financiera:
- Ganancias Bruta = Suma de las unidades vendidas
- Ganancia Neta = Ganancia bruta * 0.83
- Perdida proyectada = Ganancia neta / 12
- Diferencia de días entre F. Elaboración - F. Vencimiento
(Vista - Hilo 3):
La información del Stock debe ser ingresada por consola (para al menos 5 productos) y la información de Financiera se arma en base al Stock.
Mostrar por consola la información del modulo de Financiera
PUNTOS EXTRA:
- Que el usuario pueda ver la información por consola y pueda elegir.
¿Que información queres ver?
1. Stock
2. Información financiera.

 */


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //Metodo para pedir toda la informacion por pantalla
    public static void ingresarDatosPorConsola(ArrayList<Producto> stock) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine();


        System.out.println("Ingrese el color del producto:");
        String color = scanner.nextLine();


        System.out.println("Ingrese el peso del producto:");
        double peso = scanner.nextDouble();

        System.out.println("Ingrese el precio del producto:");
        double precio = scanner.nextDouble();


        System.out.println("Ingrese las unidades vendidas:");
        int unidadesVendidas = scanner.nextInt();


        System.out.println("Ingrese la fecha de elaboración (yyyy-MM-dd HH:mm:ss):");
        scanner.nextLine(); // Consumir el salto de línea pendiente
        String fechaElaboracionStr = scanner.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime fechaElaboracion = LocalDateTime.parse(fechaElaboracionStr + " 00:00:00", formatter);



        System.out.println("Ingrese la fecha de vencimiento (yyyy-MM-dd ):");
        String fechaVencimientoStr = scanner.next();

        LocalDateTime fechaVencimiento = LocalDateTime.parse(fechaVencimientoStr + " 00:00:00", formatter);



        Producto p1 = new Producto(nombre,color,peso,precio,unidadesVendidas,fechaElaboracion,fechaVencimiento);
        stock.add(p1);


    }


    public static void main(String[] args) {


        ArrayList<Producto> stock = new ArrayList<>(); //Se almacenan todos los productos

        // Ingresar información por consola para al menos 5 productos
        for (int i = 0; i < 5; i++) {
            ingresarDatosPorConsola(stock); //con el hilo principal (hilo 1) se pide los parametros
        }


        Thread hiloStock = new Thread(() -> {
            ConsoleView.mostrarInformacionStock(stock); //se ejecuta el stock y se muestra hilo 3
        });

        Thread hiloFinanciera = new Thread(() -> { //se ejecuta el finacialModel y se muestra hilo 2
            double gananciaBruta = FinacialModel.gananciaBruta(stock);
            double gananciaNeta = FinacialModel.gananciaNeta(gananciaBruta);
            double perdidaProyectada = FinacialModel.perdidaProyectada(gananciaNeta);
            ArrayList<Long> diferenciaDias = FinacialModel.diferenciaDias(stock);

            ConsoleView.mostrarInformacionFinanciera(gananciaBruta, gananciaNeta, perdidaProyectada,diferenciaDias);
        });


        // Puntos extra - Menú
        int opcion = ConsoleView.mostrarMenu();
        if (opcion == 1) {
            hiloStock.start();
        } else if (opcion == 2) {
            hiloFinanciera.start();

        }
    }




}
