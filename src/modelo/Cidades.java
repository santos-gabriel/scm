package modelo;

/**
 * @author Gabriel
 */
public class Cidades {
    
    private int codCidade;
    private String descricao;
    private boolean ativo;
    
    public Cidades(){
    }

    public Cidades(int codCidade) {
        this.codCidade = codCidade;
    }
    
    public Cidades(int codCidade, String descricao) {
        this.codCidade = codCidade;
        this.descricao = descricao;
    }
    
    public Cidades(int codCidade, String descricao, boolean ativo) {
        this.codCidade = codCidade;
        this.descricao = descricao;
        this.ativo = ativo;
    }
    
    public int getCodCidade() {
        return codCidade;
    }

    public void setCodCidade(int codCidade) {
        this.codCidade = codCidade;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.codCidade;
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
        final Cidades other = (Cidades) obj;
        if (this.codCidade != other.codCidade) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
    
    
}
