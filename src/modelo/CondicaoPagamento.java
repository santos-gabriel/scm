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
public class CondicaoPagamento {
    private int    cod_condicao_pagamento;      //Chave primária
    private String desc_condicao_pagamento;     //Nome para a condição de pagamento
    private int    quantidade_parcelas;         //Quantidade de vezes que essa condição terá
    private boolean ativo;
    
    public CondicaoPagamento() {
    }

    public CondicaoPagamento(int cod_condicao_pagamento, String desc_condicao_pagamento) {
        this.cod_condicao_pagamento = cod_condicao_pagamento;
        this.desc_condicao_pagamento = desc_condicao_pagamento;
    }

    public CondicaoPagamento(int cod_condicao_pagamento, String desc_condicao_pagamento, int quantidade_parcelas, boolean ativo) {
        this.cod_condicao_pagamento = cod_condicao_pagamento;
        this.desc_condicao_pagamento = desc_condicao_pagamento;
        this.quantidade_parcelas = quantidade_parcelas;
        this.ativo = ativo;
    }

    
    
    public CondicaoPagamento(int cod_condicao_pagamento, String desc_condicao_pagamento, int quantidade_parcelas) {
        this.cod_condicao_pagamento = cod_condicao_pagamento;
        this.desc_condicao_pagamento = desc_condicao_pagamento;
        this.quantidade_parcelas = quantidade_parcelas;
    }

    public int getCod_condicao_pagamento() {
        return cod_condicao_pagamento;
    }

    public void setCod_condicao_pagamento(int cod_condicao_pagamento) {
        this.cod_condicao_pagamento = cod_condicao_pagamento;
    }

    public String getDesc_condicao_pagamento() {
        return desc_condicao_pagamento;
    }

    public void setDesc_condicao_pagamento(String desc_condicao_pagamento) {
        this.desc_condicao_pagamento = desc_condicao_pagamento;
    }

    public int getQuantidade_parcelas() {
        return quantidade_parcelas;
    }

    public void setQuantidade_parcelas(int quantidade_parcelas) {
        this.quantidade_parcelas = quantidade_parcelas;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.cod_condicao_pagamento;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CondicaoPagamento other = (CondicaoPagamento) obj;
        if (this.cod_condicao_pagamento != other.cod_condicao_pagamento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return desc_condicao_pagamento;
    }

}
