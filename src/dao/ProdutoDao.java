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
import modelo.CategoriasProdutos;
import modelo.Produto;
import modelo.Usuario;

/**
 * @author Gabriel
 */
public abstract class ProdutoDao {
    
    private static Connection conexao = null;
    
    public static Integer SalvarTodosCampos (Produto prProduto){
        CriarConexoes();
        String sql = "INSERT INTO produtos(cod_produto, cod_categoria, cod_usuario, desc_produto, valor_custo, valor_venda, ativo) "
                   + "VALUES(null, ?, ?, ?, ?, ?, true)";
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, prProduto.getCategoria_Produto().getCod_Categoria());
            stmt.setInt(2, prProduto.getUsuario().getCod_Usuario());
            stmt.setString(3, prProduto.getDesc_Produto());
            stmt.setDouble(4, prProduto.getValor_Custo());
            stmt.setDouble(5, prProduto.getValor_Venda());
            stmt.executeUpdate();
            ResultSet rsKeys = stmt.getGeneratedKeys();
            if (rsKeys.next())
                return rsKeys.getInt(1);
            else
                return null;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao salvar produto, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static void AtualizarTodosCampos(Produto prProduto){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE produtos SET   "
                   + "cod_categoria = ?,    "
                   + "cod_usuario   = ?,    "
                   + "desc_produto  = ?,    "
                   + "valor_custo   = ?,    "
                   + "valor_venda   = ?     "
                   + "WHERE cod_produto = ? ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prProduto.getCategoria_Produto().getCod_Categoria());
            stmt.setInt(2, prProduto.getUsuario().getCod_Usuario());
            stmt.setString(3, prProduto.getDesc_Produto());
            stmt.setDouble(4, prProduto.getValor_Custo());
            stmt.setDouble(5, prProduto.getValor_Venda());
            stmt.setInt(6, prProduto.getCod_Produto());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao atualizar produto, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static void Excluir(Integer prCodigo){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE produtos SET ativo = false WHERE cod_produto = ? ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao excluir produto, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    
    public static Produto PesquisarViaCodigo(Integer prCodigo){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT p.cod_produto, p.cod_categoria, c.descricao as categoria, p.cod_usuario, "
                   + "       u.login as usuario, p.des_produto, p.valor_custo, p.valor_venda, p.ativo "
                   + "INNER JOIN categorias c ON                                                      "
                   + "  c.cod_categoria = p.cod_categoria                                             "
                   + "INNER JOIN usuarios u ON                                                        "
                   + "  u.cod_usuario = p.cod_usuario                                                 "
                   + "WHERE p.ativo = true                                                            "
                   + "AND   p.cod_produto = ?                                                         ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigo);
            rs = stmt.executeQuery();
            if (rs.next())
                return new Produto(
                                    rs.getInt("cod_produto"),
                                    new CategoriasProdutos(rs.getInt("cod_categoria"), rs.getString("categoria")),
                                    new Usuario(rs.getInt("cod_usuario"), rs.getString("usuario")),
                                    rs.getString("desc_produto"),
                                    rs.getDouble("valor_custo"),
                                    rs.getDouble("valor_venda"),
                                    rs.getBoolean("ativo")
                                   );
            else
                return null;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar produto pelo código, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    
    public static List<Produto> PesquisarTodos(){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT p.cod_produto, p.cod_categoria, c.descricao as categoria, p.cod_usuario, "
                   + "       u.login as usuario, p.des_produto, p.valor_custo, p.valor_venda, p.ativo "
                   + "INNER JOIN categorias c ON                                                      "
                   + "  c.cod_categoria = p.cod_categoria                                             "
                   + "INNER JOIN usuarios u ON                                                        "
                   + "  u.cod_usuario = p.cod_usuario                                                 "
                   + "WHERE p.ativo = true                                                            "
                   + "AND   p.cod_produto = ?                                                         ";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            List <Produto> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Produto(
                                        rs.getInt("cod_produto"),
                                        new CategoriasProdutos(rs.getInt("cod_categoria"), rs.getString("categoria")),
                                        new Usuario(rs.getInt("cod_usuario"), rs.getString("usuario")),
                                        rs.getString("desc_produto"),
                                        rs.getDouble("valor_custo"),
                                        rs.getDouble("valor_venda"),
                                        rs.getBoolean("ativo")
                                      ));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar produtos, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    
    
    public static List<Produto> PesquisarViaDescricaoExata(String prDescricao){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT p.cod_produto, p.cod_categoria, c.descricao as categoria, p.cod_usuario, "
                   + "       u.login as usuario, p.des_produto, p.valor_custo, p.valor_venda, p.ativo "
                   + "INNER JOIN categorias c ON                                                      "
                   + "  c.cod_categoria = p.cod_categoria                                             "
                   + "INNER JOIN usuarios u ON                                                        "
                   + "  u.cod_usuario = p.cod_usuario                                                 "
                   + "WHERE p.ativo = true                                                            "
                   + "AND   p.cod_produto = ?                                                         ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricao);
            rs = stmt.executeQuery();
            List <Produto> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Produto(
                                        rs.getInt("cod_produto"),
                                        new CategoriasProdutos(rs.getInt("cod_categoria"), rs.getString("categoria")),
                                        new Usuario(rs.getInt("cod_usuario"), rs.getString("usuario")),
                                        rs.getString("desc_produto"),
                                        rs.getDouble("valor_custo"),
                                        rs.getDouble("valor_venda"),
                                        rs.getBoolean("ativo")
                                      ));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar produtos pela descrção, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    
    
    public static List<Produto> PesquisarViaDescricaoInicia(String prDescricaoCargo){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT p.cod_produto, p.cod_categoria, c.descricao as categoria, p.cod_usuario, "
                   + "       u.login as usuario, p.des_produto, p.valor_custo, p.valor_venda, p.ativo "
                   + "INNER JOIN categorias c ON                                                      "
                   + "  c.cod_categoria = p.cod_categoria                                             "
                   + "INNER JOIN usuarios u ON                                                        "
                   + "  u.cod_usuario = p.cod_usuario                                                 "
                   + "WHERE p.ativo = true                                                            "
                   + "AND   p.cod_produto = ?                                                         ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoCargo+"%");
            rs = stmt.executeQuery();
            List <Produto> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Produto(
                                        rs.getInt("cod_produto"),
                                        new CategoriasProdutos(rs.getInt("cod_categoria"), rs.getString("categoria")),
                                        new Usuario(rs.getInt("cod_usuario"), rs.getString("usuario")),
                                        rs.getString("desc_produto"),
                                        rs.getDouble("valor_custo"),
                                        rs.getDouble("valor_venda"),
                                        rs.getBoolean("ativo")
                                      ));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar produtos pela descrção, entre em contato com o suporte do sistema ");
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
