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
public class FUNCIONARIO {
    private int Cod_Funcionario;
    private String Nome_Funcionario;
    private String Data_Nascimento;
    private String Rg_Funcionario;
    private String CPF_Funcionario;
    private String WhatsApp_Funcionario;
    private String Endereco_Funcionario;

    public FUNCIONARIO() {
    }

    public FUNCIONARIO(int Cod_Funcionario, String Nome_Funcionario, String Data_Nascimento, String Rg_Funcionario, String CPF_Funcionario, String WhatsApp_Funcionario, String Endereco_Funcionario) {
        this.Cod_Funcionario = Cod_Funcionario;
        this.Nome_Funcionario = Nome_Funcionario;
        this.Data_Nascimento = Data_Nascimento;
        this.Rg_Funcionario = Rg_Funcionario;
        this.CPF_Funcionario = CPF_Funcionario;
        this.WhatsApp_Funcionario = WhatsApp_Funcionario;
        this.Endereco_Funcionario = Endereco_Funcionario;
    }

    public int getCod_Funcionario() {
        return Cod_Funcionario;
    }

    public void setCod_Funcionario(int Cod_Funcionario) {
        this.Cod_Funcionario = Cod_Funcionario;
    }

    public String getNome_Funcionario() {
        return Nome_Funcionario;
    }

    public void setNome_Funcionario(String Nome_Funcionario) {
        this.Nome_Funcionario = Nome_Funcionario;
    }

    public String getData_Nascimento() {
        return Data_Nascimento;
    }

    public void setData_Nascimento(String Data_Nascimento) {
        this.Data_Nascimento = Data_Nascimento;
    }

    public String getRg_Funcionario() {
        return Rg_Funcionario;
    }

    public void setRg_Funcionario(String Rg_Funcionario) {
        this.Rg_Funcionario = Rg_Funcionario;
    }

    public String getCPF_Funcionario() {
        return CPF_Funcionario;
    }

    public void setCPF_Funcionario(String CPF_Funcionario) {
        this.CPF_Funcionario = CPF_Funcionario;
    }

    public String getWhatsApp_Funcionario() {
        return WhatsApp_Funcionario;
    }

    public void setWhatsApp_Funcionario(String WhatsApp_Funcionario) {
        this.WhatsApp_Funcionario = WhatsApp_Funcionario;
    }

    public String getEndereco_Funcionario() {
        return Endereco_Funcionario;
    }

    public void setEndereco_Funcionario(String Endereco_Funcionario) {
        this.Endereco_Funcionario = Endereco_Funcionario;
    }
    
}
