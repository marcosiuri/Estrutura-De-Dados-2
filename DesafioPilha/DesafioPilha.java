import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Conversão de bases numéricas (de binário a hexadecimal)");
            System.out.println("2 - Identificar palavras palíndromas");
            System.out.println("3 - Resolver o quebra-cabeça Torre de Hanoi");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();  // Consome a nova linha após o número

            switch (opcao) {
                case 1:
                    conversaoBases(sc);
                    break;
                case 2:
                    identificarPalindromo(sc);
                    break;
                case 3:
                    resolverTorreDeHanoi(sc);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();  // Linha em branco entre as opções
        } while (opcao != 0);

        sc.close();
    }

    // Método para a conversão de bases numéricas
    public static void conversaoBases(Scanner sc) {
        System.out.print("Informe o número decimal: ");
        int numero = sc.nextInt();

        System.out.print("Informe a base para qual deseja converter (2 a 16): ");
        int base = sc.nextInt();

        if (base < 2 || base > 16) {
            System.out.println("Base inválida. Escolha um valor entre 2 e 16.");
        } else {
            System.out.println("O número convertido para a base " + base + " é: " + Integer.toString(numero, base).toUpperCase());
        }
    }

    // Método para identificar palavras palíndromas
    public static void identificarPalindromo(Scanner sc) {
        System.out.print("Informe uma palavra: ");
        String palavra = sc.nextLine();

        if (ehPalindromo(palavra)) {
            System.out.println("A palavra '" + palavra + "' é um palíndromo.");
        } else {
            System.out.println("A palavra '" + palavra + "' não é um palíndromo.");
        }
    }

    public static boolean ehPalindromo(String palavra) {
        String reverso = new StringBuilder(palavra).reverse().toString();
        return palavra.equalsIgnoreCase(reverso);
    }

    // Método para resolver o quebra-cabeça Torre de Hanoi
    public static void resolverTorreDeHanoi(Scanner sc) {
        System.out.print("Informe o número de discos: ");
        int n = sc.nextInt();

        moverDiscos(n, 'A', 'C', 'B'); // A = origem, C = destino, B = auxiliar
    }

    public static void moverDiscos(int n, char origem, char destino, char auxiliar) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + origem + " para " + destino);
            return;
        }

        moverDiscos(n - 1, origem, auxiliar, destino);
        System.out.println("Mover disco " + n + " de " + origem + " para " + destino);
        moverDiscos(n - 1, auxiliar, destino, origem);
    }
}
