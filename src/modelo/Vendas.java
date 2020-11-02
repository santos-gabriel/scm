package modelo;

/**
 * @author Gabriel
 */
public class Vendas {
    
    private int codVenda;
    private Cliente cliente;
    private Funcionario funcionario;
    private CondicaoPagamento condicaoPagamento;
    private TipoPagamento tipoPagamento;
    private Comissoes comissao;
    private double valorBruto;
    private double desconto;
    private double valorTotal;
    private boolean finalizada;
    private boolean ativo;
    private String dataVenda;
    
    public Vendas(){
    }

    public Vendas(int codVenda, Cliente cliente, Funcionario funcionario, CondicaoPagamento condicaoPagamento, TipoPagamento tipoPagamento, Comissoes comissao, double valorBruto, double desconto, double valorTotal, String dataVenda, boolean finalizada) {
        this.codVenda = codVenda;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.condicaoPagamento = condicaoPagamento;
        this.tipoPagamento = tipoPagamento;
        this.comissao = comissao;
        this.valorBruto = valorBruto;
        this.desconto = desconto;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
        this.finalizada = finalizada;
    }

    public Vendas(int codVenda, Cliente cliente, Funcionario funcionario, CondicaoPagamento condicaoPagamento, TipoPagamento tipoPagamento, Comissoes comissao, double valorBruto, double desconto, double valorTotal, String dataVenda, boolean finalizada, boolean ativo) {
        this.codVenda = codVenda;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.condicaoPagamento = condicaoPagamento;
        this.tipoPagamento = tipoPagamento;
        this.comissao = comissao;
        this.valorBruto = valorBruto;
        this.desconto = desconto;
        this.valorTotal = valorTotal;
        this.finalizada = finalizada;
        this.dataVenda = dataVenda;
        this.ativo = ativo;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public CondicaoPagamento getCondicaoPagamento() {
        return condicaoPagamento;
    }

    public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
        this.condicaoPagamento = condicaoPagamento;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Comissoes getComissao() {
        return comissao;
    }

    public void setComissao(Comissoes comissao) {
        this.comissao = comissao;
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

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }
    
    
}
