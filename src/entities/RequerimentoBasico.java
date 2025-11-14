package entities;

import interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RequerimentoBasico implements Requerimento {
    private UUID id;
    private String arquivo;
    private String descricao;
    private TipoRequerimento tipoRequerimento;
    private Aluno aluno;
    private RespostaRequerimento respostaRequerimento;
    private Momento momento;
    private List<UnidadeCurricular> unidadesCurriculares;

    public RequerimentoBasico(String arquivo, String descricao, TipoRequerimento tipoRequerimento, Aluno aluno) {
        this.respostaRequerimento = new RespostaRequerimentoInicial();
        this.id = UUID.randomUUID();
        this.momento = new MomentoAtual();

        this.arquivo = arquivo;
        this.descricao = descricao;
        this.tipoRequerimento = tipoRequerimento;
        this.aluno = aluno;
        this.unidadesCurriculares = new ArrayList<>();
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
    public void responder(String descricao, Status status, Coordenacao coordenacao) {
        this.respostaRequerimento = new RespostaRequerimentoCompleta(descricao, status, coordenacao);
    }

    @Override
    public void addUnidadeCurricula(UnidadeCurricular unidadeCurricular) {
        this.unidadesCurriculares.add(unidadeCurricular);
    }
}
