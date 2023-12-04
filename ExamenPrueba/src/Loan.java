import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public class Loan extends book implements Interface{

    private LocalDate requestDate;
    private LocalDate deliveryDate;
    private String state;
    private String DNI;
    private Boolean defaulter;

    public Loan(String title, String autor,LocalDate requestDate, LocalDate deliveryDate,String state,String DNI) {
        super(title,autor);
        this.requestDate = requestDate;
        this.deliveryDate = deliveryDate;
        this.state = state;
        this.DNI = DNI;

    }

    public long dateLate(){

        LocalDate fechaActual = LocalDate.now();
        return ChronoUnit.DAYS.between(requestDate,fechaActual);

    }

    public String loadState(){
        if (dateLate()>10){
            state = "Vencido";
            defaulter = true;
        }else{
            state = "En regla";
            defaulter = false;
        }
        return state;
    }

    public double moneyOwed(){
        return 1 * dateLate();
    }

    public Boolean defaulter(){
        return defaulter;
    }
    public void writeTxt() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String actualDate = dateFormat.format(new Date());
        String name = "inventario_y_vecimientos_" + actualDate + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name, true))) {
            writer.write(toString());
            writer.newLine();
            System.out.println("La información de los libros se ha escrito en el archivo 'output_libros.txt'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Loan{" +
                "title='" + getTitle() + '\'' +
                ", autor='" + getAutor() + '\'' +
                ", requestDate=" + requestDate +
                ", deliveryDate=" + deliveryDate +
                ", state=" + state +
                ", DNI='" + DNI + '\'' +
                ", Dias desde que se presto el libro ='" + dateLate() + '\'' +
                ", Estado del prestamo ='" + loadState() + '\'' +
                ", Dinero de multa='" + moneyOwed() + '\'' +
                ", Cliente Moroso='" + defaulter() + '\'' +
                '}';
    }
}
