package Heterogenea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HashHetero {
    private int[] tabelaHash;
    private List<Integer> tabelaExtra;
    private int tamanho;

    public HashHetero(int tamanho) {
        this.tamanho = tamanho;
        tabelaHash = new int[tamanho];
        tabelaExtra = new ArrayList<>();
        inicializarTabela();
    }

    private void inicializarTabela() {
        for (int i = 0; i < tamanho; i++) {
            tabelaHash[i] = -1;
        }
    }

    private int funcaoHash(int chave) {
        return chave % tamanho;
    }

    public void inserir(int numero) {
        int valor = funcaoHash(numero);
        if (tabelaHash[valor] == -1) {
            tabelaHash[valor] = numero;
        } else {
            tabelaExtra.add(numero);
        }
    }

    public void deletar(int numero) {
        for (int i = 0; i < tamanho; i++) {
            if (tabelaHash[i] == numero) {
                tabelaHash[i] = -2;
                System.out.println("O elemento " + numero + " foi deletado da tabela.");
                return;
            }
        }

        if (tabelaExtra.contains(numero)) {
            tabelaExtra.remove(Integer.valueOf(numero));
            System.out.println("O elemento " + numero + " foi deletado da tabela extra.");
            return;
        }

        System.out.println("O elemento " + numero + " não encontrado");
    }

    public boolean buscar(int numero) {

        long startTime = System.nanoTime();

        for (int i = 0; i < tamanho; i++) {
            if (tabelaHash[i] == numero) {
                System.out.println("O elemento " + numero + " foi encontrado na posição " + i + " na tabela hash principal.");
                System.out.println(" ");

                long endTime = System.nanoTime();
                long timeElapsed = endTime - startTime;
                System.out.println("Tempo de execução em nanossegundos: " + timeElapsed);

                return true;
            }
        }

        if (tabelaExtra.contains(numero)) {
            int index = tabelaExtra.indexOf(numero);
            System.out.println("O elemento " + numero + " foi encontrado na posição " + (index + tamanho) + " na tabela hash extra.");
            System.out.println(" ");

            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            System.out.println("Tempo de execução em nanossegundos: " + timeElapsed);

            return true;
        }

        System.out.println("O elemento " + numero + " não foi encontrado.");
        System.out.println(" ");

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Tempo de execução em nanossegundos: " + timeElapsed);

        return false;
    }

    public void imprimir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(i + ": " + (tabelaHash[i] == -2 ? -1 : tabelaHash[i]));
        }
        System.out.println("TABELA HASH EXTRA:");
        for (int i = 0; i < tabelaExtra.size(); i++) {
            System.out.println((i + tamanho) + ": " + tabelaExtra.get(i));
        }
    }
}