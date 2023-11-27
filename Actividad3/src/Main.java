import java.util.Scanner;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static int askNumber1 (Scanner sc){
        System.out.println("Enter the first number");
        int a = sc.nextInt();
        return a;
    }

    public static int askNumber2 (Scanner sc){
        System.out.println("Enter the second number");
        int b = sc.nextInt();
        return b;
    }

    public static int sum (int a, int b){
        return a+b;
    }
    public static int sub (int a, int b){
        return a-b;
    }

    public static int mult (int a, int b){
        return a*b;
    }

    public static int div (int a, int b){
        if (a ==0 || b==0){
            System.err.println("Cant no divide by zero");
        }else{
            return a/b;
        }
        return 0;
    }

    public static void makeDirectory (){
        // Ruta de la carpeta que deseas crear
        String rutaCarpeta = "C:\\Users\\mnavarroj\\Desktop\\Results";

        // Crear un objeto File con la ruta de la carpeta
        File carpeta = new File(rutaCarpeta);

        // Verificar si la carpeta ya existe
        if (carpeta.exists()) {
            System.out.println("The folder is already exist.");
        } else {
            // Intentar crear la carpeta
            if (carpeta.mkdir()) {
                System.out.println("The folder was create fine.");
            } else {
                System.out.println("Error when create the folder.");
            }
        }

    }
    public static void createWriteResult (int a, int b, int sum, int sub, int mult, int div){

        String rutaArchivo = "C:\\Users\\mnavarroj\\Desktop\\Results\\result.txt";


        File archivo = new File(rutaArchivo);

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))) {

            escritor.write("The number one was:" + a);
            escritor.newLine();
            escritor.write("The number two was:" + b);
            escritor.newLine();
            escritor.write("The solution of the sum was:" + sum);
            escritor.newLine();
            escritor.write("The solution of the sub was:" + sub);
            escritor.newLine();
            escritor.write("The solution of the mult was:" + mult);
            escritor.newLine();
            escritor.write("The solution of the div was:" + div);


            System.out.println("write on the txt.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = askNumber1 (sc);
        int b = askNumber2 (sc);

        makeDirectory ();
        createWriteResult(a,b,sum(a,b),sub(a,b), mult(a,b),div(a,b));



    }
}