package dao;

import conexao.Conexao;
import excecoes.ExcecaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.TipoPagamento;

/**
 * @author Gabriel
 */
public class TipoPagamentoDao {
    
    private static Connection conexao = null;
    
    public static void SalvarTodosCampos (TipoPagamento prTipoPagamento){
        CriarConexoes();
        String sql = "";
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement(sql);
            // stmt.setString();
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao salvar tipo de pagamento, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static void AtualizarTodosCampos(TipoPagamento prTipoPagamento){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "";
        try {
            stmt = conexao.prepareStatement(sql);
            // stmt.setString();
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao atualizar tipo de pagamento, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static void Excluir(Integer prCodigo){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao excluir tipo de pagamento, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    
    public static TipoPagamento PesquisarViaCodigo(Integer prCodigo){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigo);
            rs = stmt.executeQuery();
            if (rs.next())
                return new TipoPagamento();
            else
                return null;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar tipo de pagamento pelo código, entre em contato com o suporte do sistema ");
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
