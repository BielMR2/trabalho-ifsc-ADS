package entities;

import interfaces.Aluno;

import java.math.BigInteger;

public class AlunoBasico implements Aluno {
    private String matricula;
    private String nome;

    public AlunoBasico(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    @Override
    public String matricula() {
        return this.matricula;
    }

    @Override
    public String nome() {
        return this.nome;
    }
}
