import java.util.Date;

public abstract class Alerta {
    
    private String id;
    private UnidadeBasicaDeSaude UBS;
    private Date criadoEm;
    private boolean resolvido;

    public Alerta(String id, UnidadeBasicaDeSaude UBS) {
        this.id = id;
        this.UBS = UBS;
        this.criadoEm = new Date();
        this.resolvido = false;
    }

    public void resolver() {
        this.resolvido = true;
    }

    public boolean getResolvido() {
        return resolvido;
    }

    public String getId() {
        return id;
    }

    public UnidadeBasicaDeSaude getUbs() {
        return UBS;
    }

    public Date getCriadoEm() {
        return criadoEm;
    }

    public abstract boolean deveDisparar();
    public abstract String mensagem();
}

