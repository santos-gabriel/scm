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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.CategoriasProdutos;
import modelo.Compras;
import modelo.Fornecedor;
import modelo.Produto;
import modelo.Usuario;

/**
 *
 * @author Gabriel
 */
public abstract class ComprasDao {
     
    private static Connection conexao = null;
    
    public static Integer Inserir (Compras prCompra){
        CriarConexoes();
        String sql = "INSERT INTO compras(cod_fornecedor, cod_usuario, data, total_bruto, desconto, total_liquido, ativo) VALUES(?, ?, CURRENT_TIMESTAMP, ?, ?, ?, true)";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, prCompra.getFornecedor().getCod_Fornecedor());
            stmt.setInt(2, prCompra.getUsuario().getCod_Usuario());
            stmt.setDouble(3, prCompra.getTotalBruto());
            stmt.setDouble(4, prCompra.getDesconto());
            stmt.setDouble(5, prCompra.getTotalLiquido());
            stmt.executeUpdate();
            ResultSet rsKeys = stmt.getGeneratedKeys();
            if (rsKeys.next())
                return rsKeys.getInt(1);
            else
                return null;

        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao salvar compra, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static void AtualizarTotais(Compras prCompra){
        CriarConexoes();
        String sql = "UPDATE compras SET "
                + "total_bruto      = ?, "
                + "desconto         = ?, "
                + "total_liquido    = ?  "
                + "WHERE cod_compra = ? ";
        PreparedStatement stmt = null;
        try {
           stmt = conexao.prepareStatement(sql);
           stmt.setDouble(1, prCompra.getTotalBruto());
           stmt.setDouble(2, prCompra.getDesconto());
           stmt.setDouble(3, prCompra.getTotalLiquido());
           stmt.setInt(4, prCompra.getCodCompra());
           stmt.executeUpdate();
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao atualizar dados da compra, entre em contato com o suporte do sistema");
        } finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static List<Produto> PesquisarTodosProdutosDaCompra(Compras prCompra){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = 
                  "SELECT   prod.cod_produto as Codigo, prod.desc_produto as Produto, cat.desc_categoria as Categoria,      "
                + "         prod.valor_custo as Custo, prod.valor_venda as Venda, COUNT(prod.cod_produto) as Quantidade     "
                + "FROM   compras 				comp                                                        "
                + "INNER JOIN produto_compra     		prod_comp 	ON                                          "
                + "	prod_comp.cod_compra = comp.cod_compra                                                              "
                + "INNER JOIN referencia_produto 		ref_prod 	ON                                          "
                + "	ref_prod.cod_rastreio_produto = prod_comp.cod_rastreio_produto                                      "
                + "INNER JOIN produtos 		  		prod 		ON                                          "
                + "	prod.cod_produto = ref_prod.cod_produto                                                             "
                + "INNER JOIN categorias 	      		cat   		ON                                          "
                + "	cat.cod_categoria = prod.cod_categoria                                                              "
                + "WHERE ref_prod.ativo = true                                                                              "
                + "AND   comp.cod_compra = ?                                                                                "
                + "GROUP BY prod.cod_produto, prod.desc_produto, prod.valor_custo, prod.valor_venda                         ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCompra.getCodCompra());
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
            throw new ExcecaoDB(e, "Falha ao localizar comissões, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static List<Compras> PesquisarVendasPorPeriodoFuncionario(String prDataInicial, String prDataFinal, Fornecedor prFornecedor){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = 
                  "SELECT c.*, u.login, f.nome_fornecedor       "
                + "FROM   compras c                             "
                + "INNER JOIN fornecedores f ON                 "
                + "     f.cod_fornecedor = c.cod_fornecedor     "
                + "INNER JOIN usuarios u ON                     "
                + "     u.cod_usuario = c.cod_usuario           "
                + "WHERE c.data >= ?                            "
                + "AND   c.data <= ?                            ";
        if (prFornecedor != null)
            sql += "AND c.cod_fornecedor = ?                    ";        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDataInicial);
            stmt.setString(2, prDataFinal);
            if (prFornecedor != null)
                stmt.setInt(3, prFornecedor.getCod_Fornecedor());
            rs = stmt.executeQuery();
            List<Compras> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Compras(rs.getInt("cod_compra"), 
                        new Fornecedor(rs.getInt("cod_fornecedor"), rs.getString("nome_fornecedor")), 
                        new Usuario(rs.getInt("cod_usuario"), rs.getString("login")), 
                        rs.getString("data"), 
                        rs.getDouble("total_bruto"), 
                        rs.getDouble("desconto"), 
                        rs.getDouble("total_liquido"),
                        rs.getBoolean("ativo")));                
            }
            return lista;
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao localizar compras, entre em contato com o suporte do sistema ");
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
