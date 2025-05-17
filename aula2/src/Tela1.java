import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class Tela1 extends JFrame{
    private JPanel painel;
    private JLabel jlNomeCompleto, jlDataNasc, jlNome;
    private JTextField jtxNome;
    private JButton jbOk;
    public Tela1(){

        painel = new JPanel();
        jlNome = new JLabel("Nome:");
        jlNomeCompleto = new JLabel("Victor Dias Frota");
        jlDataNasc = new JLabel("08/08/1998");
        jbOk = new JButton("OK");
        jtxNome = new JTextField();
    }

    public void configurarJanela(){
        setVisible(true);
        setTitle("Aula1604");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(600, 500);
        add(painel);
        configurarPainel();
    }

    public void configurarPainel(){
        painel.setLayout(null);
        painel.setBackground(Color.yellow);
        painel.add(jlNome);
        painel.add(jlNomeCompleto);
        painel.add(jlDataNasc);
        painel.add(jtxNome);
        painel.add(jbOk);

        jbOk.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,"oi galere");
        });
        jlNomeCompleto.setFont(new Font("Arial", Font.BOLD, 20));
        jlNomeCompleto.setForeground(Color.red);
        jlNomeCompleto.setBounds(10, 10, 200, 30);
        jlDataNasc.setBounds(210, 10, 200, 30);
        jlNome.setBounds(10, 50, 50, 30);
        jbOk.setBounds(10, 100, 100, 30);
        jtxNome.setBounds(70, 50, 200, 30);
    }
}
