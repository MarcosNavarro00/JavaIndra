package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class Vista {

    private String sol;

    public Vista(String sol) {
        this.sol = sol;
    }

    public void ejecutarVista(){
        try {
            writeToFile(generateJenkinsfile(), "Jenkinsfile");
            System.out.println("Jenkinsfile generado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo Jenkinsfile: " + e.getMessage());
        }
    }

    public String generateJenkinsfile() {
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


    public void writeToFile(String content, String fileName) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(content);
        }
    }
}
