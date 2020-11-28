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
public class Cliente {
    private int Cod_Cliente;
    private Usuario Usuario;
    private String Nome_Cliente;
    private String Data_Nascimento_Cliente;
    private String RG_Cliente;
    private String CPF_Cliente;
    private String CNPJ_Cliente;
    private String WhatsApp_Cliente;
    private String Telefone_Cliente;
    private Cidades Cidade;
    private Estados Estado;
    private String Endereco_Cliente;
    private boolean ativo;
    
    

    public Cliente() {
    }

    public Cliente(int Cod_Cliente) {
        this.Cod_Cliente = Cod_Cliente;
    }

    public Cliente(int Cod_Cliente, Usuario usuario, String Nome_Cliente, String Data_Nascimento_Cliente, String RG_Cliente, String CPF_Cliente, String CNPJ_Cliente, String WhatsApp_Cliente, String Telefone_Cliente, Cidades cidade, Estados estado, String Endereco_Cliente, boolean ativo) {
        this.Cod_Cliente = Cod_Cliente;
        this.Usuario = usuario;
        this.Nome_Cliente = Nome_Cliente;
        this.Data_Nascimento_Cliente = Data_Nascimento_Cliente;
        this.RG_Cliente = RG_Cliente;
        this.CPF_Cliente = CPF_Cliente;
        this.CNPJ_Cliente = CNPJ_Cliente;
        this.WhatsApp_Cliente = WhatsApp_Cliente;
        this.Telefone_Cliente = Telefone_Cliente;
        this.Cidade = cidade;
        this.Estado = estado;
        this.Endereco_Cliente = Endereco_Cliente;
        
        this.ativo = ativo;        
    }

    public int getCod_Cliente() {
        return Cod_Cliente;
    }

    public void setCod_Cliente(int Cod_Cliente) {
        this.Cod_Cliente = Cod_Cliente;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.Usuario = usuario;
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

    public Cidades getCidade() {
        return Cidade;
    }

    public void setCidade(Cidades cidade) {
        this.Cidade = cidade;
    }

    public Estados getEstado() {
        return Estado;
    }

    public void setEstado(Estados estado) {
        this.Estado = estado;
    }

    public String getEndereco_Cliente() {
        return Endereco_Cliente;
    }

    public void setEndereco_Cliente(String Endereco_Cliente) {
        this.Endereco_Cliente = Endereco_Cliente;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    

}
