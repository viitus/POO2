import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class Tela2 extends JFrame{
    private JPanel painel;
    private JButton jbFechar;
    private JButton jbCalcular;
    private JLabel jlAnoNascimento;
    private JTextField jtxAnoNascimento;

    public Tela2(){
        painel = new JPanel();
        jbFechar = new JButton("Fechar");
        jbCalcular = new JButton("Calcular");
        jlAnoNascimento = new JLabel("Ano de Nascimento:");
        jtxAnoNascimento = new JTextField();
    }

    public void configurarJanela(){
        setVisible(true);
        setTitle("Aula3");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(600, 500);
        add(painel);
        configurarPainel();
    }

    public void configurarPainel(){
        painel.setLayout(null);

        
        jlAnoNascimento.setBounds(10, 10, 150, 30);
        painel.add(jlAnoNascimento);

        jtxAnoNascimento.setBounds(170, 10, 150, 30);
        painel.add(jtxAnoNascimento);

        jbFechar.setBounds(10, 50, 150, 50);
        jbFechar.addActionListener(e -> {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja fechar?", "Fechar", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        painel.add(jbFechar);

        jbCalcular.setBounds(170, 50, 150, 50);
        jbCalcular.addActionListener(e -> {
            String anoStr = jtxAnoNascimento.getText();
            try {
                int ano = Integer.parseInt(anoStr);
                int idade = 2025 - ano;
                JOptionPane.showMessageDialog(this, "Idade: " + idade + " anos.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um ano válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        painel.add(jbCalcular);
        painel.setBackground(Color.red);
        
    }

}
