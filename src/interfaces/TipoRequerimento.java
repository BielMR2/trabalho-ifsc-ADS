package interfaces;

public interface TipoRequerimento {
    Integer id();
    String nome();
    String descricao();
    Boolean selecionaUC();
    Momento prazo();
}
