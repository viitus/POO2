import javax.swing.*;
import java.awt.*;

public class Tela extends JFrame{
    private JPanel painel;
    private JPanel partes[];
    private JComboBox<String> jcbFonte, jcbCor, jcbTamanho;
    private JLabel jlFonte, jlCor, jlTamanho;
    private JButton jbAlteraFormat, jbLimpaFormat, jbApagaText;
    private ButtonGroup grupoEstilo;
    private JRadioButton jrbNegrito, jrbItalico, jrbNormal, jrbNegritoItalico;
    private JTextArea jtaTexto;
    private JScrollPane jScrollPane;

    public Tela(){
        painel = new JPanel();
        partes = new JPanel[4];
        for(int i = 0; i<partes.length; i++){
            partes[i] = new JPanel();
        }
        //parte 0
        jlFonte = new JLabel("Fonte: ");
        jcbFonte = new JComboBox<>();
        jlTamanho = new JLabel("Tamanho: ");
        jcbTamanho = new JComboBox<>();
        //parte 1
        jlCor = new JLabel("Cor: ");
        jcbCor = new JComboBox<>();
        jbAlteraFormat = new JButton("Alterar Formatação");
        jbLimpaFormat = new JButton("Limpar Formatação");
        //parte 2
        grupoEstilo = new ButtonGroup();
        jrbNegrito = new JRadioButton("Negrito");
        jrbItalico = new JRadioButton("Itálico");
        jrbNormal = new JRadioButton("Normal");
        jrbNegritoItalico = new JRadioButton("Negrito-Itálico");
        jbApagaText = new JButton("Apagar Texto");
        //parte 3
        jtaTexto = new JTextArea();
        jScrollPane = new JScrollPane(jtaTexto);
    }

    public void configurarJanela(){
        setVisible(true);
        setTitle("LISTA 2");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(400, 200);
        add(painel);
        configurarPainel();
    }

    public void configurarPainel() {
        //painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        //painel.setLayout(new GridLayout(0,1));
        painel.setLayout(new FlowLayout(FlowLayout.LEFT));
        for(int i = 0; i < partes.length; i++){
            painel.add(partes[i]);
        }

        //parte 1
        partes[0].setLayout(new FlowLayout(FlowLayout.LEFT));
        partes[0].add(jlFonte);
        partes[0].add(jcbFonte);
        jcbFonte.addItem("-Selecionar-");

        jcbFonte.addItem("Arial");
        jcbFonte.addItem("Times New Roman");
        jcbFonte.addItem("Courier New");
        jcbFonte.addItem("Georgia");
        jcbFonte.addItem("Verdana");
        jcbFonte.addItem("Tahoma");
        jcbFonte.addItem("Comic Sans MS");
        jcbFonte.addItem("Impact");
        jcbFonte.addItem("Trebuchet MS");
        jcbFonte.addItem("Lucida Console");
        jcbFonte.addItem("Palatino Linotype");

        partes[0].add(jlTamanho);
        partes[0].add(jcbTamanho);
        jcbTamanho.addItem("-Selecionar-");
        for(int i=8; i<=36; i+=2){
            jcbTamanho.addItem(String.valueOf(i));
        }


        //parte2
        partes[1].setLayout(new FlowLayout(FlowLayout.LEFT));
        partes[1].add(jlCor);
        partes[1].add(jcbCor);
        jcbCor.addItem("-Selecionar-");

        jcbCor.addItem("Preto");
        jcbCor.addItem("Vermelho");
        jcbCor.addItem("Verde");
        jcbCor.addItem("Azul");
        jcbCor.addItem("Amarelo");
        jcbCor.addItem("Laranja");
        jcbCor.addItem("Rosa");
        jcbCor.addItem("Roxo");
        jcbCor.addItem("Cinza");
        jcbCor.addItem("Marrom");
        jcbCor.addItem("Ciano");
        
        partes[1].add(jbAlteraFormat);
        jbAlteraFormat.addActionListener(event-> {
            String fonte = (String) jcbFonte.getSelectedItem();
            String tamanhoStr = (String) jcbTamanho.getSelectedItem();
            String cor = (String) jcbCor.getSelectedItem();

            if (fonte.equals("-Selecionar-") || tamanhoStr.equals("-Selecionar-") || cor.equals("-Selecionar-")) {
                JOptionPane.showMessageDialog(this, "Selecione uma fonte, tamanho e cor válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int tamanho = Integer.parseInt(tamanhoStr);
            int estilo = Font.PLAIN;
            if (jrbNegrito.isSelected()) estilo = Font.BOLD;
            else if (jrbItalico.isSelected()) estilo = Font.ITALIC;
            else if (jrbNegritoItalico.isSelected()) estilo = Font.BOLD | Font.ITALIC;

            jtaTexto.setFont(new Font(fonte, estilo, tamanho));

            switch (cor) {
                case "Preto": jtaTexto.setForeground(Color.BLACK); break;
                case "Vermelho": jtaTexto.setForeground(Color.RED); break;
                case "Verde": jtaTexto.setForeground(Color.GREEN); break;
                case "Azul": jtaTexto.setForeground(Color.BLUE); break;
                case "Amarelo": jtaTexto.setForeground(Color.YELLOW); break;
                case "Laranja": jtaTexto.setForeground(Color.ORANGE); break;
                case "Rosa": jtaTexto.setForeground(Color.PINK); break;
                case "Roxo": jtaTexto.setForeground(new Color(128, 0, 128)); break;
                case "Cinza": jtaTexto.setForeground(Color.GRAY); break;
                case "Marrom": jtaTexto.setForeground(new Color(139, 69, 19)); break;
                case "Ciano": jtaTexto.setForeground(Color.CYAN); break;
            }
        });

        partes[1].add(jbLimpaFormat);
        jbLimpaFormat.addActionListener(event-> {
            jtaTexto.setFont(new Font("Arial", Font.PLAIN, 12));
            jtaTexto.setForeground(Color.BLACK);
            jcbFonte.setSelectedIndex(0);
            jcbTamanho.setSelectedIndex(0);
            jcbCor.setSelectedIndex(0);
            grupoEstilo.clearSelection();
        });

        //parte3
        partes[2].setLayout(new FlowLayout(FlowLayout.LEFT));
        grupoEstilo.add(jrbItalico);
        grupoEstilo.add(jrbNegrito);
        grupoEstilo.add(jrbNegritoItalico);
        grupoEstilo.add(jrbNormal);
        partes[2].add(jrbNegrito);
        partes[2].add(jrbNormal);
        partes[2].add(jrbItalico);
        partes[2].add(jrbNegritoItalico);
        
        partes[2].add(jbApagaText);
        jbApagaText.addActionListener(event-> {
            jtaTexto.setText("");
        });

        //parte4
        partes[3].setLayout(new FlowLayout(FlowLayout.LEFT));
        jScrollPane.setPreferredSize(new Dimension(500,400));
        jtaTexto.setLineWrap(true);
        partes[3].add(jScrollPane);
    }
}
