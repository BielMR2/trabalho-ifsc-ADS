package entities;


import interfaces.EmMemoria;
import interfaces.Requerimento;
import interfaces.TipoRequerimento;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class RequerimentoEmMemoria implements EmMemoria {
    private Map<UUID, Requerimento> requerimentos;

    @Override
    public void criarRequerimento(Requerimento requerimento) {
        requerimentos.put(requerimento.id(), requerimento);
    }

    @Override
    public List<Requerimento> listarRequerimento() {
        return this.requerimentos.values().stream().toList();
    }
}
