import entities.*;
import interfaces.IRequerimentoEmMemoria;
import useCases.CasoDeUsoAnalisarRequerimento;
import useCases.CasoDeUsoSolicitarRequerimento;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        IRequerimentoEmMemoria requerimentoEmMemoria = new RequerimentoEmMemoria();

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Selecione o caso de uso desejado: ");

            System.out.println("1 - Solicitar Requerimento");
            System.out.println("2 - Analisar Requerimento");

            int opcao = sc.nextInt();

            if (opcao == 1){
                CasoDeUsoSolicitarRequerimento casoDeUsoSolicitarRequerimento = new CasoDeUsoSolicitarRequerimento(requerimentoEmMemoria);
                casoDeUsoSolicitarRequerimento.executar();
            }

            if (opcao == 2){
                CasoDeUsoAnalisarRequerimento casoDeUsoAnalisarRequerimento = new CasoDeUsoAnalisarRequerimento(requerimentoEmMemoria);
                casoDeUsoAnalisarRequerimento.executar();
            }
        }
    }
}