public abstract class Funcionario extends Pessoa {

    private String matricula;
    private UnidadeBasicaDeSaude lotacao;

    public Funcionario(int id, String nome, String cpf, String contato, String matricula, UnidadeBasicaDeSaude lotacao){

        super(id, nome, cpf, contato);
        this.matricula = matricula;
        this.lotacao = lotacao;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setLotacao(UnidadeBasicaDeSaude lotacao) {
        this.lotacao = lotacao;
    }

    public String getMatricula() {
        return matricula;
    }

    public UnidadeBasicaDeSaude getLotacao() {
        return lotacao;
    }

    public String enderecoContato(){

        return String.format("Nome: %s%nCPF: %s%nContato: %s%nLotacao: %s%n", getNome(), getCpf(), getContato(), getLotacao());
    }

    public abstract boolean podeAutorizar(Movimentacao m);
    
}
