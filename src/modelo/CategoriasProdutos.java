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
public class CategoriasProdutos {
    private int Cod_Categoria;
    private String Desc_Categoria;
    private boolean ativo;

    public CategoriasProdutos() {
    }

    public CategoriasProdutos(int Cod_Categoria, String Desc_Categoria, boolean ativo) {
        this.Cod_Categoria = Cod_Categoria;
        this.Desc_Categoria = Desc_Categoria;
        this.ativo = ativo;
    }

    
    
    public CategoriasProdutos(int Cod_Categoria, String Desc_Categoria) {
        this.Cod_Categoria = Cod_Categoria;
        this.Desc_Categoria = Desc_Categoria;
    }

    public CategoriasProdutos(int Cod_Categoria) {
        this.Cod_Categoria = Cod_Categoria;
    }
    
    public int getCod_Categoria() {
        return Cod_Categoria;
    }

    public void setCod_Categoria(int Cod_Categoria) {
        this.Cod_Categoria = Cod_Categoria;
    }

    public String getDesc_Categoria() {
        return Desc_Categoria;
    }

    public void setDesc_Categoria(String Desc_Categoria) {
        this.Desc_Categoria = Desc_Categoria;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return this.Desc_Categoria;
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
        final CategoriasProdutos other = (CategoriasProdutos) obj;
        if (this.Cod_Categoria != other.Cod_Categoria) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.Cod_Categoria;
        return hash;
    }

    
    
}
