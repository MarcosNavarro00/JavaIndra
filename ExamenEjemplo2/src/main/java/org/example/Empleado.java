package org.example;

import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Empleado implements Interfaz{

   private String name;
   private String apellidos;
   private LocalDate fIngreso;
   private LocalDate fSalida;
   private String sexo;
   private String ciudad;
   private String posicion;
   private double sBase;

    public Empleado(String name,String apellidos,LocalDate fIngreso,LocalDate fSalida,String sexo,String ciudad, String posicion,double sBase) {
        this.name = name;
        this.apellidos = apellidos;
        this.fIngreso = fIngreso;
        this.fSalida = fSalida;
        this.sexo = sexo;
        this.ciudad = ciudad;
        this.posicion = posicion;
        this.sBase = sBase;
    }


    public  double calcularSalario(){
        return sBase * 0.83;
    }

    public long antiguedadLaboral(){

        LocalDate fechaActual = LocalDate.now();
        return ChronoUnit.DAYS.between(fIngreso,fechaActual);

    }

    public String rotacionRecomendada(){

        if ( posicion.equals("Ingeniero") && antiguedadLaboral() >= 730){
            return "Rotacion Habilitada";
        }else if( posicion.equals("Ingeniero") && antiguedadLaboral() <= 730){
            return "Rotacion no habilitada";
        }
        return "Sin Datos";
    }

    public void JSON(){

        JSONObject empleadoJson = new JSONObject();

        empleadoJson.put("name", name);
        empleadoJson.put("apellidos", apellidos);
        empleadoJson.put("fIngreso", fIngreso);
        empleadoJson.put("fSalida", fSalida);
        empleadoJson.put("sexo", sexo);
        empleadoJson.put("ciudad", ciudad);
        empleadoJson.put("apellidos", apellidos);
        empleadoJson.put("posicion", posicion);
        empleadoJson.put("sBase", sBase);
        empleadoJson.put("SFinal", calcularSalario());
        empleadoJson.put("Alaboral", antiguedadLaboral());
        empleadoJson.put("Rotacion", rotacionRecomendada());



        try (FileWriter fileWriter = new FileWriter("empleado.json", true)) {
            // Escribir el objeto JSON en el archivo
            fileWriter.write(empleadoJson.toString());
            System.out.println("Archivo JSON generado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "name='" + name + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fIngreso=" + fIngreso +
                ", fSalida=" + fSalida +
                ", sexo='" + sexo + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", posicion='" + posicion + '\'' +
                ", sBase=" + sBase +
                ", Salario Final=" + calcularSalario() +
                ", Dia de antiguedad laboral=" + antiguedadLaboral() +
                ", Rotacion recomendada=" + rotacionRecomendada() +
                '}';
    }
}
