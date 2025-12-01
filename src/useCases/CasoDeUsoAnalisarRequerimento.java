package useCases;

import entities.*;
import interfaces.*;
import utils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CasoDeUsoAnalisarRequerimento implements CasoDeUso {
    private RepositorioRequerimento requerimentos;
    private Scanner sc = new Scanner(System.in);
    private Console console = new Console();

    public CasoDeUsoAnalisarRequerimento(RepositorioRequerimento requerimentos){
        this.requerimentos = requerimentos;
    }


    @Override
    public void executar() throws Exception {
        console.titulo("ANÁLISE DE REQUERIMENTO");

        Status statusSelecionado = pegarStatus();
        List<Aluno> alunos = pegarAlunosComRequerimento(statusSelecionado);

        if (alunos.isEmpty()) {
            console.bloco("Nenhum aluno com status: " + statusSelecionado.nome());
            return;
        }

        console.bloco("Alunos com requerimentos no status: " + statusSelecionado.nome());

        for (int i = 0; i < alunos.size(); i++) {
            console.msg(i + " - " + alunos.get(i).nome());
        }

        System.out.print("\nSelecione o aluno: ");
        Aluno alunoSelecionado = alunos.get(sc.nextInt());

        List<Requerimento> requerimentosDoAluno =
                pegarRequerimentoByAluno(alunoSelecionado, statusSelecionado);

        console.bloco("Requerimentos do aluno selecionado:");

        for (int i = 0; i < requerimentosDoAluno.size(); i++) {
            Requerimento r = requerimentosDoAluno.get(i);
            console.msg(i + " - " + r.tipoRequerimento().nome() + " | " + r.descricao() + " | " + r.momento().instanteFormatado());
        }

        System.out.print("\nSelecione o requerimento: ");
        Requerimento requerimentoSelecionado = requerimentosDoAluno.get(sc.nextInt());

        console.bloco("Detalhes do requerimento:");

        console.msg("Tipo: " + requerimentoSelecionado.tipoRequerimento().nome());
        console.msg("Descrição: " + requerimentoSelecionado.descricao());
        console.msg("Arquivo: " + requerimentoSelecionado.arquivo());
        if(!requerimentoSelecionado.unidadesCurriculares().isEmpty()){
            console.msg("Unidades Curriculares:");
            for (UnidadeCurricular uc : requerimentoSelecionado.unidadesCurriculares()) {
                console.msg(" - " + uc.nome());
            }
        }
        console.msg("Data criação: " + requerimentoSelecionado.momento().instanteFormatado());
        if(requerimentoSelecionado instanceof RequerimentoRespondido){
            console.msg("Data resposta: " + requerimentoSelecionado.respostaRequerimento().momentoResposta().instanteFormatado());
        }

        if (requerimentoSelecionado instanceof RequerimentoEmAnalise reqEmAnaliseSelecionado) {
            console.bloco("Responda o Requerimento:");
            console.msg("Escolha uma opção:");
            console.msg("1 - Aprovado");
            console.msg("2 - Reprovado");

            int opcao = sc.nextInt();
            sc.nextLine();

            System.out.print("Escreva uma descrição da resposta:\n> ");
            String descricaoDaResposta = sc.nextLine();

            CoordenacaoBasico willian =
                    new CoordenacaoBasico("1234567890", "Willian da Silva de Sousa");

            if (opcao == 1) {
                requerimentos.criarRequerimento(
                        reqEmAnaliseSelecionado.aprovar(descricaoDaResposta, willian)
                );
            } else if (opcao == 2) {
                requerimentos.criarRequerimento(
                        reqEmAnaliseSelecionado.reprovar(descricaoDaResposta, willian)
                );
            }

            console.titulo("✔ Resposta salva com sucesso! ✔");
        }
    }

    private Status pegarStatus() {
        List<Status> statuses = List.of(
                new Aprovado(),
                new EmAnalise(),
                new Reprovado()
        );

        console.bloco("Filtre os requerimentos pelo status:");

        for (int i = 0; i < statuses.size(); i++) {
            console.msg(" " + i + " - " + statuses.get(i).nome());
        }

        System.out.print("\nEscolha uma opção: ");
        return statuses.get(sc.nextInt());
    }

    public List<Aluno> pegarAlunosComRequerimento(Status statusSelecionado) throws Exception {
        List<Aluno> alunos = new ArrayList<>();

        for (Requerimento r : requerimentos.listarRequerimento()) {

            if (!r.respostaRequerimento().status().nome().equals(statusSelecionado.nome())) {
                continue;
            }

            Aluno aluno = r.aluno();
            boolean alunoJaExiste = alunos.stream()
                    .anyMatch(a -> a.matricula().equals(aluno.matricula()));

            if (!alunoJaExiste) {
                alunos.add(aluno);
            }
        }

        return alunos;
    }

    public List<Requerimento> pegarRequerimentoByAluno(Aluno aluno, Status status) throws Exception {
        List<Requerimento> lista = new ArrayList<>();

        for (Requerimento r : requerimentos.listarRequerimento()) {
            if (r.aluno().matricula().equals(aluno.matricula()) &&
                    r.respostaRequerimento().status().nome().equals(status.nome())) {

                lista.add(r);
            }
        }

        return lista;
    }
}
