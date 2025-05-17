import javax.swing.JFrame;

public class Minhaprimeirajanela {
    public JFrame janela;
    public Minhaprimeirajanela() {
        janela = new JFrame();
    }

    public void criarJanela() {
        janela.setVisible(true);
        janela.setSize(400, 400);
        janela.setTitle("Minha Primeira Janela");
        janela.setResizable(true);
        janela.setLocation(200, 200);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
