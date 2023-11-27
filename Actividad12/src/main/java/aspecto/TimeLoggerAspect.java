package aspecto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;


/*Sirve pra enmarcar una clase como aspecto. Un aspecto encapsula una serie de interconexiones (advide) y de puntos de corte (pointscut),
// que definen cómo y cuándo deben aplicarse ciertas acciones en el flujo de ejecución de la aplicación.
Los advices pueden ser Before, AfterThrowing, AfterReturning, After, Around

 */
@Aspect
public class TimeLoggerAspect
{
    //Se pone *(..) para que sirva para todas las funciones de la clase funcion
    @Before("execution(* funcion.Funcion.*(..))") //El codigo de debajo se ejecuta antes que cualquier metodo de "funcion"
    public void antesEjecucion() {
        System.out.println("Antes de la ejecución del método.");
    }

    @Around("execution (* funcion.Funcion.*(..))")//Controla completamente la ejecucion del metodo
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable
    {
        //Codigo a ejecutar antes del metodo objetivo
        long startTime = System.currentTimeMillis();
        Object resultado = joinPoint.proceed();
        //Codigo a ejecutar despues del metodo objetivo
        long endTime = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución de la funcion en milisegundos: " + (endTime - startTime));
        return resultado;
    }
    //Se ejecuta después de que el método objetivo ha completado su ejecución, ya sea normal o después de lanzar una excepción.
    @After("execution(* funcion.Funcion.*(..))")
    public void despuesEjecucion() {
        System.out.println("El método finalizó.");
    }
}
