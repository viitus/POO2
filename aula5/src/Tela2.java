import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

public class Tela2 extends JFrame{
    private JPanel painel;
    private JPanel[] regioes;
    private JButton[] botoesNorth;
    private JLabel jlEast, jlWest, jlObservacao;
    private JTextArea jtxaObservacao;
    private JScrollPane jspObservacao;
    private JButton[] botoesCenter;
    private JMenuBar barraMenu;
    private JMenu jmSobre;
    private JMenuItem jmiAbout, jmiOpcoes;

    public Tela2(){
        painel = new JPanel();
        regioes = new JPanel[5];
        for(int i = 0; i < regioes.length; i++){
            regioes[i] = new JPanel();
        }
        botoesNorth = new JButton[3];
        for(int i = 0; i < botoesNorth.length; i++){
            botoesNorth[i] = new JButton("Botão " + (i + 1));
        }
        botoesCenter = new JButton[6];
        for(int i = 0; i < botoesCenter.length; i++){
            botoesCenter[i] = new JButton("Botão " + (i + 1));
        }
        jlEast = new JLabel("East");
        jlWest = new JLabel("West");
        jlObservacao = new JLabel("Observação:");
        jtxaObservacao = new JTextArea(5,30);
        jspObservacao = new JScrollPane(jtxaObservacao);
        barraMenu = new JMenuBar();
        jmSobre = new JMenu("Sobre");
        jmiAbout = new JMenuItem("About");
        jmiOpcoes = new JMenu("Opcoes");
    }

    public void configurarJanela(){
        setVisible(true);
        setTitle("Aula5");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocation(600, 500);
        add(painel);
        setJMenuBar(barraMenu);
        configurarPainel();
    }

    public void configurarPainel(){
        painel.setLayout(new BorderLayout());
        painel.add(regioes[0], BorderLayout.NORTH);
        painel.add(regioes[3], BorderLayout.SOUTH);
        painel.add(regioes[2], BorderLayout.EAST);
        painel.add(regioes[1], BorderLayout.WEST);
        painel.add(regioes[4], BorderLayout.CENTER);
        configurarPainelCenter();
        configurarPainelEast();
        configurarPainelNorth();
        configurarPainelSouth();
        configurarPainelWest();
        barraMenu.add(jmSobre);
        jmSobre.add(jmiAbout);
        jmSobre.add(jmiOpcoes);
    }

    private void configurarPainelNorth(){
        regioes[0].setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        regioes[0].setBackground(Color.white);
        for(int i = 0; i < 3; i++){
            regioes[0].add(botoesNorth[i]);
        }
        botoesNorth[0].addActionListener(evento->{
            JOptionPane.showMessageDialog(this,"Clicou no botao 1");
        });
        botoesNorth[1].addActionListener(evento->{
            botoesNorth[1].setText("Clicou botao");
        });
        botoesNorth[2].addActionListener(evento->{
            System.exit(0);
        });
    }

    private void configurarPainelSouth(){
        regioes[3].setBackground(Color.GRAY);
        regioes[3].add(jlObservacao);
        regioes[3].add(jspObservacao);
    }

    private void configurarPainelEast(){
        jlEast.setText("Loremloremloremlrfnaknf");
        regioes[2].setBackground(Color.orange);
        regioes[2].add(jlEast);
    }

    private void configurarPainelWest(){
        regioes[1].setBackground(Color.GREEN);
        regioes[1].add(jlWest);
    }

    private void configurarPainelCenter(){
        regioes[4].setLayout(new GridLayout(3,2));
        for(int i = 0; i < botoesCenter.length; i++){
            regioes[4].add(botoesCenter[i]);
        }
        botoesCenter[0].addActionListener(evento->{
            JOptionPane.showMessageDialog(this, "texto");
        });
        botoesCenter[1].addActionListener(evento->{
            String texto = jtxaObservacao.getText();
            JOptionPane.showMessageDialog(this, texto);
        });
        botoesCenter[2].addActionListener(evento->{
            jlObservacao.setFont(new Font("Corrier",Font.ITALIC,20));
        });
        //botoes 3 4 e 5 nao fazem nada
    }

}

