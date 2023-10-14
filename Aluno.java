public class Aluno {
    private int ra;
    private String nome;


    public Aluno() {
        ra = -1;
        nome = " ";
    }

    public Aluno(int r, String n) {
        ra = r;
        nome = n;
    }

    public int obterRa() {
        return ra;
    }

    public String obterNome() {
        return nome;
    }
}
