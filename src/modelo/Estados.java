package modelo;

/**
 * @author Gabriel
 */
public class Estados {
    
    private int codEstado;
    private String descricao;
    private String uf;
    private boolean ativo;
    
    
    public Estados (){
    }

    public Estados(int codEstado, String descricao, String uf, boolean ativo) {
        this.codEstado = codEstado;
        this.descricao = descricao;
        this.uf = uf;
        this.ativo = ativo;
    }

    public Estados(int codEstado, String descricao, String uf) {
        this.codEstado = codEstado;
        this.descricao = descricao;
        this.uf = uf;
    }

    public int getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(int codEstado) {
        this.codEstado = codEstado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
