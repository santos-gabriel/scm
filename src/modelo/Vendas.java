package modelo;

/**
 * @author Gabriel
 */
public class Vendas {
    
    private int codVenda;
    private int codCliente;
    private int codFuncionario;
    private int codCondicaoPagamento;
    private int codTipoPagamento;
    private int codComissao;
    private double valorBruto;
    private double desconto;
    private double valorTotal;
    private boolean finalizada;
    private boolean ativo;

    
    public Vendas(){
    }

    public Vendas(int codVenda, int codCliente, int codFuncionario, int codCondicaoPagamento, int codTipoPagamento, int codComissao, double valorBruto, double desconto, double valorTotal, boolean finalizada, boolean ativo) {
        this.codVenda = codVenda;
        this.codCliente = codCliente;
        this.codFuncionario = codFuncionario;
        this.codCondicaoPagamento = codCondicaoPagamento;
        this.codTipoPagamento = codTipoPagamento;
        this.codComissao = codComissao;
        this.valorBruto = valorBruto;
        this.desconto = desconto;
        this.valorTotal = valorTotal;
        this.finalizada = finalizada;
        this.ativo = ativo;
    }
    
    
    
    public Vendas(int codVenda, int codCliente, int codFuncionario, int codCondicaoPagamento, int codTipoPagamento, int codComissao, double valorBruto, double desconto, double valorTotal, boolean finalizada) {
        this.codVenda = codVenda;
        this.codCliente = codCliente;
        this.codFuncionario = codFuncionario;
        this.codCondicaoPagamento = codCondicaoPagamento;
        this.codTipoPagamento = codTipoPagamento;
        this.codComissao = codComissao;
        this.valorBruto = valorBruto;
        this.desconto = desconto;
        this.valorTotal = valorTotal;
        this.finalizada = finalizada;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public int getCodCondicaoPagamento() {
        return codCondicaoPagamento;
    }

    public void setCodCondicaoPagamento(int codCondicaoPagamento) {
        this.codCondicaoPagamento = codCondicaoPagamento;
    }

    public int getCodTipoPagamento() {
        return codTipoPagamento;
    }

    public void setCodTipoPagamento(int codTipoPagamento) {
        this.codTipoPagamento = codTipoPagamento;
    }

    public int getCodComissao() {
        return codComissao;
    }

    public void setCodComissao(int codComissao) {
        this.codComissao = codComissao;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
    
}
