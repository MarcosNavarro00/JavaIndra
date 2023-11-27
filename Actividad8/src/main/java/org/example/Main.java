
/*
Ejercicio 8 (Tiene Nota)
Desarrollar un programa en Java que muestre la imagen que devuelve la API al clickear el BOTON "Obtener imagen".
API: https://api.thecatapi.com/v1/images/search
ENTREGABLE:
- Codigo del proyecto.
 */

package org.example;
import org.json.*;

import javax.imageio.IIOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.imageio.ImageIO;


public class Main {

    public static String obtenerEnlace (){
        try {
            //se conecta a la URL
            URL url = new URL("https://api.thecatapi.com/v1/images/search");
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

            JSONArray jsonArray = new JSONArray(inf.toString());
            System.out.println("Objeto JSON completo:\n" + jsonArray);

            // Obtener el primer objeto del array
            JSONObject objeto = jsonArray.getJSONObject(0);
            String nuevaURL = objeto.getString("url");

            return nuevaURL;


        }catch (IOException e){
            e.printStackTrace();
        }
        return "No se ha podido generar el nuevo enlace";
    }

    public static void mostrarImagen(JLabel etiqueta, String url){
        try {
            //Se obtiene la imagen de la URL
            ImageIcon imagen = new ImageIcon(new URL(url));

            etiqueta.setIcon(imagen);

            etiqueta.setSize(imagen.getIconWidth(), imagen.getIconHeight());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //Se cre la ventana
        JFrame ventana = new JFrame("FOTOS DE GATITOS");
        ventana.setSize(700,600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Se crea el boton
        JButton boton = new JButton("Cambiar gato");

        //Se crea la etiqueta para la imagen
        JLabel imagen = new JLabel();

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("¡Botón clickeado!");
                String url = obtenerEnlace ();
                mostrarImagen(imagen,url);


            }
        });

        //se agregan los componentes a la ventana.
        ventana.getContentPane().setLayout(new java.awt.FlowLayout());
        ventana.getContentPane().add(boton);
        ventana.getContentPane().add(imagen);

        // Hacer visible el marco
        ventana.setVisible(true);
    }
}