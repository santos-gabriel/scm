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
public class Cargo {
    private int Cod_Cargo;
    private String Desc_Cargo;
    private boolean ativo;

    public Cargo() {
    }

    public Cargo(int Cod_Cargo, String Desc_Cargo, boolean ativo) {
        this.Cod_Cargo = Cod_Cargo;
        this.Desc_Cargo = Desc_Cargo;
        this.ativo = ativo;
    }

    public Cargo(int Cod_Cargo, String Desc_Cargo) {
        this.Cod_Cargo = Cod_Cargo;
        this.Desc_Cargo = Desc_Cargo;
    }

    public int getCod_Cargo() {
        return Cod_Cargo;
    }

    public void setCod_Cargo(int Cod_Cargo) {
        this.Cod_Cargo = Cod_Cargo;
    }

    public String getDesc_Cargo() {
        return Desc_Cargo;
    }

    public void setDesc_Cargo(String Desc_Cargo) {
        this.Desc_Cargo = Desc_Cargo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
