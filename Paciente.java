public class Paciente extends Pessoa {

    private String cartaoSUS;

    public Paciente (int id, String nome, String cpf, String contato, String cartaoSUS){

        super(id, nome, cpf, contato);
        this.cartaoSUS = cartaoSUS;
    }

    public void setCartaoSUS(String cartaoSUS){

        this.cartaoSUS = cartaoSUS;
    }
}

