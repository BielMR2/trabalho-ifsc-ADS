package entities;

import interfaces.TipoRequerimento;

public class EntradaSaida implements TipoRequerimento {
    private Integer id;
    private String nome;
    private String descricao;

    public EntradaSaida(){
        this.nome = "Entrada Tardia e Saída Antecipada";
        this.descricao = "Descrição 1";
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
