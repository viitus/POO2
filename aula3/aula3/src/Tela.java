import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame implements ActionListener{
    private JPanel painel;
    private JButton jbteste;
    public Tela(){
        painel = new JPanel();
        jbteste = new JButton("Clique aqui!");
    }

    public void configurarJanela(){
        setVisible(true);
        setTitle("Aula3");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(600, 500);
        add(painel);
        configurarPainel();
    }

    public void configurarPainel(){
        jbteste.setBounds(100, 100, 200, 50);
        jbteste.addActionListener(this);
        painel.add(jbteste);
        painel.setBackground(Color.red);
        painel.setLayout(null);

    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == jbteste) {
            JOptionPane.showMessageDialog(this, "Botão clicado!");
        }
    }
}
