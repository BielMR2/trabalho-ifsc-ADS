package entities;

import interfaces.TipoRequerimento;

public class JustificativaAusencia implements TipoRequerimento {
    private Integer id;
    private String nome;
    private String descricao;

    public JustificativaAusencia(){
        this.nome = "Justificativa de Ausência";
        this.descricao = "Descrição";
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
