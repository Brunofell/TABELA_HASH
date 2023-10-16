public class HashHetero {
    private Aluno[] estrutura;
    private int quant_itens;
    private int max_itens;
    private int max_posicoes;

    public HashHetero(int tam_vetor, int max) {
        quant_itens = 0;
        max_itens = max;
        max_posicoes = tam_vetor;
        estrutura = new Aluno[tam_vetor];
    }

    public void inserir(Aluno aluno) {
        int local = FuncaoHash(aluno);
        while (estrutura[local] != null && estrutura[local].getRa() != -1) {
            local = (local + 1) % max_posicoes;
        }
        estrutura[local] = aluno;
    }

    public void deletar(Aluno aluno) {
        int local = FuncaoHash(aluno);
        boolean teste = false;
        while (estrutura[local].getRa() != -1) {
            if (estrutura[local].getRa() == aluno.getRa()) {
                System.out.println("Elemento Removido!");
                estrutura[local] = new Aluno(-1); // Define o RA como -1 para indicar que está vazio
                quant_itens--;
                teste = true;
                break;
            }
            local = (local + 1) % max_posicoes;
        }
        if (!teste) {
            System.out.println("O elemento não encontrado!");
            System.out.println("Nenhum elemento foi removido!");
        }
    }


    public void buscar(Aluno aluno, boolean[] busca) {
        int local = FuncaoHash(aluno);
        busca[0] = false;
        while (estrutura[local].getRa() != -1) {
            if (estrutura[local].getRa() == aluno.getRa()) {
                busca[0] = true;
                aluno = estrutura[local];
                break;
            }
            local = (local + 1) % max_posicoes;
        }
    }

    public void imprimir() {
        System.out.println("Tabela Hash:");
        for (int i = 0; i < max_posicoes; i++) {
            if (estrutura[i] != null && estrutura[i].getRa() != -1) {
                System.out.println("Posição " + i + ":");
                System.out.println("RA: " + estrutura[i].getRa());
                // Se a classe Aluno tiver um campo nome, você também pode imprimir o nome aqui
            }
        }
    }


    private int FuncaoHash(Aluno aluno) {
        return (aluno.getRa() % max_posicoes);
    }

    public boolean estacheio() {
        return (quant_itens == max_itens);
    }

    public int obterTamanhoAtual() {
        return quant_itens;
    }

    public void setMaxPosicoes(int max_posicoes) {
        this.max_posicoes = max_posicoes;
        Aluno[] newEstrutura = new Aluno[max_posicoes];
        System.arraycopy(estrutura, 0, newEstrutura, 0, Math.min(max_posicoes, estrutura.length));
        estrutura = newEstrutura;
    }
}
