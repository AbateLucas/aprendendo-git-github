public abstract class Pessoa {

    private int id;
    private String nome;
    private  String cpf;
    private String contato;

    public Pessoa(int id, String nome, String cpf, String contato) {

        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.contato = contato;
    }
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getContato() {
        return contato;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }


}
