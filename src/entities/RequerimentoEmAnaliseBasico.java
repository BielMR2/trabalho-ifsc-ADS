package entities;

import interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RequerimentoEmAnaliseBasico implements RequerimentoEmAnalise {
    private UUID id;
    private String arquivo;
    private String descricao;
    private TipoRequerimento tipoRequerimento;
    private Aluno aluno;
    private RespostaRequerimento respostaRequerimento;
    private List<UnidadeCurricular> unidadesCurriculares;
    private Momento momentoCriacao;

    public RequerimentoEmAnaliseBasico(String arquivo, String descricao, TipoRequerimento tipoRequerimento, Aluno aluno) {
        this.respostaRequerimento = new RespostaRequerimentoInicial();
        this.id = UUID.randomUUID();
        this.arquivo = arquivo;
        this.descricao = descricao;
        this.tipoRequerimento = tipoRequerimento;
        this.aluno = aluno;
        this.unidadesCurriculares = new ArrayList<>();
        this.momentoCriacao = new MomentoAtual();
    }

    @Override
    public UUID id() {
        return this.id;
    }

    @Override
    public String arquivo() {
        return this.arquivo;
    }

    @Override
    public String descricao() {
        return this.descricao;
    }

    @Override
    public Aluno aluno() {
        return this.aluno;
    }

    @Override
    public RespostaRequerimento respostaRequerimento() {
        return this.respostaRequerimento;
    }

    @Override
    public TipoRequerimento tipoRequerimento() {
        return this.tipoRequerimento;
    }

    @Override
    public List<UnidadeCurricular> unidadesCurriculares() {
        return this.unidadesCurriculares;
    }

    @Override
    public Momento momento() { return this.momentoCriacao; }

    @Override
    public void addUnidadeCurricular(UnidadeCurricular unidadeCurricular) {
        this.unidadesCurriculares.add(unidadeCurricular);
    }

    @Override
    public RequerimentoRespondido aprovar(String descricao, Coordenacao coordenacao) {
        return new RequerimentoDeferido(this, descricao, coordenacao);
    }

    @Override
    public RequerimentoRespondido reprovar(String descricao, Coordenacao coordenacao) {
        return new RequerimentoIndeferido(this, descricao, coordenacao);
    }
}
