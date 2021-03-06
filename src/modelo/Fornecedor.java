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
public class Fornecedor {
    private int Cod_Fornecedor;
    private Usuario usuario;
    private Estados estado;
    private Cidades cidade;
    private String Nome_Fornecedor;
    private String CNPJ_Fornecedor;
    private String Inscricao_Municipal;
    private String Endereco_Fornecedor;
    private String Telefone_Fornecedor;
    private boolean ativo;

    public Fornecedor() {
    }

    public Fornecedor(int Cod_Fornecedor, String Nome_Fornecedor) {
        this.Cod_Fornecedor = Cod_Fornecedor;
        this.Nome_Fornecedor = Nome_Fornecedor;
    }
    
    public Fornecedor(int Cod_Fornecedor, Usuario usuario, Estados estado, Cidades cidade, String Nome_Fornecedor, String CNPJ_Fornecedor, String Inscricao_Municipal, String Endereco_Fornecedor, String Telefone_Fornecedor) {
        this.Cod_Fornecedor = Cod_Fornecedor;
        this.usuario = usuario;
        this.estado = estado;
        this.cidade = cidade;
        this.Nome_Fornecedor = Nome_Fornecedor;
        this.CNPJ_Fornecedor = CNPJ_Fornecedor;
        this.Inscricao_Municipal = Inscricao_Municipal;
        this.Endereco_Fornecedor = Endereco_Fornecedor;
        this.Telefone_Fornecedor = Telefone_Fornecedor;
    }
    
    public Fornecedor(int Cod_Fornecedor,  Usuario usuario, Estados estado, Cidades cidade, String Nome_Fornecedor, String CNPJ_Fornecedor, String Inscricao_Municipal, String Endereco_Fornecedor, String Telefone_Fornecedor, boolean ativo) {
        this.Cod_Fornecedor = Cod_Fornecedor;
        this.usuario = usuario;
        this.estado = estado;
        this.cidade = cidade;
        this.Nome_Fornecedor = Nome_Fornecedor;
        this.CNPJ_Fornecedor = CNPJ_Fornecedor;
        this.Inscricao_Municipal = Inscricao_Municipal;
        this.Endereco_Fornecedor = Endereco_Fornecedor;
        this.Telefone_Fornecedor = Telefone_Fornecedor;
        this.ativo = ativo;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public Cidades getCidade() {
        return cidade;
    }

    public void setCidade(Cidades cidade) {
        this.cidade = cidade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.Cod_Fornecedor;
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
        final Fornecedor other = (Fornecedor) obj;
        if (this.Cod_Fornecedor != other.Cod_Fornecedor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Nome_Fornecedor;
    }
    
}
