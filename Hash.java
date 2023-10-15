import java.util.Arrays;

public class Hash {
    private int max_itens;
    private int max_posicoes;
    private int quant_itens;
    private Aluno[] estrutura;

    public Hash(int tam_vetor, int max) {
        quant_itens = 0;
        max_itens = max;
        max_posicoes = tam_vetor;
        estrutura = new Aluno[tam_vetor];
        Arrays.fill(estrutura, new Aluno(-1)); // arrumar aqui pra inicializar so com numeros
    }

    public int FuncaoHash(Aluno aluno) { // faz o calculo da função hash, pra colocar na posição
        return (aluno.getRa() % max_posicoes);
    }

    public boolean estacheio() { // verifica se a hash ta cheia quando quant_itens == max_itens
        return (quant_itens == max_itens);
    }

    public int obterTamanhoAtual() { // retorna a quantidade de itens que tem na hash
        return quant_itens;
    }

    public void inserir(Aluno aluno) { // tratando colisões por sondagem linear
        int local = FuncaoHash(aluno); // vai dar a posição
        while (estrutura[local].getRa() > 0) { // se a posição estiver ocupada, o algoritimo procura a proxima posição disponivel
            local = (local + 1) % max_posicoes;
        }
        estrutura[local] = aluno; // inserindo la
        quant_itens++;
    }

    public void deletar(Aluno aluno) {
        int local = FuncaoHash(aluno);
        boolean teste = false;
        while (estrutura[local].getRa() != -1) {
            if (estrutura[local].getRa() == aluno.getRa()) {
                System.out.println("Elemento Removido!");
                estrutura[local] = new Aluno(-2);
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
        while (estrutura[local].getRa() != -1) {
            if (estrutura[local].getRa() == aluno.getRa()) {
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
            if (estrutura[i].getRa() > 0) {
                System.out.println(i + ":" + estrutura[i].getRa());
            }
        }
    }
}
