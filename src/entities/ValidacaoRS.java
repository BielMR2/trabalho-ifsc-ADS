package entities;

import interfaces.TipoRequerimento;

public class ValidacaoRS implements TipoRequerimento {
    private Integer id;
    private String nome;
    private String descricao;

    public ValidacaoRS(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
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
}
