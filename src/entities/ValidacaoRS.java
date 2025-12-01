package entities;

import interfaces.Momento;
import interfaces.TipoRequerimento;

import java.time.LocalDateTime;

public class ValidacaoRS implements TipoRequerimento {
    private Integer id;
    private String nome;
    private String descricao;
    private Boolean selecionaUC;
    private Momento prazo;

    public ValidacaoRS(){
        this.nome = "Validação de Unidade Curricular por Reconhecimento de Saberes";
        this.descricao = "Descrição";
        this.selecionaUC = true;
        this.prazo = new MomentoFinal(LocalDateTime.of(2025, 3 , 23, 23, 59));
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
