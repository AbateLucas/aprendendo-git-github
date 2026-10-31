public class AlertaEstoqueBaixo extends Alerta {
    private String parametro;
    private int saldoAtual;
    private int limiteMinimo;

    public AlertaEstoqueBaixo(String id, UnidadeBasicaDeSaude ubs, String parametro, int saldoAtual, int limiteMinimo) {
        super(id, ubs);
        this.parametro = parametro;
        this.saldoAtual = saldoAtual;
        this.limiteMinimo = limiteMinimo;
    }

    @Override
    public boolean deveDisparar() {
        return saldoAtual < limiteMinimo;
    }

    @Override
    public String mensagem() {
        return "ALERTA: Estoque baixo para " + parametro + "! Saldo atual: " + saldoAtual + " (Mínimo: " + limiteMinimo + ")";
    }
}