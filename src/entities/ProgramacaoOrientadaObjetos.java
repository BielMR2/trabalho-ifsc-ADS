package entities;

import interfaces.UnidadeCurricular;

public class ProgramacaoOrientadaObjetos implements UnidadeCurricular {
    private String nome;
    private Integer cargaHoraria;
    private String codigo;

    public ProgramacaoOrientadaObjetos(String nome, Integer cargaHoraria, String codigo) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
    }


    @Override
    public String nome() {
        return this.nome;
    }

    @Override
    public Integer cargaHoraria() {
        return this.cargaHoraria;
    }

    @Override
    public Void codigo() {
        return null;
    }
}
