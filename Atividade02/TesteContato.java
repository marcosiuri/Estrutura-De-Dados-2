public class TestaContato {

    public static void main(String[] args) {

        VetorContato vetor = new VetorContato(5);

        vetor.adiciona(new Contato("Teste01", "11111", "TESTE01@TESTE.COM"));
        vetor.adiciona(new Contato("Teste02", "22222", "TESTE02@TESTE.COM"));
        vetor.adiciona(new Contato("Teste03", "33333", "TESTE03@TESTE.COM"));

        System.out.println(vetor);

        System.out.println();
        System.out.println("1)");
        vetor.adiciona(new Contato("Teste04", "4444", "TESTE04@TESTE.COM"));
        System.out.println(vetor);

        System.out.println();
        System.out.println("2)");
        System.out.println(vetor.tamanho());

        System.out.println();
        System.out.println("3)");
        System.out.println(vetor.toString());

        System.out.println();
        System.out.println("4)");
        System.out.println(vetor.busca(1));

        System.out.println();
        System.out.println("5)");
        System.out.println(vetor.busca(new Contato("Teste02", "22222", "TESTE02@TESTE.COM")));

        System.out.println();
        System.out.println("6)");
        vetor.adiciona(2, new Contato("Teste05", "55555", "TESTE05@TESTE.COM"));
        System.out.println(vetor);

        System.out.println();
        System.out.println("7)");
        vetor.aumentaCapacidade();

        System.out.println();
        System.out.println("8)");
        vetor.remove(1);
        System.out.println(vetor);

        System.out.println();
        System.out.println("9)");
        System.out.println(vetor.buscaNome("Teste05"));

        System.out.println();
        System.out.println("10)");
        System.out.println(vetor.buscaEmail("TESTE05@TESTE.COM"));
    }
}