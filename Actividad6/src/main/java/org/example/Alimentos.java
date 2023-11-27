package org.example;
import org.json.*;
import java.util.Scanner;

public class Alimentos {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Se pide por pantalla la informacion 
        System.out.print("Indique su comida favorita:");
        String comida = scanner.nextLine();

        System.out.print("Indique el Ingrediente 1:");
        String ingre1 = scanner.nextLine();

        System.out.print("Indique el Ingrediente 2:");
        String ingre2 = scanner.nextLine();

        System.out.print("Indique el Ingrediente 3:");
        String ingre3 = scanner.nextLine();

        System.out.print("Indique el Ingrediente 4:");
        String ingre4 = scanner.nextLine();

        System.out.print("Indique el Ingrediente 5:");
        String ingre5 = scanner.nextLine();

        System.out.print("Indique la Bebida:");
        String bebida = scanner.nextLine();

        System.out.print("Indique el Tiempo de cocción:");
        int tCoccion = scanner.nextInt();

        // Se crea el JSON con el formato objeto
        JSONObject alimentos = new JSONObject();
        alimentos.put("Comida favorita", comida);
        alimentos.put("Ingrediente 1", ingre1);
        alimentos.put("Ingrediente 2", ingre2);
        alimentos.put("Ingrediente 3", ingre3);
        alimentos.put("Ingrediente 4", ingre4);
        alimentos.put("Ingrediente 5", ingre5);
        alimentos.put("Tiempo de cocción", tCoccion);
        alimentos.put("Bebida para acompañar", bebida);

        //Muestra como se ha cargado el JSON
        System.out.println("\nObjeto JSON como fue cargado:\n" + alimentos.toString());

       //Muestra uno por uno las propiedades del JSON
        System.out.println("\n-------------------------------------------------------:");
        System.out.println("\nEl JSON tiene la siguiente estructura:");
        System.out.println("Comida: " + alimentos.getString("Comida favorita"));
        System.out.println("Ingrediente 1: " + alimentos.getString("Ingrediente 1"));
        System.out.println("Ingrediente 2: " + alimentos.getString("Ingrediente 2"));
        System.out.println("Ingrediente 3: " + alimentos.getString("Ingrediente 3"));
        System.out.println("Ingrediente 4: " + alimentos.getString("Ingrediente 4"));
        System.out.println("Ingrediente 5: " + alimentos.getString("Ingrediente 5"));
        System.out.println("Tiempo de cocción: " + alimentos.getInt("Tiempo de cocción"));
        System.out.println("Bebida para acompañar: " + alimentos.getString("Bebida para acompañar"));
        System.out.println("\n-------------------------------------------------------:");
        
        scanner.close();
    }
}