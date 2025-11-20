package utils;

import java.util.Scanner;

public class Console {
    public void msg(String texto) {
        System.out.println(texto);
    }

    public void titulo(String texto) {
        String linha = "===============================================";
        System.out.println("\n" + linha);
        System.out.println(" " + texto);
        System.out.println(linha + "\n");
    }

    public void bloco(String texto) {
        String linha = "-----------------------------------------------";
        System.out.println("\n" + linha);
        System.out.println(" " + texto);
        System.out.println(linha + "\n");
    }
}
