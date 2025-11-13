package entities;

import interfaces.Status;

import java.util.UUID;

public class Reprovado implements Status {
    private UUID id;
    private String nome;

    public Reprovado() {
        this.id = UUID.randomUUID();
        this.nome = "Reprovado";
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
