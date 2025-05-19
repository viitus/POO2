import javax.swing.*;
import java.awt.*;

public class Tela extends JFrame {
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
    // Variaveis para armazenar os numeros e o operador
    private double numeradorA = 0;
    private double numeradorB = 0;
    private String operador = "";
    // Variavel para verificar se o segundo numero esta sendo digitado
    private boolean aguardandoSegundoNumero = false;

    public Tela() {
        painel = new JPanel();
        painelOut = new JPanel();
        painelIn = new JPanel();
        campoResultado = new JTextField(15);
        jbutoes = new JButton[simbolos.length];
        // Cria os botoes e adiciona o evento de clique
        for (int i = 0; i < simbolos.length; i++) {
            jbutoes[i] = new JButton(simbolos[i]);
            int index = i;
            jbutoes[i].addActionListener(e -> tratarBotao(simbolos[index]));
        }
        configurarJanela();
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
        //painel principal
        painel.setLayout(null);
        painel.setBackground(Color.LIGHT_GRAY);
        painel.add(painelOut);
        painel.add(painelIn);
        //posicoes
        painelOut.setBounds(10, 30, 400, 50);
        painelIn.setBounds(10, 80, 400, 380);
        //painel de resultado
        painelOut.setBackground(Color.LIGHT_GRAY);
        painelOut.add(campoResultado);
        campoResultado.setFont(new Font("Arial", Font.BOLD, 24));
        campoResultado.setHorizontalAlignment(JTextField.RIGHT);
        campoResultado.setEditable(false);
        //painel de botoes
        painelIn.setLayout(new GridLayout(5, 5));
        for (JButton botao : jbutoes) {
            painelIn.add(botao);
        }
    }

    public void tratarBotao(String simbolo) {
        //botoes de numeros e virgula, apenas adiciona o simbolo ao campo
        if (simbolo.matches("[0-9]") || simbolo.equals(",")) {
            if (simbolo.equals(",")) simbolo = ".";
            campoResultado.setText(campoResultado.getText() + simbolo);

        //Botao de AC/C limpa o campo resultado
        //se o campo resultado estiver vazio, limpa os valores da memoria
        } else if (simbolo.equals("AC/C")) {
            if (!campoResultado.getText().isEmpty()) {
                campoResultado.setText("");
            } else {
                numeradorA = 0;
                numeradorB = 0;
                operador = "";
                aguardandoSegundoNumero = false;
                campoResultado.setText("");
            }

        //Botao de igual, calcula o resultado de operacoes simples
        } else if (simbolo.equals("=")) {
            if (!operador.isEmpty() && !campoResultado.getText().isEmpty()) {
                numeradorB = Double.parseDouble(campoResultado.getText());
                calculaResultado();
            }

        //Botao de operadores simples    
        } else if (simbolo.matches("[+\\-*/]")) {           
            numeradorA = Double.parseDouble(campoResultado.getText());
            operador = simbolo;
            aguardandoSegundoNumero = true;
            campoResultado.setText("");
        
        } else if (simbolo.equals("X^Y")) {
            numeradorA = Double.parseDouble(campoResultado.getText());
            operador = simbolo;
            aguardandoSegundoNumero = true;
            campoResultado.setText("");

        } else if (simbolo.equals("%")) {            
            numeradorA = Double.parseDouble(campoResultado.getText());
            operador = simbolo;
            aguardandoSegundoNumero = true;
            campoResultado.setText("");

        //Botao de operadores especiais - dão o resultado sem precionar o =
        } else if (simbolo.equals("+/-")) {
            double valor = Double.parseDouble(campoResultado.getText());
            campoResultado.setText(String.valueOf(-valor));
        
        } else if (simbolo.equals("RaizQ")) {
            double valor = Double.parseDouble(campoResultado.getText());
            campoResultado.setText(String.valueOf(Math.sqrt(valor)));
        
        } else if (simbolo.equals("X^2")) {
            double valor = Double.parseDouble(campoResultado.getText());
            campoResultado.setText(String.valueOf(Math.pow(valor, 2)));
        
        } else if (simbolo.equals("X^3")) {
            double valor = Double.parseDouble(campoResultado.getText());
            campoResultado.setText(String.valueOf(Math.pow(valor, 3)));
        
        } else if (simbolo.equals("X!")) {
            int valor = Integer.parseInt(campoResultado.getText());
            int fatorial = 1;
            for (int i = 1; i <= valor; i++) {
                fatorial *= i;
            }
            campoResultado.setText(String.valueOf(fatorial));
        
        } else if (simbolo.equals("10^X")) {
            double valor = Double.parseDouble(campoResultado.getText());
            campoResultado.setText(String.valueOf(Math.pow(10, valor)));
            
        } else {
            campoResultado.setText("Erro");
        }
    }

    // Metodo para calcular o resultado de operacoes simples
    public void calculaResultado() {
        double resultado = 0;
        switch (operador) {
            case "+": resultado = numeradorA + numeradorB; break;
            case "-": resultado = numeradorA - numeradorB; break;
            case "*": resultado = numeradorA * numeradorB; break;
            case "X^Y": resultado = Math.pow(numeradorA, numeradorB); break;
            case "%": resultado = numeradorA * (numeradorB / 100); break;
            case "/":
                if (numeradorB == 0) {
                    campoResultado.setText("Erro: Divisão por 0");
                    return;
                }
                resultado = numeradorA / numeradorB; break;
            default: campoResultado.setText("Erro"); return;
        }
        campoResultado.setText(String.valueOf(resultado));
        numeradorA = resultado; 
        aguardandoSegundoNumero = false;
    }


}
