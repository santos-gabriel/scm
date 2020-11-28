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
public class ReferenciaProduto {
    private int     cod_rastreio_produto;     //Código gerado para cada produto cadastrado na loja
    private Produto produto;              //Chave Estrangeira da tabela produto
    private boolean ativo;
    
    public ReferenciaProduto() {
    }

    public ReferenciaProduto(int cod_rastreio_produto, Produto produto, boolean ativo) {
        this.cod_rastreio_produto = cod_rastreio_produto;
        this.produto = produto;
        this.ativo = ativo;
    }

    public ReferenciaProduto(int cod_rastreio_produto, Produto produto) {
        this.cod_rastreio_produto = cod_rastreio_produto;
        this.produto = produto;
    }

    public int getCod_rastreio_produto() {
        return cod_rastreio_produto;
    }

    public void setCod_rastreio_produto(int cod_rastreio_produto) {
        this.cod_rastreio_produto = cod_rastreio_produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
