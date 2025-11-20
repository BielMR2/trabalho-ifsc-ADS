package useCases;

import entities.*;
import interfaces.*;
import utils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CasoDeUsoSolicitarRequerimento implements CasoDeUso {
    private RepositorioRequerimento requerimentos;
    private Scanner sc = new Scanner(System.in);
    private Console console = new Console();

    public CasoDeUsoSolicitarRequerimento(RepositorioRequerimento requerimentos){
        this.requerimentos = requerimentos;
    }

    @Override
    public void executar() {

        console.titulo("SOLICITAÇÃO DE REQUERIMENTO");

        TipoRequerimento tipoRequerimentoSelecionado = pegarTipoRequerimento();
        sc.nextLine();

        console.bloco("Selecione as unidades curriculares:");
        List<UnidadeCurricular> unidadeCurricularSelecionado = pegarUnidadesCurriculares();
        sc.nextLine();

        console.bloco("Unidades curriculares selecionadas:");
        for (UnidadeCurricular unidadeCurricular : unidadeCurricularSelecionado) {
            console.msg(" - " + unidadeCurricular.nome());
        }

        console.bloco("Envio de arquivo");
        System.out.print("Arquivo: ");
        String arquivo = sc.nextLine();

        System.out.print("\nEscreva a justificativa:\n> ");
        String justificativa = sc.nextLine();

        AlunoBasico arthur = new AlunoBasico("202510704000", "Arthur Antoniasse de Oliveira");
        Requerimento requerimento =
                new RequerimentoEmAnalise(arquivo, justificativa, tipoRequerimentoSelecionado, arthur);

        for (UnidadeCurricular unidade : unidadeCurricularSelecionado){
            requerimento.addUnidadeCurricular(unidade);
        }

        this.requerimentos.criarRequerimento(requerimento);

        console.titulo("✔ Requerimento criado com sucesso! ✔");
    }

    // ============================================================
    // Selecionar tipo de requerimento
    // ============================================================
    private TipoRequerimento pegarTipoRequerimento(){
        List<TipoRequerimento> tipoRequerimentos = List.of(
                new EntradaSaida(),
                new JustificativaAusencia(),
                new ExercicioDomiciliar(),
                new ValidacaoRE(),
                new ValidacaoRS()
        );

        console.bloco("Selecione o tipo de requerimento:");

        for (int i = 0; i < tipoRequerimentos.size(); i++) {
            console.msg(" " + i + " - " + tipoRequerimentos.get(i).nome());
        }

        System.out.print("\nEscolha uma opção: ");
        return tipoRequerimentos.get(sc.nextInt());
    }

    public List<UnidadeCurricular> pegarUnidadesCurriculares() {

        List<UnidadeCurricular> unidades = new ArrayList<>(List.of(
                new AnaliseDesenvolvimentoSistemas(
                        "Analise e Desenvolvimento de Sistemas", 80, "ADS-01"),
                new ProgramacaoOrientadaObjetos(
                        "Programação Orientada a Objetos", 60, "POO-01")
        ));

        List<UnidadeCurricular> selecionadas = new ArrayList<>();

        while (!unidades.isEmpty()) {

            console.bloco("Selecione uma unidade curricular (ou -1 para finalizar):");

            for (int i = 0; i < unidades.size(); i++) {
                console.msg(" " + i + " - " + unidades.get(i).nome());
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
                console.msg("✔ Adicionado: " + uc.nome());
            } else {
                console.msg("✘ Índice inválido! Tente novamente.");
            }
        }

        return selecionadas;
    }
}
