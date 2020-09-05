package modelo;

import java.util.Date;

/**
 * @author Gabriel
 */
public class Compras {
    
    private int codCompra;
    private int codFornecedor;
    private int codUsuario;
    private Date data;
    private Double totalBruto;
    private Double desconto;
    private Double totalLiquido;
    private boolean ativo;

    
    public Compras(){
    }

    public Compras(int codCompra, int codFornecedor, int codUsuario, Date data, Double totalBruto, Double desconto, Double totalLiquido, boolean ativo) {
        this.codCompra = codCompra;
        this.codFornecedor = codFornecedor;
        this.codUsuario = codUsuario;
        this.data = data;
        this.totalBruto = totalBruto;
        this.desconto = desconto;
        this.totalLiquido = totalLiquido;
        this.ativo = ativo;
    }
    
    
    public Compras(int codCompra, int codFornecedor, int codUsuario, Date dataCOmpra, Double valorBruto, Double desconto, Double valorLiquido) {
        this.codCompra = codCompra;
        this.codFornecedor = codFornecedor;
        this.codUsuario = codUsuario;
        this.data = dataCOmpra;
        this.totalBruto = valorBruto;
        this.desconto = desconto;
        this.totalLiquido = valorLiquido;
    }

    public int getCodCompra() {
        return codCompra;
    }

    public void setCodCompra(int codCompra) {
        this.codCompra = codCompra;
    }

    public int getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(int codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getTotalBruto() {
        return totalBruto;
    }

    public void setTotalBruto(Double totalBruto) {
        this.totalBruto = totalBruto;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getTotalLiquido() {
        return totalLiquido;
    }

    public void setTotalLiquido(Double totalLiquido) {
        this.totalLiquido = totalLiquido;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
    
}
