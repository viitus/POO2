package revisao;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        Agenda clinica = new Agenda();
        int opcao;

        String[] opcoes = {"Cadastrar Consulta", "Editar Consulta", "Imprimir Consulta", "Imprimir Todas", "Sair"};

        do {
            opcao = exibirMenu(opcoes);

            switch (opcao) {
                case 0:
                    cadastrarConsulta(clinica);
                    break;
                case 1:
                    editarConsulta(clinica);
                    break;
                case 2:
                    imprimirConsulta(clinica);
                    break;
                case 3:
                    imprimirTodasAsConsultas(clinica);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (opcao != 4);
    }

    private static int exibirMenu(String[] opcoes) {
        return JOptionPane.showOptionDialog(
                null,
                "Escolha uma opção",
                "Menu Principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );
    }

    private static void cadastrarConsulta(Agenda clinica) {
        Consulta nova = new Consulta();

        nova.setCodigo(Integer.parseInt(JOptionPane.showInputDialog(null, "Código da consulta:", "Consulta", JOptionPane.QUESTION_MESSAGE)));
        nova.setData(obterData());
        nova.setPaciente(obterPaciente());
        nova.setEspecialista(obterProfissional());
        nova.setHorario(JOptionPane.showInputDialog(null, "Horário (ex: 14:00):", "Consulta", JOptionPane.QUESTION_MESSAGE));
        nova.setDescricaoSintoma(JOptionPane.showInputDialog(null, "Descrição dos sintomas:", "Consulta", JOptionPane.QUESTION_MESSAGE));
        nova.setPrescricao(JOptionPane.showInputDialog(null, "Prescrição médica:", "Consulta", JOptionPane.QUESTION_MESSAGE));

        clinica.cadastrarAgenda(nova);
        JOptionPane.showMessageDialog(null, "Consulta cadastrada com sucesso!");
    }

    private static void editarConsulta(Agenda clinica) {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Código da consulta a editar:", "Editar Consulta", JOptionPane.QUESTION_MESSAGE));
        Consulta nova = new Consulta();
        nova.setCodigo(codigo);

        nova.setData(obterData());
        nova.setPaciente(obterPaciente());
        nova.setEspecialista(obterProfissional());
        nova.setHorario(JOptionPane.showInputDialog(null, "Horário:", "Consulta", JOptionPane.QUESTION_MESSAGE));
        nova.setDescricaoSintoma(JOptionPane.showInputDialog(null, "Novo sintoma:", "Consulta", JOptionPane.QUESTION_MESSAGE));
        nova.setPrescricao(JOptionPane.showInputDialog(null, "Nova prescrição:", "Consulta", JOptionPane.QUESTION_MESSAGE));

        clinica.editarConsulta(codigo, nova);
        JOptionPane.showMessageDialog(null, "Consulta editada com sucesso!");
    }

    private static void imprimirConsulta(Agenda clinica) {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Código da consulta:", "Imprimir Consulta", JOptionPane.QUESTION_MESSAGE));
        clinica.imprimirConsulta(codigo);
    }

    private static void imprimirTodasAsConsultas(Agenda clinica) {
        clinica.imprimirTodos();
    }

    private static Data obterData() {
        Data data = new Data();
        data.setDia(Integer.parseInt(JOptionPane.showInputDialog(null, "Dia:", "Data", JOptionPane.QUESTION_MESSAGE)));
        data.setMes(JOptionPane.showInputDialog(null, "Mês:", "Data", JOptionPane.QUESTION_MESSAGE));
        data.setAno(Integer.parseInt(JOptionPane.showInputDialog(null, "Ano:", "Data", JOptionPane.QUESTION_MESSAGE)));
        return data;
    }

    private static Paciente obterPaciente() {
        Paciente paciente = new Paciente();
        paciente.setNome(JOptionPane.showInputDialog(null, "Nome:", "Paciente", JOptionPane.QUESTION_MESSAGE));
        paciente.setCpf(Integer.parseInt(JOptionPane.showInputDialog(null, "CPF (somente números):", "Paciente", JOptionPane.QUESTION_MESSAGE)));
        paciente.setPlanoSaude(JOptionPane.showInputDialog(null, "Plano de Saúde:", "Paciente", JOptionPane.QUESTION_MESSAGE));
        paciente.setSexo(JOptionPane.showInputDialog(null, "Sexo:", "Paciente", JOptionPane.QUESTION_MESSAGE));
        return paciente;
    }

    private static Profissional obterProfissional() {
        Profissional prof = new Profissional();
        prof.setNome(JOptionPane.showInputDialog(null, "Nome:", "Profissional", JOptionPane.QUESTION_MESSAGE));
        prof.setCpf(Integer.parseInt(JOptionPane.showInputDialog(null, "CPF (somente números):", "Profissional", JOptionPane.QUESTION_MESSAGE)));
        prof.setEspecialidade(JOptionPane.showInputDialog(null, "Especialidade:", "Profissional", JOptionPane.QUESTION_MESSAGE));
        prof.setTitulacao(JOptionPane.showInputDialog(null, "Titulação:", "Profissional", JOptionPane.QUESTION_MESSAGE));
        prof.setSalario(Float.parseFloat(JOptionPane.showInputDialog(null, "Salário:", "Profissional", JOptionPane.QUESTION_MESSAGE)));
        return prof;
    }
}
