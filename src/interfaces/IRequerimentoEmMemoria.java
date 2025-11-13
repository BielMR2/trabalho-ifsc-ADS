package interfaces;

import java.util.List;

public interface IRequerimentoEmMemoria {
    void criarRequerimento(Requerimento requerimento);
    List<Requerimento> listarRequerimento();
}
