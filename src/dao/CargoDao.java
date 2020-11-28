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
import modelo.Cargo;

/**
 * @author Gabriel
 */
public abstract class CargoDao {
    
    private static Connection conexao = null;
    
    public static Integer SalvarTodosCampos (Cargo prCargo){
        CriarConexoes();
        String sql = "INSERT INTO cargos(cod_cargo, desc_cargo, ativo) VALUES(null, ?, true)";
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, prCargo.getDesc_Cargo());
            stmt.executeUpdate();
            ResultSet rsKeys = stmt.getGeneratedKeys();
            if (rsKeys.next())
                return rsKeys.getInt(1);
            else
                return null;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao salvar cargo, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static void AtualizarTodosCampos(Cargo prCargo){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE cargos SET desc_cargo = ? WHERE cod_cargo = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prCargo.getDesc_Cargo());
            stmt.setInt(2, prCargo.getCod_Cargo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao atualizar cargo, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static void Excluir(Integer prCodigoCargo){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE cargos SET ativo = false WHERE cod_cargo = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigoCargo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao excluir cargo, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static Cargo PesquisarViaCodigo(Integer prCodigoCargo){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT c.cod_cargo, c.desc_cargo FROM cargos c WHERE c.cod_cargo = ? AND c.ativo = true";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigoCargo);
            rs = stmt.executeQuery();
            if (rs.next())
                return new Cargo(rs.getInt("cod_cargo"), rs.getString("desc_cargo"));
            else
                return null;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar cargo pelo código, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static List<Cargo> PesquisarTodos(){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT c.cod_cargo, c.desc_cargo FROM cargos c WHERE c.ativo = true ORDER BY c.desc_cargo ASC ";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            List <Cargo> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Cargo(rs.getInt("cod_cargo"), rs.getString("desc_cargo")));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar cargos, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static List<Cargo> PesquisarViaDescricaoExata(String prDescricaoCargo){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT c.cod_cargo, c.desc_cargo FROM cargos c WHERE UPPER(c.desc_cargo) = UPPER(?) AND c.ativo = true ORDER BY c.desc_cargo ASC ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoCargo);
            rs = stmt.executeQuery();
            List <Cargo> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Cargo(rs.getInt("cod_cargo"), rs.getString("desc_cargo")));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar cargo pela descrção, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static List<Cargo> PesquisarViaDescricaoInicia(String prDescricaoCargo){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT c.cod_cargo, c.desc_cargo FROM cargos c WHERE UPPER(c.desc_cargo) LIKE UPPER(?) AND c.ativo = true ORDER BY c.desc_cargo ASC ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoCargo+"%");
            rs = stmt.executeQuery();
            List <Cargo> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Cargo(rs.getInt("cod_cargo"), rs.getString("desc_cargo")));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar cargo pela descrção, entre em contato com o suporte do sistema ");
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
