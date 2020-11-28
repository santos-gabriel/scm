package modelo;

/**
 * @author Gabriel
 */
public class Permissoes {
    
    private int codPermissao;
    private String descricao;
    private boolean ativo;
    
    public Permissoes(){
    }

    public Permissoes(int codPermissao, String descricao, boolean ativo) {
        this.codPermissao = codPermissao;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    
    
    public Permissoes(int codPermissao, String descricao) {
        this.codPermissao = codPermissao;
        this.descricao = descricao;
    }

    public int getCodPermissao() {
        return codPermissao;
    }

    public void setCodPermissao(int codPermissao) {
        this.codPermissao = codPermissao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
