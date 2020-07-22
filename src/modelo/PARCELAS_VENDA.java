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
public class PARCELAS_VENDA {
    private int     Cod_Parcela;              //Chave primária da tabela Parcelas Venda
    private int     Cod_Venda;                //Chave Estrangeira da tabela venda
    private double  valor_parcela;            //Valor que será divido pelo o software
    private String  data_vencimento_parcela;  //Datas de vencimento tentar gerar pelo o software
    private boolean status_pagamento;         //Se está pago ou não pago
    private String  data_pagamento;           //Data que efetuaram o pagamento

    public PARCELAS_VENDA() {
    }

    public PARCELAS_VENDA(int cod_parcela, int cod_venda, double valor_parcela, String data_vencimento_parcela, boolean status_pagamento, String desc_status_pagamento, String data_pagamento) {
        this.Cod_Parcela = cod_parcela;
        this.Cod_Venda = cod_venda;
        this.valor_parcela = valor_parcela;
        this.data_vencimento_parcela = data_vencimento_parcela;
        this.status_pagamento = status_pagamento;
        this.data_pagamento = data_pagamento;
    }

    public int getCod_Parcela() {
        return Cod_Parcela;
    }

    public void setCod_Parcela(int Cod_Parcela) {
        this.Cod_Parcela = Cod_Parcela;
    }

    public int getCod_Venda() {
        return Cod_Venda;
    }

    public void setCod_Venda(int Cod_Venda) {
        this.Cod_Venda = Cod_Venda;
    }

    public double getValor_parcela() {
        return valor_parcela;
    }

    public void setValor_parcela(double valor_parcela) {
        this.valor_parcela = valor_parcela;
    }

    public String getData_vencimento_parcela() {
        return data_vencimento_parcela;
    }

    public void setData_vencimento_parcela(String data_vencimento_parcela) {
        this.data_vencimento_parcela = data_vencimento_parcela;
    }

    public boolean isStatus_pagamento() {
        return status_pagamento;
    }

    public void setStatus_pagamento(boolean status_pagamento) {
        this.status_pagamento = status_pagamento;
    }

    public String getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(String data_pagamento) {
        this.data_pagamento = data_pagamento;
    }
    
    
}
