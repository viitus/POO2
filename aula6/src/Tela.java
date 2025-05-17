import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class Tela extends JFrame{
    private JPanel painel;
    private JLabel jlLogin, jlCEP, jlTeste, jlOpcoes;
    private JFormattedTextField jftCEP, jftTeste;
    private JButton jbImprimir;
    private JPasswordField jpfLogin;
    private JSpinner jspOpcoes, jspIntervalo;

    public Tela(){
        painel = new JPanel();
        jlLogin = new JLabel("Login: ");
        jpfLogin = new JPasswordField();
        jbImprimir = new JButton("Imprimir");
        jlCEP = new JLabel("CEP: ");
        jlTeste = new JLabel("Teste: ");
        try{
            jftCEP = new JFormattedTextField(new MaskFormatter("##.###-###"));
            jftTeste = new JFormattedTextField(new MaskFormatter("UUUU"));
        }catch(ParseException erro){
            System.out.println(erro.getMessage());
        }
        jlOpcoes = new JLabel("Opções: ");
        jspOpcoes = new JSpinner(new SpinnerListModel(new String[]{"Opção 1","Opção 2","opcao3","Calos","Marximos"}));
        jspIntervalo = new JSpinner(new SpinnerNumberModel(50,0,100,5));
    }

    public void configurarJanela(){
        setVisible(true);
        setTitle("Aula6");
        setSize(280, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocation(600, 500);
        add(painel);
        configurarPainel();
    }

    public void configurarPainel(){
        painel.setLayout(null);
        
        jlLogin.setBounds(10, 10, 50, 20);
        jpfLogin.setBounds(70, 10, 150, 20);  
        jbImprimir.setBounds(10, 100, 210, 20);
        jlCEP.setBounds(10, 40, 50, 20);
        jftCEP.setBounds(70, 40, 150, 20);
        jftTeste.setBounds(70, 70, 150, 20);
        jlTeste.setBounds(10, 70, 50, 20);
        jlOpcoes.setBounds(10, 130, 50, 20);
        jspOpcoes.setBounds(70, 130, 80, 20);
        jspIntervalo.setBounds(170, 130, 50, 20);

        jbImprimir.addActionListener(e -> {
            String senha = new String(jpfLogin.getPassword());
            String cep = new String(jftCEP.getText());
            String teste = jftTeste.getText();
            String opcaoSelecionada = jspOpcoes.getValue().toString();
            int intervalo = (int) jspIntervalo.getValue();
            
            System.out.println("Senha: " + senha);
            System.out.println("CEP: " + cep);
            System.out.println("Teste: " + teste);
            System.out.println("Opção Selecionada: " + opcaoSelecionada);
            System.out.println("Intervalo: " + intervalo);
        });

        painel.add(jlTeste);
        painel.add(jftTeste);
        painel.add(jpfLogin);
        painel.add(jbImprimir);
        painel.add(jlLogin);
        painel.add(jlCEP);
        painel.add(jftCEP);
        painel.add(jlOpcoes);
        painel.add(jspOpcoes);
        painel.add(jspIntervalo);
    }
}
