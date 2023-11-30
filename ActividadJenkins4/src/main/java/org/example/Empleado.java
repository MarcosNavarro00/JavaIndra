package org.example;

public class Empleado {

    private String nombre;
    private String puesto;
    private double sueldo;
    private int hEntrada;
    private int hSalida;

    private int nInfracciones = 0;
    private double sueldoFinal;

    public Empleado(String nombre,String puesto, double sueldo,int hEntrada,int hSalida) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.sueldo = sueldo;
        this.hEntrada = hEntrada;
        this.hSalida = hSalida;
    }


    public double calcularInfraccion(){
        switch (puesto){
            case "CEO":
                if (hEntrada != 7 || hSalida != 18){
                    nInfracciones++;
                    sueldoFinal = sueldo * 0.99;
                    break;

                }
            case "Jefe":
                if (hEntrada != 8 || hSalida != 18){
                    nInfracciones++;
                    sueldoFinal = sueldo * 0.95;
                    break;
                }
            case "Ingeniero":
                if (hEntrada != 9 || hSalida != 18){
                    nInfracciones++;
                    sueldoFinal = sueldo * 0.85;
                    break;
                }
            case "Analista":
                if (hEntrada != 9 || hSalida != 17){
                    nInfracciones++;
                    sueldoFinal = sueldo * 0.80;
                    break;
                }
            case "Scrum":
                if (hEntrada != 9 || hSalida != 18){
                    nInfracciones++;
                    sueldoFinal = sueldo * 0.90;
                    break;
                }
            case "RRHH":
                if (hEntrada != 9 || hSalida != 18){
                    nInfracciones++;
                    sueldoFinal = sueldo * 0.91;
                    break;
                }
            default:
                System.out.println("Posición no válida.");
        }
        return sueldoFinal;
    }

    public int getnInfracciones(){
        return nInfracciones;
    }

    public void print() {
        System.out.println("Empleado{" +
                "nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", sueldo=" + sueldo +
                ", hEntrada=" + hEntrada +
                ", hSalida=" + hSalida +
                ", nInfracciones=" + nInfracciones +
                ", sueldoFinal=" + sueldoFinal +
                '}');
    }
}
