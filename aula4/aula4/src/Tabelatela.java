import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabelatela extends JFrame{
    private JPanel painel;
    private JTable jtProduto;
    private JScrollPane jsProduto;
    private DefaultTableModel modeloProduto;
    private JButton jbAdicionar, jbImprimir;

    public Tabelatela(){
        painel = new JPanel();
        //jtProduto = new JTable(new String[][]{{"1","1","1"},{"2","2","2"}}, new String[] {"Descrição", "Preço", "Estoque"});
        modeloProduto = new DefaultTableModel(new String[] {"Descrição", "Preço", "Estoque"}, 0);
        jtProduto = new JTable(modeloProduto);
        jsProduto = new JScrollPane(jtProduto);
        jbAdicionar = new JButton("Adicionar");
        jbImprimir = new JButton("Imprimir");

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
        painel.setLayout(null);

        jsProduto.setBounds(10,10,160,100);
        painel.add(jsProduto); 
    
        jbAdicionar.setBounds(10, 120, 100, 20);
        jbAdicionar.addActionListener(evento -> {
            modeloProduto.addRow(new String[] {"Batata", "10.00", "5"});
        });
        painel.add(jbAdicionar);
    
        jbImprimir.setBounds(120, 120, 100, 20);
        jbImprimir.addActionListener(evento -> {
            int linha = jtProduto.getSelectedRow();
            JOptionPane.showMessageDialog(this, "Linha selecionada: " + linha + "\n" +
            "Descrição: " + jtProduto.getValueAt(linha, 0) + "\n" +
            "Preço: " + jtProduto.getValueAt(linha, 1) + "\n" +
            "Estoque: " + jtProduto.getValueAt(linha, 2));
        });
        painel.add(jbImprimir);
    }
}
