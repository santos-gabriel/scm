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
public class Usuario {
    private int Cod_Usuario;
    private Funcionario Funcionario;
    private String Login;
    private String Senha;
    private boolean ativo;
    
    public Usuario() {
    }

    public Usuario(int Cod_Usuario) {
        this.Cod_Usuario = Cod_Usuario;
    }
    
    public Usuario(int Cod_Usuario, String Login) {
        this.Cod_Usuario = Cod_Usuario;
        this.Login = Login;
    }
    
    public Usuario(int Cod_Usuario, Funcionario funcionario, String Login, String Senha, boolean ativo) {
        this.Cod_Usuario = Cod_Usuario;
        this.Funcionario = funcionario;
        this.Login = Login;
        this.Senha = Senha;
        this.ativo = ativo;
    }

    public Usuario(int Cod_Usuario, String Login, String Senha) {
        this.Cod_Usuario = Cod_Usuario;
        this.Login = Login;
        this.Senha = Senha;
    }
    
    public Usuario(int Cod_Usuario, String Login, Funcionario funcionario) {
        this.Cod_Usuario = Cod_Usuario;
        this.Login = Login;
        this.Funcionario = funcionario;
    }

    
    public Usuario(int Cod_Usuario, Funcionario funcionario, String Login, String Senha) {
        this.Cod_Usuario = Cod_Usuario;
        this.Funcionario = funcionario;
        this.Login = Login;
        this.Senha = Senha;
    }

    public int getCod_Usuario() {
        return Cod_Usuario;
    }

    public void setCod_Usuario(int Cod_Usuario) {
        this.Cod_Usuario = Cod_Usuario;
    }

    public Funcionario getFuncionario() {
        return Funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.Funcionario = funcionario;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
    
}
