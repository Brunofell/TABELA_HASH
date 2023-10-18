import Heterogenea.HashHetero;
import homogenea.Chave;
import homogenea.Hash;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------");
        System.out.println("- Programa gerador de Hash! -");
        System.out.println("- Digite o tamanho da Hash! -");
        System.out.println("-----------------------------");
        int tam_vetor;
        do{
            System.out.println(">>");
            tam_vetor = scanner.nextInt();
            if (tam_vetor <= 0){
                System.out.println("Tamanho invalido, só é permitido valores maiores que zero");
            }
        }while (tam_vetor <= 0);
            Hash alunohash = new Hash(tam_vetor);

            HashHetero hashTable = new HashHetero(tam_vetor); // criou a hash desse tamanho ai
        int opcao;
        int num;
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
                System.out.println("- Digite [3] para BUSCAR um elemento!    - ");
                System.out.println("- Digite [4] para IMPRIMIR a hash!       - ");
                System.out.println("------------------------------------------ ");
                System.out.print(">> ");
                opcao = scanner.nextInt();

                if (opcao == 1) {
                    System.out.println("Qual número vai INSERIR? ");
                    System.out.print(">> ");
                    num = scanner.nextInt();
                    if (num < 0){
                        System.out.println("Valor invalido, só é permitido numeros inteiros");
                    }
                    else{
                        Chave chave = new Chave(num);
                        alunohash.inserir(chave);
                    }
                } else if (opcao == 2) {
                    System.out.println("Qual número vai REMOVER? ");
                    System.out.print(">> ");
                    num = scanner.nextInt();
                    Chave chave = new Chave(num);
                    alunohash.deletar(chave);
                } else if (opcao == 3) {
                    System.out.println("Qual número vai BUSCAR? ");
                    System.out.print(">> ");
                    num = scanner.nextInt();
                    Chave chave = new Chave(num);
                    long startTime = System.nanoTime();
                    int indiceEncontrado = alunohash.buscar(chave);

                    if (indiceEncontrado != -1) {
                        System.out.println("Número encontrado na posição " + indiceEncontrado + " na tabela hash.");
                        long endTime = System.nanoTime();
                        long timeElapsed = endTime - startTime;
                        System.out.println("Tempo de execução em nanossegundos: " + timeElapsed);

                    } else {
                        System.out.println("Número não encontrado na tabela hash.");
                        long endTime = System.nanoTime();
                        long timeElapsed = endTime - startTime;
                        System.out.println("Tempo de execução em nanossegundos: " + timeElapsed);
                    }
                } else if (opcao == 4) {
                    alunohash.imprimir();
                }

            } while (opcao != 0);

            scanner.close();
        }else if(metodo == 2){

            do{
                System.out.println("------------------------------------------ ");
                System.out.println("- Digite [0] para PARAR o algoritmo!     - ");
                System.out.println("- Digite [1] para INSERIR um elemento!   - ");
                System.out.println("- Digite [2] para REMOVER um elemento!   - ");
                System.out.println("- Digite [3] para BUSCAR um elemento!    - ");
                System.out.println("- Digite [4] para IMPRIMIR a hash!       - ");
                System.out.println("------------------------------------------ ");
                System.out.print(">> ");
                opcao = scanner.nextInt();

                if(opcao == 1){
                    System.out.println("Qual número vai INSERIR? ");
                    System.out.print(">> ");
                    num = scanner.nextInt();
                    if (num < 0){
                        System.out.println("Valor invalido, só é permitido numeros inteiros");
                    }
                    else{
                        hashTable.inserir(num);
                    }
                } else if(opcao == 2){
                    System.out.println("Qual número vai REMOVER? ");
                    System.out.print(">> ");
                    num = scanner.nextInt();
                    hashTable.deletar(num);
                } else if(opcao == 3){
                    System.out.println("Qual número vai BUSCAR? ");
                    System.out.print(">> ");
                    num = scanner.nextInt();
                    hashTable.buscar(num);
                } else if(opcao == 4){
                    hashTable.imprimir();
                }

            } while (opcao != 0);

            scanner.close();
        }
    }
}