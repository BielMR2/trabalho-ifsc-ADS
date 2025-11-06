package entities;

import interfaces.Status;

import java.util.UUID;

public class Aprovado implements Status {
    private UUID id;
    private String nome;

    public Aprovado(String nome) {
        this.id = UUID.randomUUID();
        this.nome = nome;
    }


    @Override
    public UUID id() {
        return this.id;
    }

    @Override
    public String nome() {
        return this.nome;
    }
}
