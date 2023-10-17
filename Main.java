import heterogenea.AlunoHetero;
import heterogenea.HashHetero;
import homogenea.Aluno;
import homogenea.Hash;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------");
        System.out.println("- Programa gerador de Hash! -");
        System.out.println("- Digite o tamanho da Hash! -");
        System.out.println("-----------------------------");
        System.out.print(">>");
        int tam_vetor = scanner.nextInt(); // 3

        Hash alunohash = new Hash(tam_vetor);
        HashHetero alunoHashHet = new HashHetero(tam_vetor);
        int opcao;
        int ra;
        boolean busca = true;

        System.out.println("- Qual metodo de colisão quer testar?");
        System.out.println("- [1] Homogêneo ");
        System.out.println("- [2] Heterogêneo");
        System.out.print(">> ");
        int metodo = scanner.nextInt();

        if(metodo == 1){
            do {
                System.out.println("------------------------------------------ ");
                System.out.println("- Digite [0] para PARAR o algoritmo!     - ");
                System.out.println("- Digite [1] para INSERIR um elemento!   - ");
                System.out.println("- Digite [2] para REMOVER um elemento!   - ");
                System.out.println("- Digite [3] para BUSCAR um elemento!     - ");
                System.out.println("- Digite [4] para IMPRIMIR a hash!       - ");
                System.out.println("------------------------------------------ ");
                System.out.print(">> ");
                opcao = scanner.nextInt();

                if (opcao == 1) {
                    System.out.print("Qual e o RA do aluno: ");
                    ra = scanner.nextInt();
                    Aluno aluno = new Aluno(ra);
                    alunohash.inserir(aluno);
                } else if (opcao == 2) {
                    System.out.print("Qual e o RA do aluno a ser removido: ");
                    ra = scanner.nextInt();
                    Aluno aluno = new Aluno(ra);
                    alunohash.deletar(aluno);
                }else if (opcao == 3) {
                    System.out.print("Qual é o RA do aluno a ser buscado: ");
                    ra = scanner.nextInt();
                    Aluno aluno = new Aluno(ra);
                    int indiceEncontrado = alunohash.buscar(aluno);

                    if (indiceEncontrado != -1) {
                        System.out.println("Aluno encontrado na posição " + indiceEncontrado + " na tabela hash.");
                    } else {
                        System.out.println("Aluno não encontrado na tabela hash.");
                    }
                } else if (opcao == 4) {
                    alunohash.imprimir();
                }

            } while (opcao != 0);

            scanner.close();
        }else if(metodo == 2){
            do {
                System.out.println("Digite 0 para parar o algoritmo!");
                System.out.println("Digite 1 para inserir um elemento!");
                System.out.println("Digite 2 para remover um elemento!");
                System.out.println("Digite 3 para busca um elemento!");
                System.out.println("Digite 4 para imprimir a Hash!");
                opcao = scanner.nextInt();

                if (opcao == 1) {
                    System.out.println("Qual é o RA do aluno?");
                    ra = scanner.nextInt();
                    AlunoHetero alunoH = new AlunoHetero(ra, 0);
                    alunoHashHet.inserirH(alunoH);
                } else if (opcao == 2) {
                    System.out.println("Qual é o RA do aluno a ser removido?");
                    ra = scanner.nextInt();
                    AlunoHetero alunoH = new AlunoHetero(ra, 0);
                    alunoHashHet.deletarH(alunoH);
                } else if (opcao == 3) {
                    System.out.println("Qual é o RA do aluno a ser buscado?");
                    ra = scanner.nextInt();
                    AlunoHetero aluno = new AlunoHetero(ra, 0); // Crie um novo objeto Aluno com a chave aleatória
                    boolean[] buscaArray = new boolean[1];
                    alunoHashHet.buscarH(aluno, buscaArray);
                    if (buscaArray[0]) {
                        System.out.println("RA encontrado:");
                        System.out.println("RA: " + aluno.getRa());
                    } else {
                        System.out.println("Aluno não encontrado!");
                    }

                } else if (opcao == 4) {
                    alunoHashHet.imprimirH();
                }

            } while (opcao != 0);

            scanner.close();
        }
    }
}


