package useCases;

import entities.*;
import interfaces.CasoDeUso;
import interfaces.EmMemoria;
import interfaces.Requerimento;

import java.util.Scanner;

public class CasoDeUsoSolicitarRequerimento implements CasoDeUso {
    private EmMemoria requerimentos;
    private Scanner sc = new Scanner(System.in);

    CasoDeUsoSolicitarRequerimento(EmMemoria requerimentos){
        this.requerimentos = requerimentos;
    }

    @Override
    public void executar() {
        EntradaSaida entradaSaida = new EntradaSaida("Entrada Tardia e Saída Antecipada", "descricao");

        AnaliseDesenvolvimentoSistemas analiseDesenvolvimentoSistemas = new AnaliseDesenvolvimentoSistemas("Analise e Desenvolvimento de Sistemas", 80, "ADS-01");

        CoordenacaoBasico willian = new CoordenacaoBasico("1234567890", "Willian da Silva de Sousa");

        AlunoBasico arthur = new AlunoBasico("202510704000", "Arthur Antoniasse de Oliveira");

        Requerimento requerimento = new RequerimentoBasico("arquivo.txt", "Descricao do requerimento", entradaSaida, arthur);
        requerimento.addUnidadeCurricula(analiseDesenvolvimentoSistemas);

        this.requerimentos.criarRequerimento(requerimento);
    }
}
