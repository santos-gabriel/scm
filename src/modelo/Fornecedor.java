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
public class Fornecedor {
    private int Cod_Fornecedor;
    private String Nome_Fornecedor;
    private String CNPJ_Fornecedor;
    private String Inscricao_Municipal;
    private String Endereco_Fornecedor;
    private String Telefone_Fornecedor;

    public Fornecedor() {
    }

    public Fornecedor(int Cod_Fornecedor, String Nome_Fornecedor, String CNPJ_Fornecedor, String Inscricao_Municipal, String Endereco_Fornecedor, String Telefone_Fornecedor) {
        this.Cod_Fornecedor = Cod_Fornecedor;
        this.Nome_Fornecedor = Nome_Fornecedor;
        this.CNPJ_Fornecedor = CNPJ_Fornecedor;
        this.Inscricao_Municipal = Inscricao_Municipal;
        this.Endereco_Fornecedor = Endereco_Fornecedor;
        this.Telefone_Fornecedor = Telefone_Fornecedor;
    }

    public int getCod_Fornecedor() {
        return Cod_Fornecedor;
    }

    public void setCod_Fornecedor(int Cod_Fornecedor) {
        this.Cod_Fornecedor = Cod_Fornecedor;
    }

    public String getNome_Fornecedor() {
        return Nome_Fornecedor;
    }

    public void setNome_Fornecedor(String Nome_Fornecedor) {
        this.Nome_Fornecedor = Nome_Fornecedor;
    }

    public String getCNPJ_Fornecedor() {
        return CNPJ_Fornecedor;
    }

    public void setCNPJ_Fornecedor(String CNPJ_Fornecedor) {
        this.CNPJ_Fornecedor = CNPJ_Fornecedor;
    }

    public String getInscricao_Municipal() {
        return Inscricao_Municipal;
    }

    public void setInscricao_Municipal(String Inscricao_Municipal) {
        this.Inscricao_Municipal = Inscricao_Municipal;
    }

    public String getEndereco_Fornecedor() {
        return Endereco_Fornecedor;
    }

    public void setEndereco_Fornecedor(String Endereco_Fornecedor) {
        this.Endereco_Fornecedor = Endereco_Fornecedor;
    }

    public String getTelefone_Fornecedor() {
        return Telefone_Fornecedor;
    }

    public void setTelefone_Fornecedor(String Telefone_Fornecedor) {
        this.Telefone_Fornecedor = Telefone_Fornecedor;
    }
    
}
