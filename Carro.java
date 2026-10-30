public class Carro extends Automovel{
    
    private final String modelo;
    private double gasolinaRestante;

    public Carro(String cor, String modelo){

        super(4, "Terrestre", cor);
        this.modelo = modelo;

    }

    public void abastecer (int quantidade){

        this.gasolinaRestante += quantidade;
    }


}
