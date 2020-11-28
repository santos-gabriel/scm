package modelo;

/**
 * @author Gabriel
 */
public class ProdutosVenda {
    
    private Vendas venda;
    private ReferenciaProduto rastreioProduto;
    private boolean ativo;

    public ProdutosVenda(){
    }

    public ProdutosVenda(Vendas venda, ReferenciaProduto rastreioProduto) {
        this.venda = venda;
        this.rastreioProduto = rastreioProduto;
    }

    public ProdutosVenda(Vendas venda, ReferenciaProduto rastreioProduto, boolean ativo) {
        this.venda = venda;
        this.rastreioProduto = rastreioProduto;
        this.ativo = ativo;
    }

    public Vendas getVenda() {
        return venda;
    }

    public void setVenda(Vendas venda) {
        this.venda = venda;
    }

    public ReferenciaProduto getRastreioProduto() {
        return rastreioProduto;
    }

    public void setRastreioProduto(ReferenciaProduto rastreioProduto) {
        this.rastreioProduto = rastreioProduto;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    
    
    
}
