public class Automovel {
    
    private final int quantidadeRodas;
    private final String ambiente;
    private String cor;
    private final String modelo;


    public Automovel(int quantidadeRodas, String ambiente, String cor, String modelo){

        this.quantidadeRodas = quantidadeRodas;
        this.ambiente = ambiente;
        this.cor = cor;
        this.modelo = modelo;

    }

    public void printar (String cor){

        this.cor = cor;
    }

    public String getCor(){

        return this.cor;
    }

    public int getQuantidadeRodas(){

        return this.quantidadeRodas;
    }
}
