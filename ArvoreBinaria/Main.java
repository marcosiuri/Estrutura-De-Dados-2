import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Insira um valor (ou 'sair' para terminar): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("sair")) {
                break;
            }
            try {
                int value = Integer.parseInt(input);
                tree.insert(value);
                
                // Exibe o valor inserido
                System.out.print("Seu valor: " + value + " ");
                
                // Mostra os valores na árvore após a inserção
                tree.displayInOrder(); 
                System.out.println(); // Apenas para uma linha em branco
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um número válido.");
            }
        }

        scanner.close();
    }
}
