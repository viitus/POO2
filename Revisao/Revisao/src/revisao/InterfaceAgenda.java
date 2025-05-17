package revisao;

/**
 *
 * @author Cris
 */
public interface InterfaceAgenda {
    public void cadastrarAgenda(Consulta consulta);
    public void editarConsulta(int codigo, Consulta consulta);
    public void imprimirTodos();
    public void imprimirConsulta(int codigo);
}
