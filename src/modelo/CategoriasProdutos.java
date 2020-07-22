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

    public CategoriasProdutos() {
    }

    public CategoriasProdutos(int Cod_Categoria, String Desc_Categoria) {
        this.Cod_Categoria = Cod_Categoria;
        this.Desc_Categoria = Desc_Categoria;
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
    
}
