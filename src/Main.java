import entities.*;
import interfaces.Requerimento;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Status
        Aprovado aprovado = new Aprovado("Aprovado");
        Reprovado reprovado = new Reprovado("Reprovado");
        EmAnalise emAnalise = new EmAnalise();

        // Tipo Requerimento
        EntradaSaida entradaSaida = new EntradaSaida("Entrada Tardia e Saída Antecipada", "descricao");
        JustificativaAusencia justificativaAusencia = new JustificativaAusencia("Justificativa de Ausência", "descricao");
        ExercicioDomiciliar exercicioDomiciliar = new ExercicioDomiciliar("Exercício Domiciliar", "descricao");
        ValidacaoRE validacaoEA = new ValidacaoRE("Validação de Unidade Curricular por Reconhecimento de Estudos", "descricao");
        ValidacaoRS validacaoRS = new ValidacaoRS("Validação de Unidade Curricular por Reconhecimento de Saberes", "descricao");

        // Unidades Currículares
        AnaliseDesenvolvimentoSistemas analiseDesenvolvimentoSistemas = new AnaliseDesenvolvimentoSistemas("Analise e Desenvolvimento de Sistemas", 80, "ADS-01");
        ProgramacaoOrientadaObjetos programacaoOrientadaObjetos = new ProgramacaoOrientadaObjetos("Programação Orientada a Objetos", 60, "POO-01");

        // Coordenacao
        CoordenacaoBasico willian = new CoordenacaoBasico("1234567890", "Willian da Silva de Sousa");

        // Aluno
        AlunoBasico arthur = new AlunoBasico("202510704000", "Arthur Antoniasse de Oliveira");
        AlunoBasico gabriel = new AlunoBasico("202510704002", "Gabriel Martins Ribeiro");
        AlunoBasico lucas = new AlunoBasico("202510704008", "Lucas Gomes Mendes");

        // Requerimento
        Requerimento requerimento = new RequerimentoBasico("arquivo.txt", "Descricao do requerimento", entradaSaida, arthur);
        requerimento.addUnidadeCurricula(analiseDesenvolvimentoSistemas);

        requerimento.responder("Parabéns, voce foi aprovado", reprovado, willian);
    }
}