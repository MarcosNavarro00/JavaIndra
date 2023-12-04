package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static Empleado pedirInfo(){
        Scanner scanner = new Scanner(System.in);


        System.out.print("Nombre del empleado: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido del empleado: ");
        String apellido = scanner.nextLine();

        System.out.print("Fecha de ingreso: ");
        String fechaIngreso = scanner.nextLine();

        System.out.print("Fecha de salida: ");
        String fechaSalida = scanner.nextLine();

        System.out.print("Sexo: ");
        String sexo = scanner.nextLine();

        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();

        System.out.print("Posición: ");
        String posicion = scanner.nextLine();

        System.out.print("Salario base: ");
        double salarioBase = scanner.nextDouble();



        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);

        LocalDate requestDateF = LocalDate.parse(fechaIngreso, formatter);
        LocalDate deliveryDateF = LocalDate.parse(fechaSalida, formatter);

        Empleado e = new Empleado(nombre,apellido,requestDateF,deliveryDateF,sexo,ciudad,posicion,salarioBase);

        return  new Empleado(nombre,apellido,requestDateF,deliveryDateF,sexo,ciudad,posicion,salarioBase);
    }

    public static void main(String[] args) {

        Empleado[] empleados = new Empleado[2];

        for (int i = 0; i<2; i++){
            empleados[i] = pedirInfo();
            empleados[i].toString();
            empleados[i].JSON();
        }





    }
}