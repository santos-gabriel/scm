package dao;

import conexao.Conexao;
import excecoes.ExcecaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cidades;
import modelo.Estados;
import modelo.Fornecedor;
import modelo.Usuario;

/**
 * @author Gabriel
 */
public abstract class FornecedorDao {
    private static Connection conexao = null;
    
    
    public static void SalvarTodosCampos (Fornecedor prFornecedor){
        CriarConexoes();
        String sql = "INSERT INTO fornecedores(cod_fornecedor, cod_usuario, cod_estado, cod_cidade, nome_fornecedor, "
                                            + "cnpj_fornecedor, inscricao_municip, endereco_fornecedor, telefone_fornecedor, ativo) "
                          + "VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, true)";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prFornecedor.getUsuario().getCod_Usuario());
            stmt.setInt(2, prFornecedor.getEstado().getCodEstado());
            stmt.setInt(3, prFornecedor.getCidade().getCodCidade());
            stmt.setString(4, prFornecedor.getNome_Fornecedor());
            stmt.setString(5, prFornecedor.getCNPJ_Fornecedor());
            stmt.setString(6, prFornecedor.getInscricao_Municipal());
            stmt.setString(7, prFornecedor.getEndereco_Fornecedor());
            stmt.setString(8, prFornecedor.getTelefone_Fornecedor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao salvar fornecedor, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static void AtualizarTodosCampos(Fornecedor prFornecedor){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE fornecedores SET        "
                        + "cod_usuario          = ?, "
                        + "cod_estado           = ?, "
                        + "cod_cidade           = ?, "
                        + "nome_fornecedor      = ?, "
                        + "cnpj_fornecedor      = ?, "
                        + "inscricao_municip    = ?, "
                        + "endereco_fornecedor  = ?, "
                        + "telefone_fornecedor  = ?  "
                        + "WHERE cod_fornecedor = ?  ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prFornecedor.getUsuario().getCod_Usuario());
            stmt.setInt(2, prFornecedor.getEstado().getCodEstado());
            stmt.setInt(3, prFornecedor.getCidade().getCodCidade());
            stmt.setString(4, prFornecedor.getNome_Fornecedor());
            stmt.setString(5, prFornecedor.getCNPJ_Fornecedor());
            stmt.setString(6, prFornecedor.getInscricao_Municipal());
            stmt.setString(7, prFornecedor.getEndereco_Fornecedor());
            stmt.setString(8, prFornecedor.getTelefone_Fornecedor());
            stmt.setInt(9, prFornecedor.getCod_Fornecedor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao atualizar fornecedor, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static void Excluir(Integer prCodigo){
        CriarConexoes();
        PreparedStatement stmt = null;
        String sql = "UPDATE fornecedores SET ativo = false WHERE cod_fornecedor = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao excluir fornecedor, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, null);
        }
    }
    
    
    public static List<Fornecedor> PesquisarTodos(){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT forn.cod_fornecedor, forn.nome_fornecedor, forn.cnpj_fornecedor, forn.inscricao_municip,               "
                          + "forn.telefone_fornecedor, forn.endereco_fornecedor, forn.cod_estado, est.descricao AS estado, est.uf,  "
                          + "forn.cod_cidade, cit.descricao AS cidade, forn.cod_usuario, usr.login, forn.ativo                      "
                   + "FROM   fornecedores   forn                                                                                    "
                   + "INNER JOIN estados    est   ON                                                                                "
                   + "  est.cod_estado = forn.cod_estado                                                                            "
                   + "INNER JOIN cidades    cit   ON                                                                                "
                   + "  cit.cod_cidade = forn.cod_cidade                                                                            "
                   + "INNER JOIN usuarios   usr   ON                                                                                "
                   + "  usr.cod_usuario = forn.cod_usuario                                                                          "
                   + "WHERE forn.ativo  = true                                                                                      "
                   + "ORDER BY forn.nome_fornecedor ASC                                                                             ";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            List <Fornecedor> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Fornecedor(
                                            rs.getInt("cod_fornecedor"), 
                                            new Usuario(rs.getInt("cod_usuario"), rs.getString("login")), 
                                            new Estados(rs.getInt("cod_estado"), rs.getString("estado"), rs.getString("uf")), 
                                            new Cidades(rs.getInt("cod_cidade"), rs.getString("cidade")), 
                                            rs.getString("nome_fornecedor"), 
                                            rs.getString("cnpj_fornecedor"), 
                                            rs.getString("inscricao_municip"), 
                                            rs.getString("endereco_fornecedor"), 
                                            rs.getString("telefone_fornecedor"), 
                                            rs.getBoolean("ativo")
                                        ));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar fornecedor pela descrção, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static Fornecedor PesquisarViaCodigo(Integer prCodigo){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT forn.cod_fornecedor, forn.nome_fornecedor, forn.cnpj_fornecedor, forn.inscricao_municip,               "
                          + "forn.telefone_fornecedor, forn.endereco_fornecedor, forn.cod_estado, est.descricao AS estado, est.uf,  "
                          + "forn.cod_cidade, cit.descricao AS cidade, forn.cod_usuario, usr.login, forn.ativo                      "
                   + "FROM   fornecedores   forn                                                                                    "
                   + "INNER JOIN estados    est   ON                                                                                "
                   + "  est.cod_estado = forn.cod_estado                                                                            "
                   + "INNER JOIN cidades    cit   ON                                                                                "
                   + "  cit.cod_cidade = forn.cod_cidade                                                                            "
                   + "INNER JOIN usuarios   usr   ON                                                                                "
                   + "  usr.cod_usuario = forn.cod_usuario                                                                          "
                   + "WHERE forn.ativo  = true                                                                                      "
                   + "AND forn.cod_fornecedor = ?                                                                                   ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, prCodigo);
            rs = stmt.executeQuery();
            if (rs.next()){
                return new Fornecedor(
                                        rs.getInt("cod_fornecedor"), 
                                        new Usuario(rs.getInt("cod_usuario"), rs.getString("login")), 
                                        new Estados(rs.getInt("cod_estado"), rs.getString("estado"), rs.getString("uf")), 
                                        new Cidades(rs.getInt("cod_cidade"), rs.getString("cidade")), 
                                        rs.getString("nome_fornecedor"), 
                                        rs.getString("cnpj_fornecedor"), 
                                        rs.getString("inscricao_municip"), 
                                        rs.getString("endereco_fornecedor"), 
                                        rs.getString("telefone_fornecedor"), 
                                        rs.getBoolean("ativo")
                                    );
            }else
                return null;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar fornecedor pelo código, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static List<Fornecedor> PesquisarViaDescricaoExata(String prDescricaoFornecedor){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT forn.cod_fornecedor, forn.nome_fornecedor, forn.cnpj_fornecedor, forn.inscricao_municip,               "
                          + "forn.telefone_fornecedor, forn.endereco_fornecedor, forn.cod_estado, est.descricao AS estado, est.uf,  "
                          + "forn.cod_cidade, cit.descricao AS cidade, forn.cod_usuario, usr.login, forn.ativo                      "
                   + "FROM   fornecedores   forn                                                                                    "
                   + "INNER JOIN estados    est   ON                                                                                "
                   + "  est.cod_estado = forn.cod_estado                                                                            "
                   + "INNER JOIN cidades    cit   ON                                                                                "
                   + "  cit.cod_cidade = forn.cod_cidade                                                                            "
                   + "INNER JOIN usuarios   usr   ON                                                                                "
                   + "  usr.cod_usuario = forn.cod_usuario                                                                          "
                   + "WHERE forn.ativo  = true                                                                                      "
                   + "AND UPPER(forn.nome_fornecedor) LIKE UPPER(?)                                                                 "
                   + "ORDER BY forn.nome_fornecedor ASC                                                                             ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoFornecedor);
            rs = stmt.executeQuery();
            List <Fornecedor> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Fornecedor(
                                            rs.getInt("cod_fornecedor"), 
                                            new Usuario(rs.getInt("cod_usuario"), rs.getString("login")), 
                                            new Estados(rs.getInt("cod_estado"), rs.getString("estado"), rs.getString("uf")), 
                                            new Cidades(rs.getInt("cod_cidade"), rs.getString("cidade")), 
                                            rs.getString("nome_fornecedor"), 
                                            rs.getString("cnpj_fornecedor"), 
                                            rs.getString("inscricao_municip"), 
                                            rs.getString("endereco_fornecedor"), 
                                            rs.getString("telefone_fornecedor"), 
                                            rs.getBoolean("ativo")
                                        ));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar fornecedor pela descrção, entre em contato com o suporte do sistema ");
        }finally{
            FecharConexoes(conexao, stmt, rs);
        }
    }
    
    
    public static List<Fornecedor> PesquisarViaDescricaoInicia(String prDescricaoFornecedor){
        CriarConexoes();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT forn.cod_fornecedor, forn.nome_fornecedor, forn.cnpj_fornecedor, forn.inscricao_municip,               "
                          + "forn.telefone_fornecedor, forn.endereco_fornecedor, forn.cod_estado, est.descricao AS estado, est.uf,  "
                          + "forn.cod_cidade, cit.descricao AS cidade, forn.cod_usuario, usr.login, forn.ativo                      "
                   + "FROM   fornecedores   forn                                                                                    "
                   + "INNER JOIN estados    est   ON                                                                                "
                   + "  est.cod_estado = forn.cod_estado                                                                            "
                   + "INNER JOIN cidades    cit   ON                                                                                "
                   + "  cit.cod_cidade = forn.cod_cidade                                                                            "
                   + "INNER JOIN usuarios   usr   ON                                                                                "
                   + "  usr.cod_usuario = forn.cod_usuario                                                                          "
                   + "WHERE forn.ativo  = true                                                                                      "
                   + "AND UPPER(forn.nome_fornecedor) LIKE UPPER(?)                                                                 "
                   + "ORDER BY forn.nome_fornecedor ASC                                                                             ";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, prDescricaoFornecedor+"%");
            rs = stmt.executeQuery();
            List <Fornecedor> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(new Fornecedor(
                                            rs.getInt("cod_fornecedor"), 
                                            new Usuario(rs.getInt("cod_usuario"), rs.getString("login")), 
                                            new Estados(rs.getInt("cod_estado"), rs.getString("estado"), rs.getString("uf")), 
                                            new Cidades(rs.getInt("cod_cidade"), rs.getString("cidade")), 
                                            rs.getString("nome_fornecedor"), 
                                            rs.getString("cnpj_fornecedor"), 
                                            rs.getString("inscricao_municip"), 
                                            rs.getString("endereco_fornecedor"), 
                                            rs.getString("telefone_fornecedor"), 
                                            rs.getBoolean("ativo")
                                        ));
            }
            return lista;
        } catch (SQLException e) {
            throw new ExcecaoDB(e, "Falha ao localizar fornecedor pela descrção, entre em contato com o suporte do sistema ");
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
