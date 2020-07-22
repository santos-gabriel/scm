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
public class CLIENTE {
    private int Cod_Cliente;
    private String Nome_Cliente;
    private String Data_Nascimento_Cliente;
    private String RG_Cliente;
    private String CPF_Cliente;
    private String CNPJ_Cliente;
    private String WhatsApp_Cliente;
    private String Telefone_Cliente;
    private String Endereco_Cliente;

    public CLIENTE() {
    }

    public CLIENTE(int Cod_Cliente, String Nome_Cliente, String Data_Nascimento_Cliente, String RG_Cliente, String CPF_Cliente, String CNPJ_Cliente, String WhatsApp_Cliente, String Telefone_Cliente, String Endereco_Cliente) {
        this.Cod_Cliente = Cod_Cliente;
        this.Nome_Cliente = Nome_Cliente;
        this.Data_Nascimento_Cliente = Data_Nascimento_Cliente;
        this.RG_Cliente = RG_Cliente;
        this.CPF_Cliente = CPF_Cliente;
        this.CNPJ_Cliente = CNPJ_Cliente;
        this.WhatsApp_Cliente = WhatsApp_Cliente;
        this.Telefone_Cliente = Telefone_Cliente;
        this.Endereco_Cliente = Endereco_Cliente;
    }

    public int getCod_Cliente() {
        return Cod_Cliente;
    }

    public void setCod_Cliente(int Cod_Cliente) {
        this.Cod_Cliente = Cod_Cliente;
    }

    public String getNome_Cliente() {
        return Nome_Cliente;
    }

    public void setNome_Cliente(String Nome_Cliente) {
        this.Nome_Cliente = Nome_Cliente;
    }

    public String getData_Nascimento_Cliente() {
        return Data_Nascimento_Cliente;
    }

    public void setData_Nascimento_Cliente(String Data_Nascimento_Cliente) {
        this.Data_Nascimento_Cliente = Data_Nascimento_Cliente;
    }

    public String getRG_Cliente() {
        return RG_Cliente;
    }

    public void setRG_Cliente(String RG_Cliente) {
        this.RG_Cliente = RG_Cliente;
    }

    public String getCPF_Cliente() {
        return CPF_Cliente;
    }

    public void setCPF_Cliente(String CPF_Cliente) {
        this.CPF_Cliente = CPF_Cliente;
    }

    public String getCNPJ_Cliente() {
        return CNPJ_Cliente;
    }

    public void setCNPJ_Cliente(String CNPJ_Cliente) {
        this.CNPJ_Cliente = CNPJ_Cliente;
    }

    public String getWhatsApp_Cliente() {
        return WhatsApp_Cliente;
    }

    public void setWhatsApp_Cliente(String WhatsApp_Cliente) {
        this.WhatsApp_Cliente = WhatsApp_Cliente;
    }

    public String getTelefone_Cliente() {
        return Telefone_Cliente;
    }

    public void setTelefone_Cliente(String Telefone_Cliente) {
        this.Telefone_Cliente = Telefone_Cliente;
    }

    public String getEndereco_Cliente() {
        return Endereco_Cliente;
    }

    public void setEndereco_Cliente(String Endereco_Cliente) {
        this.Endereco_Cliente = Endereco_Cliente;
    }

    
    
}
