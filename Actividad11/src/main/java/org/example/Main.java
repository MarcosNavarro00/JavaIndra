

/*
Nos contrataron del servicio metereologico para desarrollar un programa que informe en base a la siguiente API
    https://open-meteo.com/en/docs
Información pertinente a las siguientes ciudades:
- Barcelona
- Madrid
- Berlin
- Buenos Aires

Para cada ciudad se debe informar lo siguiente:
- latitude
- longitude
- timezone
- elevation
- temperature_2m (la primer posición de la lista)

Se debe desarrollar un programa que tenga una interfaz de usuario haciendo uso de JFrame, JLabel, entre otros. Y que por cada ciudad que se elija, mostrar una imagen de la misma y la información antes obtenida.

El esquema de la ventana del programa debe ser:

Boton Barcelona -> click -> mostrar imagen de la ciudad y la información obtenida de la API.
Boton Madrid - click -> mostrar imagen de la ciudad y la información obtenida de la API
boton Berlin -> click -> mostrar imagen de la ciudad y la información obtenida de la API.
información Buenos Aires -> click -> mostrar imagen de la ciudad y la información obtenida de la API.


ENTREGABLES:
- Codigo del proyecto.
 */

package org.example;
import org.json.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    //Se obtienen las coordendas de las 4 ciudades para despues utilizarlas para la api
    public static String[][] obtenerInfoCiudades(){
        try {

            String ciudades[] = {"Madrid","Barcelona","Berlin","Buenos Aires"};
            String informacion[][] = new String[4][3];
            for (int i=0; i< ciudades.length;i++){
                String urlAntigua = "https://geocode.maps.co/search?q={"+ciudades[i]+"}";

                URL url = new URL(urlAntigua);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();

                int codigoRespuesta = conn.getResponseCode();


                StringBuilder inf = new StringBuilder();
                Scanner sc = new Scanner(url.openStream());

                while(sc.hasNext()) {
                    inf.append(sc.nextLine());
                }

                sc.close();

                JSONArray  objeto = new JSONArray (inf.toString());

                Object lat1 = objeto.getJSONObject(0).getJSONArray("boundingbox").get(0);
                Object lat2 = objeto.getJSONObject(0).getJSONArray("boundingbox").get(1);
                String lat = lat1.toString() +","+ lat2.toString();

                Object log1 = objeto.getJSONObject(0).getJSONArray("boundingbox").get(2);
                Object lag2 = objeto.getJSONObject(0).getJSONArray("boundingbox").get(3);
                String log = log1.toString() +","+ lag2.toString();

                informacion[i][0] = ciudades[i];
                informacion[i][1] = lat;
                informacion[i][2] = log;

            }


            return informacion;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    //A traves de las coordenadas anteriormente calculada se obtiene la URL necesaria para obtener el resto de informacion
    public static String[] obtenerMeteo(String urlAntigua){

        try {

            String[] resultado = new String[5];
            URL url = new URL(urlAntigua);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int codigoRespuesta = conn.getResponseCode();


            StringBuilder inf = new StringBuilder();
            Scanner sc = new Scanner(url.openStream());

            while(sc.hasNext()) {
                inf.append(sc.nextLine());
            }
            System.out.println(inf);
            sc.close();

            JSONArray objeto = new JSONArray(inf.toString());
            System.out.println(objeto);

            double elevacion = objeto.getJSONObject(0).getDouble("elevation");
            System.out.println(elevacion);

            String timezone = objeto.getJSONObject(0).getString("timezone");
            System.out.println(timezone);

            double latitude = objeto.getJSONObject(0).getDouble("latitude");
            System.out.println(latitude);

            double longitude = objeto.getJSONObject(0).getDouble("longitude");
            System.out.println(longitude);

            double temp = objeto.getJSONObject(0).getJSONObject("hourly").getJSONArray("temperature_2m").getDouble(0);
            System.out.println(temp);

            resultado[0] = Double.toString(latitude);
            resultado[1] = Double.toString(longitude);
            resultado[2] = timezone;
            resultado[3] = Double.toString(elevacion);
            resultado[4] = Double.toString(temp);

            return resultado;
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;

    }

    //Muestra el panel principal con los 4 botones. Cuando se pulsa alguno se llama a la funciones obtenerMeteo y ventanaSolucion
    public static void PanelMeteo( String[][] informacionCiudades) {
        JFrame frame = new JFrame("Panel de Meteo");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        // Crear botones
        JButton btnMadrid = new JButton("Madrid");
        JButton btnBarcelona = new JButton("Barcelona");
        JButton btnBerlin = new JButton("Berlín");
        JButton btnBuenosAires = new JButton("Buenos Aires");

        // Agregar ActionListener a cada botón
        btnMadrid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "https://api.open-meteo.com/v1/forecast?latitude=" + informacionCiudades[0][1] + "&longitude=" + informacionCiudades[0][2]+ "&hourly=temperature_2m&timezone=Europe%2FLondon&past_days=5&forecast_days=1";
                System.out.println("Enlace " + url);
                String[] resultado = obtenerMeteo(url);
                ventanaSolucion("Madrid",resultado);
            }
        });

        btnBarcelona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "https://api.open-meteo.com/v1/forecast?latitude=" +informacionCiudades[1][1] + "&longitude=" + informacionCiudades[1][2]+ "&hourly=temperature_2m&timezone=Europe%2FLondon&past_days=5&forecast_days=1";
                String[] resultado = obtenerMeteo(url);
                ventanaSolucion("Barcelona",resultado);
            }
        });

        btnBerlin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "https://api.open-meteo.com/v1/forecast?latitude=" +informacionCiudades[2][1] + "&longitude=" + informacionCiudades[2][2]+ "&hourly=temperature_2m&timezone=Europe%2FLondon&past_days=5&forecast_days=1";
                String[] resultado = obtenerMeteo(url);
                ventanaSolucion("Berlin",resultado);
            }
        });

        btnBuenosAires.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String  url ="https://api.open-meteo.com/v1/forecast?latitude=" +informacionCiudades[3][1] + "&longitude=" + informacionCiudades[3][2]+ "&hourly=temperature_2m&timezone=Europe%2FLondon&past_days=5&forecast_days=1";

                String[] resultado = obtenerMeteo(url);
                ventanaSolucion("Buenos Aires",resultado);
            }
        });

        // Agregar botones al panel
        panel.add(btnMadrid);
        panel.add(btnBarcelona);
        panel.add(btnBerlin);
        panel.add(btnBuenosAires);

        // Agregar panel al marco
        frame.add(panel);

        // Hacer visible el marco
        frame.setVisible(true);

    }
    //Muesta la ventana con todas las soluciones mas la imagen. Se ejecuta cuando se pulsa cualquier boton
    public static void ventanaSolucion(String ciudad, String[] resultado){
        // Crear un nuevo JFrame para mostrar la información detallada
        JFrame detalleFrame = new JFrame(ciudad + " - Detalles de Meteo");
        detalleFrame.setSize(1000, 1000);

        // Crear campos de texto
        JTextField campoTexto1 = new JTextField("La latitud es: " +resultado[0]);
        JTextField campoTexto2 = new JTextField("La longitud es: " +resultado[1]);
        JTextField campoTexto3 = new JTextField("El tiempo horario es: " +resultado[2]);
        JTextField campoTexto4 = new JTextField("La elevacion es: " +resultado[3]);
        JTextField campoTexto5 = new JTextField("La temperatura es: " +resultado[4]);

        ImageIcon imagen = null;

        // Crear etiqueta para la imagen
        switch (ciudad) {
            case "Madrid":
                imagen = new ImageIcon("Madrid.jpg");
                break;
            case "Barcelona":
                imagen = new ImageIcon("Barcelona.jpg");
                break;
            case "Berlin":
                imagen = new ImageIcon("Berlin.jpg");
                break;
            case "Buenos Aires":
                imagen = new ImageIcon("Buenos_Aires.jpg");
                break;

        }
        Image img = imagen.getImage();
        Image imgNueva = img.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH);
        imagen = new ImageIcon(imgNueva);
        JLabel etiquetaImagen = new JLabel(imagen);

        // Crear panel para los campos de texto y la imagen
        JPanel detallePanel = new JPanel();
        detallePanel.setLayout(new GridLayout(6, 1));
        detallePanel.add(campoTexto1);
        detallePanel.add(campoTexto2);
        detallePanel.add(campoTexto3);
        detallePanel.add(campoTexto4);
        detallePanel.add(campoTexto5);
        detallePanel.add(etiquetaImagen);

        // Agregar panel al marco de detalles
        detalleFrame.add(detallePanel);

        // Hacer visible el marco de detalles
        detalleFrame.setVisible(true);

    }

    public static void main(String[] args) {
        String[][] informacionCiudades = obtenerInfoCiudades();

        PanelMeteo(informacionCiudades);

    }
}