import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Tela3 extends JFrame{
    private JPanel painel;
    private JRadioButton jrbMasculino, jrbFeminino, jrbOutro;
    private JCheckBox jckMetal, jckFolk, jckSertanejo;
    private JLabel jlSexo, jlGenero;
    private ButtonGroup grupoSexo;
    private JButton jbImprimir;

    public Tela3(){
        painel = new JPanel();
        jrbMasculino = new JRadioButton("Masculino");
        jrbFeminino = new JRadioButton("Feminino");
        jrbOutro = new JRadioButton("Outro", true);
        jckMetal = new JCheckBox("Metal", true);
        jckFolk = new JCheckBox("Folk");
        jckSertanejo = new JCheckBox("Sertanejo");
        jlSexo = new JLabel("Sexo:");
        jlGenero = new JLabel("Gênero Musical Favorito:");
        grupoSexo = new ButtonGroup();
        jbImprimir = new JButton("Imprimir Resultado");
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
        
        jlSexo.setBounds(10, 10, 150, 30);
        painel.add(jlSexo);
        jrbMasculino.setBounds(10, 50, 150, 30);
        painel.add(jrbMasculino);
        jrbFeminino.setBounds(10, 90, 150, 30);
        painel.add(jrbFeminino);
        jrbOutro.setBounds(10, 130, 150, 30);
        painel.add(jrbOutro);
        grupoSexo.add(jrbMasculino);
        grupoSexo.add(jrbFeminino);
        grupoSexo.add(jrbOutro);

        jlGenero.setBounds(200, 10, 150, 30);
        painel.add(jlGenero);
        jckMetal.setBounds(200, 50, 150, 30);
        painel.add(jckMetal);
        jckFolk.setBounds(200, 90, 150, 30);
        painel.add(jckFolk);
        jckSertanejo.setBounds(200, 130, 150, 30);
        painel.add(jckSertanejo);

        jbImprimir.setBounds(10, 170, 150, 50);
        jbImprimir.addActionListener(e -> {
            String sexo = "Sexo: ";
            if (jrbMasculino.isSelected()) {
                sexo += "Masculino";
            } else if (jrbFeminino.isSelected()) {
                sexo += "Feminino";
            } else {
                sexo += "Outro";
            }

            String genero = "\n\nGênero Musicais: \n";
            if (jckMetal.isSelected()) {
                genero += "Metal \n";
            }
            if (jckFolk.isSelected()) {
                genero += "Folk \n";
            }
            if (jckSertanejo.isSelected()) {
                genero += "Sertanejo \n";
            }
            JOptionPane.showMessageDialog(this, sexo + genero, "\nResultado", JOptionPane.PLAIN_MESSAGE);
        });
        painel.add(jbImprimir);
    }

}
