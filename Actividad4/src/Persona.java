import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
public class Persona {

    private String nombre, apellido, ciudad;
    private int edad;


    public Persona (String nombre, String apellido, int edad, String ciudad ){
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;

    }
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiudad() {
        return ciudad;
    }



}
