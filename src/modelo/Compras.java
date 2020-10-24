package modelo;

import java.util.Date;

/**
 * @author Gabriel
 */
public class Compras {
    
    private int codCompra;
    private Fornecedor fornecedor;
    private Usuario usuario;
    private String data;
    private Double totalBruto;
    private Double desconto;
    private Double totalLiquido;
    private boolean ativo;

    
    public Compras(){
    }

    public Compras(int codCompra, Fornecedor fornecedor, Usuario usuario, String data, Double totalBruto, Double desconto, Double totalLiquido, boolean ativo) {
        this.codCompra = codCompra;
        this.fornecedor = fornecedor;
        this.usuario = usuario;
        this.data = data;
        this.totalBruto = totalBruto;
        this.desconto = desconto;
        this.totalLiquido = totalLiquido;
        this.ativo = ativo;
    }
    
    
    public Compras(int codCompra, Fornecedor fornecedor, Usuario usuario, String dataCOmpra, Double valorBruto, Double desconto, Double valorLiquido) {
        this.codCompra = codCompra;
        this.fornecedor = fornecedor;
        this.usuario = usuario;
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

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
