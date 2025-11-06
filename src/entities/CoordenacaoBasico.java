package entities;

import interfaces.Coordenacao;

public class CoordenacaoBasico implements Coordenacao {
    private String codigo;
    private String nome;

    public CoordenacaoBasico(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }


    @Override
    public String codigo() {
        return this.codigo;
    }

    @Override
    public String nome() {
        return "";
    }
}
