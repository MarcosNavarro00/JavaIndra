
/*
Desarrollar un programa en Java que implemente 3 hilos, los cuales cada uno va a ser encargado de
realizar distintas acciones.
Hilo principal:
Generar la información del sistema, recibir la informacion y calcularla.
Hilo secundario 1:
Generar un directorio
Hilo secundario 2:
Imprimir la información que genera el sistema en un archivo de salida tipo txt
Nos contraron del Ministerio de Geografica para desarrollarles un sistema que los ayude a contabilizar
la información de las distintas ciudades.Se debe ingresar por consola los siguientes campos:
- Ciudad
- Cantidad de habitantes
- Superficie
El programa debe implementar al menos una Interfaz que se encargue de generar el campo:
- "Proyección habitantes 2030"  = Cantidad de habitantes * 0.90
- Superficie ocupada= Superficie actual + 10000
Luego, generar el fichero de salida:
- Ciudad
- Cantidad de habitantes
- Superficie
- Proyección habitantes 2030
- Superficie ocupada
Realizar para al menos 3 ciudades de España
from Profesor | Gustavo Vargas to everyone:    3:30 PM
Entregables:
- Link de tu repositorio con el codigo del proyecto (SUBIRLO DESDE TU IDE A GITHUB).

 */


import java.util.Scanner;

public class Main {

    //Se pide la informacion por pantalla
    public static Ministerio askInformation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la ciudad:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la población de la ciudad:");
        int poblacion = scanner.nextInt();

        // Limpiar el buffer del scanner
        scanner.nextLine();

        System.out.println("Ingrese la superficie de la ciudad:");
        double superficie = scanner.nextDouble();

        // Crear y retornar un objeto Ciudad con los datos proporcionados
        return new Ministerio(nombre, poblacion, superficie);
    }

    public static void main(String[] args) {

        //Se crea el primer hilo
        Thread t1 = new Thread(new tarea("Thread 1"));
        t1.start();

        try {
            // Esperar a que t1 termine antes de continuar con t2
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Se crea los objetos de las 3 ciudades y se pide por pantalla
        Ministerio[] ministerios = new Ministerio[3];
        ministerios[0] = askInformation();
        ministerios[1] = askInformation();
        ministerios[2] = askInformation();

        ministerios[0].print();
        ministerios[1].print();
        ministerios[2].print();

        // Crear el hilo t2
        Thread t2 = new Thread(new tarea("Thread 2", ministerios));
        t2.start();




    }
}