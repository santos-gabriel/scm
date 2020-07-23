package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Cargo;

/**
 * @author Gabriel
 */
public abstract class CargoDao {
    
    private static Connection conexao = null;
    
    public static void SalvarTodosCampos (Cargo prCargo){
        CriarConexoes();
        String sql = "INSERT INTO CARGO(DESCRICAO) VALUES(?)";
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(0, prCargo.getDesc_Cargo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao salvar cargo, entre em contato com o suporte do sistema ");
            e.printStackTrace();
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static void AtualizarTodosCampos(Cargo prCargo){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE CARGO SET DESCRICAO = ? WHERE CODIGO = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prCargo.getDesc_Cargo());
            stmt.setInt(2, prCargo.getCod_Cargo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar cargo, entre em contato com o suporte do sistema ");
            e.printStackTrace();
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static void Excluir(Integer prCodigoCargo){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "DELETE FROM CARGO WHERE CODIGO = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigoCargo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir cargo, entre em contato com o suporte do sistema ");
            e.printStackTrace();
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static Cargo PesquisarViaCodigo(Integer prCodigoCargo){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT C.CODIGO, C.DECRICAO FROM CARGO C WHERE C.CODIGO = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigoCargo);
            rs = stmt.executeQuery();
            if (rs.next())
                return new Cargo(rs.getInt("CODIGO"), rs.getString("DESCRICAO"));
            else
                return null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao localizar cargo pelo código, entre em contato com o suporte do sistema ");
            e.printStackTrace();
            return null;
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static List<Cargo> PesquisarViaDescricaoExata(String prDescricaoCargo){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT C.CODIGO, C.DECRICAO FROM CARGO C WHERE UPPER(C.DESCRICAO) = UPPER(?) ORDER BY C.DESCRICAO ASC";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoCargo);
            rs = stmt.executeQuery();
            List <Cargo> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Cargo(rs.getInt("CODIGO"), rs.getString("DESCRICAO")));
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao localizar cargo pela descrção, entre em contato com o suporte do sistema ");
            e.printStackTrace();
            return null;
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static List<Cargo> PesquisarViaDescricaoInicia(String prDescricaoCargo){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT C.CODIGO, C.DECRICAO FROM CARGO C WHERE UPPER(C.DESCRICAO) LIKE UPPER(?%) ORDER BY C.DESCRICAO ASC";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoCargo);
            rs = stmt.executeQuery();
            List <Cargo> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Cargo(rs.getInt("CODIGO"), rs.getString("DESCRICAO")));
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao localizar cargo pela descrção, entre em contato com o suporte do sistema ");
            e.printStackTrace();
            return null;
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
