import javax.swing.*;
import java.awt.*;

public class Tela extends JFrame{
    private JPanel painel, painelOut, painelIn;
    private JButton[] jbutoes;
    private String simbolos[] = {
         "AC/C", "+/-", "%", "RaizQ", "/", 
            "7",   "8", "9",  "X^Y",  "*", 
            "4",   "5", "6",  "X^2",  "-", 
            "1",   "2", "3",  "X^3",  "+", 
            "0",   ",", "X!", "10^X", "="
        }; 

    private JTextField campoExpressao;
    private JTextField campoResultado;

    public Tela(){
        painel = new JPanel();
        
        painelOut = new JPanel();
        painelIn = new JPanel();
        
        campoExpressao = new JTextField(20);
        campoResultado= new JTextField(20);
        
        jbutoes = new JButton[simbolos.length];
        for (int i = 0; i < simbolos.length; i++) {
            jbutoes[i] = new JButton(simbolos[i]);
            int index = i;

            jbutoes[i].addActionListener(e -> {
                String texto = simbolos[index];

                // Botoes numéricos
                if (texto.matches("[0-9]")) {  
                    campoResultado.setText(campoResultado.getText() + texto);
                } 
                
                // Botoes de operacoes simples
                else if (texto.matches("[+\\-*/]")) {
                    campoExpressao.setText(campoExpressao.getText() + campoResultado.getText() + " " + texto + " ");
                    campoResultado.setText(""); 

                } 
                
                // Botao de Igual
                else if (texto.equals("=")) { 
                    String expressaoCompleta = campoExpressao.getText() + campoResultado.getText();

                    try {
                        double resultado = avaliarExpressao(expressaoCompleta);
                        campoResultado.setText(String.valueOf(resultado));
                        campoExpressao.setText(""); 
                    } catch (Exception ex) {
                        campoResultado.setText("Erro");
                    }
                } 
                
                // Botao de apagar
                else if (texto.equals("AC/C")) {
                    if (campoResultado.getText().isEmpty()) {
                        campoExpressao.setText("");
                    }
                    campoResultado.setText("");
                } 
                
                // Botao de troca de sinal
                else if (texto.equals("+/-")) {
                    String atual = campoResultado.getText();
                    if (!atual.isEmpty()) {
                        if (atual.startsWith("-")) {
                            campoResultado.setText(atual.substring(1));
                        } else {
                            campoResultado.setText("-" + atual);
                        }
                    }
                } 
                
                //Botao de virgula
                else if (texto.equals(",")) {
                    if (!campoResultado.getText().contains(".")) {
                        campoResultado.setText(campoResultado.getText() + ".");
                    }
                }
                
            });
        }
    }

    public void configurarJanela(){
        setVisible(true);
        setTitle("Calculadora");
        setSize(435, 510);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocation(600, 500);
        add(painel);
        configurarPainel();
    }

    public void configurarPainel(){
        //configurações painel principal
        painel.setLayout(null);
        painel.setBackground(Color.LIGHT_GRAY);
        painel.add(painelOut);
        painel.add(painelIn);
        
        //configurações de tamanho de paineis secundarios
        painelOut.setBounds(10, 10, 400, 70);
        painelIn.setBounds(10, 80, 400,380);

        //configurações do painel de Output
        painelOut.setLayout(new GridLayout(2,1));
        painelOut.add(campoExpressao);
        painelOut.add(campoResultado);

        campoExpressao.setFont(new Font("Arial", Font.PLAIN, 16));
        campoExpressao.setHorizontalAlignment(JTextField.RIGHT);
        campoExpressao.setEditable(false);
        campoExpressao.setBorder(null);
        
        campoResultado.setFont(new Font("Arial", Font.BOLD, 24));
        campoResultado.setHorizontalAlignment(JTextField.RIGHT);
        campoResultado.setEditable(false);
        campoResultado.setBorder(null);
        
        //configuração do painel de Input
        painelIn.setLayout(new GridLayout(5,5));
        for (int i = 0; i < simbolos.length; i++) {
            painelIn.add(jbutoes[i]);
        }
        
    }

    private double avaliarExpressao(String expressao) {
        // Troca X por * se necessário (ex: se futuramente usar X no botão)
        expressao = expressao.replaceAll("X", "*");
        
        // Usa JavaScript para avaliar expressão simples
        try {
            return (double) new javax.script.ScriptEngineManager()
                .getEngineByName("JavaScript")
                .eval(expressao);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao avaliar expressão: " + expressao);
        }
    }
    
}
