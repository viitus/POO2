import javax.swing.*;
import java.awt.*;

public class Tela2 extends JFrame {
    private JPanel painel, painelOut, painelIn;
    private JButton[] jbutoes;
    private String simbolos[] = {
        "AC/C", "+/-", "%", "RaizQ", "/",
        "7", "8", "9", "X^Y", "*",
        "4", "5", "6", "X^2", "-",
        "1", "2", "3", "X^3", "+",
        "0", ",", "X!", "10^X", "="
    };

    private JTextField campoExpressao;
    private JTextField campoResultado;

    public Tela2() {
        painel = new JPanel();
        painelOut = new JPanel();
        painelIn = new JPanel();

        campoExpressao = new JTextField(20);
        campoResultado = new JTextField(20);

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

        painelOut.setLayout(new GridLayout(2, 1));
        painelOut.add(campoExpressao);
        painelOut.add(campoResultado);

        campoExpressao.setFont(new Font("Arial", Font.BOLD, 16));
        campoExpressao.setHorizontalAlignment(JTextField.RIGHT);
        campoExpressao.setEditable(false);
        campoExpressao.setBorder(null);

        campoResultado.setFont(new Font("Arial", Font.BOLD, 24));
        campoResultado.setHorizontalAlignment(JTextField.RIGHT);
        campoResultado.setEditable(false);
        campoResultado.setBorder(null);

        painelIn.setLayout(new GridLayout(5, 5));
        for (JButton botao : jbutoes) {
            painelIn.add(botao);
        }
    }

    private void tratarBotao(String texto) {
        switch (texto) {
            case "AC/C": limpar(); break;
            case "+/-": inverterSinal(); break;
            case ",": adicionarVirgula(); break;
            case "=": calcularResultado(); break;
            case "X^2": aplicarPotenciaRapida(2); break;
            case "X^3": aplicarPotenciaRapida(3); break;
            case "10^X": aplicarDezElevado(); break;
            case "X^Y": prepararPotencia(); break;
            case "RaizQ": calcularRaiz(); break;
            case "X!": calcularFatorial(); break;
            case "%": calcularPorcentagem(); break;
            default:
                if (texto.matches("[0-9]")) {
                    campoResultado.setText(campoResultado.getText() + texto);
                } else if (texto.matches("[+\\-*/^]")) {
                    tratarOperador(texto);
                }
                break;
        }
    }

    private void tratarOperador(String operador) {
        String resultadoAtual = campoResultado.getText().trim();
        String expressaoAtual = campoExpressao.getText().trim();

        if (!resultadoAtual.isEmpty()) {
            String expressao = expressaoAtual + resultadoAtual;
            try {
                double resultado = avaliarExpressao(expressao);
                campoExpressao.setText(resultado + " " + operador + " ");
                campoResultado.setText("");
            } catch (Exception e) {
                campoResultado.setText("Erro");
            }
        } else if (!expressaoAtual.isEmpty()) {
            campoExpressao.setText(expressaoAtual.replaceAll("[+\\-*/^]\\s*$", operador + " "));
        }
    }

    private void aplicarPotenciaRapida(int expoente) {
        try {
            String expressao = campoExpressao.getText() + campoResultado.getText();
            double base = avaliarExpressao(expressao);
            double resultado = Math.pow(base, expoente);
            campoExpressao.setText(base + "^" + expoente);
            campoResultado.setText(String.valueOf(resultado));
        } catch (Exception e) {
            campoResultado.setText("Erro");
        }
    }

    private void aplicarDezElevado() {
        try {
            String expressao = campoExpressao.getText() + campoResultado.getText();
            double valor = avaliarExpressao(expressao);
            double resultado = Math.pow(10, valor);
            campoExpressao.setText("10^" + valor);
            campoResultado.setText(String.valueOf(resultado));
        } catch (Exception e) {
            campoResultado.setText("Erro");
        }
    }

    private void limpar() {
        if (campoResultado.getText().isEmpty()) {
            campoExpressao.setText("");
        }
        campoResultado.setText("");
    }

    private void inverterSinal() {
        String atual = campoResultado.getText();
        if (!atual.isEmpty()) {
            campoResultado.setText(atual.startsWith("-") ? atual.substring(1) : "-" + atual);
        }
    }

    private void adicionarVirgula() {
        if (!campoResultado.getText().contains(".")) {
            campoResultado.setText(campoResultado.getText() + ".");
        }
    }

    private void calcularResultado() {
        try {
            String expressao = campoExpressao.getText() + campoResultado.getText();
            double resultado = avaliarExpressao(expressao);
            campoExpressao.setText(expressao);
            campoResultado.setText(String.valueOf(resultado));
        } catch (Exception e) {
            campoResultado.setText("Erro");
        }
    }

    private void prepararPotencia() {
        try {
            String expressao = campoExpressao.getText() + campoResultado.getText();
            double base = avaliarExpressao(expressao);
            campoExpressao.setText(base + " ^ ");
            campoResultado.setText("");
        } catch (Exception ex) {
            campoResultado.setText("Erro");
        }
    }

    private void calcularRaiz() {
        try {
            String expressao = campoExpressao.getText() + campoResultado.getText();
            double valor = avaliarExpressao(expressao);
            campoExpressao.setText("√(" + valor + ")");
            campoResultado.setText(String.valueOf(Math.sqrt(valor)));
        } catch (NumberFormatException ex) {
            campoResultado.setText("Erro");
        }
    }

    private void calcularFatorial() {
        try {
            String expressao = campoExpressao.getText() + campoResultado.getText();
            int valor = (int) avaliarExpressao(expressao);
            int fatorial = 1;
            for (int j = 1; j <= valor; j++) {
                fatorial *= j;
            }
            campoExpressao.setText(valor + "!");
            campoResultado.setText(String.valueOf(fatorial));
        } catch (Exception ex) {
            campoResultado.setText("Erro");
        }
    }

    private void calcularPorcentagem() {
        try {
            String expressao = campoExpressao.getText() + campoResultado.getText();
            double valor = avaliarExpressao(expressao);
            campoExpressao.setText(valor + "%");
            campoResultado.setText(String.valueOf(valor / 100));
        } catch (Exception ex) {
            campoResultado.setText("Erro");
        }
    }

    private double avaliarExpressao(String expressao) {
        try {
            expressao = expressao.replaceAll("X", "*").replaceAll(",", ".");

            String[] tokens = expressao.trim().split(" ");

            if (tokens.length == 1) {
                return Double.parseDouble(tokens[0]);
            }

            if (tokens.length != 3) {
                throw new IllegalArgumentException("Formato inválido");
            }

            double n1 = Double.parseDouble(tokens[0]);
            String op = tokens[1];
            double n2 = Double.parseDouble(tokens[2]);

            switch (op) {
                case "+": return n1 + n2;
                case "-": return n1 - n2;
                case "*": return n1 * n2;
                case "/": return n1 / n2;
                case "^": return Math.pow(n1, n2);
                default: throw new IllegalArgumentException("Operador inválido");
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao avaliar expressão: " + expressao);
        }
    }
}