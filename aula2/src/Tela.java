import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class Tela extends JFrame{
    private JPanel painel;
    public Tela(){
        painel = new JPanel();
    }

    public void configurarJanela(){
        setVisible(true);
        setTitle("AulaX");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(600, 500);
        add(painel);
        configurarPainel();
    }

    public void configurarPainel(){
        painel.setBackground(Color.yellow);
    }
}
