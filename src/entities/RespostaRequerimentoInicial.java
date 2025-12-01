package entities;

import interfaces.Momento;
import interfaces.RespostaRequerimento;
import interfaces.Status;

public class RespostaRequerimentoInicial implements RespostaRequerimento {
    private Status status;
    private Momento momentoResposta;

    public RespostaRequerimentoInicial() {
        this.momentoResposta = new MomentoAtual();

        this.status = new EmAnalise() {
        };
    }

    @Override
    public String descricao() {
        return null;
    }

    @Override
    public Status status() {
        return this.status;
    }

    @Override
    public Momento momentoResposta() { return this.momentoResposta; }
}
