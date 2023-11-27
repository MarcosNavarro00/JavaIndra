import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    private JTextField display;
    private String operador;
    private double num1, num2, resultado;

    public Main() {
        // Configuración de la ventana
        setTitle("Calculadora");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //boton para cerrar
        setLocationRelativeTo(null); //Se utiliza para centrar la pantalla en el medio
        setLayout(new BorderLayout());

        // Campo de texto para mostrar la entrada y el resultado
        display = new JTextField();
        display.setEditable(true); //indica que no se puede editar
        display.setPreferredSize(new Dimension(100, 50)); //se establece el tamaño del campo de texto.
        add(display, BorderLayout.NORTH); //Agrega la parte del texto en la parte superior

        // Panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5, 4)); //se define las filas y cols del panel

        // Crear botones
        String[] labels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+", "borrar"
        };

        for (String label : labels) {
            JButton button = new JButton(label); //se crea los botones asociados a cada etiqueta
            button.addActionListener(this); //Los botones pueden hacer acciones y entonces al pulsarlos se ejecutara la funcion actionPeformed
            panelBotones.add(button); //El boton se agrega al panel de botones
        }

        add(panelBotones, BorderLayout.CENTER);
    }

    //Cuando se pusla un boton se ejecuta este metodo.
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); //se obtiene la informacion del boton que se ha pulsado.

        if (Character.isDigit(command.charAt(0))) {
            //si el boton que se ha pulsado es un numero se agrega al campo de texto
            display.setText(display.getText() + command);
        } else if (command.equals(".")) {
            //si el boton que se ha pulsado es un "." se agrega al campo de texto
            if (!display.getText().contains(".")) {
                display.setText(display.getText() + command);
            }
        } else if (command.equals("=")) { //si el boton que se ha pulsado es un "=" se agrega al campo de texto
            num2 = Double.parseDouble(display.getText()); // se obtiene el segundo numero pulsado
            calcular(); //se calcula el resultado
            display.setText(String.valueOf(resultado)); //se muestra el resultado en el campo de texto
            num1 = resultado; //el numero 1 pasa a ser el resultado obtenido
            operador = ""; //se reinicia el valor del operador
        } else { //si no es nada de lo anterior significa que es un operador
            operador = command; //el boton que se acaba de pulsar pasa a ser el operador. Como ha entrado en el if significa que es un operador si o si.
            if (!display.getText().isEmpty()) { //si el campo de texto no esta vacio entra
                num1 = Double.parseDouble(display.getText()); // entonces lo que hay en el campo de texto pasa a ser el numero 1
            }
            display.setText("");
        }
    }

    private void calcular() {
        switch (operador) {
            case "borrar":
                resultado = 0;
                break;
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    display.setText("Error");
                }
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main calculadora = new Main();
            calculadora.setVisible(true); //con hacerlo visible ya se ejecuta siempre hasta que se cierra la ventana.
        });
    }
}
