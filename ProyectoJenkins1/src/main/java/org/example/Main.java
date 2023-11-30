/*
Ejercicios Jenkins - Actividad °3:
Desarrollar un proyecto de tipo Maven que contenga información sobre un usuario (la información es solicitada por consola).
- Nombre
- Apellido
- Ciudad
- Edad
Y luego compilar el proyecto en Jenkins con el siguiente comando:
clean install
El proyecto debe estar subido a Github para su compilación.
Entregable:
- Captura de la consola de Jenkins.
 */


package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();


        System.out.print("Ingrese su apellido: ");
        String apellidos = scanner.nextLine();


        System.out.print("Ingrese su ciudad: ");
        String ciudad= scanner.nextLine();


        System.out.print("Ingrese su edad: ");
        int edad  = scanner.nextInt();

        scanner.close();
        Persona p1 = new Persona(nombre,apellidos,ciudad,edad);

        p1.toString();
    }
}