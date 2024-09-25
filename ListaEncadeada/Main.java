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
