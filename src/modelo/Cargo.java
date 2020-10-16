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

    public Cargo(int Cod_Cargo) {
        this.Cod_Cargo = Cod_Cargo;
    }
    
    public Cargo(int Cod_Cargo, String Desc_Cargo) {
        this.Cod_Cargo = Cod_Cargo;
        this.Desc_Cargo = Desc_Cargo;
    }
    
    public Cargo(int Cod_Cargo, String Desc_Cargo, boolean ativo) {
        this.Cod_Cargo = Cod_Cargo;
        this.Desc_Cargo = Desc_Cargo;
        this.ativo = ativo;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.Cod_Cargo;
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
        final Cargo other = (Cargo) obj;
        if (this.Cod_Cargo != other.Cod_Cargo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Desc_Cargo;
    }
    
}
