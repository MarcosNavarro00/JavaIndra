package org.example;

/*
Ejercicio 7 (Tiene nota)
Desarrollar un programa que se conecte a la api de https://pokeapi.co/, en la misma debe elegir un Pokemon (el que usted prefiera) e informar lo siguiente de el:
- Nombre (species: name)
- Tipo de pokemon que es (type)
- Peso (weight)
Una vez obtenida esa información imprimirla en un TXT, a su vez, compilar el proyecto de tipo Maven.
ENTREGABLES:
- Codigo del proyecto


 */

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://pokeapi.co/api/v2/pokemon/kyogre");
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

                String nombre = objeto.getString("name");
            String tipo = objeto.getJSONArray("types").getJSONObject(0).getJSONObject("type").getString("name");
            double peso = objeto.getDouble("weight");

            System.out.println("Nombre del Pokémon: " + nombre);
            System.out.println("TIPO del Pokémon: " + tipo);
            System.out.println("PESO del Pokémon: " + peso);








        }catch (IOException e){
            e.printStackTrace();
        }

    }
}