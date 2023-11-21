import java.io.File;

public class tarea implements Runnable{

    private String name;
    private Ministerio[] m;

    public tarea(String name){
        this.name= name;

    }
    public tarea(String name, Ministerio[] m){
        this.name= name;
        this.m= m;
    }

    @Override
    public void run() {

        if (name.equals("Thread 1")){
            System.out.println("El hilo 1 se ejecuta");

            String rutaDirectorio = "C:\\Users\\mnavarroj\\IdeaProjects\\Actividad13\\NuevoDirectorio";

            File directorio = new File(rutaDirectorio);

            if (!directorio.exists()) {
                if (directorio.mkdir()) {
                    System.out.println("Primer Hilo: Directorio creado con éxito.");
                } else {
                    System.out.println("Primer Hilo: Error al crear el directorio.");
                }
            } else {
                System.out.println("Primer Hilo: El directorio ya existe.");
            }

        }else if (name.equals("Thread 2")){
            System.out.println("El hilo 2 se ejecuta");
            m[0].sendToTxt();
            m[1].sendToTxt();
            m[2].sendToTxt();
        }

    }
}
