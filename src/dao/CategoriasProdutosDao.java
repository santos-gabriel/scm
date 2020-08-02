package dao;

import conexao.Conexao;
import excecoes.ExcecaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.CategoriasProdutos;

/**
 * @author Gabriel
 */
public abstract class CategoriasProdutosDao {
    private static Connection conexao = null;
    
    public static void SalvarTodosCampos (CategoriasProdutos prCategoria){
        CriarConexoes();
        String sql = "INSERT INTO CATEGORIA_PRODUTO(DESCRICAO) VALUES(?)";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prCategoria.getDesc_Categoria());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao salvar categoria, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static void AtualizarTodosCampos(CategoriasProdutos prCategoria){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE CATEGORIA_PRODUTO SET DESCRICAO = ? WHERE CODIGO = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prCategoria.getDesc_Categoria());
            stmt.setInt(2, prCategoria.getCod_Categoria());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao atualizar categoria, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static void Excluir(Integer prCodigoCategoria){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "DELETE FROM CATEGORIA_PRODUTO WHERE CODIGO = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigoCategoria);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao excluir categoria, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static CategoriasProdutos PesquisarViaCodigo(Integer prCodigoCategoria){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT C.CODIGO, C.DECRICAO FROM CATEGORIA_PRODUTO C WHERE C.CODIGO = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigoCategoria);
            rs = stmt.executeQuery();
            if (rs.next())
                return new CategoriasProdutos(rs.getInt("CODIGO"), rs.getString("DESCRICAO"));
            else
                return null;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar categoria pelo código, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static List<CategoriasProdutos> PesquisarViaDescricaoExata(String prDescricaoCategoria){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT C.CODIGO, C.DECRICAO FROM CATEGORIA_PRODUTO C WHERE UPPER(C.DESCRICAO) = UPPER(?) ORDER BY C.DESCRICAO ASC";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoCategoria);
            rs = stmt.executeQuery();
            List <CategoriasProdutos> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new CategoriasProdutos(rs.getInt("CODIGO"), rs.getString("DESCRICAO")));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar categoria pela descrção, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static List<CategoriasProdutos> PesquisarViaDescricaoInicia(String prDescricaoCategoria){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT C.CODIGO, C.DECRICAO FROM CATEGORIA_PRODUTO C WHERE UPPER(C.DESCRICAO) LIKE UPPER(?%) ORDER BY C.DESCRICAO ASC";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoCategoria);
            rs = stmt.executeQuery();
            List<CategoriasProdutos> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new CategoriasProdutos(rs.getInt("CODIGO"), rs.getString("DESCRICAO")));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar categoria pela descrção, entre em contato com o suporte do sistema ");
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
