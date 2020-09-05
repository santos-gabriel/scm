package modelo;

import java.util.Date;

/**
 * @author Gabriel
 */
public class Caixa {
    
    private int codCaixa;
    private int codUsuario;
    private Date fechamentoData;
    private Double valor;
    private boolean ativo;

    public Caixa(){
    }

    public Caixa(int codCaixa, int codUsuario, Date fechamentoData, Double valor, boolean ativo) {
        this.codCaixa = codCaixa;
        this.codUsuario = codUsuario;
        this.fechamentoData = fechamentoData;
        this.valor = valor;
        this.ativo = ativo;
    }
    
    public Caixa(int codCaixa, int codUsuario, Date fechamentoData, Double valor) {
        this.codCaixa = codCaixa;
        this.codUsuario = codUsuario;
        this.fechamentoData = fechamentoData;
        this.valor = valor;
    }

    public int getCodCaixa() {
        return codCaixa;
    }

    public void setCodCaixa(int codCaixa) {
        this.codCaixa = codCaixa;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Date getFechamentoData() {
        return fechamentoData;
    }

    public void setFechamentoData(Date fechamentoData) {
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
