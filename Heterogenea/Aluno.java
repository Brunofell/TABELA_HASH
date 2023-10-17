public class Aluno {
    private int ra;
    private int chaveAleatoria;

    public Aluno(int ra, int chaveAleatoria) {
        this.ra = ra;
        this.chaveAleatoria = chaveAleatoria;
    }

    public int getRa() {
        return ra;
    }

    public int getChaveAleatoria() {
        return chaveAleatoria;
    }

    public void copyFrom(Aluno outroAluno) {
        this.ra = outroAluno.ra;
        this.chaveAleatoria = outroAluno.chaveAleatoria;
    }
}
