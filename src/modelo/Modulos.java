package modelo;

/**
 * @author Gabriel
 */
public class Modulos {
    private int codModulo;
    private String descricao;
    private boolean ativo;

    public Modulos() {
    }

    public Modulos(int codModulo, String descricao, boolean ativo) {
        this.codModulo = codModulo;
        this.descricao = descricao;
        this.ativo = ativo;
    }
    
    public Modulos(int codModulo, String descricao) {
        this.codModulo = codModulo;
        this.descricao = descricao;
    }

    public int getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(int codModulo) {
        this.codModulo = codModulo;
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
