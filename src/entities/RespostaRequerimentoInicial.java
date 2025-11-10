package entities;

import interfaces.Momento;
import interfaces.RespostaRequerimento;
import interfaces.Status;

public class RespostaRequerimentoInicial implements RespostaRequerimento {
    private String descricao;
    private Status status;
    private Momento momento;

    public RespostaRequerimentoInicial() {
        this.momento = new MomentoAtual();

        this.descricao = descricao;
        this.status = new EmAnalise() {
        };
    }

    @Override
    public String descricao() {
        return this.descricao;
    }

    @Override
    public Status status() {
        return this.status;
    }
}
