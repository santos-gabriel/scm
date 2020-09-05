package modelo;

/**
 * @author Gabriel
 */
public class PermissaoUsuario {
    
    private int codPermissaoUsuario;
    private int codUsuario;
    private int codModulo;
    private int codPermissao;
    private boolean ativo;

    
    public PermissaoUsuario(){
    }

    public PermissaoUsuario(int codPermissaoUsuario, int codUsuario, int codModulo, int codPermissao, boolean ativo) {
        this.codPermissaoUsuario = codPermissaoUsuario;
        this.codUsuario = codUsuario;
        this.codModulo = codModulo;
        this.codPermissao = codPermissao;
        this.ativo = ativo;
    }
    
    
    public PermissaoUsuario(int codPermissaoUsuario, int codUsuario, int codModulo, int codPermissao) {
        this.codPermissaoUsuario = codPermissaoUsuario;
        this.codUsuario = codUsuario;
        this.codModulo = codModulo;
        this.codPermissao = codPermissao;
    }

    public int getCodPermissaoUsuario() {
        return codPermissaoUsuario;
    }

    public void setCodPermissaoUsuario(int codPermissaoUsuario) {
        this.codPermissaoUsuario = codPermissaoUsuario;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public int getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(int codModulo) {
        this.codModulo = codModulo;
    }

    public int getCodPermissao() {
        return codPermissao;
    }

    public void setCodPermissao(int codPermissao) {
        this.codPermissao = codPermissao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
    
}
