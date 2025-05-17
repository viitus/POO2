package revisao;

/**
 *
 * @author Cris
 */
public class Paciente extends Pessoa{
    private Data dataNascimento;
    private String planoSaude,sexo;
    
    public Paciente(){
        dataNascimento = new Data();
        planoSaude = "";
        sexo = "";
    }

    public Paciente(Data dataNascimento, String planoSaude) {
        this.dataNascimento = dataNascimento;
        this.planoSaude = planoSaude;
        sexo = "";
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(String planoSaude) {
        this.planoSaude = planoSaude;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
}
