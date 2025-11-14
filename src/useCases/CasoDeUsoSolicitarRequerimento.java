package useCases;

import entities.*;
import interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CasoDeUsoSolicitarRequerimento implements CasoDeUso {
    private IRequerimentoEmMemoria requerimentos;
    private Scanner sc = new Scanner(System.in);

    public CasoDeUsoSolicitarRequerimento(IRequerimentoEmMemoria requerimentos){
        this.requerimentos = requerimentos;
    }

    @Override
    public void executar() {

        System.out.println("\n===============================================");
        System.out.println("           SOLICITAÇÃO DE REQUERIMENTO        ");
        System.out.println("===============================================\n");

        TipoRequerimento tipoRequerimentoSelecionado = pegarTipoRequerimento();
        sc.nextLine();

        System.out.println("\n-----------------------------------------------");
        List<UnidadeCurricular> unidadeCurricularSelecionado = pegarUnidadesCurriculares();
        sc.nextLine();

        System.out.println("\n-----------------------------------------------");
        System.out.println("Unidades curriculares selecionadas:");
        for (UnidadeCurricular unidadeCurricular : unidadeCurricularSelecionado){
            System.out.println(" - " + unidadeCurricular.nome());
        }

        System.out.println("\n-----------------------------------------------");
        System.out.print("Envie o arquivo: ");
        String arquivo = sc.nextLine();

        System.out.print("\nEscreva a justificativa:\n> ");
        String justificativa = sc.nextLine();

        AlunoBasico arthur = new AlunoBasico("202510704000", "Arthur Antoniasse de Oliveira");
        Requerimento requerimento = new RequerimentoBasico(arquivo, justificativa, tipoRequerimentoSelecionado, arthur);

        for (UnidadeCurricular unidadeCurricular : unidadeCurricularSelecionado){
            requerimento.addUnidadeCurricula(unidadeCurricular);
        }

        this.requerimentos.criarRequerimento(requerimento);

        System.out.println("\n===============================================");
        System.out.println("      ✔ Requerimento criado com sucesso! ✔     ");
        System.out.println("===============================================\n");
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

        System.out.println("\n-----------------------------------------------");
        System.out.println("Selecione o tipo de requerimento:\n");

        for (int i = 0; i < tipoRequerimentos.size(); i++) {
            System.out.println(" " + i + " - " + tipoRequerimentos.get(i).nome());
        }

        System.out.print("\nEscolha uma opção: ");
        return tipoRequerimentos.get(sc.nextInt());
    }

    public List<UnidadeCurricular> pegarUnidadesCurriculares() {
        // Lista Unidades Curriculares
        AnaliseDesenvolvimentoSistemas ads =
                new AnaliseDesenvolvimentoSistemas("Analise e Desenvolvimento de Sistemas", 80, "ADS-01");
        ProgramacaoOrientadaObjetos poo =
                new ProgramacaoOrientadaObjetos("Programação Orientada a Objetos", 60, "POO-01");

        List<UnidadeCurricular> unidades = new ArrayList<>();
        unidades.add(ads);
        unidades.add(poo);

        List<UnidadeCurricular> selecionadas = new ArrayList<>();

        while (!unidades.isEmpty()) {
            System.out.println("\n-----------------------------------------------");
            System.out.println("Selecione uma unidade curricular:");
            System.out.println("(Digite -1 para finalizar)\n");

            for (int i = 0; i < unidades.size(); i++) {
                System.out.println(" " + i + " - " + unidades.get(i).nome());
            }

            System.out.print("\nEscolha: ");
            int escolha = sc.nextInt();

            if (escolha == -1) {
                break;
            }

            if (escolha >= 0 && escolha < unidades.size()) {
                UnidadeCurricular uc = unidades.get(escolha);
                selecionadas.add(uc);
                unidades.remove(escolha);
                System.out.println("✔ Adicionado: " + uc.nome());
            } else {
                System.out.println("✘ Índice inválido! Tente novamente.");
            }
        }

        return selecionadas;
    }
}
