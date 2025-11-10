package entities;

import interfaces.Status;

import java.util.UUID;

public class EmAnalise implements Status {
    private UUID id;
    private String nome;

    public EmAnalise() {
        this.id = UUID.randomUUID();
        this.nome = "Em Análise";
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
