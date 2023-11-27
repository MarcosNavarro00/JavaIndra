import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ministerio implements Interface {

    private String name;
    private int residentN;
    private double sufarce;


    public Ministerio (String name, int residentN, double sufarce){
        this.name= name;
        this.residentN = residentN;
        this.sufarce = sufarce;
    }

    public double proyectionResidentN (){
        return residentN * 0.9;
    }

    public double occupiedSurface (){
        return sufarce + 1000;
    }

    public void sendToTxt (){
        String ruta = "C:\\Users\\mnavarroj\\IdeaProjects\\Actividad13\\NuevoDirectorio\\sol";
        File archivo = new File(ruta);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {

            String informacion = "Ciudad{" +
                    "nombre='" + name + '\'' +
                    ", poblacion=" + residentN +
                    ", superficie=" + sufarce +
                    ", Proyección habitantes 2030 = " + proyectionResidentN() +
                    ", Superficie total ocupada = " + occupiedSurface() +
                    '}';
            writer.write(informacion);
            writer.newLine(); // Agregar una nueva línea para la siguiente entrada
            System.out.println("Información escrita en el archivo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print(){
        System.out.println("Ciudad{" +
                "nombre='" + name + '\'' +
                ", poblacion=" + residentN +
                ", superficie=" + sufarce +
                '}');
    }

}