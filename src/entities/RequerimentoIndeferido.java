package entities;

import interfaces.*;

import java.util.List;
import java.util.UUID;

public class RequerimentoIndeferido implements RequerimentoRespondido {
    private Requerimento requerimento;
    private RespostaRequerimento respostaRequerimento;

    public RequerimentoIndeferido(Requerimento requerimento, String descricao, Coordenacao coordenacao) {
        this.requerimento = requerimento;

        this.respostaRequerimento = new RespostaRequerimentoCompleta(descricao, new Reprovado(), coordenacao);
    }

    @Override
    public UUID id() {
        return this.requerimento.id();
    }

    @Override
    public String arquivo() {
        return this.requerimento.arquivo();
    }

    @Override
    public String descricao() {
        return this.requerimento.descricao();
    }

    @Override
    public Aluno aluno() {
        return this.requerimento.aluno();
    }

    @Override
    public RespostaRequerimento respostaRequerimento() {
        return this.respostaRequerimento;
    }

    @Override
    public TipoRequerimento tipoRequerimento() {
        return this.requerimento.tipoRequerimento();
    }

    @Override
    public List<UnidadeCurricular> unidadesCurriculares() {
        return this.requerimento.unidadesCurriculares();
    }
}
