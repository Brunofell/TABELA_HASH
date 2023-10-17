package heterogenea;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashHetero {
    private ArrayList<LinkedList<AlunoHetero>> estrutura;
    private int max_itens;
    private int max_posicoes;
    private double fatorDeCarga = 0.7; // da pra ajustar se precisar (eu ainda não entendi isso direito)

    public HashHetero(int tam_vetor) {
        max_posicoes = tam_vetor;
        estrutura = new ArrayList<LinkedList<AlunoHetero>>(tam_vetor);

        for (int i = 0; i < tam_vetor; i++) {
            estrutura.add(new LinkedList<AlunoHetero>());
        }
    }

    public void inserirH(AlunoHetero aluno) {
        if ((double) quantidadeItens() / max_posicoes >= fatorDeCarga) {
            redimensionar();
        }

        int local = FuncaoHash(aluno);
        LinkedList<AlunoHetero> lista = estrutura.get(local);

        lista.add(aluno);
    }

    public void deletarH(AlunoHetero aluno) {
        int local = FuncaoHash(aluno);
        LinkedList<AlunoHetero> lista = estrutura.get(local);

        lista.removeIf(a -> a.getRa() == aluno.getRa());
    }

    public void buscarH(AlunoHetero aluno, boolean[] busca) {
        int local = FuncaoHash(aluno);
        LinkedList<AlunoHetero> lista = estrutura.get(local);
        busca[0] = false;

        for (AlunoHetero a : lista) {
            if (a.getRa() == aluno.getRa()) {
                busca[0] = true;
                aluno.copyFrom(a);
                break;
            }
        }
    }

    public void imprimirH() {
        System.out.println("Tabela homogenea.Hash:");
        for (int i = 0; i < max_posicoes; i++) {
            LinkedList<AlunoHetero> lista = estrutura.get(i);
            if (!lista.isEmpty()) {
                System.out.println("Posição " + i + ":");
                for (AlunoHetero a : lista) {
                    System.out.println("RA: " + a.getRa());
                }
            }
        }
    }

    public int FuncaoHash(AlunoHetero aluno) {
        int ra = aluno.getRa();
        return (ra & 0x7FFFFFFF) % max_posicoes;
        //  0x7FFFFFFF para garantir um valor não negativo (o chatgpt botou isso no lugar do calculo
        // e deu certo melhor do que qnd tinha calculo. Vai entender, isso não é de Deus.
    }


    //Aqui caso a tabela esteja completa e vc adicione um novo valor ela vai expandir a tabela. Ainda tem uns bug pra arrumar
    private void redimensionar() {
        int novoTamanho = max_posicoes * 2;
        ArrayList<LinkedList<AlunoHetero>> novaEstrutura = new ArrayList<>(novoTamanho);

        for (int i = 0; i < novoTamanho; i++) {
            novaEstrutura.add(new LinkedList<>());
        }

        for (LinkedList<AlunoHetero> lista : estrutura) {
            for (AlunoHetero aluno : lista) {
                int novaPosicao = FuncaoHash(aluno);
                novaEstrutura.get(novaPosicao).add(aluno);
            }
        }

        estrutura = novaEstrutura;
        max_posicoes = novoTamanho;
    }

    public int quantidadeItens() {
        int quantidade = 0;
        for (LinkedList<AlunoHetero> lista : estrutura) {
            quantidade += lista.size();
        }
        return quantidade;
    }
}
