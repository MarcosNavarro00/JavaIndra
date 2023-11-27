import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Producto {

    private String nombre;
    private double precio;
    private Date fechaCaducidad;

    public Producto(String nombre, double precio,String fechaCaducidad ) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaCaducidad = dateFormat.parse(fechaCaducidad);
        this.nombre = nombre;
        this.precio = precio;
    }

    public double calcularPrecioDescuento(){
        return precio - (precio * 0.25);
    }

    public long diasSinCaducidad(){
        Date fechaActual = new Date();
        long diferenciaMili = fechaCaducidad.getTime() - fechaActual.getTime();
        return diferenciaMili/ (24 * 60 * 60 * 1000);
    }

    @Override
    public String toString() {
        if (diasSinCaducidad() <0){
            return "Nombre del producto: " + nombre +
                    "\nPrecio del Producto: " + precio +
                    "\nPrecio con descuento: " + calcularPrecioDescuento()+
                    "\nFecha de Caducidad: " + fechaCaducidad.toString() +
                    "\nDías hasta la caducidad: " + "El producto ya está caducado" +
                    "\n---------------------------------------------";
        }
        return "Nombre del producto: " + nombre +
                "\nPrecio del Producto: " + precio +
                "\nPrecio con descuento: " + calcularPrecioDescuento()+
                "\nFecha de Caducidad: " + fechaCaducidad.toString() +
                "\nDías hasta la caducidad: " + diasSinCaducidad() +
                "\n---------------------------------------------";
    }
    public void enviarATxt(){
        String nombreArchivo = "datos_Supermercado.txt";

        File archivo = new File(nombreArchivo);

        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true));

            String informacion = toString();

            writer.write(informacion);
            writer.newLine();

            writer.close();

            System.out.println("Los datos se han escrito en el archivo " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
