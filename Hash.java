import java.util.Arrays;

public class Hash {
    private int max_itens;
    private int max_posicoes;
    private int quant_itens;
    private Aluno[] estrutura;

    public int FuncaoHash(Aluno aluno) {
        return (aluno.obterRa() % max_posicoes);
    }

    public Hash(int tam_vetor, int max) {
        quant_itens = 0;
        max_itens = max;
        max_posicoes = tam_vetor;
        estrutura = new Aluno[tam_vetor];
        Arrays.fill(estrutura, new Aluno(-1, ""));
    }

    public boolean estacheio() {
        return (quant_itens == max_itens);
    }

    public int obterTamanhoAtual() {
        return quant_itens;
    }

    public void inserir(Aluno aluno) {
        int local = FuncaoHash(aluno);
        while (estrutura[local].obterRa() > 0) {
            local = (local + 1) % max_posicoes;
        }
        estrutura[local] = aluno;
        quant_itens++;
    }

    public void deletar(Aluno aluno) {
        int local = FuncaoHash(aluno);
        boolean teste = false;
        while (estrutura[local].obterRa() != -1) {
            if (estrutura[local].obterRa() == aluno.obterRa()) {
                System.out.println("Elemento Removido!");
                estrutura[local] = new Aluno(-2, " ");
                quant_itens--;
                teste = true;
                break;
            }
            local = (local + 1) % max_posicoes;
        }
        if (!teste) {
            System.out.println("O elemento nao encontrado!");
            System.out.println("Nenhum elemento foi removido!");
        }
    }

    public void buscar(Aluno aluno, Boolean busca) {
        int local = FuncaoHash(aluno);
        busca = false;
        while (estrutura[local].obterRa() != -1) {
            if (estrutura[local].obterRa() == aluno.obterRa()) {
                busca = true;
                aluno = estrutura[local];
                break;
            }
            local = (local + 1) % max_posicoes;
        }
    }

    public void imprimir() {
        System.out.println("Tabela Hash:");
        for (int i = 0; i < max_posicoes; i++) {
            if (estrutura[i].obterRa() > 0) {
                System.out.println(i + ":" + estrutura[i].obterRa() + " " + estrutura[i].obterNome());
            }
        }
    }
}
