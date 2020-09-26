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
public class Funcionario {
    private int Cod_Funcionario;
    private Cargo cargo;
    private String Nome_Funcionario;
    private String Data_Nascimento;
    private String Rg_Funcionario;
    private String CPF_Funcionario;
    private String WhatsApp_Funcionario;
    private Cidades cidade;
    private Estados estado;
    private String Endereco_Funcionario;
    private boolean ativo;
    private Usuario usuarioCadastro;

    public Funcionario() {
    }
    
    public Funcionario(int Cod_Funcionario){
        this.Cod_Funcionario = Cod_Funcionario;
    }
    
    public Funcionario(String nome){
        this.Nome_Funcionario = nome;
    }
    
    public Funcionario(int Cod_Funcionario, Cargo cargo, String Nome_Funcionario, String Data_Nascimento, String Rg_Funcionario, String CPF_Funcionario, String WhatsApp_Funcionario, Cidades cidade, Estados estado, String Endereco_Funcionario) {
        this.Cod_Funcionario = Cod_Funcionario;
        this.cargo = cargo;
        this.Nome_Funcionario = Nome_Funcionario;
        this.Data_Nascimento = Data_Nascimento;
        this.Rg_Funcionario = Rg_Funcionario;
        this.CPF_Funcionario = CPF_Funcionario;
        this.WhatsApp_Funcionario = WhatsApp_Funcionario;
        this.cidade = cidade;
        this.estado = estado;
        this.Endereco_Funcionario = Endereco_Funcionario;
    }
    
    public Funcionario(int Cod_Funcionario, Cargo cargo, String Nome_Funcionario, String Data_Nascimento, String Rg_Funcionario, String CPF_Funcionario, String WhatsApp_Funcionario, Cidades cidade, Estados estado, String Endereco_Funcionario, boolean ativo) {
        this.Cod_Funcionario = Cod_Funcionario;
        this.cargo = cargo;
        this.Nome_Funcionario = Nome_Funcionario;
        this.Data_Nascimento = Data_Nascimento;
        this.Rg_Funcionario = Rg_Funcionario;
        this.CPF_Funcionario = CPF_Funcionario;
        this.WhatsApp_Funcionario = WhatsApp_Funcionario;
        this.cidade = cidade;
        this.estado = estado;
        this.Endereco_Funcionario = Endereco_Funcionario;
        this.ativo = ativo;
    }

    public Funcionario(int Cod_Funcionario, Cargo cargo, String Nome_Funcionario, String Data_Nascimento, String Rg_Funcionario, String CPF_Funcionario, String WhatsApp_Funcionario, Cidades cidade, Estados estado, String Endereco_Funcionario, boolean ativo, Usuario usuarioCadastro) {
        this.Cod_Funcionario = Cod_Funcionario;
        this.cargo = cargo;
        this.Nome_Funcionario = Nome_Funcionario;
        this.Data_Nascimento = Data_Nascimento;
        this.Rg_Funcionario = Rg_Funcionario;
        this.CPF_Funcionario = CPF_Funcionario;
        this.WhatsApp_Funcionario = WhatsApp_Funcionario;
        this.cidade = cidade;
        this.estado = estado;
        this.Endereco_Funcionario = Endereco_Funcionario;
        this.ativo = ativo;
        this.usuarioCadastro = usuarioCadastro;
    }

    public int getCod_Funcionario() {
        return Cod_Funcionario;
    }

    public void setCod_Funcionario(int Cod_Funcionario) {
        this.Cod_Funcionario = Cod_Funcionario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
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

    public Cidades getCidade() {
        return cidade;
    }

    public void setCidade(Cidades cidade) {
        this.cidade = cidade;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public String getEndereco_Funcionario() {
        return Endereco_Funcionario;
    }

    public void setEndereco_Funcionario(String Endereco_Funcionario) {
        this.Endereco_Funcionario = Endereco_Funcionario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Usuario getUsuarioCadastro() {
        return usuarioCadastro;
    }

    public void setUsuarioCadastro(Usuario usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }

}
