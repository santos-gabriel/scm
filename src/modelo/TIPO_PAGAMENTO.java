/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

/**
 *
 * @author Guilherme
 */
public class TIPO_PAGAMENTO {
    private int    cod_pagamento;
    private String desc_pagamento;

    public TIPO_PAGAMENTO() {
    }

    public TIPO_PAGAMENTO(int cod_pagamento, String desc_pagamento) {
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
    
    
}
