package interfaces;

import java.util.List;
import java.util.UUID;

public interface Requerimento {
    UUID id();
    String arquivo();
    String descricao();
    Aluno aluno();
    RespostaRequerimento respostaRequerimento() throws Exception;
    TipoRequerimento tipoRequerimento();
    List<UnidadeCurricular> unidadesCurriculares();
    Requerimento aprovar(String descricao, Coordenacao coordenacao) throws Exception;
    Requerimento reprovar(String descricao, Coordenacao coordenacao) throws Exception;
    void addUnidadeCurricular(UnidadeCurricular unidadeCurricular);
}
