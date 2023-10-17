package homogenea;

import java.util.Arrays;

public class Hash {

    private int max_posicoes;
    private int quant_itens;
    private Aluno[] estrutura;
    private int tamanho;

    public Hash(int tam_vetor) {
        tamanho = tam_vetor;
        quant_itens = 0;
        max_posicoes = tam_vetor;
        estrutura = new Aluno[tamanho];
        Arrays.fill(estrutura, new Aluno(-1)); // arrumar aqui para inicializar somente com números
    }

    public int FuncaoHash(Aluno aluno) {
        return (aluno.getRa() % max_posicoes);
    }

    private void rehash() {
        int novoTamanho = max_posicoes * 2;
        Aluno[] novaEstrutura = new Aluno[novoTamanho];
        Arrays.fill(novaEstrutura, new Aluno(-1));

        for (Aluno aluno : estrutura) {
            if (aluno.getRa() > 0) {
                int local = FuncaoHash(aluno);
                while (novaEstrutura[local].getRa() > 0) {
                    local = (local + 1) % novoTamanho;
                }
                novaEstrutura[local] = aluno;
            }
        }

        this.max_posicoes = novoTamanho;
        this.estrutura = novaEstrutura;
    }
    public void inserir(Aluno aluno) {
        if ((quant_itens / max_posicoes) > 0.7) {
            rehash();
        }

        int local = FuncaoHash(aluno);
        while (estrutura[local].getRa() > 0) {
            local = (local + 1) % max_posicoes;
        }
        estrutura[local] = aluno;
        quant_itens++;
    }

    public void deletar(Aluno aluno) {
        int local = FuncaoHash(aluno);
        boolean teste = false;
        while (estrutura[local].getRa() != -1) {
            if (estrutura[local].getRa() == aluno.getRa()) {
                System.out.println("Elemento Removido!");
                estrutura[local] = new Aluno(-2); // remove e troca o valor por -2
                quant_itens--;
                teste = true;
                break;
            }
            local = (local + 1) % max_posicoes;
        }
        if (teste == false) {
            System.out.println("O elemento nao encontrado!");
            System.out.println("Nenhum elemento foi removido!");
        }
    }

    public int buscar(Aluno aluno) {
        int local = FuncaoHash(aluno);
        int originalLocal = local;
        while (estrutura[local].getRa() != -1) {
            if (estrutura[local].getRa() == aluno.getRa()) {
                return local; // Retorna o índice onde o elemento está armazenado
            }
            local = (local + 1) % max_posicoes;
            if (local == originalLocal) { // Se voltar ao ponto de partida, o elemento não está na tabela
                break;
            }
        }
        return -1; // Retorna -1 se o elemento não foi encontrado
    }


    public void imprimir() {
        System.out.println("Tabela homogenea.Hash:");
        for (int i = 0; i < max_posicoes; i++) {
            if (estrutura[i].getRa() > 0) {
                System.out.println(i + ":" + estrutura[i].getRa());
            }
        }
    }

    public int getQuant_itens() {
        return quant_itens;
    }
}
