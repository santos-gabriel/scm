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
    
    public Estados(int codEstado){
        this.codEstado = codEstado;
    }

    public Estados(int codEstado, String descricao){
        this.codEstado = codEstado;
        this.descricao = descricao;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.codEstado;
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
        final Estados other = (Estados) obj;
        if (this.codEstado != other.codEstado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
    
    
}
