public class Moto extends Automovel {
    
    private final String cilindrada;

     public Moto(String cor, String modelo, String cilindradas){

        super(2, "Rodoviario", cor, modelo);
        this.cilindrada = cilindradas;
    }

}
