import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static List readTxt(){
        try {

            File file = new File("data.txt");
            Scanner scanner = new Scanner(file);
            List<Loan> loans = new ArrayList<>();

            while (scanner.hasNextLine()) {

                String n = scanner.nextLine().trim();
                String name = scanner.nextLine().trim();
                String a = scanner.nextLine().trim();
                String autor = scanner.nextLine().trim();
                String rD = scanner.nextLine().trim();
                String requestDate = scanner.nextLine().trim();
                String dyD = scanner.nextLine().trim();
                String deliveryDate = scanner.nextLine().trim();
                String s = scanner.nextLine().trim();
                String state = scanner.nextLine().trim();
                String d = scanner.nextLine().trim();
                String dni = scanner.nextLine().trim();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);

                LocalDate requestDateF = LocalDate.parse(requestDate, formatter);
                LocalDate deliveryDateF = LocalDate.parse(deliveryDate, formatter);
                Loan l = new Loan(name, autor, requestDateF, deliveryDateF, state, dni);
                loans.add(l);



            }

            scanner.close();
            return loans;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        List<Loan> loans = readTxt();
        for (Loan l : loans) {
            l.writeTxt();
            System.out.println(l.toString());
        }


    }
}