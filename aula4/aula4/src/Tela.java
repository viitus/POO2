import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;

public class Tela extends JFrame{
    private JPanel painel;
    //parte 1
    private JComboBox<String> jcbEstados;
    private JLabel jlEstados;
    private JButton jbAdicionar, jbImprimir;
    //parte 2
    private JTextArea jtxaObservacao;
    private JScrollPane jspObservacao;
    private JButton jbImprimir2, jbFormatar;

    public Tela(){
        painel = new JPanel();
        //parte 1
        jlEstados = new JLabel("Selecione o seu estado: ");
        jcbEstados = new JComboBox<>(new String[] {"Acre", "Minas Gerais", "São Paulo", "Pernanbuco"});
        jbAdicionar = new JButton("Adicionar");
        jbImprimir = new JButton("Imprimir");
        //parte 2
        jtxaObservacao = new JTextArea();
        jspObservacao = new JScrollPane(jtxaObservacao);
        jbImprimir2 = new JButton("Imprimir");
        jbFormatar = new JButton("Formatar");
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
        painel.setLayout(null);
        
        //parte 1
        jlEstados.setBounds(10,10,150,20);
        painel.add(jlEstados);

        jcbEstados.setBounds(160, 10, 100, 20);
        painel.add(jcbEstados);

        jbAdicionar.setBounds(10, 50, 100, 20);
        jbAdicionar.addActionListener(evento -> {
            String estado = JOptionPane.showInputDialog("Digite o nome do estado: ");
            jcbEstados.addItem(estado);
        });
        painel.add(jbAdicionar);

        jbImprimir.setBounds(120, 50, 100, 20);
        jbImprimir.addActionListener(evento -> {
            String estado = jcbEstados.getSelectedItem().toString();
            Integer index = jcbEstados.getSelectedIndex();
            JOptionPane.showMessageDialog(null, "Estado: " + estado + "\nIndex: " + index, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        });
        painel.add(jbImprimir);
        
        //parte 2
        jspObservacao.setBounds(10, 100, 350, 200);
        jspObservacao.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jspObservacao.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jtxaObservacao.setLineWrap(true);
        painel.add(jspObservacao);

        jbImprimir2.setBounds(10, 310, 100, 20);
        jbImprimir2.addActionListener(evento ->{
            String texto = jtxaObservacao.getText();
            JOptionPane.showMessageDialog(this, texto);
        });
        painel.add(jbImprimir2);

        jbFormatar.setBounds(120, 310, 100, 20);
        jbFormatar.addActionListener(evento -> {
            jtxaObservacao.setFont(new Font("Arial",Font.BOLD,16));
            jtxaObservacao.setForeground(Color.MAGENTA);
        });
        painel.add(jbFormatar);

    }
}
