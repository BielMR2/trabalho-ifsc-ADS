package useCases;

import entities.*;
import interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CasoDeUsoAnalisarRequerimento implements CasoDeUso {
    private IRequerimentoEmMemoria requerimentos;
    private Scanner sc = new Scanner(System.in);

    public CasoDeUsoAnalisarRequerimento(IRequerimentoEmMemoria requerimentos){
        this.requerimentos = requerimentos;
    }

    @Override
    public void executar() {

        System.out.println("\n===============================================");
        System.out.println("           ANÁLISE DE REQUERIMENTO            ");
        System.out.println("===============================================\n");

        Status statusSelecionado = pegarStatus();

        List<Aluno> alunos = pegarAlunosComRequerimento(statusSelecionado);

        if(alunos.isEmpty()){
            System.out.println("\n-----------------------------------------------");
            System.out.println("Nenhum aluno com status: " + statusSelecionado.nome());
            System.out.println("-----------------------------------------------\n");

            return;
        }

        System.out.println("\n-----------------------------------------------");
        System.out.println("Alunos com requerimentos no status: " + statusSelecionado.nome());
        System.out.println("-----------------------------------------------\n");

        for (int i = 0; i < alunos.size(); i++) {
            System.out.println(i + " - " + alunos.get(i).nome());
        }

        System.out.print("\nSelecione o aluno: ");
        Aluno alunoSelecionado = alunos.get(sc.nextInt());

        List<Requerimento> requerimentosDoAluno = pegarRequerimentoByAluno(alunoSelecionado, statusSelecionado);

        System.out.println("\n-----------------------------------------------");
        System.out.println("Requerimentos do aluno selecionado:");
        System.out.println("-----------------------------------------------\n");

        for (int i = 0; i < requerimentosDoAluno.size(); i++) {
            Requerimento r = requerimentosDoAluno.get(i);
            System.out.println(i + " - " + r.tipoRequerimento().nome() + " | " + r.descricao());
        }

        System.out.print("\nSelecione o requerimento: ");
        Requerimento requerimentoSelecionado = requerimentosDoAluno.get(sc.nextInt());

        System.out.println("\n-----------------------------------------------");
        System.out.println("Detalhes do requerimento:");
        System.out.println("-----------------------------------------------\n");

        System.out.println("Tipo: " + requerimentoSelecionado.tipoRequerimento().nome());
        System.out.println("Descrição: " + requerimentoSelecionado.descricao());
        System.out.println("Arquivo: " + requerimentoSelecionado.arquivo());

        System.out.println("Unidades Curriculares:");
        for(UnidadeCurricular uc : requerimentoSelecionado.unidadesCurriculares()){
            System.out.println(" - " + uc.nome());
        }

        if (statusSelecionado instanceof EmAnalise){
            System.out.println("\n-----------------------------------------------");
            System.out.println("Responda o Requerimento:");
            System.out.println("-----------------------------------------------\n");

            Status statusDaResposta = pegarStatusDaResposta();
            sc.nextLine();

            System.out.print("Escreva uma descrição da resposta:\n> ");
            String descricaoDaResposta = sc.nextLine();

            CoordenacaoBasico willian = new CoordenacaoBasico("1234567890", "Willian da Silva de Sousa");

            requerimentoSelecionado.responder(descricaoDaResposta, statusDaResposta, willian);

            System.out.println("\n===============================================");
            System.out.println("      ✔ Resposta salva com sucesso! ✔          ");
            System.out.println("===============================================\n");
        }
    }

    private Status pegarStatus(){
        // Lista de Status
        Aprovado aprovado = new Aprovado();
        EmAnalise emAnalise = new EmAnalise();
        Reprovado reprovado = new Reprovado();

        List<Status> statuses = new ArrayList<>();
        statuses.add(aprovado);
        statuses.add(emAnalise);
        statuses.add(reprovado);

        System.out.println("\n-----------------------------------------------");
        System.out.println("Filtre os requerimentos pelo status:");
        System.out.println("-----------------------------------------------\n");

        for (int i = 0; i < statuses.size(); i++) {
            System.out.println(" " + i + " - " + statuses.get(i).nome());
        }

        System.out.print("\nEscolha uma opção: ");
        return statuses.get(sc.nextInt());
    }

    private Status pegarStatusDaResposta(){
        // Lista de Status possíveis para resposta
        Aprovado aprovado = new Aprovado();
        Reprovado reprovado = new Reprovado();

        List<Status> statuses = new ArrayList<>();
        statuses.add(aprovado);
        statuses.add(reprovado);

        System.out.println("-----------------------------------------------");
        System.out.println("Selecione o novo status do requerimento:");
        System.out.println("-----------------------------------------------\n");

        for (int i = 0; i < statuses.size(); i++) {
            System.out.println(" " + i + " - " + statuses.get(i).nome());
        }

        System.out.print("\nEscolha uma opção: ");
        return statuses.get(sc.nextInt());
    }

    public List<Aluno> pegarAlunosComRequerimento(Status statusSelecionado) {
        List<Aluno> alunos = new ArrayList<>();

        for (Requerimento r : requerimentos.listarRequerimento()) {

            if (!r.respostaRequerimento().status().nome().equals(statusSelecionado.nome())) {
                continue;
            }

            Aluno aluno = r.aluno();
            boolean jaExiste = false;

            for (Aluno a : alunos) {
                if (a.matricula().equals(aluno.matricula())) {
                    jaExiste = true;
                    break;
                }
            }

            if (!jaExiste) {
                alunos.add(aluno);
            }
        }

        return alunos;
    }

    public List<Requerimento> pegarRequerimentoByAluno(Aluno aluno, Status status){
        List<Requerimento> requerimentosDoAluno = new ArrayList<>();

        for (Requerimento r : requerimentos.listarRequerimento()){
            if(r.aluno().matricula() == aluno.matricula() && r.respostaRequerimento().status().nome() == status.nome()){
                requerimentosDoAluno.add(r);
            }
        }

        return  requerimentosDoAluno;
    }
}
