package entities;

import interfaces.Coordenacao;
import interfaces.Momento;
import interfaces.RespostaRequerimento;
import interfaces.Status;

public class RespostaRequerimentoCompleta implements RespostaRequerimento {
    private String descricao;
    private Status status;
    private Momento momentoResposta;
    private Coordenacao coordenacao;

    public RespostaRequerimentoCompleta(String descricao, Status status, Coordenacao coordenacao) {
        this.momentoResposta = new MomentoAtual();

        this.descricao = descricao;
        this.status = status;
        this.coordenacao = coordenacao;
    }

    @Override
    public String descricao() {
        return this.descricao;
    }

    @Override
    public Status status() {
        return this.status;
    }

    @Override
    public Momento momentoResposta() { return this.momentoResposta; }
}
