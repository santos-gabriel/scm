package dao;

import conexao.Conexao;
import excecoes.ExcecaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Comissoes;

/**
 * @author Gabriel
 */
public abstract class ComissoesDao {
    
    private static Connection conexao = null;
    
    
    public static void SalvarTodosCampos (Comissoes prComissoes){
       CriarConexoes();
       String sql = "INSERT INTO COMISSOES(valor_comissao, unidade_medida, ativo) VALUES(?, ?, true)";
       PreparedStatement stmt = null;

       try {
           stmt = conexao.prepareStatement(sql);
           stmt.setDouble(1, prComissoes.getValor_comisssao());
           stmt.setString(2, prComissoes.getUnidade_medida());
           stmt.executeUpdate();
       } catch (SQLException e) {
           throw new ExcecaoDB(e, "Falha ao salvar comissao, entre em contato com o suporte do sistema ");
       }finally{
           FecharConexoes(conexao, stmt, null);
       }
    }
    
    
     public static void AtualizarTodosCampos(Comissoes prComissoes){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE COMISSOES SET valor_comissao = ?, unidade_medida = ? WHERE cod_comissao = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, prComissoes.getValor_comisssao());
            stmt.setString(2, prComissoes.getUnidade_medida());
            stmt.setInt(3, prComissoes.getCod_comissao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao atualizar comissao, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static void Excluir(Integer prCodigoComissao){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE COMISSOES SET ativo = false WHERE cod_comissao = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigoComissao);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao inativar comissão, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
     
    public static Comissoes PesquisarViaCodigo(Integer prCodigoComissao){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT c.cod_comissao, c.valor_comissao, c.unidade_medida, c.ativo FROM comissoes c WHERE c.cod_comissao = ? AND c.ativo = true";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigoComissao);
            rs = stmt.executeQuery();
            if (rs.next()){
                Comissoes c =  new Comissoes();
                c.setCod_comissao(rs.getInt("CODIGO"));
                c.setValor_comisssao(rs.getDouble("VALOR"));
                c.setUnidade_medida(rs.getString("UNIDADE_MEDIDA"));
                return c;
            }else
                return null;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar comissão pelo código, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static List<Comissoes> PesquisarTodos(){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT c.cod_comissao AS codigo, c.valor_comissao AS valor, c.unidade_medida, c.ativo FROM comissoes c WHERE c.ativo = true";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            List <Comissoes> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Comissoes(rs.getInt("CODIGO"), rs.getDouble("VALOR"), rs.getString("UNIDADE_MEDIDA"), rs.getBoolean("ATIVO")));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar comissões, entre em contato com o suporte do sistema ");
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
