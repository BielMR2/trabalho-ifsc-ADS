package entities;

import interfaces.TipoRequerimento;

public class ExercicioDomiciliar implements TipoRequerimento {
    private Integer id;
    private String nome;
    private String descricao;
    private Boolean selecionaUC;

    public ExercicioDomiciliar(){
        this.nome = "Exercício Domiciliar";
        this.descricao = "Descricao";
        this.selecionaUC = true;
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
