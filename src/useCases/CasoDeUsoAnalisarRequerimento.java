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
        Status statusSelecionado = pegarStatus();

        List<Aluno> alunos = pegarAlunosComRequerimento(statusSelecionado);

        System.out.println("Selecione o aluno:");

        for (int i = 0; i < alunos.size(); i++) {
            System.out.println(i + " " + alunos.get(i).nome());
        }

        Aluno alunoSelecionado = alunos.get(sc.nextInt());

        List<Requerimento> requerimentosDoAluno = pegarRequerimentoByAluno(alunoSelecionado);

        System.out.println("Selecione o requerimento:");

        for (int i = 0; i < requerimentosDoAluno.size(); i++) {
            Requerimento requerimento = requerimentosDoAluno.get(i);
            System.out.println(i + " ");
        }

        Requerimento requerimentoSelecionado = requerimentosDoAluno.get(sc.nextInt());

        sc.nextLine();



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

        System.out.println("Filtre os requerimentos pelo status:");

        for (int i = 0; i < statuses.size(); i++) {
            System.out.println(i + " " + statuses.get(i).nome());
        }

        return statuses.get(sc.nextInt());
    }

    private TipoRequerimento pegarTipoRequerimento(){
        // Lista de Tipos de Requerimento
        EntradaSaida entradaSaida = new EntradaSaida();
        JustificativaAusencia justificativaAusencia = new JustificativaAusencia();
        ExercicioDomiciliar exercicioDomiciliar = new ExercicioDomiciliar();
        ValidacaoRE validacaoEA = new ValidacaoRE();
        ValidacaoRS validacaoRS = new ValidacaoRS();


        List<TipoRequerimento> tipoRequerimentos = new ArrayList<>();
        tipoRequerimentos.add(entradaSaida);
        tipoRequerimentos.add(justificativaAusencia);
        tipoRequerimentos.add(exercicioDomiciliar);
        tipoRequerimentos.add(validacaoEA);
        tipoRequerimentos.add(validacaoRS);

        System.out.println("Selecione a tipo de requerimento:");

        for (int i = 0; i < tipoRequerimentos.size(); i++) {
            System.out.println(i + " " + tipoRequerimentos.get(i).nome());
        }

        return tipoRequerimentos.get(sc.nextInt());
    }

    public List<UnidadeCurricular> pegarUnidadesCurriculares(Status statusSelecionado) {
        // Lista Unidades Curriculares
        AnaliseDesenvolvimentoSistemas ads =
                new AnaliseDesenvolvimentoSistemas("Analise e Desenvolvimento de Sistemas", 80, "ADS-01");
        ProgramacaoOrientadaObjetos poo =
                new ProgramacaoOrientadaObjetos("Programação Orientada a Objetos", 60, "POO-01");

        List<UnidadeCurricular> unidades = new ArrayList<>();
        unidades.add(ads);
        unidades.add(poo);

        List<UnidadeCurricular> selecionadas = new ArrayList<>();

        while (true) {
            System.out.println("\nSelecione uma unidade curricular (digite o número):");
            System.out.println("Digite -1 para finalizar.");

            for (int i = 0; i < unidades.size(); i++) {
                System.out.println(i + " - " + unidades.get(i).nome());
            }

            System.out.print("Escolha: ");
            int escolha = sc.nextInt();

            if (escolha == -1) {
                break;
            }

            if (escolha >= 0 && escolha < unidades.size()) {
                UnidadeCurricular uc = unidades.get(escolha);
                selecionadas.add(uc);
                System.out.println("Adicionado: " + uc.nome());
            } else {
                System.out.println("Índice inválido! Tente novamente.");
            }
        }

        return selecionadas;
    }

    public List<Aluno> pegarAlunosComRequerimento(Status statusSelecionado) {
        List<Aluno> alunos = new ArrayList<>();

        for (Requerimento r : requerimentos.listarRequerimento()) {
            if(r.respostaRequerimento().status().nome() != statusSelecionado.nome()){
                continue;
            }

            Aluno aluno = r.aluno();

            if (!alunos.contains(aluno)) {
                alunos.add(aluno);
            }
        }
        return alunos;
    }

    public List<Requerimento> pegarRequerimentoByAluno(Aluno aluno){
        List<Requerimento> requerimentosDoAluno = new ArrayList<>();

        for (Requerimento r : requerimentos.listarRequerimento()){
            if(r.aluno() == aluno){
                requerimentosDoAluno.add(r);
            }
        }

        return  requerimentosDoAluno;
    }
}
