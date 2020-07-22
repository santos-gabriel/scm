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
    private int Cod_Funcionario;
    private String Login;
    private String Senha;

    public Usuario() {
    }

    public Usuario(int Cod_Usuario, int Cod_Funcionario, String Login, String Senha) {
        this.Cod_Usuario = Cod_Usuario;
        this.Cod_Funcionario = Cod_Funcionario;
        this.Login = Login;
        this.Senha = Senha;
    }

    public int getCod_Usuario() {
        return Cod_Usuario;
    }

    public void setCod_Usuario(int Cod_Usuario) {
        this.Cod_Usuario = Cod_Usuario;
    }

    public int getCod_Funcionario() {
        return Cod_Funcionario;
    }

    public void setCod_Funcionario(int Cod_Funcionario) {
        this.Cod_Funcionario = Cod_Funcionario;
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
    
}
