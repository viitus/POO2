import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Tela extends JFrame{
    private JPanel painel;
    private JButton[] botoes;

    public Tela(){
        painel = new JPanel();
        botoes = new JButton[15];
        for(int i = 0; i < botoes.length; i++){
            botoes[i] = new JButton("Botão " + (i + 1));
        }
    }

    public void configurarJanela(){
        setVisible(true);
        setTitle("Aula5");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocation(600, 500);
        add(painel);
        configurarPainel();
    }

    public void configurarPainel(){
        //painel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        //painel.setLayout(new GridLayout(5,3, 10,10));
        painel.setLayout(new BorderLayout());
        
        painel.add(botoes[0], BorderLayout.NORTH);
        painel.add(botoes[1], BorderLayout.SOUTH);
        painel.add(botoes[2], BorderLayout.EAST);
        painel.add(botoes[3], BorderLayout.WEST);
        painel.add(botoes[4], BorderLayout.CENTER);
        

        //for (int i = 0; i < botoes.length; i++){
        //    painel.add(botoes[i]);
        //}

    }
}
