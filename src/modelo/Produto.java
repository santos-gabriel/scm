/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Guilherme
 */
public class Produto {
    private int Cod_Produto;
    private CategoriasProdutos Categoria_Produto;
    private Usuario usuario;
    private String Desc_Produto; 
    private Double Valor_Custo;
    private Double Valor_Venda;
    private boolean ativo;
    
    private int auxQuantidade;
    
    public Produto() {
    }

    public Produto(int Cod_Produto, CategoriasProdutos Categoria_Produto, Usuario usuario, String Desc_Produto, Double Valor_Custo, Double Valor_Venda, boolean ativo) {
        this.Cod_Produto = Cod_Produto;
        this.Categoria_Produto = Categoria_Produto;
        this.usuario = usuario;
        this.Desc_Produto = Desc_Produto;
        this.Valor_Custo = Valor_Custo;
        this.Valor_Venda = Valor_Venda;
        this.ativo = ativo;
    }

    
    
    public Produto(int Cod_Produto, CategoriasProdutos Categoria_Produto, Usuario usuario, String Desc_Produto, Double Valor_Custo, Double Valor_Venda) {
        this.Cod_Produto = Cod_Produto;
        this.usuario = usuario;
        this.Desc_Produto = Desc_Produto;
        this.Valor_Custo = Valor_Custo;
        this.Valor_Venda = Valor_Venda;
        this.Categoria_Produto = Categoria_Produto;
    }

    public int getCod_Produto() {
        return Cod_Produto;
    }

    public void setCod_Produto(int Cod_Produto) {
        this.Cod_Produto = Cod_Produto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    public String getDesc_Produto() {
        return Desc_Produto;
    }

    public void setDesc_Produto(String Desc_Produto) {
        this.Desc_Produto = Desc_Produto;
    }

    public Double getValor_Custo() {
        return Valor_Custo;
    }

    public void setValor_Custo(Double Valor_Custo) {
        this.Valor_Custo = Valor_Custo;
    }

    public Double getValor_Venda() {
        return Valor_Venda;
    }

    public void setValor_Venda(Double Valor_Venda) {
        this.Valor_Venda = Valor_Venda;
    }

    public CategoriasProdutos getCategoria_Produto() {
        return Categoria_Produto;
    }

    public void setCategoria_Produto(CategoriasProdutos Categoria_Produto) {
        this.Categoria_Produto = Categoria_Produto;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public int getAuxQuantidade(){
        return this.auxQuantidade;
    }
    
    public void setAuxQuantidade(int quantidade){
        this.auxQuantidade = quantidade;
    }
    
}
