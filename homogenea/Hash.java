package homogenea;

import java.util.Arrays;

public class Hash {

    private int max_posicoes;
    private int quant_itens;
    private Chave[] estrutura;
    private int tamanho;

    public Hash(int tam_vetor) {
        tamanho = tam_vetor;
        quant_itens = 0;
        max_posicoes = tam_vetor;
        estrutura = new Chave[tamanho];
        Arrays.fill(estrutura, new Chave(-1)); // arrumar aqui para inicializar somente com números
    }

    public int FuncaoHash(Chave chave) {
        return (chave.getNumero() % max_posicoes);
    }

    private void rehash() {
        int novoTamanho = max_posicoes * 2;
        Chave[] novaEstrutura = new Chave[novoTamanho];
        Arrays.fill(novaEstrutura, new Chave(-1));

        for (Chave chave : estrutura) {
            if (chave.getNumero() > 0) {
                int local = FuncaoHash(chave);
                while (novaEstrutura[local].getNumero() > 0) {
                    local = (local + 1) % novoTamanho;
                }
                novaEstrutura[local] = chave;
            }
        }

        this.max_posicoes = novoTamanho;
        this.estrutura = novaEstrutura;
    }
    public void inserir(Chave chave) {
        if ((quant_itens / max_posicoes) > 0.7) {
            rehash();
        }

        int local = FuncaoHash(chave);
        while (estrutura[local].getNumero() > 0) {
            local = (local + 1) % max_posicoes;
        }
        estrutura[local] = chave;
        quant_itens++;
    }

    public void deletar(Chave chave) {
        int local = FuncaoHash(chave);
        boolean teste = false;
        while (estrutura[local].getNumero() != -1) {
            if (estrutura[local].getNumero() == chave.getNumero()) {
                System.out.println("Elemento Removido!");
                estrutura[local] = new Chave(-2); // remove e troca o valor por -2
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

    public int buscar(Chave chave) {
        int local = FuncaoHash(chave);
        int originalLocal = local;
        while (estrutura[local].getNumero() != -1) {
            if (estrutura[local].getNumero() == chave.getNumero()) {
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
        System.out.println("Tabela Hash:");
        for (int i = 0; i < max_posicoes; i++) {
            if (estrutura[i].getNumero() > 0) {
                System.out.println(i + ":" + estrutura[i].getNumero());
            }
        }
    }

    public int getQuant_itens() {
        return quant_itens;
    }
}
