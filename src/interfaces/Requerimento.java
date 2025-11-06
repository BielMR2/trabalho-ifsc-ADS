package interfaces;

import java.util.UUID;

public interface Requerimento {
    UUID id();
    String arquivo();
    String descricao();
    Aluno aluno();
    RespostaRequerimento respostaRequerimento();
    void responder(String descricao, Status status, Coordenacao coordenacao);
    void addUnidadeCurricula(UnidadeCurricular unidadeCurricular);
}
