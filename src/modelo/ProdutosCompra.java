package modelo;

/**
 * @author Gabriel
 */
public class ProdutosCompra {
    
    private Compras compra;
    private ReferenciaProduto rastreioProduto;
    private boolean ativo;

    
    public ProdutosCompra(){
    }

    public ProdutosCompra(Compras compra, ReferenciaProduto rastreioProduto, boolean ativo) {
        this.compra = compra;
        this.rastreioProduto = rastreioProduto;
        this.ativo = ativo;
    }
    
    
    public ProdutosCompra(Compras compra, ReferenciaProduto rastreioProduto) {
        this.compra = compra;
        this.rastreioProduto = rastreioProduto;
    }

    public Compras getCompra() {
        return compra;
    }

    public void setCompra(Compras compra) {
        this.compra = compra;
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
