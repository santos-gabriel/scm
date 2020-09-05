package dao;

import conexao.Conexao;
import excecoes.ExcecaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Funcionario;

/**
 * @author Gabriel
 */
public class FuncionarioDao {
    
    private static Connection conexao = null;
    
    
    public static void SalvarTodosCampos (Funcionario prFuncionario){
        CriarConexoes();
        String sql = "INSERT INTO funcionarios() VALUES () ";
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement(sql);
            // stmt.setString();
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao salvar Funcionario, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static void AtualizarTodosCampos(Funcionario prFuncionario){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "";
        try {
            stmt = conexao.prepareStatement(sql);
            // stmt.setString();
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao atualizar Funcionario, entre em contato com o suporte do sistema ");
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
            throw new ExcecaoDB(e, "Falha ao excluir Funcionario, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static Funcionario PesquisarViaCodigo(Integer prCodigo){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigo);
            rs = stmt.executeQuery();
            if (rs.next())
                return new Funcionario();
            else
                return null;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar Funcionario pelo código, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static List<Funcionario> PesquisarViaDescricaoExata(String prDescricaoFuncionario){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoFuncionario);
            rs = stmt.executeQuery();
            List <Funcionario> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Funcionario());
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar Funcionario pela descrção, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static List<Funcionario> PesquisarViaDescricaoInicia(String prDescricaoFuncionario){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoFuncionario);
            rs = stmt.executeQuery();
            List <Funcionario> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Funcionario());
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar Funcionario pela descrção, entre em contato com o suporte do sistema ");
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
