import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Programa gerador de Hash!");
        int tam_vetor, max;
        System.out.println("Digite o tamanho da Hash!");
        tam_vetor = scanner.nextInt();
        System.out.println("Digite o numero maximo de elementos!");
        max = scanner.nextInt();
        System.out.println("O fator de carga e: " + ((float) max / (float) tam_vetor));

        Hash alunohash = new Hash(tam_vetor, max);
        int opcao;
        int ra;
        boolean busca = true;

        do {
            System.out.println("Digite 0 para parar o algoritmo!");
            System.out.println("Digite 1 para inserir um elemento!");
            System.out.println("Digite 2 para remover um elemento!");
            System.out.println("Digite 3 para busca um elemento!");
            System.out.println("Digite 4 para imprimir a Hash!");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("Qual e o RA do aluno?");
                ra = scanner.nextInt();
                Aluno aluno = new Aluno(ra);
                alunohash.inserir(aluno);
            } else if (opcao == 2) {
                System.out.println("Qual e o RA do aluno a ser removido?");
                ra = scanner.nextInt();
                Aluno aluno = new Aluno(ra);
                alunohash.deletar(aluno);
            } else if (opcao == 3) {
                System.out.println("Qual e o RA do aluno a ser buscado?");
                ra = scanner.nextInt();
                Aluno aluno = new Aluno(ra);
                alunohash.buscar(aluno, busca);
                if (busca) {
                    System.out.println("Aluno encontrado:");
                    System.out.println("RA: " + aluno.getRa());
                } else {
                    System.out.println("Aluno nao encontrado!");
                }
            } else if (opcao == 4) {
                alunohash.imprimir();
            }

        } while (opcao != 0);

        scanner.close();
    }
}
