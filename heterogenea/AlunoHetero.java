package heterogenea;

public class AlunoHetero {
    private int ra;
    private int chaveAleatoria;

    public AlunoHetero(int ra, int chaveAleatoria) {
        this.ra = ra;
        this.chaveAleatoria = chaveAleatoria;
    }

    public int getRa() {
        return ra;
    }

    public int getChaveAleatoria() {
        return chaveAleatoria;
    }

    public void copyFrom(AlunoHetero outroAluno) {
        this.ra = outroAluno.ra;
        this.chaveAleatoria = outroAluno.chaveAleatoria;
    }
}
