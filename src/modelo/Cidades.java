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

    public Cidades(int codCidade, String descricao, boolean ativo) {
        this.codCidade = codCidade;
        this.descricao = descricao;
        this.ativo = ativo;
    }
    
    public Cidades(int codCidade, String descricao) {
        this.codCidade = codCidade;
        this.descricao = descricao;
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
    
}
