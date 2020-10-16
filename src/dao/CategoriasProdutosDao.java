package dao;

import com.mysql.jdbc.Statement;
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
    
    public static Integer SalvarTodosCampos (CategoriasProdutos prCategoria){
        CriarConexoes();
        String sql = "INSERT INTO categorias(cod_categoria, desc_categoria, ativo) VALUES(null, ?, true)";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, prCategoria.getDesc_Categoria());
            stmt.executeUpdate();
            ResultSet rsKeys = stmt.getGeneratedKeys();
            if (rsKeys.next())
                return rsKeys.getInt(1);
            else
                return null;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao salvar categoria, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    public static void AtualizarTodosCampos(CategoriasProdutos prCategoria){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE categorias SET desc_categoria = ? WHERE cod_categoria = ?";
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
        String sql = "UPDATE categorias SET ativo = false WHERE cod_categoria = ?";
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
        String sql = "SELECT cod_categoria, desc_categoria FROM categorias WHERE cod_categoria = ? AND ativo = true ORDER BY desc_categoria ASC";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigoCategoria);
            rs = stmt.executeQuery();
            if (rs.next())
                return new CategoriasProdutos(rs.getInt("cod_categoria"), rs.getString("desc_categoria"));
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
        String sql = "SELECT cod_categoria, desc_categoria FROM categorias WHERE UPPER(desc_categoria) = UPPER(?) AND ativo = true ORDER BY desc_categoria ASC";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoCategoria);
            rs = stmt.executeQuery();
            List <CategoriasProdutos> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new CategoriasProdutos(rs.getInt("cod_categoria"), rs.getString("desc_categoria")));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar categoria pela descrição, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static List<CategoriasProdutos> PesquisarViaDescricaoInicia(String prDescricaoCategoria){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT cod_categoria, desc_categoria FROM categorias WHERE UPPER(desc_categoria) LIKE UPPER(?) AND ativo = true ORDER BY desc_categoria ASC";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoCategoria+"%");
            rs = stmt.executeQuery();
            List<CategoriasProdutos> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new CategoriasProdutos(rs.getInt("cod_categoria"), rs.getString("desc_categoria")));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar categoria pela descrição, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    public static List<CategoriasProdutos> PesquisarTodos(){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT cod_categoria, desc_categoria FROM categorias WHERE ativo = true ORDER BY desc_categoria ASC";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<CategoriasProdutos> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new CategoriasProdutos(rs.getInt("cod_categoria"), rs.getString("desc_categoria")));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar categorias, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    
     public static List<CategoriasProdutos> PesquisarTodosExeto(CategoriasProdutos categoriaProduto){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT cod_categoria, desc_categoria FROM categorias WHERE ativo = true AND cod_categoria <> ? ORDER BY desc_categoria ASC";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, categoriaProduto.getCod_Categoria());
            rs = stmt.executeQuery();
            List<CategoriasProdutos> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new CategoriasProdutos(rs.getInt("cod_categoria"), rs.getString("desc_categoria")));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar categorias, entre em contato com o suporte do sistema ");
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
