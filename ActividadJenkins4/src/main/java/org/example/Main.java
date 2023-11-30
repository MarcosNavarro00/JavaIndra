
/*
Ejercicios de Jenkins - Actividad ° 4:
Nos contrataron de "Doña Clotilde" que es una empresa de seguridad,ya que quieren generar un sistema de control de calidad de empleados. El mismo consiste en chequear
el horario de ingreso y de egreso de los empleados de la empresa. En base al puesto del empleado se contemplan distintas franjas horarias de acceso.

Posición: CEO
Horario estipulado de ingreso: 7am
Horario estipulado de egreso: 6pm

Posición: Jefe
Horario estipulado de ingreso: 8am
Horario estipulado de egreso: 6pm

Posición: Ingeniero
Horario estipulado de ingreso: 9am
Horario estipulado de egreso: 6pm

Posición: Analista
Horario estipulado de ingreso: 9am
Horario estipulado de egreso: 5pm

Posición: Scrum Master
Horario estipulado de ingreso: 9am
Horario estipulado de egreso: 6pm

Posición: RRHH
Horario estipulado de ingreso: 9am
Horario estipulado de egreso: 6pm

Si estas franjas horarias no se respetan, se generan infracciones salariales. Donde segun el puesto se descuenta un % del sueldo anual a cada empleado.
Si Posicion = CEO Entonces se le descuenta 0.01
Si Posicion = Jefe Entonces se le descuenta 0.05
Si Posicion = Ingeniero Entonces se le descuenta 0.15
Si Posicion = Analista Entonces se le descuenta 0.20
Si Posicion = Scrum Master Entonces se le descuenta 0.10
Si Posicion = RRHH Entonces se le descuenta 0.09

El programa debe solicitar por consola los siguientes datos:
- Nombre
- Posicion
- Sueldo
- Horario de Ingreso
En base a los datos ingresados se debe informar quien tiene una infracción. Hacer 1 para cada posición, como minimo.

SECCION JENKINS:
Generar un Jenkinsfile desde el programa de Java que informe cuales fueron los empleados y la posición qué ocupan en la empresa para mostrarlos por consola de Jenkins.
Para esto deben subir el proyecto a Github y escanear el Jenkinsfile.

Entregable:
- Link del repositorio de Github
- Captura de pantalla de la consola de Jenkins.
 */

package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static String generateJenkinsfile() {
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
        jenkinsfile.append("    }\n");
        jenkinsfile.append("}\n");

        return jenkinsfile.toString();
    }

    public static void writeToFile(String content, String fileName) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(content);
        }
    }
    public static Empleado ask(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese su posicion: ");
        String posicion = scanner.nextLine();

        System.out.println("Ingrese su sueldo: ");
        double sueldo = scanner.nextDouble();

        System.out.println("Ingrese su hora de entrada: ");
        int hEntrada= scanner.nextInt();

        System.out.println("Ingrese su hora de salida: ");
        int hSalida= scanner.nextInt();

        return new Empleado(nombre, posicion, sueldo, hEntrada, hSalida);


    }


    public static void main(String[] args) {

        String jenkinsfileContent = generateJenkinsfile();

        try {
            writeToFile(jenkinsfileContent, "Jenkinsfile");
            System.out.println("Jenkinsfile generado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo Jenkinsfile: " + e.getMessage());
        }

        Empleado[] registroEmpleados = new Empleado[6];

        for (int i = 0; i < 1; i++) {
            Empleado e1 = ask();

            double sFinal = e1.calcularInfraccion();
            int nInfracciones = e1.getnInfracciones();
            registroEmpleados[i] = e1;
            registroEmpleados[i].print();
        }

    }
}