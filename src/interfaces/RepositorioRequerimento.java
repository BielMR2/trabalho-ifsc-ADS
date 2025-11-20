package interfaces;

import java.util.List;

public interface RepositorioRequerimento {
    void criarRequerimento(Requerimento requerimento);
    void removerRequerimento(Requerimento requerimento);
    List<Requerimento> listarRequerimento();
}
