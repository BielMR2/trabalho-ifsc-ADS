package entities;

import interfaces.Momento;

import java.time.LocalDateTime;

public class MomentoAtual implements Momento {
    private LocalDateTime instante;

    public MomentoAtual(){
        this.instante = LocalDateTime.now();
    }

    @Override
    public LocalDateTime instante() {
        return this.instante;
    }
}
