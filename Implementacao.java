import homogenea.Aluno;
import homogenea.Hash;

import java.util.Scanner;

public class Implementacao{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Programa gerador de homogenea.Hash!");
        System.out.println("Digite o tamanho da homogenea.Hash!");
        int tam_vetor = scanner.nextInt(); // 3

        Hash alunohash = new Hash(tam_vetor);
        int opcao;
        int ra;
        boolean busca = true;

        do {
            System.out.println("Digite 0 para parar o algoritmo!");
            System.out.println("Digite 1 para inserir um elemento!");
            System.out.println("Digite 2 para remover um elemento!");
            System.out.println("Digite 3 para busca um elemento!");
            System.out.println("Digite 4 para imprimir a homogenea.Hash!");
            System.out.println("Digite 5 para ver o fator de carga!");
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
            }else if (opcao == 3) {
                System.out.println("Qual é o RA do aluno a ser buscado?");
                ra = scanner.nextInt();
                Aluno aluno = new Aluno(ra);
                int indiceEncontrado = alunohash.buscar(aluno);

                if (indiceEncontrado != -1) {
                    System.out.println("homogenea.Aluno encontrado na posição " + indiceEncontrado + " na tabela hash.");
                } else {
                    System.out.println("homogenea.Aluno não encontrado na tabela hash.");
                }
            } else if (opcao == 4) {
                alunohash.imprimir();
            } else if(opcao == 5){
                //infinity?????????????
                System.out.println("O fator de carga é: " + ((float) alunohash.getQuant_itens()) / (float) tam_vetor);
            }

        } while (opcao != 0);

        scanner.close();
    }
}
