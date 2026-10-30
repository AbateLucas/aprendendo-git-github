public class Automovel {
    
    private final int quantidadeRodas;
    private final String ambiente;
    private String cor;

    public Automovel(int quantidadeRodas, String ambiente, String cor){

        this.quantidadeRodas = quantidadeRodas;
        this.ambiente = ambiente;
        this.cor = cor;

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
