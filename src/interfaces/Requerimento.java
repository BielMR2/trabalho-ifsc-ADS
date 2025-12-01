package interfaces;

import java.util.List;
import java.util.UUID;

public interface Requerimento {
    UUID id();
    String arquivo();
    String descricao();
    Aluno aluno();
    RespostaRequerimento respostaRequerimento();
    TipoRequerimento tipoRequerimento();
    List<UnidadeCurricular> unidadesCurriculares();
    Momento momento();
}
