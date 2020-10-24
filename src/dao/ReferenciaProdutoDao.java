package dao;

import conexao.Conexao;
import excecoes.ExcecaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        String sql = "UPDATE referencia_produto SET ativo = ?;";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setBoolean(1, prReferenciaProduto.isAtivo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao atualizar referencia, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
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
