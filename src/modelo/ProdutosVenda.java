package modelo;

/**
 * @author Gabriel
 */
public class ProdutosVenda {
    
    private int codVenda;
    private int codRastreioProduto;
    private boolean ativo;

    public ProdutosVenda(){
    }

    public ProdutosVenda(int codVenda, int codRastreioProduto, boolean ativo) {
        this.codVenda = codVenda;
        this.codRastreioProduto = codRastreioProduto;
        this.ativo = ativo;
    }
    
    
    
    public ProdutosVenda(int codVenda, int codRastreioProduto) {
        this.codVenda = codVenda;
        this.codRastreioProduto = codRastreioProduto;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public int getCodRastreioProduto() {
        return codRastreioProduto;
    }

    public void setCodRastreioProduto(int codRastreioProduto) {
        this.codRastreioProduto = codRastreioProduto;
    }


    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
    
}
