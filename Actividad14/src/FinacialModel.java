
//Se corresponde con el controlador

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class FinacialModel {


    public static double gananciaBruta(ArrayList<Producto> stock){
        double gananciaBruta = 0;
        for (Producto producto : stock) {
            gananciaBruta += producto.unidadesVendidas;
        }
        return gananciaBruta;
    }

    public static double gananciaNeta(double gananciaBruta){
        return gananciaBruta * 0.83;
    }

    public static double perdidaProyectada(double gananciaNeta){
        return gananciaNeta/12;
    }

    public static  ArrayList<Long> diferenciaDias(ArrayList<Producto> stock){
        ArrayList<Long> diferencias = new ArrayList<>();
        for (Producto producto : stock) {


            long diferencia = ChronoUnit.DAYS.between(producto.fechaElaboracion, producto.fechaVencimiento);
            diferencias.add(diferencia);
        }

        return diferencias;

    }


}
