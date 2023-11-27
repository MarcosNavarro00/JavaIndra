
/*
Nos contrataron de la empresa aeronáutica Iberia para poder estandarizar y sistematizar la información que tienen hoy en día en un TXT
-	Nombre del vuelo
-	Cantidad de pasajeros
-	Tipo de pasaje
-	Valor unitario del pasaje
-	Fecha del vuelo
Generar una salida que calcule lo siguiente:
ValorFinalPorVuelo = ValorUnitario * Cant Pasajeros
Crear una columna llamada "Segmentación" en base a la siguiente Logica IF Tipo_pasaje = Económico && ValorFinalPorVuelo > 100 Entonces es Rentable
IF Tipo_pasaje = Económico && ValorFinalPorVuelo < 100 Entonces es No Rentable
IF Tipo_pasaje = Premier && ValorFinalPorVuelo > 1500 Entonces es Rentable
IF Tipo_pasaje = Premier && ValorFinalPorVuelo < 1500 Entonces no es Rentable
Para los que no esten dentro de estas definiciones, el mensaje debe ser "A CONFIRMAR"
El programa debe implementar lo siguiente:
- Clases
- Herencia
- Funciones

ENTREGABLES:
- Codigo del proyecto.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {



    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("INFO_VUELOS.csv"))) {
            String linea;
            boolean cabecera = true;

            while ((linea = br.readLine()) != null) {
                //no se lee la cabecera
                if (cabecera) {
                    cabecera = false;
                    continue;
                }

                // Se separa por ;
                String[] campos = linea.split(";");

                // Imprimir información
                String nombre = campos[0];
                int nPasajeros = Integer.parseInt(campos[1]);
                String tipoPasaje = campos[2];
                int valor = Integer.parseInt(campos[3]);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

                // Convertir el String a LocalDate
                LocalDate fecha = LocalDate.parse(campos[4], formatter);

                Vuelo v = new Vuelo(nombre,nPasajeros,tipoPasaje,valor,fecha);
                v.enviarTxt();
                v.enviarPantalla();
                
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }



}