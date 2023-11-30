package org.example;

public class Persona {

    private String nombre;
    private String apellidos;
    private String ciudad;
    private int edad;

    public Persona(String nombre,String apellidos,String ciudad, int edad){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ciudad = ciudad;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", edad=" + edad +
                '}';
    }
}
