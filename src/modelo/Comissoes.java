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
public class Comissoes {
    private int cod_comissao;         
    private double valor_comisssao;      
    private String unidade_medida;
    private boolean ativo;

    public Comissoes() {
    }

    public Comissoes(int cod_comissao, double valor_comisssao, String unidade_medida, boolean ativo) {
        this.cod_comissao = cod_comissao;
        this.valor_comisssao = valor_comisssao;
        this.unidade_medida = unidade_medida;
        this.ativo = ativo;
    }
    
    public Comissoes(int cod_comissao, double valor_comisssao, String unidade_medida) {
        this.cod_comissao = cod_comissao;
        this.valor_comisssao = valor_comisssao;
        this.unidade_medida = unidade_medida;
    }
    
    public int getCod_comissao() {
        return cod_comissao;
    }

    public void setCod_comissao(int cod_comissao) {
        this.cod_comissao = cod_comissao;
    }

    public double getValor_comisssao() {
        return valor_comisssao;
    }

    public void setValor_comisssao(double valor_comisssao) {
        this.valor_comisssao = valor_comisssao;
    }

    public String getUnidade_medida() {
        return unidade_medida;
    }

    public void setUnidade_medida(String unidade_medida) {
        this.unidade_medida = unidade_medida;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
