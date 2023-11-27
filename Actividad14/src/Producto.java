
//Se corresponde al modelo y a la ejecucion del hilo 1

import java.time.LocalDateTime;

public class Producto {
    public String nombre;
    public String color;
    public double peso;
    public double precio;
    public int unidadesVendidas;
    public LocalDateTime fechaElaboracion;
    public LocalDateTime fechaVencimiento;

    public Producto(String nombre, String color, double peso, double precio, int unidadesVendidas, LocalDateTime fechaElaboracion, LocalDateTime fechaVencimiento ){
        this.color = color;
        this.nombre = nombre;
        this.peso = peso;
        this.precio = precio;
        this.unidadesVendidas = unidadesVendidas;
        this.fechaElaboracion = fechaElaboracion;
        this.fechaVencimiento = fechaVencimiento;

    }

}
