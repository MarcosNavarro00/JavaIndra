import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vuelo {

    public String nombre,tipoPasaje;
    public int nPasajeros;
    public double valor;
    public LocalDate fecha;

    public Vuelo(String nombre, int nPasajeros,  String tipoPasaje,  double valor,LocalDate fecha ){
        this.fecha = fecha;
        this.nPasajeros = nPasajeros;
        this.tipoPasaje = tipoPasaje;
        this.nombre = nombre;
        this.valor = valor;

    }
    public double valorFinal(){
        return valor * nPasajeros;
    }
    public void enviarTxt(){
        try {
            File archivo = new File("INFO_VUELOS_FINAL.txt");
            boolean existeArchivo = archivo.exists();

            VueloRyanair vr = new VueloRyanair(nombre,nPasajeros,tipoPasaje,valor,fecha);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("INFO_VUELOS_FINAL.txt", true))) {
                //True indica que si ya hay un archivo escribe al final
                if (!existeArchivo) {
                    // Se crea el archivo y se añade la cabecera
                    writer.write("NOMBRE_VUELO\tCANT_PASAJEROS\tTIPO_PASAJE\tVALOR_UNITARIO\tFECHA_VUELO\tVALOR_FINAL\tSEGMENTACION");
                    writer.newLine();
                }

                String informacion = nombre + "\t" + nPasajeros + "\t" + tipoPasaje + "\t"
                        + valor + "\t" + fecha + "\t" + valorFinal() +"\t" + vr.segmentacion();
                writer.write(informacion);
                writer.newLine();

            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void enviarPantalla(){

        VueloRyanair vr = new VueloRyanair(nombre,nPasajeros,tipoPasaje,valor,fecha);
        System.out.println("Nombre de vuelo: " +  nombre);
        System.out.println("Cantidad de pasajeros: " + nPasajeros);
        System.out.println("Tipo de pasaje: " + tipoPasaje);
        System.out.println("Valor unitario: " + valor);
        System.out.println("Fecha de vuelo: " + fecha);
        System.out.println("Valor Final del vuelo: " + valorFinal());
        System.out.println("Segmentacion: " + vr.segmentacion());
        System.out.println("--------------------");
    }


}
