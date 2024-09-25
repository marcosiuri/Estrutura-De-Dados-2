// Definição do nó da lista encadeada
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Implementação da lista encadeada
class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // Inserir ordenado
    public void insertOrdered(int value) {
        Node newNode = new Node(value);
        
        if (head == null || head.data >= value) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data < value) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Remover nó
    public void remove(int value) {
        if (head == null) {
            System.out.println("A lista está vazia.");
            return;
        }
        
        if (head.data == value) {
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;
        
        while (current != null && current.data != value) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Elemento não encontrado.");
            return;
        }

        previous.next = current.next;
    }

    // Buscar elemento na lista
    public boolean search(int value) {
        Node current = head;
        
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        
        return false;
    }

    // Exibir a lista
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

// Classe principal
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        list.insertOrdered(10);
        list.insertOrdered(5);
        list.insertOrdered(20);
        list.insertOrdered(15);

        System.out.println("Lista após inserções ordenadas:");
        list.display();

        System.out.println("Buscando o valor 15: " + list.search(15));
        System.out.println("Buscando o valor 25: " + list.search(25));

        list.remove(10);
        System.out.println("Lista após remover o valor 10:");
        list.display();
    }
}
