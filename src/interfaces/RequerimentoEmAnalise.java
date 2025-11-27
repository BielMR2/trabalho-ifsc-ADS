package interfaces;

public interface RequerimentoEmAnalise extends Requerimento {
    void addUnidadeCurricular(UnidadeCurricular unidadeCurricular);
    RequerimentoRespondido aprovar(String descricao, Coordenacao coordenacao);
    RequerimentoRespondido reprovar(String descricao, Coordenacao coordenacao);
}
