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
public class TipoPagamento {
    private int    cod_pagamento;
    private String desc_pagamento;
    private boolean ativo;
    

    public TipoPagamento() {
    }

    public TipoPagamento(int cod_pagamento, String desc_pagamento, boolean ativo) {
        this.cod_pagamento = cod_pagamento;
        this.desc_pagamento = desc_pagamento;
        this.ativo = ativo;
    }

    
    
    public TipoPagamento(int cod_pagamento, String desc_pagamento) {
        this.cod_pagamento = cod_pagamento;
        this.desc_pagamento = desc_pagamento;
    }

    public int getCod_pagamento() {
        return cod_pagamento;
    }

    public void setCod_pagamento(int cod_pagamento) {
        this.cod_pagamento = cod_pagamento;
    }

    public String getDesc_pagamento() {
        return desc_pagamento;
    }

    public void setDesc_pagamento(String desc_pagamento) {
        this.desc_pagamento = desc_pagamento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.cod_pagamento;
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
        final TipoPagamento other = (TipoPagamento) obj;
        if (this.cod_pagamento != other.cod_pagamento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return desc_pagamento;
    }
       
    
}
