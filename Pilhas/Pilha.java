import java.util.Stack;
import java.util.Scanner;

public class Pilha {
    private Stack<Integer> stack = new Stack<>();

    public void empilhar(int elemento) {
        stack.push(elemento);
        System.out.println("Elemento " + elemento + " empilhado.");
    }

    public void tamanhoPilha() {
        System.out.println("Tamanho da pilha: " + stack.size());
    }

    public void imprimirDesempilhando() {
        System.out.println("Elementos desempilhados: ");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public void topoPilha() {
        if (!stack.isEmpty()) {
            System.out.println("Elemento no topo da pilha: " + stack.peek());
        } else {
            System.out.println("A pilha está vazia.");
        }
    }

    public void verificarElemento(int elemento) {
        if (stack.contains(elemento)) {
            System.out.println("Elemento " + elemento + " está na pilha.");
        } else {
            System.out.println("Elemento " + elemento + " não está na pilha.");
        }
    }

    public void desempilhar() {
        if (!stack.isEmpty()) {
            int removido = stack.pop();
            System.out.println("Elemento " + removido + " desempilhado.");
        } else {
            System.out.println("A pilha está vazia.");
        }
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        Scanner sc = new Scanner(System.in);
        int opcao, elemento;

        do {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1 - Empilhar");
            System.out.println("2 - Verificar o tamanho da pilha");
            System.out.println("3 - Imprimir e desempilhar todos os elementos");
            System.out.println("4 - Verificar o elemento no topo da pilha");
            System.out.println("5 - Verificar se um elemento existe na pilha");
            System.out.println("6 - Desempilhar");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o elemento para empilhar:");
                    elemento = sc.nextInt();
                    pilha.empilhar(elemento);
                    break;
                case 2:
                    pilha.tamanhoPilha();
                    break;
                case 3:
                    pilha.imprimirDesempilhando();
                    break;
                case 4:
                    pilha.topoPilha();
                    break;
                case 5:
                    System.out.println("Digite o elemento para verificar:");
                    elemento = sc.nextInt();
                    pilha.verificarElemento(elemento);
                    break;
                case 6:
                    pilha.desempilhar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);

        sc.close();
    }
}
