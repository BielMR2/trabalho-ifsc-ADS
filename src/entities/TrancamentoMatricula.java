package entities;

import interfaces.TipoRequerimento;

public class TrancamentoMatricula implements TipoRequerimento {
    private Integer id;
    private String nome;
    private String descricao;
    private Boolean selecionaUC;

    public TrancamentoMatricula(){
        this.nome = "Trancamento de Matrícula";
        this.descricao = "Descrição 1";
        this.selecionaUC = false;
    }

    @Override
    public Integer id() {
        return this.id;
    }

    @Override
    public String nome() {
        return this.nome;
    }

    @Override
    public String descricao() {
        return this.descricao;
    }

    @Override
    public Boolean selecionaUC() { return this.selecionaUC; }
}
