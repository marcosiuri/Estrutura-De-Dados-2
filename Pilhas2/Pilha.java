import java.util.Stack;
import java.util.Scanner;

public class Pilha {
    private Stack<String> stack = new Stack<>();

    public void empilhar(String elemento) {
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

    public void verificarElemento(String elemento) {
        int posicao = stack.search(elemento); 
        if (posicao != -1) {
            System.out.println("Elemento " + elemento + " está na pilha na posição " + posicao);
        } else {
            System.out.println("Elemento " + elemento + " não está na pilha.");
        }
    }

    public void pesquisarPorNome(String nome) {
        verificarElemento(nome);
    }

    public void pesquisarPorEmail(String email) {
        verificarElemento(email);
    }

    public void pesquisarPorTelefone(String telefone) {
        verificarElemento(telefone);
    }

    public void desempilhar() {
        if (!stack.isEmpty()) {
            String removido = stack.pop();
            System.out.println("Elemento " + removido + " desempilhado.");
        } else {
            System.out.println("A pilha está vazia.");
        }
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        Scanner sc = new Scanner(System.in);
        int opcao;
        String elemento;

        do {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1 - Empilhar");
            System.out.println("2 - Verificar o tamanho da pilha");
            System.out.println("3 - Imprimir e desempilhar todos os elementos");
            System.out.println("4 - Verificar o elemento no topo da pilha");
            System.out.println("5 - Verificar se um elemento existe na pilha");
            System.out.println("6 - Desempilhar");
            System.out.println("7 - Pesquisar por nome");
            System.out.println("8 - Pesquisar por e-mail");
            System.out.println("9 - Pesquisar por telefone");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("Digite o elemento (nome/email/telefone) para empilhar:");
                    elemento = sc.nextLine();
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
                    elemento = sc.nextLine();
                    pilha.verificarElemento(elemento);
                    break;
                case 6:
                    pilha.desempilhar();
                    break;
                case 7:
                    System.out.println("Digite o nome para pesquisar:");
                    elemento = sc.nextLine();
                    pilha.pesquisarPorNome(elemento);
                    break;
                case 8:
                    System.out.println("Digite o e-mail para pesquisar:");
                    elemento = sc.nextLine();
                    pilha.pesquisarPorEmail(elemento);
                    break;
                case 9:
                    System.out.println("Digite o telefone para pesquisar:");
                    elemento = sc.nextLine();
                    pilha.pesquisarPorTelefone(elemento);
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
