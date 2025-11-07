package entities;

import interfaces.Coordenacao;
import interfaces.Momento;
import interfaces.RespostaRequerimento;
import interfaces.Status;

import java.time.LocalDateTime;

public class RespostaRequerimentoBasico implements RespostaRequerimento {
    private String descricao;
    private Status status;
    private Momento momento;
    private Coordenacao coordenacao;

    public RespostaRequerimentoBasico(String descricao, Status status, Coordenacao coordenacao) {
        this.momento = new MomentoAtual();

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
}
