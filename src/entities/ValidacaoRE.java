package entities;

import interfaces.TipoRequerimento;

public class ValidacaoRE implements TipoRequerimento {
    private Integer id;
    private String nome;
    private String descricao;
    private Boolean selecionaUC;

    public ValidacaoRE(){
        this.nome = "Validação de Unidade Curricular por Reconhecimento de Estudos";
        this.descricao = "Descrição";
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
