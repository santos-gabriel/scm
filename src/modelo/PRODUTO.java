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
    private String Desc_Produto; 
    private Double Valor_Custo;
    private Double Valor_Venda;
    private int Cod_Categoria_Produto;

    public Produto() {
    }

    public Produto(int Cod_Produto, String Desc_Produto, Double Valor_Custo, Double Valor_Venda, int Cod_Categoria_Produto) {
        this.Cod_Produto = Cod_Produto;
        this.Desc_Produto = Desc_Produto;
        this.Valor_Custo = Valor_Custo;
        this.Valor_Venda = Valor_Venda;
        this.Cod_Categoria_Produto = Cod_Categoria_Produto;
    }

    public int getCod_Produto() {
        return Cod_Produto;
    }

    public void setCod_Produto(int Cod_Produto) {
        this.Cod_Produto = Cod_Produto;
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

    public int getCod_Categoria_Produto() {
        return Cod_Categoria_Produto;
    }

    public void setCod_Categoria_Produto(int Cod_Categoria_Produto) {
        this.Cod_Categoria_Produto = Cod_Categoria_Produto;
    }
    
    
}
