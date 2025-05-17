package revisao;
import java.util.ArrayList;
/**
 *
 * @author Cris
 */
public class Agenda implements InterfaceAgenda {
    private ArrayList<Consulta> agendaMedica;
    
    public Agenda(){
        agendaMedica = new ArrayList<>();
    }
    @Override
    public void cadastrarAgenda(Consulta consulta) {
        agendaMedica.add(consulta);
    }

    @Override
    public void editarConsulta(int codigo, Consulta consulta) {
        agendaMedica.set(codigo, consulta);
    }

    @Override
    public void imprimirTodos() {
        for(Consulta c: agendaMedica){
            System.out.println("Paciente: "+ c.getPaciente().getNome());
            System.out.println("Especialista: "+ c.getEspecialista().getNome());
            System.out.println("Horario: "+ c.getHorario());
        }
    }

    @Override
    public void imprimirConsulta(int codigo) {
        for (Consulta c : agendaMedica) {
            if (c.getCodigo() == codigo) {
                System.out.println("Paciente: "+ c.getPaciente().getNome());
                System.out.println("Especialista: "+ c.getEspecialista().getNome());
                System.out.println("Horário: "+ c.getHorario());
                return;
            }
        }
        System.out.println("Consulta com código " + codigo + " não encontrada.");
    }

    public ArrayList<Consulta> getAgendaMedica() {
        return agendaMedica;
    }

    public void setAgendaMedica(ArrayList<Consulta> agendaMedica) {
        this.agendaMedica = agendaMedica;
    }
    
}
