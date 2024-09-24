import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TestaArrayList2 {
    private static ArrayList<Contato> listaContatos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Verificar quantidade de contatos");
            System.out.println("3 - Imprimir contatos");
            System.out.println("4 - Obter contato de uma posição específica");
            System.out.println("5 - Verificar se existe o contato");
            System.out.println("6 - Adicionar contato em qualquer posição");
            System.out.println("7 - Duplicar tamanho do vetor");
            System.out.println("8 - Remover contato");
            System.out.println("9 - Pesquisar por nome");
            System.out.println("10 - Pesquisar por e-mail");
            System.out.println("11 - Pesquisar por telefone");
            System.out.println("12 - Ordenar por nome");
            System.out.println("13 - Ordenar por e-mail");
            System.out.println("14 - Ordenar por telefone");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();
            sc.nextLine(); // Consome a quebra de linha

            switch (opcao) {
                case 1:
                    adicionarContato(sc);
                    break;
                case 2:
                    verificarQuantidadeContatos();
                    break;
                case 3:
                    imprimirContatos();
                    break;
                case 4:
                    obterContatoPosicao(sc);
                    break;
                case 5:
                    verificarSeExisteContato(sc);
                    break;
                case 6:
                    adicionarContatoPosicao(sc);
                    break;
                case 7:
                    duplicarTamanhoVetor();
                    break;
                case 8:
                    removerContato(sc);
                    break;
                case 9:
                    pesquisarPorNome(sc);
                    break;
                case 10:
                    pesquisarPorEmail(sc);
                    break;
                case 11:
                    pesquisarPorTelefone(sc);
                    break;
                case 12:
                    ordenarPorNome();
                    break;
                case 13:
                    ordenarPorEmail();
                    break;
                case 14:
                    ordenarPorTelefone();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }

    private static void adicionarContato(Scanner sc) {
        System.out.println("Digite o nome:");
        String nome = sc.nextLine();
        System.out.println("Digite o e-mail:");
        String email = sc.nextLine();
        System.out.println("Digite o telefone:");
        String telefone = sc.nextLine();
        listaContatos.add(new Contato(nome, email, telefone));
        System.out.println("Contato adicionado com sucesso!");
    }

    private static void verificarQuantidadeContatos() {
        System.out.println("Quantidade de contatos: " + listaContatos.size());
    }

    private static void imprimirContatos() {
        if (listaContatos.isEmpty()) {
            System.out.println("Nenhum contato disponível.");
        } else {
            for (Contato contato : listaContatos) {
                System.out.println(contato);
            }
        }
    }

    private static void obterContatoPosicao(Scanner sc) {
        System.out.println("Digite a posição do contato:");
        int posicao = sc.nextInt();
        if (posicao >= 0 && posicao < listaContatos.size()) {
            System.out.println(listaContatos.get(posicao));
        } else {
            System.out.println("Posição inválida.");
        }
    }

    private static void verificarSeExisteContato(Scanner sc) {
        System.out.println("Digite o nome do contato:");
        String nome = sc.nextLine();
        boolean encontrado = false;
        for (Contato contato : listaContatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Contato encontrado: " + contato);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Contato não encontrado.");
        }
    }

    private static void adicionarContatoPosicao(Scanner sc) {
        System.out.println("Digite a posição para inserir o contato:");
        int posicao = sc.nextInt();
        sc.nextLine(); // Consome a quebra de linha
        if (posicao >= 0 && posicao <= listaContatos.size()) {
            System.out.println("Digite o nome:");
            String nome = sc.nextLine();
            System.out.println("Digite o e-mail:");
            String email = sc.nextLine();
            System.out.println("Digite o telefone:");
            String telefone = sc.nextLine();
            listaContatos.add(posicao, new Contato(nome, email, telefone));
            System.out.println("Contato adicionado com sucesso!");
        } else {
            System.out.println("Posição inválida.");
        }
    }

    private static void duplicarTamanhoVetor() {
        ArrayList<Contato> novoArray = new ArrayList<>(listaContatos.size() * 2);
        novoArray.addAll(listaContatos);
        listaContatos = novoArray;
        System.out.println("Tamanho do vetor duplicado.");
    }

    private static void removerContato(Scanner sc) {
        System.out.println("Digite o nome do contato para remover:");
        String nome = sc.nextLine();
        listaContatos.removeIf(contato -> contato.getNome().equalsIgnoreCase(nome));
        System.out.println("Contato removido, se existia.");
    }

    private static void pesquisarPorNome(Scanner sc) {
        System.out.println("Digite o nome para pesquisar:");
        String nome = sc.nextLine();
        listaContatos.stream()
            .filter(contato -> contato.getNome().equalsIgnoreCase(nome))
            .forEach(System.out::println);
    }

    private static void pesquisarPorEmail(Scanner sc) {
        System.out.println("Digite o e-mail para pesquisar:");
        String email = sc.nextLine();
        listaContatos.stream()
            .filter(contato -> contato.getEmail().equalsIgnoreCase(email))
            .forEach(System.out::println);
    }

    private static void pesquisarPorTelefone(Scanner sc) {
        System.out.println("Digite o telefone para pesquisar:");
        String telefone = sc.nextLine();
        listaContatos.stream()
            .filter(contato -> contato.getTelefone().equalsIgnoreCase(telefone))
            .forEach(System.out::println);
    }

    private static void ordenarPorNome() {
        Collections.sort(listaContatos, Comparator.comparing(Contato::getNome));
        System.out.println("Contatos ordenados por nome.");
    }

    private static void ordenarPorEmail() {
        Collections.sort(listaContatos, Comparator.comparing(Contato::getEmail));
        System.out.println("Contatos ordenados por e-mail.");
    }

    private static void ordenarPorTelefone() {
        Collections.sort(listaContatos, Comparator.comparing(Contato::getTelefone));
        System.out.println("Contatos ordenados por telefone.");
    }
}
