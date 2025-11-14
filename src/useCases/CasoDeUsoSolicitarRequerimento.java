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
        TipoRequerimento tipoRequerimentoSelecionado = pegarTipoRequerimento();
        sc.nextLine();

        List<UnidadeCurricular> unidadeCurricularSelecionado = pegarUnidadesCurriculares();
        sc.nextLine();

        System.out.println("Unidades curriculares selecionada");
        for (UnidadeCurricular unidadeCurricular : unidadeCurricularSelecionado){
            System.out.println(unidadeCurricular.nome());
        }

        System.out.println("Envie o arquivo:");
        String arquivo = sc.nextLine();

        System.out.println("Escreva a justificativa:");
        String justificativa = sc.nextLine();

        AlunoBasico arthur = new AlunoBasico("202510704000", "Arthur Antoniasse de Oliveira");
        Requerimento requerimento = new RequerimentoBasico(arquivo, justificativa, tipoRequerimentoSelecionado, arthur);

        for (UnidadeCurricular unidadeCurricular : unidadeCurricularSelecionado){
            requerimento.addUnidadeCurricula(unidadeCurricular);
        }

        this.requerimentos.criarRequerimento(requerimento);

        System.out.println("Requerimento criado com sucesso !!!");
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
                unidades.remove(escolha);
                System.out.println("Adicionado: " + uc.nome());
            } else {
                System.out.println("Índice inválido! Tente novamente.");
            }
        }

        return selecionadas;
    }
}
