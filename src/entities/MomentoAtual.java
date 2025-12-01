package entities;

import interfaces.Momento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MomentoAtual implements Momento {
    private LocalDateTime instante;

    public MomentoAtual(){
        this.instante = LocalDateTime.now();
    }

    @Override
    public LocalDateTime instante() {
        return this.instante;
    }

    public String instanteFormatado() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
        return this.instante.format(formatter);
    }
}
