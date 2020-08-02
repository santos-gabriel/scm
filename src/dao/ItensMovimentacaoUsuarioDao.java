package dao;

import conexao.Conexao;
import excecoes.ExcecaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.ItensMovimentacaoUsuario;

/**
 * @author Gabriel
 */
public class ItensMovimentacaoUsuarioDao {
    
    private static Connection conexao = null;
        
    public static void SalvarTodosCampos (ItensMovimentacaoUsuario prItensMovimentacaoUsuario){
        CriarConexoes();
        String sql = "";
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement(sql);
            // stmt.setString();
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao salvar itens, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static void AtualizarTodosCampos(ItensMovimentacaoUsuario prItensMovimentacaoUsuario){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "";
        try {
            stmt = conexao.prepareStatement(sql);
            // stmt.setString();
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao atualizar itens, entre em contato com o suporte do sistema ");
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
            throw new ExcecaoDB(e, "Falha ao excluir itens, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static ItensMovimentacaoUsuario PesquisarViaCodigo(Integer prCodigo){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigo);
            rs = stmt.executeQuery();
            if (rs.next())
                return new ItensMovimentacaoUsuario();
            else
                return null;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar itens pelo código, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static List<ItensMovimentacaoUsuario> PesquisarViaDescricaoExata(String prDescricaoItensMovimentacaoUsuario){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoItensMovimentacaoUsuario);
            rs = stmt.executeQuery();
            List <ItensMovimentacaoUsuario> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new ItensMovimentacaoUsuario());
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar itens pela descrção, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static List<ItensMovimentacaoUsuario> PesquisarViaDescricaoInicia(String prDescricaoItensMovimentacaoUsuario){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoItensMovimentacaoUsuario);
            rs = stmt.executeQuery();
            List <ItensMovimentacaoUsuario> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new ItensMovimentacaoUsuario());
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar itens pela descrção, entre em contato com o suporte do sistema ");
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
