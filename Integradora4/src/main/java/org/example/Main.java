
/*
Debemos desarrollar una importante aplicación para una empresa de Finanzas que se encarga de contabilizar la ganancia de las 10 mejores peliculas de la historia. Para esto tienen en cuenta
los siguientes criterios:
- Cantidad de espectadores globalmente
- Ganancia bruta (distinta de la ganancia neta)
- Cantidad de salas donde se proyecto la pelicula
Para esto comparan el año actual vs lo que paso el año anterior. Haciendo de información historica para llegar a conclusiones.

Titulo                                        Cantidad de espectadores 2022          Cantidad de salas 2022              Ganancia Bruta 2022            Ganancia Neta 2022 (G. Bruta * 0.80)
Avatar	                                                100000                              10000                          1.000.000.000                          80.000.000.000
Avengers: Endgame	                                      90000                               9000                            810.000.000
Avatar: The Way of Water                                80000                               8000                            640.000.000
Titanic                                                 70000                               7000                            490.000.000
Star Wars: Episode VII - The Force Awakens              60000                               6000                            360.000.000
Avengers: Infinity War                                  50000                               5000                            250.000.000
Spider-Man: No Way Home	                                40000                               4000                            160.000.000
Jurassic World	                                        30000                               3000                            90.000.000
The Lion King	                                          20000                               2000                            40.000.000
The Avengers                                            10000                               1000                            10.000.000

En base a los datos de 2022 se debe proyectar cuales son los estimados de 2023 entendiendo que los espectadores de 2023 seran la mitad de los espectadores de 2022 y que la cantidad de salas de 2023
sera la mitad, tambien, de las que hubo en 2022. En base a esto calcular la Ganancia Bruta de 2023 y la Ganancia Neta de 2023.

SECCION JENKINS:
Generar un Jenkinsfile que contenga la información de 2023.

ENTREGABLES:
- Link del Repositorio
- Captura de pantalla de la consola de Jenkins.
 */

//Controlador
package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static String generateJenkinsfile(String sol) {
        StringBuilder jenkinsfile = new StringBuilder();

        jenkinsfile.append("pipeline {\n");
        jenkinsfile.append("    agent any\n");
        jenkinsfile.append("    stages {\n");
        jenkinsfile.append("        stage('Ejemplo') {\n");
        jenkinsfile.append("            steps {\n");
        jenkinsfile.append("                script {\n");
        jenkinsfile.append("                    def unidadBase = env.WORKSPACE\n");
        jenkinsfile.append("                    echo \"La unidad base es: ${unidadBase}\"\n");
        jenkinsfile.append("                    // Tu lógica adicional aquí\n");
        jenkinsfile.append("                }\n");
        jenkinsfile.append("            }\n");
        jenkinsfile.append("        }\n");
        jenkinsfile.append("        stage('Solucion') {\n");
        jenkinsfile.append("            steps {\n");
        jenkinsfile.append("                script {\n");
        jenkinsfile.append("                    def sol = \"").append(sol).append("\"\n");
        jenkinsfile.append("                    echo \"La solución es: ${sol}\"\n");
        jenkinsfile.append("                    // Tu lógica adicional aquí\n");
        jenkinsfile.append("                }\n");
        jenkinsfile.append("            }\n");
        jenkinsfile.append("        }\n");
        jenkinsfile.append("    }\n");
        jenkinsfile.append("}\n");

        return jenkinsfile.toString();
    }


    public static void writeToFile(String content, String fileName) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(content);
        }
    }
    public static Pelicula[] getTxt(String rutaArchivo) {
        try {
            File archivo = new File(rutaArchivo);
            Scanner scanner = new Scanner(archivo);

            Pelicula[] peliculas = new Pelicula[10];
            int i = 0;

            // Saltar la primera línea que contiene encabezados
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split("\\s+"); // Dividir la línea en partes usando espacios en blanco

                // Verificar que haya suficientes partes y que no estén vacías
                if (partes.length >= 5 && !partes[1].isEmpty() && !partes[2].isEmpty() && !partes[3].isEmpty() && !partes[4].isEmpty()) {
                    // Crear un objeto Pelicula con la información de la línea
                    Pelicula pelicula = new Pelicula(
                            partes[0],
                            Integer.parseInt(partes[1]),
                            Integer.parseInt(partes[2]),
                            Long.parseLong(partes[3].replaceAll("\\.", "")), // Eliminar puntos de la representación numérica
                            Long.parseLong(partes[4].replaceAll("\\.", ""))
                    );

                    peliculas[i] = pelicula;
                    i++;
                }
            }

            scanner.close();

            return peliculas;
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
        return null;
    }

    public static Pelicula[] proyeccion2023(Pelicula[] peliculas){
        Pelicula[] peliculas23 = new Pelicula[10];

        for (int i = 0; i<peliculas.length; i++){

            int espectadores23 =  peliculas[i].getEspectadores()/2;
            int salas23 =  peliculas[i].getSalas()/2;
            long bruta23 = espectadores23*salas23;
            double neta23 = bruta23 * 0.8;

            Pelicula p23 = new Pelicula(
                    peliculas[i].getTitulo(),
                    espectadores23,
                    salas23,
                    bruta23,
                    (long)neta23
            );

            peliculas23[i] =p23;
            System.out.println("peliculas 2023: " + peliculas23[i].toString());
        }

        return peliculas23;
    }


    public static void main(String[] args) {
        String sol = "";

        Pelicula[] peliculas = getTxt("datos.txt");

        Pelicula[] p23 = proyeccion2023(peliculas);

        for (int i = 0; i<p23.length; i++){
            System.out.println("Peliculas 2023: " + p23[i].toString());
            sol += p23[i].toString();
        }

        System.out.println("Solucion: " + sol);
        String jenkinsfileContent = generateJenkinsfile(sol);
        try {
            writeToFile(jenkinsfileContent, "Jenkinsfile");
            System.out.println("Jenkinsfile generado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo Jenkinsfile: " + e.getMessage());
        }



    }
}