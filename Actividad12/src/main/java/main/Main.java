package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuracion.*;
import funcion.Funcion;

public class Main {

    public static void main (String [] args)
    {
        //Se crea un nuevo contexto a partir de la configuracion realizada en la clase AspectConfig, este contexto contiene los beans definidos
        AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(AspectConfig.class);
        Funcion funcion = contexto.getBean(Funcion.class); //Se obtiene el bean definido "Funcion" de la clase AspectConfig
        System.out.println("--------------------------------------");
        System.out.println("Resultado de la suma :" + funcion.sumar(100, 100));
        System.out.println("--------------------------------------");
        System.out.println("Resultado de la resta :" + funcion.restar(150, 100));
        System.out.println("--------------------------------------");
        System.out.println("Resultado de la multiplicacion :" + funcion.multiplicar(15, 10));
        System.out.println("--------------------------------------");
        System.out.println("Resultado de la division :" + funcion.dividir(50, 10));
        System.out.println("--------------------------------------");
        contexto.close();
    }

}
