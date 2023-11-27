import java.time.LocalDate;

public class VueloRyanair extends Vuelo {
    VueloRyanair(String nombreVuelo, int cantPasajeros, String tipoPasaje, double valorUnitario, LocalDate fechaVuelo) {
        super(nombreVuelo, cantPasajeros, tipoPasaje, valorUnitario, fechaVuelo);
    }

    public String segmentacion(){

        if (tipoPasaje.equals("ECONOMICO")){
            if ( valorFinal()>100){
                return "Rentable";
            }else{
                return "No Rentable";
            }
        }if(tipoPasaje.equals("PREMIER")){
            if ( valorFinal()>1500){
                return "Rentable";
            }else {
                return "No Rentable";
            }
        }else{
            return "A CONFIRMAR";
        }
    }
}
