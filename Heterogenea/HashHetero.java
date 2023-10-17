import java.util.ArrayList;
import java.util.LinkedList;

public class HashHetero {
    private ArrayList<LinkedList<Aluno>> estrutura;
    private int max_itens;
    private int max_posicoes;
    private double fatorDeCarga = 0.7; // da pra ajustar se precisar (eu ainda não entendi isso direito)

    public HashHetero(int tam_vetor, int max) {
        max_itens = max;
        max_posicoes = tam_vetor;
        estrutura = new ArrayList<LinkedList<Aluno>>(tam_vetor);

        for (int i = 0; i < tam_vetor; i++) {
            estrutura.add(new LinkedList<Aluno>());
        }
    }

    public void inserir(Aluno aluno) {
        if ((double) quantidadeItens() / max_posicoes >= fatorDeCarga) {
            redimensionar();
        }

        int local = FuncaoHash(aluno);
        LinkedList<Aluno> lista = estrutura.get(local);

        lista.add(aluno);
    }

    public void deletar(Aluno aluno) {
        int local = FuncaoHash(aluno);
        LinkedList<Aluno> lista = estrutura.get(local);

        lista.removeIf(a -> a.getRa() == aluno.getRa());
    }

    public void buscar(Aluno aluno, boolean[] busca) {
        int local = FuncaoHash(aluno);
        LinkedList<Aluno> lista = estrutura.get(local);
        busca[0] = false;

        for (Aluno a : lista) {
            if (a.getRa() == aluno.getRa()) {
                busca[0] = true;
                aluno.copyFrom(a);
                break;
            }
        }
    }

    public void imprimir() {
        System.out.println("Tabela Hash:");
        for (int i = 0; i < max_posicoes; i++) {
            LinkedList<Aluno> lista = estrutura.get(i);
            if (!lista.isEmpty()) {
                System.out.println("Posição " + i + ":");
                for (Aluno a : lista) {
                    System.out.println("RA: " + a.getRa());
                }
            }
        }
    }

    public int FuncaoHash(Aluno aluno) {
        int ra = aluno.getRa();
        return (ra & 0x7FFFFFFF) % max_posicoes;
        //  0x7FFFFFFF para garantir um valor não negativo (o chatgpt botou isso no lugar do calculo
        // e deu certo melhor do que qnd tinha calculo. Vai entender, isso não é de Deus.
    }


    //Aqui caso a tabela esteja completa e vc adicione um novo valor ela vai expandir a tabela. Ainda tem uns bug pra arrumar
    private void redimensionar() {
        int novoTamanho = max_posicoes * 2;
        ArrayList<LinkedList<Aluno>> novaEstrutura = new ArrayList<>(novoTamanho);

        for (int i = 0; i < novoTamanho; i++) {
            novaEstrutura.add(new LinkedList<>());
        }

        for (LinkedList<Aluno> lista : estrutura) {
            for (Aluno aluno : lista) {
                int novaPosicao = FuncaoHash(aluno);
                novaEstrutura.get(novaPosicao).add(aluno);
            }
        }

        estrutura = novaEstrutura;
        max_posicoes = novoTamanho;
    }

    public int quantidadeItens() {
        int quantidade = 0;
        for (LinkedList<Aluno> lista : estrutura) {
            quantidade += lista.size();
        }
        return quantidade;
    }
}
