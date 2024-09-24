public class VetorContato {
    
    private String[] contatos;
    private int tamanho;
    
    public VetorContato(int capacidade) {
        this.contatos = new String[capacidade];
        this.tamanho = 0;
    }

    public boolean adiciona(Contato contato) {
        if (this.tamanho < this.contatos.length) {
            this.contatos[this.tamanho] = "[Nome: " + contato.getNome() + ", Telefone: " + contato.getTelefone() + ", Email: " + contato.getEmail() + "]";
            this.tamanho++;
            return true;
        }
        return false;
    }
    
    public void aumentaCapacidade() {
        if (this.tamanho == this.contatos.length) {
            String[] contatosNovos = new String[this.contatos.length * 2];
            for (int i = 0; i < this.contatos.length; i++) {
                contatosNovos[i] = this.contatos[i];
            }
            this.contatos = contatosNovos;
        }
    }
    
    public int tamanho() {
        return this.tamanho;
    }
    
    public int busca(Contato contato) {
        String contatoFormatado = "[Nome: " + contato.getNome() + ", Telefone: " + contato.getTelefone() + ", Email: " + contato.getEmail() + "]";
        for (int i = 0; i < this.tamanho; i++) {
            if (this.contatos[i].equals(contatoFormatado)) {
                return i;
            }
        }
        return -1;
    }

    public String busca(int posicao) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        return this.contatos[posicao];
    }
    
    public void remove(int posicao) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.contatos[i] = this.contatos[i + 1];
        }
        this.tamanho--;
    }
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < this.tamanho - 1; i++) {
            s.append(this.contatos[i]);
            s.append(", ");
        }
        if (this.tamanho > 0) {
            s.append(this.contatos[this.tamanho - 1]);
        }
        s.append("]");
        return s.toString();
    }
    
    public boolean adiciona(int posicao, Contato contato) {
        if (!(posicao >= 0 && posicao <= tamanho)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        this.aumentaCapacidade();
        // mover todos os contatos
        for (int i = this.tamanho - 1; i >= posicao; i--) {
            this.contatos[i + 1] = this.contatos[i];
        }
        this.contatos[posicao] = "[Nome: " + contato.getNome() + ", Telefone: " + contato.getTelefone() + ", Email: " + contato.getEmail() + "]";
        this.tamanho++;
        return true;
    }

    public String buscaNome(String nome){
        for (int i = 0; i < this.tamanho; i++) {
            String[] contatoSplit = this.contatos[i].split("Nome: ");
            String[] nomeSplit = contatoSplit[1].split(",");
            String trueNome = nomeSplit[0];
            if(nome.equals(trueNome)){
                return this.contatos[i];
            }
        }
        return null;
    }
    
    public String buscaEmail(String email){
        for (int i = 0; i < this.tamanho; i++) {
            String[] contatoSplit = this.contatos[i].split(", Email: ");
            String[] emailSplit = contatoSplit[1].split("]");
            String trueEmail = emailSplit[0];
            if(email.equals(trueEmail)){
                return this.contatos[i];
            }
        }
        return null;
    }
}