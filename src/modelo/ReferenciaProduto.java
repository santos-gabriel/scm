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
    private int     cod_produto;              //Chave Estrangeira da tabela produto
    private boolean ativo;
    
    public ReferenciaProduto() {
    }

    public ReferenciaProduto(int cod_rastreio_produto, int cod_produto, boolean ativo) {
        this.cod_rastreio_produto = cod_rastreio_produto;
        this.cod_produto = cod_produto;
        this.ativo = ativo;
    }

    public ReferenciaProduto(int cod_rastreio_produto, int cod_produto) {
        this.cod_rastreio_produto = cod_rastreio_produto;
        this.cod_produto = cod_produto;
    }

    public int getCod_rastreio_produto() {
        return cod_rastreio_produto;
    }

    public void setCod_rastreio_produto(int cod_rastreio_produto) {
        this.cod_rastreio_produto = cod_rastreio_produto;
    }

    public int getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
