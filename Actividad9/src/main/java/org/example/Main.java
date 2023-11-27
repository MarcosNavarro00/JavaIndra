
/*

Dentro del siguiente enlace: https://rickandmortyapi.com/documentation vais a encontrar 3 APIS
Characters: Informacion de los personajes de Rick and Morty
Locations: Ubicaciones de los personajes de Rick and Morty
Episodes: Episodios de la serie.
Utilizar el endpoint de la siguiente API:
https://rickandmortyapi.com/api/character
Para generar un programa que muestre la siguiente información
de TODOS los personajes.
- Nombre
- Status
- Species
- Gender
- Location
Una vez obtenida la información, generar un fichero de salida con la misma, y el fichero se debe llamar "personajes_RickAndMorty.txt"
 */

package org.example;
import org.json.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static String[][] obtenerInfo(){
        try {
            //se conecta a la URL
            URL url = new URL("https://rickandmortyapi.com/api/character");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int codigoRespuesta = conn.getResponseCode();
            System.out.println(codigoRespuesta);

            StringBuilder inf = new StringBuilder();
            Scanner sc = new Scanner(url.openStream());

            while(sc.hasNext()) {
                inf.append(sc.nextLine());
            }

            System.out.println(inf);
            sc.close();

            JSONObject objeto = new JSONObject(inf.toString());
            System.out.println("Objeto JSON completo:\n" + objeto);


            int numeroPersonajes = objeto.getJSONArray("results").length(); //Se obtiene el numero de personajes
            System.out.println("Número de personajes: " + numeroPersonajes);

            String[][] personajes = new String[numeroPersonajes][5]; //Se crea el array bidimensional donde se almacena toda la informacion

            for (int i = 0; i<numeroPersonajes ;i++){
                String nombrePersonaje = objeto.getJSONArray("results").getJSONObject(i).getString("name"); //s eobtiene el nombre
                personajes[i][0] = nombrePersonaje;

                String status = objeto.getJSONArray("results").getJSONObject(i).getString("status");//se obtiene el status
                personajes[i][1] = status;

                String species = objeto.getJSONArray("results").getJSONObject(i).getString("species");//se obtiene la especie
                personajes[i][2] = species;

                String gender = objeto.getJSONArray("results").getJSONObject(i).getString("gender");//se obtiene la especie
                personajes[i][3] = gender;

                String location = objeto.getJSONArray("results").getJSONObject(i).getJSONObject("location").getString("name");//se obtiene la especie
                personajes[i][4] = location;

            }

            return personajes;

        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void escribirTxt(String personajes[][]){
        try {
            File archivo = new File("C:\\Users\\mnavarroj\\IdeaProjects\\Actvidadad9");

            if (!archivo.exists()) {
                // Crear el archivo si no existe
                archivo.createNewFile();
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("archivo"));
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.println("Nombre Status Especie Género Localizacion"); //Se añade una cabecera

            //se añade al txt
            for (String[] fila : personajes) {
                for (String elemento : fila) {
                    printWriter.print(elemento + ", ");
                }
                printWriter.println();
            }
            printWriter.close();
            writer.close();

            System.out.println("Se escribio la informacion en el archivo con éxito.");

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String personajes[][] = obtenerInfo();

        escribirTxt(personajes);

    }
}