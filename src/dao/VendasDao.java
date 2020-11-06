/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import excecoes.ExcecaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.CategoriasProdutos;
import modelo.Cliente;
import modelo.Comissoes;
import modelo.CondicaoPagamento;
import modelo.Funcionario;
import modelo.Produto;
import modelo.TipoPagamento;
import modelo.Vendas;

/**
 *
 * @author Gabriel
 */
public abstract class VendasDao {
    
     
    private static Connection conexao = null;
    
    
    public static Integer Inserir(Vendas prVenda){
        CriarConexoes();
        String sql = "INSERT INTO vendas(cod_venda, cod_cliente, cod_funcionario, cod_condicao_pagamento, cod_tipo_pagamento, "
                + "cod_comissao, valor_bruto, desconto, valor_total, finalizada, ativo, data_venda) "
                + "VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, true, CURRENT_TIMESTAMP)";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, prVenda.getCliente().getCod_Cliente());
            stmt.setInt(2, prVenda.getFuncionario().getCod_Funcionario());
            stmt.setInt(3, prVenda.getCondicaoPagamento().getCod_condicao_pagamento());
            stmt.setInt(4, prVenda.getTipoPagamento().getCod_pagamento());
            stmt.setInt(5, prVenda.getComissao().getCod_comissao());            
            stmt.setDouble(6, prVenda.getValorBruto());
            stmt.setDouble(7, prVenda.getDesconto());
            stmt.setDouble(8, prVenda.getValorTotal());
            stmt.setBoolean(9, prVenda.isFinalizada());
            stmt.executeUpdate();
            ResultSet rsKeys = stmt.getGeneratedKeys();
            if (rsKeys.next())
                return rsKeys.getInt(1);
            else
                return null;
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao salvar venda, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static void AtualizarTotais(Vendas prVenda){
        CriarConexoes();
        String sql = "UPDATE vendas SET "
                + "valor_bruto      = ?, "
                + "desconto         = ?, "
                + "valor_total      = ?  "
                + "WHERE cod_venda  = ? ";
        PreparedStatement stmt = null;
        try {
           stmt = conexao.prepareStatement(sql);
           stmt.setDouble(1, prVenda.getValorBruto());
           stmt.setDouble(2, prVenda.getDesconto());
           stmt.setDouble(3, prVenda.getValorTotal());
           stmt.setInt(4, prVenda.getCodVenda());
           stmt.executeUpdate();
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao atualizar dados da venda, entre em contato com o suporte do sistema");
        } finally{
            FecharConexoes(conexao, stmt, null);
        }
    }    
    
    
    public static List<Produto> PesquisarTodosProdutosDaVenda(Vendas prVenda){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT prod.cod_produto as Codigo, prod.desc_produto as Produto, cat.desc_categoria as Categoria,     "
                    + "      prod.valor_custo as Custo, prod.valor_venda as Venda, COUNT(prod.cod_produto) as Quantidade    "
                    +"FROM   vendas 				vend                                                        "
                    +"INNER JOIN produtos_venda 		prod_vend   ON                                              "
                    +"  prod_vend.cod_venda = vend.cod_venda                                                                "
                    +"INNER JOIN referencia_produto		ref_prod    ON                                              "
                    +"	ref_prod.cod_rastreio_produto = prod_vend.cod_rastreio_produto                                      "
                    +"INNER JOIN produtos			prod        ON                                              "
                    +"	prod.cod_produto = ref_prod.cod_produto                                                             "
                    +"INNER JOIN categorias			cat         ON                                              "
                    +"  cat.cod_categoria = prod.cod_categoria                                                              "
                    +"WHERE ref_prod.ativo = false                                                                          "
                    +"AND   vend.cod_venda = ?                                                                              "
                    +"GROUP BY prod.cod_produto                                                                             ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prVenda.getCodVenda());
            rs = stmt.executeQuery();
            List<Produto> lista = new ArrayList<>();
            while(rs.next()){
                Produto produto = new Produto();
                produto.setCod_Produto(rs.getInt("Codigo"));
                produto.setDesc_Produto(rs.getString("Produto"));
                produto.setCategoria_Produto(new CategoriasProdutos(0, rs.getString("Categoria")));
                produto.setValor_Custo(rs.getDouble("Custo"));
                produto.setValor_Venda(rs.getDouble("Venda"));
                produto.setAuxQuantidade(rs.getInt("Quantidade"));
                lista.add(produto);
            }
            return lista;
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao localizar produtos, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
     
    public static Integer PesquisaQuantidadeDisponivelProduto(Produto prProduto){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(ref_prod.cod_rastreio_produto) AS QUANTIDADE "
                    +"FROM   referencia_produto ref_prod                        "
                    +"WHERE ref_prod.ativo = true                               "
                    +"AND   ref_prod.cod_produto = ?                            ";        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prProduto.getCod_Produto());
            rs = stmt.executeQuery();
            if (rs.next())
                return rs.getInt("QUANTIDADE");
            else 
                return null;            
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao localizar quantidade disponível do produto, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static List<Vendas> PesquisarVendasPorPeriodoFuncionario(String prDataInicial, String prDataFinal, Funcionario prFuncionario){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT v.*, f.nome_funcionario, c.nome_cliente "
                   + "FROM   vendas v "
                   + "INNER JOIN funcionarios f ON "
                   + "  f.cod_funcionario = v.cod_funcionario "
                   + "INNER JOIN clientes c ON "
                   + "	c.cod_cliente = v.cod_cliente "
                   + "WHERE v.data_venda >= ? "
                   + "AND   v.data_venda <= ? ";
        if (!(prFuncionario == null))
            sql += "AND v.cod_funcionario = ? ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDataInicial);
            stmt.setString(2, prDataFinal);
            if (!(prFuncionario == null))
                stmt.setInt(3, prFuncionario.getCod_Funcionario());
            rs = stmt.executeQuery();
            List<Vendas> lista = new ArrayList<>();
            while(rs.next()){
                Vendas venda = new Vendas();
                Cliente cliente = new Cliente();
                cliente.setCod_Cliente(rs.getInt("cod_cliente"));
                cliente.setNome_Cliente(rs.getString("nome_cliente"));
                Funcionario funcionario = new Funcionario();
                funcionario.setCod_Funcionario(rs.getInt("cod_funcionario"));
                funcionario.setNome_Funcionario(rs.getString("nome_funcionario"));
                Comissoes comissao = new Comissoes();
                comissao.setCod_comissao(rs.getInt("cod_comissao"));
                CondicaoPagamento condicao = new CondicaoPagamento();
                condicao.setCod_condicao_pagamento(rs.getInt("cod_condicao_pagamento"));
                TipoPagamento tipoPagamento = new TipoPagamento();
                tipoPagamento.setCod_pagamento(rs.getInt("cod_tipo_pagamento"));
                
                venda.setCodVenda(rs.getInt("cod_venda"));
                venda.setAtivo(rs.getBoolean("ativo"));                
                venda.setCliente(cliente);
                venda.setComissao(comissao);
                venda.setCondicaoPagamento(condicao);
                venda.setDataVenda(rs.getString("data_venda"));
                venda.setDesconto(rs.getDouble("desconto"));
                venda.setFinalizada(rs.getBoolean("finalizada"));
                venda.setFuncionario(funcionario);
                venda.setTipoPagamento(tipoPagamento);
                venda.setValorBruto(rs.getDouble("valor_bruto"));
                venda.setValorTotal(rs.getDouble("valor_total"));                
                
                lista.add(venda);
            }
            return lista;
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao localizar vendas, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    
    private static void CriarConexoes(){
        conexao = Conexao.conectar();
    }
    
    private static void FecharConexoes(Connection conexao, PreparedStatement stmt, ResultSet rs){
        if(conexao != null && stmt == null && rs == null){
            Conexao.desconectar(conexao);
        }else if (stmt != null && rs != null){
            Conexao.desconectar(conexao, stmt, rs);
        }else if(stmt != null && rs == null){
            Conexao.desconectar(conexao, stmt);
        }
    }
    
    
}
