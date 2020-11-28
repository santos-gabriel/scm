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
import modelo.Produto;
import modelo.ReferenciaProduto;

/**
 * @author Gabriel
 */
public abstract class ReferenciaProdutoDao {
    
    private static Connection conexao = null;
    
    public static Integer Inserir(ReferenciaProduto prReferenciaProduto){
        CriarConexoes();
        String sql = "INSERT INTO referencia_produto(cod_rastreio_produto, cod_produto, ativo) VALUES (null, ?, true)";
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, prReferenciaProduto.getProduto().getCod_Produto());
            stmt.executeUpdate();
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next())
                return keys.getInt(1);
            else
                return null;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao salvar referencia, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static void Atualizar(ReferenciaProduto prReferenciaProduto){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE referencia_produto SET ativo = ? WHERE cod_rastreio_produto = ?;";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setBoolean(1, prReferenciaProduto.isAtivo());
            stmt.setInt(2, prReferenciaProduto.getCod_rastreio_produto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao atualizar referencia, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static List<ReferenciaProduto> PesquisaTodosAtivosViaCodProduto(Produto prProduto){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM referencia_produto ref_prod WHERE ref_prod.ativo = true AND ref_prod.cod_produto = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prProduto.getCod_Produto());
            rs = stmt.executeQuery();
            List<ReferenciaProduto> lista = new ArrayList<>();
            while(rs.next()){
                ReferenciaProduto refProd = new ReferenciaProduto();
                refProd.setCod_rastreio_produto(rs.getInt("cod_rastreio_produto"));
                lista.add(refProd);
            }
            return lista;
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao localizar produtos, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static List<ReferenciaProduto> PesquisaAtivosViaCodProduto(Produto prProduto, Integer prQuantidade){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT   ref_prod.* "
                   + "FROM     referencia_produto ref_prod "
                   + "WHERE    ref_prod.ativo = true "
                   + "AND      ref_prod.cod_produto = ? "
                   + "ORDER BY ref_prod.cod_rastreio_produto ASC "
                   + "LIMIT ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prProduto.getCod_Produto());
            stmt.setInt(2, prQuantidade);
            rs = stmt.executeQuery();
            List<ReferenciaProduto> lista = new ArrayList<>();
            while(rs.next()){
                ReferenciaProduto refProd = new ReferenciaProduto();
                refProd.setCod_rastreio_produto(rs.getInt("cod_rastreio_produto"));
                lista.add(refProd);
            }
            return lista;
        } catch (Exception e) {
            throw new ExcecaoDB(e, "Falha ao localizar produtos, entre em contato com o suporte do sistema ");
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
