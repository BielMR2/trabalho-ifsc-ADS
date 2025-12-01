package entities;

import interfaces.Momento;
import interfaces.TipoRequerimento;

import java.time.LocalDateTime;

public class EntradaSaida implements TipoRequerimento {
    private Integer id;
    private String nome;
    private String descricao;
    private Boolean selecionaUC;
    private Momento prazo;

    public EntradaSaida(){
        this.nome = "Entrada Tardia e Saída Antecipada";
        this.descricao = "Descrição 1";
        this.selecionaUC = true;
        this.prazo = new MomentoFinal(LocalDateTime.of(2025, 12 , 30, 23, 59));
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

    @Override
    public Momento prazo() { return this.prazo; }
}
