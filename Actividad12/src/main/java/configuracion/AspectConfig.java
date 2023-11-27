package configuracion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aspecto.*;

@Configuration //Indica que esta clase sirve como una fuente de definiciones de beans para el contexto de la aplicación.
@ComponentScan("funcion") //Habilita la escaneo de componentes (beans) de paquete "funcion"
@EnableAspectJAutoProxy //Habilita el soporte de proxy para los aspectos en la aplicación, como el objeto Aspect.
public class AspectConfig
{
    @Bean //Crea un bean para la clase TimeLoggerAspect
    public TimeLoggerAspect timeLoggerAspect()
    {
        return new TimeLoggerAspect();
    }
}
