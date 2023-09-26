import java.util.Random;
import java.util.Scanner;

public class LotoFacil {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        char letraPremiada = 'M';
        int tentativas = 0;

        System.out.println("Bem-vindo à LotoFacil. Aposte o quanto quiser!");
        boolean jogarNovamente = true;

        while (jogarNovamente) {
            tentativas = 0;
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Aposta de número");
            System.out.println("2. Aposta de letra");
            System.out.println("3. Aposta em número ímpar ou par");
            System.out.println("4. Sair");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    jogarNumero(scanner, random, tentativas);
                    break;
                case 2:
                    jogarLetra(scanner, letraPremiada, tentativas);
                    break;
                case 3:
                    jogarPar(scanner, tentativas);
                    break;
                case 4:
                    jogarNovamente = false;
                    System.out.println("Obrigado por jogar. Seu dinheiro faz a diferença!");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }

    public static void jogarNumero(Scanner scanner, Random random, int tentativas) {
        int numeroSorteado = random.nextInt(101);
        boolean ganhou = false;

        do {
            System.out.print("Digite um número de 0 a 100: ");
            int numeroApostado = scanner.nextInt();
            tentativas++;

            if (numeroApostado < 0 || numeroApostado > 100) {
                System.out.println("Aposta inválida.");
            } else {
                if (numeroApostado == numeroSorteado) {
                    System.out.println("PARABÉNS! Você ganhou R$ 1.000,00 reais!");
                    ganhou = true;
                } else {
                    System.out.println("Não foi dessa vez! O número sorteado foi: " + numeroSorteado + ".");
                }
            }
        } while (!ganhou);

        System.out.println("Você acertou em " + tentativas + " tentativas.");
    }

    public static void jogarLetra(Scanner scanner, char letraPremiada, int tentativas) {
        boolean ganhou = false;

        do {
            System.out.print("Digite uma letra de A a Z: ");
            char letraApostada = scanner.next().toUpperCase().charAt(0);
            tentativas++;

            if (!Character.isLetter(letraApostada)) {
                System.out.println("Aposta inválida.");
            } else {
                if (letraApostada == letraPremiada) {
                    System.out.println(" É ASSIM QUE SE FAZ! Você ganhou R$ 500,00 reais!");
                    ganhou = true;
                } else {
                    System.out.println("Que pena! A letra sorteada foi: " + letraPremiada + ".");
                }
            }
        } while (!ganhou);

        System.out.println("Você acertou em " + tentativas + " tentativas.");
    }

    public static void jogarPar(Scanner scanner, int tentativas) {
        boolean ganhou = false;

        do {
            System.out.print("Digite um número inteiro: ");
            int numeroPar = scanner.nextInt();
            tentativas++;

            if (numeroPar % 2 == 0) {
                System.out.println("PARABÉNS VOCÊ GANHOU R$ 100,00 reais!");
                ganhou = true;
            } else {
                System.out.println("NÃO FOI HOJE! O número digitado é ímpar e a premiação foi para números pares.");
            }
        } while (!ganhou);

        System.out.println("Você acertou em " + tentativas + " tentativas.");
    }
}
