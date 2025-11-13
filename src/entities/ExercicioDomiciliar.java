package entities;

import interfaces.TipoRequerimento;

public class ExercicioDomiciliar implements TipoRequerimento {
    private Integer id;
    private String nome;
    private String descricao;

    public ExercicioDomiciliar(){
        this.nome = "Exercício Domiciliar";
        this.descricao = "Descricao";
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
