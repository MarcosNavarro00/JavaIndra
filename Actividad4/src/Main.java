
/*
Autor MARCOS NAVARRO JUAN
En base a lo que ya has aprendido, se debe armar un programa. Nos contactaron desde el area de recursos humanos para ayudarlos con el desarrollo de un nuevo sistema.
El cual debe almacenar en el programa la siguiente información (pedida por consola) de los empleados:
- Nombre
- Apellido
- Edad
- Ciudad
- Puesto
- Salario Bruto
- Area
Esta información se debe almacenar y en base a la misma se deben hacer los siguientes calculos:
- Salario neto = Salario bruto * 0.80
Informar todos los campos en un fichero de salida que se llame "informacion_nomina.txt".
ESTRUCTURA DEL PROGRAMA:
- El programa debe implementar la clase Persona y ser utilizada para herencia.
- El programa debe implementar el metodo calculoSalarioNeto dentro de una interfaz.
- Hacer para al menos 3 empleados.
ENTREGABLES:
- Codigo del proyecto.
 */


import java.util.Scanner;

public class Main  {

    public static String pedirParametrosS (String parametro){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor, ingrese el " + parametro + " de la persona: ");
        return scanner.next();
    }

    public static int pedirParametrosI (String parametro){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor, ingrese " + parametro + " de la persona: ");
        return scanner.nextInt();
    }
    public static double pedirParametrosD (String parametro){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor, ingrese " + parametro + " de la persona: ");
        return scanner.nextDouble();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor, indique el numero de persona que quiere dar de alta: ");
        int nEmpleados = scanner.nextInt();

        Empleado[] listaEmpleados = new Empleado[nEmpleados];
        for (int i = 0; i < nEmpleados; i++) {
            System.out.print("\n");
            System.out.print("Persona " + i + ": ");
            String nombre = pedirParametrosS ("el nombre");
            String apellidos = pedirParametrosS ("los apellidos");
            int edad = pedirParametrosI ("la edad");
            String ciudad = pedirParametrosS ("la ciudad");
            String puesto = pedirParametrosS ("el puesto");
            double salarioB = pedirParametrosD ("el salario bruto");
            String area = pedirParametrosS ("el area");

            listaEmpleados[i] = new Empleado(nombre, apellidos, edad, ciudad, puesto, salarioB, area);
            listaEmpleados[i].imprimirPersona();
            listaEmpleados[i].enviarATxt();
        }

        System.out.print("[INFO]. Fin del Programa");

    }



}



















