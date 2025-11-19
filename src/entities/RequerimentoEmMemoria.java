package entities;


import interfaces.IRequerimentoEmMemoria;
import interfaces.Requerimento;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class RequerimentoEmMemoria implements IRequerimentoEmMemoria {
    private Map<UUID, Requerimento> requerimentos;

    public RequerimentoEmMemoria() {
        this.requerimentos = new HashMap<>();
    }

    @Override
    public void criarRequerimento(Requerimento requerimento) {
        requerimentos.put(requerimento.id(), requerimento);
    }

    @Override
    public void removerRequerimento(Requerimento requerimento) {
        this.requerimentos.remove(requerimento.id());
    }

    @Override
    public List<Requerimento> listarRequerimento() {
        return this.requerimentos.values().stream().toList();
    }
}
