import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;

public class Tela extends JFrame{
    private JPanel painel, painelOut, painelIn;
    private JButton[] jbutoes;
    private String simbolos[] = {"AC/C" , "+/-", "%", "RaizQ", "/", "7", "8", "9", "X^Y","*", "4", "5", "6", "X^2","-", "1", "2", "3", "X^3","+", "0", ",", "X!", "10^X","="}; 
    private JTextField campoOut;

    public Tela(){
        painel = new JPanel();
        painelOut = new JPanel();
        painelIn = new JPanel();
        campoOut = new JTextField(20);
        jbutoes = new JButton[simbolos.length];
        for (int i = 0; i < simbolos.length; i++) {
            final int index = i;
            jbutoes[index] = new JButton(simbolos[index]);
            jbutoes[index].setFont(new Font("Arial", Font.BOLD, 15));
            jbutoes[index].addActionListener(e->{
                if (simbolos[index].equals("AC/C")){
                    campoOut.setText("");
                } else if (simbolos[index].matches("[0-9]")) {
                    campoOut.setText(campoOut.getText() + simbolos[index]);
                } else if (simbolos[index].equals(",")) {
                    campoOut.setText(campoOut.getText() + ".");
                } else if (simbolos[index].equals("=")) {
                    // Aqui você pode adicionar a lógica para calcular o resultado
                    // Exemplo: String resultado = calcularResultado(campoOut.getText());
                    // campoOut.setText(resultado);

                }else {
                    campoOut.setText(campoOut.getText() + simbolos[index]);
                }
            });
        }
    }

    public void configurarJanela(){
        setVisible(true);
        setTitle("Calculadora");
        setSize(435, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocation(600, 500);
        add(painel);
        configurarPainel();
    }

    public void configurarPainel(){
        //configurações painel principal
        painel.setLayout(null);
        painel.add(painelOut);
        painel.add(painelIn);
        
        //configurações de tamanho de paineis secundarios
        painelOut.setBounds(10, 0, 400, 50);
        painelIn.setBounds(10, 50, 400,400);

        //configurações do painel de Output
        campoOut.setPreferredSize(new Dimension(400, 40));
        campoOut.setFont(new Font("Arial", Font.BOLD, 20));
        campoOut.setEditable(false);
        painelOut.add(campoOut);
        painelOut.setLayout(new FlowLayout());
        
        //configuração do painel de Input
        painelIn.setLayout(new GridLayout(5,5));
        for (int i = 0; i < simbolos.length; i++) {
            painelIn.add(jbutoes[i]);
        }
        
        
    }
}
