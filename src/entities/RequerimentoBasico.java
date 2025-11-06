package entities;

import interfaces.*;

import java.time.LocalDateTime;
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
    private LocalDateTime localDateTime;
    private List<UnidadeCurricular> unidadesCurriculares;

    public RequerimentoBasico(String arquivo, String descricao, TipoRequerimento tipoRequerimento, Aluno aluno, Coordenacao coordenacao) {
        this.localDateTime = LocalDateTime.now();
        this.respostaRequerimento = new RespostaRequerimentoBasico("", new EmAnalise("Em analise"), coordenacao);
        this.id = UUID.randomUUID();

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
    public void responder(String descricao, Status status, Coordenacao coordenacao) {
        this.respostaRequerimento = new RespostaRequerimentoBasico(descricao, status, coordenacao);
    }

    @Override
    public void addUnidadeCurricula(UnidadeCurricular unidadeCurricular) {
        this.unidadesCurriculares.add(unidadeCurricular);
    }
}
