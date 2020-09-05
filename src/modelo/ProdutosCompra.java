package modelo;

/**
 * @author Gabriel
 */
public class ProdutosCompra {
    
    private int codCompra;
    private int codRastreioProduto;
    private boolean ativo;

    
    public ProdutosCompra(){
    }

    public ProdutosCompra(int codCompra, int codRastreioProduto, boolean ativo) {
        this.codCompra = codCompra;
        this.codRastreioProduto = codRastreioProduto;
        this.ativo = ativo;
    }
    
    
    public ProdutosCompra(int codCompra, int codProduto) {
        this.codCompra = codCompra;
        this.codRastreioProduto = codProduto;
    }

    public int getCodCompra() {
        return codCompra;
    }

    public void setCodCompra(int codCompra) {
        this.codCompra = codCompra;
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
