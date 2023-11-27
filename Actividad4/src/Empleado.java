import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Empleado extends Persona implements Interfaz{
    private String puesto;
    private double salarioB;
    private String area;

    public Empleado(String nombre, String apellido, int edad, String ciudad, String puesto, double salarioB, String area) {
        super(nombre, apellido, edad, ciudad);
        this.puesto = puesto;
        this.salarioB = salarioB;
        this.area = area;
    }

    public double calcularSalarioNeto (){
        return salarioB * 0.8;
    }
    //imprime por pantalla la info de la persona
    public void imprimirPersona (){
        System.out.println("Se trata de la persona: " + getNombre() + getApellido() + " con edad " + getEdad() + " de la ciudad " + getCiudad() + " en el puesto y area " +
                puesto + " " + area + " con una salario bruto de " + salarioB + " . Por lo cual con un salario neto de: " + calcularSalarioNeto() );

    }
    //envia la informacion a un txt. sino hay txt lo crea
    public void enviarATxt(){
        String nombreArchivo = "datos_empleado.txt";

        File archivo = new File(nombreArchivo);

        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true));

            String informacion = "Se trata de la persona: " + getNombre() + getApellido()  + " con edad " + getEdad()  + " de la ciudad " + getCiudad() + " en el puesto y area " +
                    puesto + " " + area + " con una salario bruto de " + salarioB + " . Por lo cual con un salario neto de: " + calcularSalarioNeto();

            writer.write(informacion);
            writer.newLine();

            writer.close();

            System.out.println("Los datos se han escrito en el archivo " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
