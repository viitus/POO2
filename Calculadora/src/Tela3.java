import javax.swing.*;
import java.awt.*;

public class Tela3 extends JFrame {
    private JPanel painel, painelOut, painelIn;
    private JButton[] jbutoes;
    private String simbolos[] = {
        "AC/C", "+/-", "%", "RaizQ", "/",
        "7", "8", "9", "X^Y", "*",
        "4", "5", "6", "X^2", "-",
        "1", "2", "3", "X^3", "+",
        "0", ",", "X!", "10^X", "="
    };

    private JTextField campoResultado;

    public Tela3() {
        painel = new JPanel();
        painelOut = new JPanel();
        painelIn = new JPanel();
        campoResultado = new JTextField(15);
        jbutoes = new JButton[simbolos.length];
        for (int i = 0; i < simbolos.length; i++) {
            jbutoes[i] = new JButton(simbolos[i]);
            int index = i;
            jbutoes[i].addActionListener(e -> tratarBotao(simbolos[index]));
        }
    }

    public void configurarJanela() {
        setVisible(true);
        setTitle("Calculadora");
        setSize(435, 510);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocation(600, 500);
        add(painel);
        configurarPainel();
    }

    public void configurarPainel() {
        painel.setLayout(null);
        painel.setBackground(Color.LIGHT_GRAY);
        painel.add(painelOut);
        painel.add(painelIn);

        painelOut.setBounds(10, 10, 400, 70);
        painelIn.setBounds(10, 80, 400, 380);
        painelOut.setBackground(Color.LIGHT_GRAY);
        painelOut.add(campoResultado);

        campoResultado.setFont(new Font("Arial", Font.BOLD, 24));
        campoResultado.setHorizontalAlignment(JTextField.RIGHT);
        campoResultado.setEditable(false);


        painelIn.setLayout(new GridLayout(5, 5));
        for (JButton botao : jbutoes) {
            painelIn.add(botao);
        }
    }

    public void tratarBotao(String simbolo) {
        switch (simbolo) {
            case "=": calcularesultado(); break;
            case "AC/C": apagar(); break;
            case ",": campoResultado.setText(campoResultado.getText() + "."); break;
            case "+/-": campoResultado.setText("-(" + campoResultado.getText() + ")"); break;
            case "X^Y": campoResultado.setText(campoResultado.getText() + "^"); break;
            case "X^2": campoResultado.setText(campoResultado.getText() + "^2"); break;
            case "X^3": campoResultado.setText(campoResultado.getText() + "^3"); break;
            case "X!": campoResultado.setText(campoResultado.getText() + "!"); break;
            case "10^X": campoResultado.setText( "10^" + campoResultado.getText()); break;
            case "RaizQ": campoResultado.setText("√(" + campoResultado.getText() + ")"); break;
            default: campoResultado.setText(campoResultado.getText() + simbolo);
        }
    }
    
    public void apagar() {
        campoResultado.setText("");
    }

    public void calcularesultado() {
        String expressao = campoResultado.getText();
        String resultado = Calculadora.avaliar(expressao);
        campoResultado.setText(resultado);
    }
}