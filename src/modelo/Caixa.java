package modelo;

/**
 * @author Gabriel
 */
public class Caixa {
    
    private int codCaixa;
    private Usuario usuario;
    private String fechamentoData;
    private Double valor;
    private boolean ativo;

    public Caixa(){
    }

    public Caixa(int codCaixa, Usuario usuario, String fechamentoData, Double valor) {
        this.codCaixa = codCaixa;
        this.usuario = usuario;
        this.fechamentoData = fechamentoData;
        this.valor = valor;
    }

    public Caixa(int codCaixa, Usuario usuario, String fechamentoData, Double valor, boolean ativo) {
        this.codCaixa = codCaixa;
        this.usuario = usuario;
        this.fechamentoData = fechamentoData;
        this.valor = valor;
        this.ativo = ativo;
    }

    public int getCodCaixa() {
        return codCaixa;
    }

    public void setCodCaixa(int codCaixa) {
        this.codCaixa = codCaixa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getFechamentoData() {
        return fechamentoData;
    }

    public void setFechamentoData(String fechamentoData) {
        this.fechamentoData = fechamentoData;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
