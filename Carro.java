public class Carro extends Automovel{
    
    private final int quantidadeDePortas;

    public Carro(String cor, String modelo, int quantidadeDePortas){

        super(4, "Rodoviario", cor, modelo);
        this.quantidadeDePortas = quantidadeDePortas;
    }

}
